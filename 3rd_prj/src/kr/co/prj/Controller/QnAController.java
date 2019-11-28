package kr.co.prj.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.prj.domain.QnABoardDetailDomain;
import kr.co.prj.domain.QnAListDomain;
import kr.co.prj.service.QnAService;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;


@Controller
public class QnAController {

	@RequestMapping(value="board/qna_list.do" ,method =GET)
	public String searchQnABoard(Model model) {
		 QnAService qs = new QnAService();
		 List<QnAListDomain> list = qs.searchAllQnA();
		 model.addAttribute("list", list);
		return "board/qna_list";
	}//searchBoard
	@RequestMapping(value="board/qna_post.do",method=GET)
	public String searchQnADetail(int q_num,Model model) {
		QnAService qs = new QnAService();
		QnABoardDetailDomain qbdd = qs.searchDetailQnA(q_num);
		model.addAttribute("qbdd",qbdd);
		return "board/qna_post";
	}//searchQnADetail
	@RequestMapping(value="board/write_form.do",method=GET)
	public String writeForm() {
		
		return "board/write_form";
	}//searchQnADetail
	
	
}//class
