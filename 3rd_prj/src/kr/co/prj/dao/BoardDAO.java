package kr.co.prj.dao;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.co.prj.domain.LoginDomain;
import kr.co.prj.domain.NoticeBoardDetailDomain;
import kr.co.prj.domain.NoticeListDomain;
import kr.co.prj.domain.QnABoardDetailDomain;
import kr.co.prj.domain.QnAListDomain;
import kr.co.prj.vo.LoginVO;
import kr.co.prj.vo.SearchVO;


public class BoardDAO {

	private static BoardDAO bdDao;
	public static SqlSessionFactory ssf;
	
	private BoardDAO() {
		org.apache.ibatis.logging.LogFactory.useLog4JLogging();
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
	
	
	///////////////////////////////////////////////////퍼온것///////////////////////////////////////////////////////////////
	
	
	/**
	 * 전체 게시물의 수 
	 * @return
	 * @throws SQLException
	 */
	public int selectTotalCount(SearchVO dsVO) throws SQLException{
		int cnt=0;
		try {
			SqlSession ss = getSessionFactory().openSession();
		} catch (IOException e) {
			e.printStackTrace();
		}//end catch
		
			
		return cnt;
	}//selectTotalCount
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
	public List<QnAListDomain> selectAllQnA()throws SQLException{
		List<QnAListDomain> list = null;
		
		//3.Handler얻기
		try {
			SqlSession ss = getSessionFactory().openSession();
			list=ss.selectList("qnaList"); //parameterType속성이 존재하지 없기 때문에 아이디만 넣는다.
			ss.close();
		} catch (IOException e) {
			e.printStackTrace();
		}//end catch
		System.out.println("안녕하세욥욥욥ㅇ뵹뵤욥ㅇ뵹뵤욥욥요뵤뚠뚠이~~");
		return list;
		
	}//selectAllEmp
	
	public QnABoardDetailDomain selectDetailQnA(int q_num)throws SQLException{
		QnABoardDetailDomain qbdd = null;
		try {
			SqlSession ss = getSessionFactory().openSession();
			qbdd = ss.selectOne("qnaPost", q_num);
			ss.close();
		} catch (IOException e) {
			e.printStackTrace();
		}//end catch
		return qbdd;
	}//selectDetailQnA
	
	public List<NoticeListDomain> selectAllNotice()throws SQLException{
		List<NoticeListDomain> list = null;
		
		//3.Handler얻기
		try {
			SqlSession ss = getSessionFactory().openSession();
			list=ss.selectList("noticeList"); //parameterType속성이 존재하지 없기 때문에 아이디만 넣는다.
			ss.close();
		} catch (IOException e) {
			e.printStackTrace();
		}//end catch
		
		return list;
		
	}//selectAllNotice
	public NoticeBoardDetailDomain selectDetailNotice(int n_num)throws SQLException{
		NoticeBoardDetailDomain nbdd = null;
		try {
			SqlSession ss = getSessionFactory().openSession();
			nbdd = ss.selectOne("noticePost", n_num);
			ss.close();
		} catch (IOException e) {
			e.printStackTrace();
		}//end catch
		return nbdd;
	}//selectDetailQnA

}//class
