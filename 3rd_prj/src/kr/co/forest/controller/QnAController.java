package kr.co.forest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;


@Controller
public class QnAController {

	@RequestMapping(value="qna_list.do" ,method =GET)
	public String searchQnABoard() {
		
		return "board/qna_list";
	}//searchBoard
	@RequestMapping(value="qna_post.do",method=GET)
	public String searchQnADetail() {
		
		return "board/qna_post";
	}//searchQnADetail
	
	
}//class
