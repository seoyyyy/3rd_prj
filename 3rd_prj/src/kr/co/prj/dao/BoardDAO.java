package kr.co.prj.dao;

import java.io.IOException;
import java.io.Reader;
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
	
	public List<QnAListDomain> selectAllQnA()throws SQLException{
		List<QnAListDomain> list = null;
		
		//3.Handler���
		try {
			SqlSession ss = getSessionFactory().openSession();
			list=ss.selectList("qnaList"); //parameterType�Ӽ��� �������� ���� ������ ���̵� �ִ´�.
			ss.close();
		} catch (IOException e) {
			e.printStackTrace();
		}//end catch
		
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
		
		//3.Handler���
		try {
			SqlSession ss = getSessionFactory().openSession();
			list=ss.selectList("noticeList"); //parameterType�Ӽ��� �������� ���� ������ ���̵� �ִ´�.
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
