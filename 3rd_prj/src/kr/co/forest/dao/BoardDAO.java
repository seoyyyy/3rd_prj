package kr.co.forest.dao;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class BoardDAO {

	private static BoardDAO bdDao;
	public static SqlSessionFactory ssf;
	
	private BoardDAO() {
	}

	public static BoardDAO getInstance() {
		if(bdDao==null) {
			bdDao=new BoardDAO();
		}//end if
		return bdDao;
	}//getInstance
	
	public SqlSessionFactory getSessionFactory()throws IOException {//싱글턴 //ssf가 없는 경우에만 만들어지고 있다면 만들어지지 않는다.
		if(ssf==null) {
			
			Reader reader = null;
			try {
				//1.설정용 xml을 스트림으로 연결
					reader = Resources.getResourceAsReader("kr/co/forest/dao/mybatis-config.xml");
				//2.SqlSessionFactoryBuilder 생성
					SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
				//3.SqlSessionFactory 얻기
					ssf= ssfb.build(reader);
				
			}finally {
				if(reader!=null) {reader.close();}//end if
			}//end finally
			
		}//end if
		return ssf;
	}//getSessionFactory
	
	
}//class
