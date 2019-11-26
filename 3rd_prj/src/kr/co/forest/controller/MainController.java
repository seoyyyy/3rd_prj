package kr.co.forest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	@RequestMapping(value = "main.do")
	public String mainForm() {
		
		return "main/home";
	}
}//class
