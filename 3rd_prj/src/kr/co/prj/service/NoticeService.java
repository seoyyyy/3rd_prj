package kr.co.prj.service;

import java.sql.SQLException;
import java.util.List;

import kr.co.prj.dao.BoardDAO;
import kr.co.prj.domain.NoticeBoardDetailDomain;
import kr.co.prj.domain.NoticeListDomain;
import kr.co.prj.domain.QnABoardDetailDomain;

public class NoticeService {
	
	public List<NoticeListDomain> searchAllNotice(){
		List<NoticeListDomain> noticeList= null;
		BoardDAO bDao = BoardDAO.getInstance();
		try {
			noticeList=bDao.selectAllNotice();
		
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
