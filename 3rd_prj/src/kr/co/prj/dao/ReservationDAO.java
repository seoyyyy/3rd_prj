package kr.co.prj.dao;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.co.prj.domain.BankInfoDomain;
import kr.co.prj.domain.DiaryDomain;
import kr.co.prj.domain.MemberCheckDomain;
import kr.co.prj.domain.RoomInfoDomain;
import kr.co.prj.domain.RsvTimeDomain;
import kr.co.prj.vo.DiarySearchVO;
import kr.co.prj.vo.ParamDateVO;
import kr.co.prj.vo.RTimeVO;
import kr.co.prj.vo.ReservationTimeVO;
import kr.co.prj.vo.ReservationTotalVO;
import kr.co.prj.vo.ReservationVO;

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
	public List<RTimeVO> selectReservationTime(String rNum) throws SQLException{
		List<RTimeVO> list = null;
		
		//3.Handler���
		try {
			SqlSession ss = getSessionFactory().openSession();
			list=ss.selectList("rTime",rNum); //parameterType�Ӽ��� �������� ���� ������ ���̵� �ִ´�.
			ss.close();
		} catch (IOException e) {
			e.printStackTrace();
		}//end catch
		
		return list;
		
	}//selectAllEmp
	
	public ReservationTotalVO selectReservation(String rNum) throws SQLException{
		ReservationTotalVO rVO = null;
		
		//3.Handler���
		try {
			SqlSession ss = getSessionFactory().openSession();
			rVO=ss.selectOne("reservation",rNum); //parameterType�Ӽ��� �������� ���� ������ ���̵� �ִ´�.
			ss.close();
		} catch (IOException e) {
			e.printStackTrace();
		}//end catch
		
		return rVO;
		
	}//selectAllEmp
	public List<ReservationTotalVO> selectReservation2(String id) throws SQLException{
		List<ReservationTotalVO> list = null;
		
		//3.Handler���
		try {
			SqlSession ss = getSessionFactory().openSession();
			list=ss.selectList("reservation2",id); //parameterType�Ӽ��� �������� ���� ������ ���̵� �ִ´�.
			ss.close();
		} catch (IOException e) {
			e.printStackTrace();
		}//end catch
		
		return list;
		
	}//selectAllEmp
	
	public List<RsvTimeDomain> selectRsvTime() throws SQLException{
		List<RsvTimeDomain> list = null;
		
		//3.Handler���
		try {
			SqlSession ss = getSessionFactory().openSession();
			list=ss.selectList("selectRsvTime"); //parameterType�Ӽ��� �������� ���� ������ ���̵� �ִ´�.
			ss.close();
		} catch (IOException e) {
			e.printStackTrace();
		}//end catch
		
		return list;
		
	}//selectAllEmp
	
	public List<DiaryDomain> diaryList(DiarySearchVO dsVO) throws SQLException{
		List<DiaryDomain> list = null;
		
		//3.Handler���
		try {
			SqlSession ss = getSessionFactory().openSession();
			list=ss.selectList("diaryList",dsVO); //parameterType�Ӽ��� �������� ���� ������ ���̵� �ִ´�.
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
	
	
	public int selectRoomCharge(String room_name) throws SQLException{
		int roomCharge=0;
		
		try {
			//Handler ���
			SqlSession ss=getSessionFactory().openSession();
			//���� ���� : �� �� ��ȸ
			System.out.println(room_name+"---------���̸�");
			roomCharge=ss.selectOne("selectRoomCharge", room_name);
			ss.close();
		} catch (IOException e) {
			e.printStackTrace();
		}//end catch
		
		
		return roomCharge;
	}//selectMemberInfo 
	
	
	
	public boolean insertReservation(ReservationVO rsvVO) {
		boolean insertFlag=false;
		
		try {
			//Handler ���
			SqlSession ss=getSessionFactory().openSession();
			//���� ���� : �� �� ��ȸ
			insertFlag=ss.insert("insertReservation",rsvVO)==1;
			ss.commit();
			ss.close();
		} catch (IOException e) {
			e.printStackTrace();
		}//end catch
		
		return insertFlag;
		
	}//insertReservation
	
	public boolean insertReservationTime(ReservationTimeVO rsvTVO) {
		boolean insertFlag=false;
		
		try {
			//Handler ���
			SqlSession ss=getSessionFactory().openSession();
			//���� ���� : �� �� ��ȸ
			insertFlag=ss.insert("insertTime",rsvTVO)==1;
			ss.commit();
			ss.close();
		} catch (IOException e) {
			e.printStackTrace();
		}//end catch
		
		return insertFlag;
		
	}//insertReservation
	
	
	
	
	public String getReservationNum() {
		String reservationCode = "";
		
		try {
			//Handler ���
			SqlSession ss=getSessionFactory().openSession();
			//���� ���� : �� �� ��ȸ
			reservationCode=ss.selectOne("reservationCode");
		
			ss.close();
		} catch (IOException e) {
			e.printStackTrace();
		}//end catch
		
		return reservationCode;
		
	}//insertReservation
	
	public BankInfoDomain selectBankInfo(String rNum) throws SQLException{
		BankInfoDomain bid=null;
		
		try {
			//Handler ���
			SqlSession ss=getSessionFactory().openSession();
			//���� ���� : �� �� ��ȸ
			bid=ss.selectOne("bankInfo", rNum);
			ss.close();
		} catch (IOException e) {
			e.printStackTrace();
		}//end catch
	
	
		return bid;
	}//selectMemberInfo 
	
	public List<Integer> timeCheck(ParamDateVO pdVO) throws SQLException{
		List<Integer> cnt = null;
		
		try {
			//Handler ���
			SqlSession ss=getSessionFactory().openSession();
			//���� ���� : �� �� ��ȸ
			cnt=ss.selectList("rsvTimeCheck", pdVO);
			ss.close();
		} catch (IOException e) {
			e.printStackTrace();
		}//end catch
	
		
		
		return cnt;
	}
	
}//class










