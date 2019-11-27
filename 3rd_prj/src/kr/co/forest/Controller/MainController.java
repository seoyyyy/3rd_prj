package kr.co.forest.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	@RequestMapping(value = "index.do")
	public String mainForm() {
		
		return "main/home";
	}
	//임시 매핑들
	@RequestMapping(value="rsv_main.do")
	public String rsvForm() {
		return "reservation/rsv_main";
	}//rsvForm
	@RequestMapping(value="introduce.do")
	public String introForm() {
		return "introduce/about";
	}//introduceForm
	@RequestMapping(value="about1.do")
	public String about1Form() {
		return "introduce/about1";
	}//introduceForm
	@RequestMapping(value="about2.do")
	public String about2Form() {
		return "introduce/about2";
	}//introduceForm
	@RequestMapping(value="location.do")
	public String locationForm() {
		return "contact/location";
	}//introduceForm
	@RequestMapping(value="login.do")
	public String loginForm() {
		return "login/login";
	}//introduceForm
	@RequestMapping(value="signUp.do")
	public String signUpForm() {
		return "login/signUp";
	}//introduceForm
}//class
