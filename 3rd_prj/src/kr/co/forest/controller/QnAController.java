package kr.co.forest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class QnAController {

	@RequestMapping(value="qna_list.do" ,method =RequestMethod.GET )
	public String searchQnABoard() {
		
		return "board/qna_list";
	}//searchBoard
	
	
	
}//class
