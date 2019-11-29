package kr.co.prj.service;

import java.sql.SQLException;

import kr.co.prj.dao.BoardDAO;
import kr.co.prj.dao.LoginDAO;
import kr.co.prj.vo.LoginVO;

public class LoginService {
	public String login(LoginVO lVo) {
		String id = "";
		LoginDAO loDao = LoginDAO.getInstance();
		try {
			id = loDao.login(lVo);
		} catch (SQLException e) {
			e.printStackTrace();
		}//end catch
		
		return id;
	}//login
}//class
