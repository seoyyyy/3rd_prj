package kr.co.prj.service;

import java.sql.SQLException;
import java.util.List;

import kr.co.prj.dao.BoardDAO;
import kr.co.prj.domain.QnABoardDetailDomain;
import kr.co.prj.domain.QnAListDomain;

public class QnAService {
	
	public List<QnAListDomain> searchAllQnA(){
		List<QnAListDomain> list= null;
		BoardDAO bDao = BoardDAO.getInstance();
		try {
			list=bDao.selectAllQnA();
		
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
}//class
