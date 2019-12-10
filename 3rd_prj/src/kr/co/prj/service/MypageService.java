package kr.co.prj.service;

import java.sql.SQLException;
import java.util.List;

import org.json.simple.JSONObject;

import kr.co.prj.dao.MypageDAO;
import kr.co.prj.domain.MyCardDomain;
import kr.co.prj.domain.MypageQnaDomain;

/**
 * 등록된 카드 화면에서 제공해야 할 데이터 생성
 * @author kangg
 */
public class MypageService {	
	
	//등록된 카드
	public List<MyCardDomain> selectAllCard(String id){
		List<MyCardDomain> list=null;
		
		MypageDAO mDao=MypageDAO.getInstance();
		try {
			list = mDao.selectMypageCard(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}//end catch
		
		return list;
	}//selectCard
	
	//문의확인
	public List<MypageQnaDomain> selectQna(String id){
		List<MypageQnaDomain> qnaList=null;
		
		MypageDAO mDao=MypageDAO.getInstance();
		try {
			qnaList=mDao.selectMyQna(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return qnaList;
	}//selectQna
	
	//등록된 카드 삭제
	public boolean removeCard(String chk) {
		boolean flag=false;
		
		MypageDAO mDao=MypageDAO.getInstance();
		try {
			flag= mDao.deleteCard(chk) ==1;
		} catch (SQLException e) {
			e.printStackTrace();
		}//end catch
		return flag;
	}//removeCard
	
	 	
}//class
