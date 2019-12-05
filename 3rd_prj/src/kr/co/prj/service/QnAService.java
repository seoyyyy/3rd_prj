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
///////////////////////�ۿ°�////////////////////////////////////////
	
	/**
	 * �˻����� �޾Ƽ� �˻����� ���ٸ� ��ü ���� ������ ��ȸ�ϰ�, �˻����� �ִٸ� 
	 * �˻����� �ش��ϴ� ���� ������ ��ȸ�ϴ� ��.
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
	 * �� ȭ�鿡 ������ �Խù��� ��
	 * @return
	 */
	public int pageScale() {
		int pageScale=10;
		return pageScale;
	}//pageScale

	/**
	 * �� �������� �����ֱ� ���� �ʿ��� ������ ��
	 * @param pageScale �� ȭ�鿡 ������ �Խù��� �� 
	 * @param totalCount �� �Խù��� �� 
	 * @return
	 */
	public int totalPage(int pageScale, int totalCount) {
	  	int totalPage= totalCount/pageScale ;//��� �Խù��� �����ֱ� ���� �� ������ ��
	  	
		if ( totalCount % pageScale !=0 ) {// pageScale�� �� �������� ������ ������ �Խù��� �����ֱ� ���� �� �� �� �ʿ��ϴ�.
			totalPage++;
		} //end if
		//int totalPage=(int)Math.ceil( (double) totalCount / pageScale );
		
		return totalPage;
	}//totalPage
	/**
	 * �������� ���۹�ȣ ���ϴ� ��
	 * @param pageScale
	 * @param currentPage
	 * @return
	 */
	public int startNum( int pageScale, int currentPage) {
		int startNum=currentPage*pageScale()-pageScale()+1;
			
		return startNum;
	}//startNum
	
	/**
	 * �������� ����ȣ ���ϴ� ��
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
