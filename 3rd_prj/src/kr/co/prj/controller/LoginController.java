package kr.co.prj.controller;

import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.prj.service.LoginService;
import kr.co.prj.vo.LoginVO;
import kr.co.sist.util.cipher.DataEncrypt;
 @Controller
public class LoginController {

	
	@RequestMapping(value="login/signUp.do")
	public String signUpForm() {
		return "login/signUp";
	}//introduceForm
	@RequestMapping(value="login/login.do")
	public String loginForm() {
		return "login/login";
	}//introduceForm
	
	@RequestMapping(value="login/login_process.do")
	public String loginProcess(HttpSession session,LoginVO lVO) {
		System.out.println( lVO.getInputId()+"/"+lVO.getInputPassword());
		
		String uri = "login/failLogin";
		try {
			lVO.setInputPassword(DataEncrypt.messageDigest("MD5", lVO.getInputPassword()));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		LoginService ls = new LoginService();
		if(ls.login(lVO)) {
			session.setAttribute("memberId", lVO.getInputId());
			uri = "main/home";
		}
		System.out.println("로그인 성공 아이디:"+session.getAttribute("memberId"));
		return uri;
	}
	
	@RequestMapping(value = "login/logout.do")
	public String logoutProcess(HttpSession session) {
		
		session.invalidate();
		
		
		return "main/home";
	}
	@RequestMapping(value = "login/find_id.do")
	public String findId() {
	
		
		return "login/find_id";
	}
	
	
}
