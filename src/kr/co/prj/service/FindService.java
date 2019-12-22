package kr.co.prj.service;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import java.util.UUID;

import javax.mail.internet.MimeMessage;
import javax.print.attribute.standard.Fidelity;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import kr.co.prj.dao.FindDAO;
import kr.co.prj.vo.FindIdEmailVO;
import kr.co.prj.vo.FindIdPhoneVO;
import kr.co.prj.vo.FindPwVO;
import kr.co.prj.vo.SendEmailVO;
import kr.co.prj.vo.UpdatePwVO;
import kr.co.sist.util.cipher.DataDecrypt;
import kr.co.sist.util.cipher.DataEncrypt;

@Component
public class FindService {

	@Autowired
	private JavaMailSender mailSender;

	public JSONObject findIdByPhone(FindIdPhoneVO fvo) {
		JSONObject jo = new JSONObject();
		String id = null;
		FindDAO fDao = FindDAO.getInstance();

		try {
			id = fDao.selectIdByPhone(fvo);
		} catch (SQLException e) {
			e.printStackTrace();
		} // end catch

		jo.put("resultFlag", id != null);
		jo.put("id", id);

		return jo;
	}// findId

	public JSONObject findIdByEmail(FindIdEmailVO fevo) {
		JSONObject jo = new JSONObject();
		String id = null;
		FindDAO fDao = FindDAO.getInstance();

		try {
			id = fDao.selectIdByEmail(fevo);
		} catch (SQLException e) {
			e.printStackTrace();
		} // end catch

		jo.put("resultFlag", id != null);
		jo.put("id", id);

		return jo;
	}// findIdByEmail

	public JSONObject findPw(FindPwVO fpvo) {
		JSONObject jo = new JSONObject();
		String id = null;
		FindDAO fDao = FindDAO.getInstance();

		try {
			id = fDao.selectPw(fpvo);
		} catch (SQLException e) {
			e.printStackTrace();
		} // end catch

		jo.put("resultFlag", id != null);
		jo.put("id", id);

		return jo;
	}// findId

	/**
	 * ���̵� �ߺ�Ȯ��
	 * @param id
	 * @return
	 */
	public int checkId(String id) {
		int idCheck = 0;

		FindDAO fDao = FindDAO.getInstance();

		try {
			idCheck = fDao.selectId(id);
		} catch (SQLException e) {
			e.printStackTrace();
		} // end catch
		return idCheck;
	}// checkId

	/**
	 * ���� ��й�ȣ 10�ڸ� ����
	 * 
	 * @param fpvo
	 * @return
	 */
	public SendEmailVO setPw(String id, String email) {
		boolean updateFlag = false;
		/**
		 * String ranPw=null; for (int i = 0; i < 5; i++) { ranPw =
		 * UUID.randomUUID().toString().replaceAll("-", ""); // -�� ������ �־���. ranPw =
		 * ranPw.substring(0, 10); //uuid�� �տ������� 10�ڸ� �߶���. }
		 */

		char pwCollection[] = new char[] { '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', 'A', 'B', 'C', 'D', 'E',
				'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
				'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u',
				'v', 'w', 'x', 'y', 'z', '!', '@', '#', '$', '%', '^', '&', '*', '(', ')' };// �迭�� ����

		String ranPw = "";

		for (int i = 0; i < 10; i++) {
			int selectRandomPw = (int) (Math.random() * (pwCollection.length));// Math.rondom()�� 0.0�̻� 1.0�̸��� ������ ������
																				// �ش�.
			ranPw += pwCollection[selectRandomPw];
		}

		System.out.println("���� : " + ranPw);

		FindDAO fDao = FindDAO.getInstance();
		// update�� ���� �ӽú�й�ȣ
		String encryptPw;
		UpdatePwVO upvo = new UpdatePwVO();

		SendEmailVO sevo = new SendEmailVO();
		try {
			encryptPw = DataEncrypt.messageDigest("MD5", ranPw);
			upvo.setId(id);
			upvo.setPassword(encryptPw);
		} catch (NoSuchAlgorithmException e2) {
			e2.printStackTrace();
		}

		sevo.setId(id);
		sevo.setPassword(ranPw);

		sevo.setEmail(email);

		System.out.println("�ѹ� �غ���" + sevo.getId() + "-------" + sevo.getPassword() + "------" + sevo.getEmail());

		try {
			updateFlag = fDao.updatePw(upvo);

			/**
			 * if ( updateFlag ) {
			 * 
			 * sendPw(sevo); }
			 */

		} catch (SQLException e) {
			e.printStackTrace();
		} // end catch

		/**
		 * FindDAO fDao=FindDAO.getInstance();
		 * 
		 * try { id=fDao.selectPw(fpvo); } catch (SQLException e) { e.printStackTrace();
		 * }//end catch
		 * 
		 * 
		 * jo.put("resultFlag", id!=null); jo.put("id", id);
		 * 
		 */
		return sevo;

	}// setPw

	/**
	 * public void sendPw(SendEmailVO sevo) {
	 * 
	 * 
	 * 
	 * String setfrom = ""; String tomail = sevo.getEmail(); // �޴� ��� �̸��� String
	 * title = sevo.getId() +"���� �ӽ� ��й�ȣ �߱� �����Դϴ�."; // ���� String content =
	 * sevo.getId()+" ���� �ӽ� ��й�ȣ�� "+sevo.getPassword()+"�Դϴ�."; // ����
	 * 
	 * try {
	 * 
	 * System.out.println(mailSender);
	 * 
	 * MimeMessage message = mailSender.createMimeMessage(); MimeMessageHelper
	 * messageHelper = new MimeMessageHelper(message, true, "UTF-8");
	 * 
	 * System.out.println("���� ������ �;��");
	 * 
	 * messageHelper.setFrom("pspace.rental@gmail.com"); // �����»�� �����ϸ� �����۵��� ����
	 * messageHelper.setTo("rma1057@gmail.com"); // �޴»�� �̸���
	 * messageHelper.setSubject(title); // ���������� ������ �����ϴ�
	 * messageHelper.setText(content); // ���� ����
	 * 
	 * mailSender.send(message); } catch (Exception e) { System.out.println(e);
	 * }//end catch
	 * 
	 * }
	 */
}
