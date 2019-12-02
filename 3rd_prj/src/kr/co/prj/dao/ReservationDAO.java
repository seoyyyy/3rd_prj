package kr.co.prj.dao;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.co.prj.domain.MemberCheckDomain;
import kr.co.prj.domain.RoomInfoDomain;

public class ReservationDAO {
	private static ReservationDAO rsvDao;
	public static SqlSessionFactory ssf;
	
	private ReservationDAO() {
	}

	public static ReservationDAO getInstance() {
		if(rsvDao==null) {
			rsvDao=new ReservationDAO();
		}//end if
		return rsvDao;
	}//getInstance
	
	public SqlSessionFactory getSessionFactory()throws IOException {//싱글턴 //ssf가 없는 경우에만 만들어지고 있다면 만들어지지 않는다.
		if(ssf==null) {
			
			Reader reader = null;
			try {
				//1.설정용 xml을 스트림으로 연결
					reader = Resources.getResourceAsReader("kr/co/prj/dao/mybatis-config.xml");
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
	
	public List<RoomInfoDomain> selectAllRoomInfo() throws SQLException{
		List<RoomInfoDomain> list = null;
		
		//3.Handler얻기
		try {
			SqlSession ss = getSessionFactory().openSession();
			list=ss.selectList("RoomInfoList"); //parameterType속성이 존재하지 없기 때문에 아이디만 넣는다.
			ss.close();
		} catch (IOException e) {
			e.printStackTrace();
		}//end catch
		
		return list;
		
	}//selectAllEmp
	
	
	
	
	public MemberCheckDomain selectMemberInfo(String user_id) throws SQLException{
		MemberCheckDomain mcd=null;
		
		try {
			//Handler 얻기
			SqlSession ss=getSessionFactory().openSession();
			//쿼리 수행 : 한 행 조회
			mcd=ss.selectOne("memberChk", user_id);
			ss.close();
		} catch (IOException e) {
			e.printStackTrace();
		}//end catch
	
	
		return mcd;
	}//selectMemberInfo 
	
	
	
}//class
