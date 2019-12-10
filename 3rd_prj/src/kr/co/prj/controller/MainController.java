package kr.co.prj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	@RequestMapping(value = "index.do")
	public String mainForm() {
		return "main/home";
	}
	
	
		@RequestMapping(value="contact/location.do")
		public String locationForm() {
			return "contact/location";
		}//introduceForm

		
	
	
	
	
	
	
	
	
}//class
