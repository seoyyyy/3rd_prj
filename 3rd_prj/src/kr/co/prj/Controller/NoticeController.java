package kr.co.prj.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class NoticeController {

	@RequestMapping(value="board/notice_list.do" ,method =RequestMethod.GET )
	public String searchNoticeBoard() {
		
		return "board/notice_list";
	}//searchBoard
	

	
}//class
