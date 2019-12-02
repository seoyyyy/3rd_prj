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
	
	public List<RoomInfoDomain> selectAllRoomInfo() throws SQLException{
		List<RoomInfoDomain> list = null;
		
		//3.Handler���
		try {
			SqlSession ss = getSessionFactory().openSession();
			list=ss.selectList("RoomInfoList"); //parameterType�Ӽ��� �������� ���� ������ ���̵� �ִ´�.
			ss.close();
		} catch (IOException e) {
			e.printStackTrace();
		}//end catch
		
		return list;
		
	}//selectAllEmp
	
	
	
	
	public MemberCheckDomain selectMemberInfo(String user_id) throws SQLException{
		MemberCheckDomain mcd=null;
		
		try {
			//Handler ���
			SqlSession ss=getSessionFactory().openSession();
			//���� ���� : �� �� ��ȸ
			mcd=ss.selectOne("memberChk", user_id);
			ss.close();
		} catch (IOException e) {
			e.printStackTrace();
		}//end catch
	
	
		return mcd;
	}//selectMemberInfo 
	
	
	
}//class
