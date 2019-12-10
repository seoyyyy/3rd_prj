package kr.co.prj.dao;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.co.prj.domain.MyCardDomain;
import kr.co.prj.domain.MypageDomain;
import kr.co.prj.domain.MypageQnaDomain;

public class MypageDAO {
	private static MypageDAO mDao;
	private static SqlSessionFactory ssf;

	private MypageDAO() {
		org.apache.ibatis.logging.LogFactory.useLog4JLogging();
	}

	public static MypageDAO getInstance() {
		if (mDao == null) {
			mDao = new MypageDAO();
		} // end if
		return mDao;
	}// getInstance

	public SqlSessionFactory getSessionFactory() throws IOException {
		if (ssf == null) {
			Reader reader = null;

			try {
				// 1. 설정용 xml을 스트림으로 연결
				reader = Resources.getResourceAsReader("kr/co/prj/dao/mybatis-config.xml");
				// 2. SqlSessionFactoryBuilder 생성
				SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
				// 3. SqlSessionFactory 얻기
				ssf = ssfb.build(reader);

			} finally {
				if (reader != null) {
					reader.close();
				} // end if

			} // end finally
		} // end if
		return ssf;
	}// getSessionFactory
	
	//등록된 카드 
	public List<MyCardDomain> selectMypageCard(String id) throws SQLException {
		List<MyCardDomain> list = null;
		// 4. MyBatis Handler 얻기
		try {
			SqlSession ss = getSessionFactory().openSession();
			// parameterType 속성이 없기 때문에 아이디만 넣는다.
			list = ss.selectList("selectAllCard", id);

			ss.close();
		} catch (IOException e) {
			e.printStackTrace();
		} // end catch

		return list;
	}// mypageCard
	
	//문의확인
	public List<MypageQnaDomain> selectMyQna(String id) throws SQLException{
		List<MypageQnaDomain> list = null;
		try {
			SqlSession ss = getSessionFactory().openSession();
			list = ss.selectList("selectQna", id);
			ss.close();
		} catch (IOException e) {
			e.printStackTrace();
		} // end catch

		return list;
	}
	
	//등록된 카드 삭제
	public int deleteCard(String chk) throws SQLException {
		int cnt = 0;

		try {
			SqlSession ss = getSessionFactory().openSession();
			cnt = ss.delete("deleteCard", chk);
			if (cnt == 1) {
				ss.commit();
			} // end if
			ss.close();
		} catch (IOException e) {
			e.printStackTrace();
		} // end catch
		return cnt;
	}// deleteCard
	

	
	


}// class
