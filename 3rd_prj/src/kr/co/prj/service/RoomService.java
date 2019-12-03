package kr.co.prj.service;

import java.sql.SQLException;
import java.util.List;

import kr.co.prj.dao.RoomDAO;
import kr.co.prj.domain.RoomInfoDomain;

/**
 * Main화면에서 제공해야할 데이터를 정의
 * @author owner
 */
public class RoomService {
	public List<RoomInfoDomain> RoomInfo(){
		List<RoomInfoDomain>list=null;
		//DAO단의 클래스를 생성하여 DB의 정보를 받는다.
		RoomDAO rDao = RoomDAO.getInstance();
		try {
			list=rDao.RoomInfo();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}//selectDept
}
