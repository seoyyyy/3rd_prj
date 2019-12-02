package kr.co.prj.service;

import java.sql.SQLException;
import java.util.List;

import kr.co.prj.dao.BoardDAO;
import kr.co.prj.domain.NoticeBoardDetailDomain;
import kr.co.prj.domain.NoticeListDomain;
import kr.co.prj.domain.QnABoardDetailDomain;
import kr.co.prj.vo.SearchRangeVO;
import kr.co.prj.vo.SearchVO;

public class NoticeService {
	
	/**
	 * �˻����� �޾Ƽ� �˻����� ���ٸ� ��ü ���� ������ ��ȸ�ϰ�, �˻����� �ִٸ� 
	 * �˻����� �ش��ϴ� ���� ������ ��ȸ�ϴ� ��.
	 * @param sVO
	 * @return
	 */
	public int selectTotalCount(SearchVO sVO) {
		int cnt = 0;
		String mappedId="noticeTotalCount";
		BoardDAO bDao = BoardDAO.getInstance();
		try {
			cnt = bDao.selectTotalCount(mappedId,sVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}//end catch
		return cnt;
	}
	
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

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
	
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	public List<NoticeListDomain> searchAllNotice( SearchVO sVO){
		List<NoticeListDomain> noticeList= null;
		BoardDAO bDao = BoardDAO.getInstance();
		try {
			noticeList=bDao.selectAllNotice(sVO);
		
		} catch (SQLException e) {
			e.printStackTrace();
		}//end catch
		return noticeList;
	}//searchAllNotice
	public NoticeBoardDetailDomain searchDetailNotice(int num){
		NoticeBoardDetailDomain nbdd =null;
		BoardDAO bDao = BoardDAO.getInstance();
		
		try {
			nbdd = bDao.selectDetailNotice(num);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}//end catch
		return nbdd;
	}//searchDetailQnA
}//class
