package kr.co.prj.service;

import java.sql.SQLException;
import java.util.List;

import kr.co.prj.dao.RoomConceptDAO;
import kr.co.prj.domain.RoomConceptDomain;

/**
 * Mainȭ�鿡�� �����ؾ��� �����͸� ����
 * @author owner
 */
public class RoomConceptService {
	public List<RoomConceptDomain> conceptInfo(){
		List<RoomConceptDomain>list=null;
		//DAO���� Ŭ������ �����Ͽ� DB�� ������ �޴´�.
		RoomConceptDAO rcDao = RoomConceptDAO.getInstance();
		try {
			list=rcDao.conceptInfo();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}//selectDept
}
