package kr.co.prj.service;

import java.sql.SQLException;
import java.util.List;

import kr.co.prj.dao.RoomDAO;
import kr.co.prj.domain.ConceptBriefDomain;
import kr.co.prj.domain.RoomInfoDomain;

/**
 * Mainȭ�鿡�� �����ؾ��� �����͸� ����
 * @author owner
 */
public class RoomService {
	public List<RoomInfoDomain> RoomInfo(String concept){
		List<RoomInfoDomain>list=null;
		//DAO���� Ŭ������ �����Ͽ� DB�� ������ �޴´�.
		RoomDAO rDao = RoomDAO.getInstance();
		try {
			list=rDao.RoomInfo(concept);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}//selectDept
	public ConceptBriefDomain conceptInfo(String concept){
		ConceptBriefDomain cbd=null;
		//DAO���� Ŭ������ �����Ͽ� DB�� ������ �޴´�.
		RoomDAO rDao = RoomDAO.getInstance();
		try {
			cbd=rDao.conceptInfo(concept);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cbd;
	}//selectDept
}
