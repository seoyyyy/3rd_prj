package kr.co.prj.dao;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.co.prj.vo.FindIdEmailVO;
import kr.co.prj.vo.FindIdPhoneVO;
import kr.co.prj.vo.FindPwVO;
import kr.co.prj.vo.UpdatePwVO;

public class FindDAO {

	private static FindDAO fDao;
	public static SqlSessionFactory ssf;
	
	private FindDAO() {
		
	}
	
	public static FindDAO getInstance() {
		if(fDao==null) {
			fDao=new FindDAO();
		}//ned if
		return fDao;	
	}//getInstance
	
	public SqlSessionFactory getSessionFactory()throws IOException {//�̱��� //ssf�� ���� ��쿡�� ��������� �ִٸ� ��������� �ʴ´�.
		if(ssf==null) {
			
			Reader reader = null;
			try {
				//1.������ xml�� ��Ʈ������ ����
					reader = Resources.getResourceAsReader("kr/co/prj/dao/mybatis-config.xml");
				//2.SqlSessionFactoryBuilder ����
					SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
				//3.SqlSessionFactory ���
					ssf= ssfb.build(reader);
				
			}finally {
				if(reader!=null) {reader.close();}//end if
			}//end finally
			
		}//end if
		return ssf;
	}//getSessionFactory
	
	public int selectId(String id) throws SQLException {
		
		String idCheck=null;
		int idCheckFlag=0;
		
		try {
			SqlSession ss=getSessionFactory().openSession();
			//���� ���� : �� �� ��ȸ
			idCheck=ss.selectOne("selectIdCheck", id );
			if (idCheck != null ) {
				idCheckFlag=1;
			}
			System.out.println(idCheck + "���Դϴ�~~~~~~~~~~~!!!");
		} catch (IOException e) {
			e.printStackTrace();
		}//end catch
		
		return idCheckFlag;
	}//selectIdByPhone
	
	
	public String selectIdByPhone(FindIdPhoneVO fvo) throws SQLException {
		String id=null;
		
		try {
			SqlSession ss=getSessionFactory().openSession();
			//���� ���� : �� �� ��ȸ
			System.out.println(fvo.getName() +"-----------"+ fvo.getPhone());
			id=ss.selectOne("selectIdPhone", fvo );
		} catch (IOException e) {
			e.printStackTrace();
		}//end catch
		
		return id;
	}//selectIdByPhone
	
	public String selectIdByEmail(FindIdEmailVO fevo) throws SQLException {
		String id=null;
		
		try {
			SqlSession ss=getSessionFactory().openSession();
			//���� ���� : �� �� ��ȸ
			System.out.println(fevo.getName() +"-----------"+ fevo.getEmail());
			id=ss.selectOne("selectIdEmail", fevo );
		} catch (IOException e) {
			e.printStackTrace();
		}//end catch
		
		return id;
	}//selectIdByEmail
	
	public String selectPw(FindPwVO fpvo) throws SQLException {
		String id=null;
		
		try {
			SqlSession ss=getSessionFactory().openSession();
			//���� ���� : �� �� ��ȸ
			id=ss.selectOne("selectPw", fpvo );
		} catch (IOException e) {
			e.printStackTrace();
		}//end catch
		
		return id;
	}//selectPw
	
	public boolean updatePw(UpdatePwVO upvo) throws SQLException {
		boolean updateFlag=false;
		
		try {
			SqlSession ss=getSessionFactory().openSession();
			//���� ���� : �� �� ��ȸ
			updateFlag=ss.update("updatePw",upvo)==1;
			
			ss.commit();
			ss.close();
		} catch (IOException e) {
			e.printStackTrace();
		}//end catch
		
		return updateFlag;
	}//selectPw
	
	
	
	
}//class
