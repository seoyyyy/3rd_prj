package kr.co.prj.Controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.prj.domain.NoticeBoardDetailDomain;
import kr.co.prj.domain.NoticeListDomain;
import kr.co.prj.service.NoticeService;


@Controller
public class NoticeController {

	@RequestMapping(value="board/notice_list.do" ,method =RequestMethod.GET )
	public String searchNoticeBoard(Model model) {
		NoticeService ns = new NoticeService();
		List<NoticeListDomain> list= ns.searchAllNotice();
		model.addAttribute("list",list);
		return "board/notice_list";
	}//searchBoard
	
	@RequestMapping(value="board/notice_post.do" ,method =RequestMethod.GET )
	public String searchNoticeDetail(int n_num,Model model) {
		NoticeService ns = new NoticeService();
		NoticeBoardDetailDomain nbdd = ns.searchDetailNotice(n_num);
		model.addAttribute("nbdd",nbdd);
		return "board/notice_post";
	}//searchBoard
	

	
}//class
