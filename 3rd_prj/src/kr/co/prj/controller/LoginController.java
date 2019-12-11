package kr.co.prj.controller;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.prj.domain.PassHintDomain;
import kr.co.prj.service.FindService;
import kr.co.prj.service.LoginService;
import kr.co.prj.service.SignUpService;
import kr.co.prj.vo.FindIdEmailVO;
import kr.co.prj.vo.FindIdPhoneVO;
import kr.co.prj.vo.FindPwVO;
import kr.co.prj.vo.LoginVO;
import kr.co.prj.vo.SendEmailVO;
import kr.co.sist.util.cipher.DataEncrypt;
 @Controller
public class LoginController {

	 @Autowired
		private JavaMailSender mailSender;
	

	@RequestMapping(value="login/login.do")
	public String loginForm() {
		return "login/login";

		
	}//introduceForm
	
	@RequestMapping(value="login/login_process.do")
	public String loginProcess(HttpSession session,LoginVO lVO) {
		System.out.println( lVO.getInputId()+"/"+lVO.getInputPassword());
		
		String uri = "login/failLogin";
		
		
		try {
			lVO.setInputPassword(DataEncrypt.messageDigest("MD5", lVO.getInputPassword()));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		LoginService ls = new LoginService();
		if(ls.login(lVO)) {
			session.setAttribute("memberId", lVO.getInputId());
			uri = "main/home";
		}
		
		System.out.println("�α��� ���� ���̵�:"+session.getAttribute("memberId"));
		return uri;
	}
	
	@RequestMapping(value = "login/logout.do")
	public String logoutProcess(HttpSession session) {
		
		session.invalidate();
		
		
		return "main/home";
	}//logoutProcess
	
	
	@RequestMapping(value = "login/find_id.do")
	public String findId() {
	
		
		return "login/find_id";
	}//ajax�� �ؼ� alert
	
	@RequestMapping(value = "login/find_id1.do",  produces = "application/json; charset=utf8")
	@ResponseBody
	public String findId(FindIdPhoneVO fvo) {
		FindService fs=new FindService();
		JSONObject json=fs.findIdByPhone(fvo);
		System.out.println(json.toJSONString());
		return json.toJSONString();		
	}//findId
	
	@RequestMapping(value = "login/find_id2.do",  produces = "application/json; charset=utf8")
	@ResponseBody
	public String findIdByEmail(FindIdEmailVO fevo) {
		FindService fs=new FindService();
		JSONObject json=fs.findIdByEmail(fevo);
		System.out.println(json.toJSONString());
		return json.toJSONString();		
	}//findId
	

	@RequestMapping(value = "login/find_pw.do")
	public String findPw(Model model) {	
		
		SignUpService ss = new SignUpService();
		List<PassHintDomain> list = ss.passHintMultiRow();
		
		model.addAttribute("passHintList",list);
		System.out.println(list);
		
		return "login/find_pw";
	}//ajax�� �ؼ� alert
	
	
	 @RequestMapping(value = "login/find_pw2.do", produces =
	 "application/json; charset=utf8")
	 
	 @ResponseBody
	 public String setPw(FindPwVO fpvo) { 
	 boolean updateFlag=false;

	 System.out.println(fpvo.getId()+"------"+fpvo.getPhone()+"------"+fpvo.getEmail()+"--------"+fpvo.getHint_code()+"---"+fpvo.getAnswer());
	 
	 FindService fs=new FindService();
	 JSONObject json=fs.findPw(fpvo);
	 String email=fpvo.getEmail();
	 String id=(String)json.get("id");

	 System.out.println(json.toJSONString()); 

	 FindService fs1=new FindService();
	// updateFlag=fs1.setPw(id, email);
	//	 System.out.println(updateFlag);
	
	 
	 SendEmailVO sevo=fs1.setPw(id, email);
	 
	 updatePw(sevo);
	 
	 return json.toJSONString();	
	// return "login/send_email";
	 }//findId
	 

	 
	 
	 public void updatePw(SendEmailVO sevo) {
		 
		 
		 
		 String setfrom = "";
			String tomail = sevo.getEmail(); // �޴� ��� �̸���
			String title = sevo.getId() +"���� �ӽ� ��й�ȣ �߱� �����Դϴ�.";  // ����
			StringBuilder content=new StringBuilder();
			

			
			content.append("<h1>"+"[ :P ]"+"</h1> \n\n")
					  //.append("<img src=\"http://211.63.89.150:8080/3rd_prj/common/images/plogo.png\">")
						
					  .append("��й�ȣ�� �����ڵ� �� �� ������<br/>")
					  .append("��ȣȭ�Ͽ� ����Ǳ� ������<br/>")
					  .append("���ο� �ӽú�й�ȣ�� �����Ͽ� �ȳ��� �帮����<br/>")
					  .append("�ӽú�й�ȣ�� �α����Ͻ� ��, <br/>")
					  .append("��й�ȣ �н� ������ ���� �������� ������ ���� <br/>")
					  .append("���ο� ��й�ȣ�� �����Ͽ� ����� �ֽʽÿ�. <br/>")
					  .append("<br/>")
					  .append(sevo.getId()+" ���� �ӽ� ��й�ȣ�� '<strong>"+sevo.getPassword()+"'</strong> �Դϴ�.<br/>")
					  .append("<br/>")
					  .append("����� ������ ���ﵿ 409-7 3F, 4F [ :P ] | Copyright(C)2010 Worldjob.or.kr.All Rights Reserved. ");

										 

			try {
				
				
				
				MimeMessage message = mailSender.createMimeMessage();
				MimeMessageHelper messageHelper = new MimeMessageHelper(message,
						true, "UTF-8");
				
				System.out.println("���� ������ �;��");

				messageHelper.setFrom("pspace.rental@gmail.com"); // �����»�� �����ϸ� �����۵��� ����
				messageHelper.setTo("rma1057@gmail.com"); // �޴»�� �̸���
				messageHelper.setSubject(title); // ���������� ������ �����ϴ�
				messageHelper.setText(String.valueOf(content), true); // ���� ����

				/**
				 * �̹��� ������ �ȵ� �ð� ���� �ϱ�
				String contents = content+ "<img src=\"cid:plogo.png\">";
				messageHelper.setText(contents, true);
				
				FileSystemResource file = new FileSystemResource(new File("c:/plogo.png")); 
				messageHelper.addInline("plogo.png", file);
				*/
				
				
				mailSender.send(message);
			} catch (Exception e) {
				System.out.println(e);
			}//end catch
			
			return;
		 
	 }//updatePw


}
