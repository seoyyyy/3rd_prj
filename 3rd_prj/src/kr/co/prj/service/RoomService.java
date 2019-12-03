package kr.co.prj.service;

import java.sql.SQLException;
import java.util.List;

import kr.co.prj.dao.RoomDAO;
import kr.co.prj.domain.RoomInfoDomain;

/**
 * Mainȭ�鿡�� �����ؾ��� �����͸� ����
 * @author owner
 */
public class RoomService {
	public List<RoomInfoDomain> RoomInfo(){
		List<RoomInfoDomain>list=null;
		//DAO���� Ŭ������ �����Ͽ� DB�� ������ �޴´�.
		RoomDAO rDao = RoomDAO.getInstance();
		try {
			list=rDao.RoomInfo();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}//selectDept
}
