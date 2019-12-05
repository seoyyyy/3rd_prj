package kr.co.prj.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.ui.Model;

import kr.co.prj.dao.BoardDAO;
import kr.co.prj.domain.QnABoardDetailDomain;
import kr.co.prj.domain.QnAListDomain;
import kr.co.prj.vo.QnAAddRpVO;
import kr.co.prj.vo.QnAModifyVO;
import kr.co.prj.vo.QnAWriteVO;
import kr.co.prj.vo.RpModifyVO;
import kr.co.prj.vo.SearchRangeVO;
import kr.co.prj.vo.SearchVO;


public class QnAService {
///////////////////////퍼온것////////////////////////////////////////
	
	/**
	 * 검색값을 받아서 검색값이 없다면 전체 글의 갯수를 조회하고, 검색값이 있다면 
	 * 검색값에 해당하는 글의 갯수를 조회하는 일.
	 * @param sVO
	 * @return
	 */
	public int selectTotalCount(SearchVO sVO) {
		int cnt = 0;
		String mappedId="qnaTotalCount";
		BoardDAO bDao = BoardDAO.getInstance();
		try {
			cnt = bDao.selectTotalCount(mappedId,sVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}//end catch
		return cnt;
	}
	
	/**
	 * 한 화면에 보여줄 게시물의 수
	 * @return
	 */
	public int pageScale() {
		int pageScale=10;
		return pageScale;
	}//pageScale

	/**
	 * 총 페이지를 보여주기 위해 필요한 페이지 수
	 * @param pageScale 한 화면에 보여줄 게시물의 수 
	 * @param totalCount 총 게시물의 수 
	 * @return
	 */
	public int totalPage(int pageScale, int totalCount) {
	  	int totalPage= totalCount/pageScale ;//모든 게시물을 보여주기 위한 총 페이지 수
	  	
		if ( totalCount % pageScale !=0 ) {// pageScale로 딱 떨어지지 않으면 나머지 게시물을 보여주기 위해 한 장 더 필요하다.
			totalPage++;
		} //end if
		//int totalPage=(int)Math.ceil( (double) totalCount / pageScale );
		
		return totalPage;
	}//totalPage
	/**
	 * 페이지의 시작번호 구하는 일
	 * @param pageScale
	 * @param currentPage
	 * @return
	 */
	public int startNum( int pageScale, int currentPage) {
		int startNum=currentPage*pageScale()-pageScale()+1;
			
		return startNum;
	}//startNum
	
	/**
	 * 페이지의 끝번호 구하는 일
	 * @param pageScale
	 * @param startNum
	 * @return
	 */
	public int endNum(int pageScale, int startNum) {
		int endNum=startNum+pageScale-1;
		return endNum;
	}//endNum
	
///////////////////////////////////////////////////////////////
	
	public List<QnAListDomain> searchAllQnA( SearchVO sVO){
		List<QnAListDomain> list= null;
		BoardDAO bDao = BoardDAO.getInstance();
		try {
			list=bDao.selectAllQnA(sVO);
		
		} catch (SQLException e) {
			e.printStackTrace();
		}//end catch
		 
		
		return list;
	}//searchAllQnA
	public QnABoardDetailDomain searchDetailQnA(int num){
		QnABoardDetailDomain qbdd =null;
		BoardDAO bDao = BoardDAO.getInstance();
		
		try {
			qbdd = bDao.selectDetailQnA(num);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}//end catch
		return qbdd;
	}//searchDetailQnA
	
	public int insertQnAPost(QnAWriteVO qwVO) {
		int cnt = 0;
		
		BoardDAO bDAO = BoardDAO.getInstance();
		cnt = bDAO.insertQnAPost(qwVO);
		
		return cnt;
	}//insertQnAPost
	
	public int deletePostQnA(int q_num) {
		int cnt=0;
		BoardDAO bDAO = BoardDAO.getInstance();
		cnt = bDAO.deletePostQnA(q_num);
		
		return cnt;
	}//deletePostQnA
	public int updatePostQnA(QnAModifyVO qVo) {
		int cnt = 0;
		BoardDAO bDAO = BoardDAO.getInstance();
		cnt = bDAO.updatePostQnA(qVo);
		return cnt;
	}//deletePostQnA
	public int updateQnARp(QnAAddRpVO qarVO) {
		int cnt = 0;
		BoardDAO bDAO = BoardDAO.getInstance();
		cnt = bDAO.updateQnARp(qarVO);
		return cnt;
	}//deletePostQnA
	
	public int replyModify(RpModifyVO rmVO) {
		int cnt =0;
		BoardDAO bDAO = BoardDAO.getInstance();
		cnt = bDAO.replyModify(rmVO);
		return cnt;
	}//replyModify 
}//class
