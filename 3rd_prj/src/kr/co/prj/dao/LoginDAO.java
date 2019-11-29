package kr.co.prj.dao;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.co.prj.vo.LoginVO;

public class LoginDAO {
	private static LoginDAO loDao;
	public static SqlSessionFactory ssf;
	
	private LoginDAO() {
	}

	public static LoginDAO getInstance() {
		if(loDao==null) {
			loDao=new LoginDAO();
		}//end if
		return loDao;
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
	public String login(LoginVO lVo) throws SQLException{
		String id ="";
		
		SqlSession ss;
		try {
			ss = getSessionFactory().openSession();
			id=ss.selectOne("login",lVo);
			ss.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return id;
	}//login
}
