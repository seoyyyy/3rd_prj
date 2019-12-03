package kr.co.prj.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.prj.domain.QnABoardDetailDomain;
import kr.co.prj.domain.QnAListDomain;
import kr.co.prj.service.QnAService;
import kr.co.prj.vo.QnAModifyVO;
import kr.co.prj.vo.QnAWriteVO;
import kr.co.prj.vo.SearchRangeVO;
import kr.co.prj.vo.SearchVO;


@Controller
public class QnAController {

	@RequestMapping(value="board/qna_list.do",method =GET)
	public String searchQnABoard(HttpServletRequest request,Model model) {

		String currentPage = request.getParameter("page");
		String field = request.getParameter("field");
		String keyword = request.getParameter("keyword");
		
		int tempPage=1;
		if( currentPage != null ) {//��ȿ�� ����
			tempPage=Integer.parseInt(currentPage);
		}//end if
		
		QnAService qs = new QnAService();
		int pageScale=qs.pageScale(); //�� ȭ�鿡 ������ �� �� 
		int startNum=qs.startNum(pageScale, tempPage);// ���۹�ȣ
		int endNum=qs.endNum(pageScale, startNum); //�� ��ȣ
		SearchVO sVO = new SearchVO(field,keyword,tempPage,startNum,endNum);
		int totalCount=qs.selectTotalCount(sVO); // ��ü �� ��ȸ
		int totalPage=qs.totalPage(pageScale, totalCount); //�� ������ ��
		
		
		
	

		SearchRangeVO srVO = new SearchRangeVO(startNum,endNum);
		 List<QnAListDomain> list = qs.searchAllQnA(sVO);
		 model.addAttribute("list", list);
		 model.addAttribute("totalPage", totalPage);
		 return "board/qna_list";
	}//searchBoard
	
	@RequestMapping(value="board/qna_post.do",method= {GET,POST})
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
	/**
	 * @param session
	 * @param qwVO
	 * @return
	 */
	@RequestMapping(value="board/write_post.do",method=POST)
	public String writeProcess(HttpSession session,QnAWriteVO qwVO) {
		QnAService qs = new QnAService();
		 qs.insertQnAPost(qwVO);
		return "board/write_process";
	}
	@RequestMapping(value="board/delete_post.do",method=GET)
	public String deleteProcess(int q_num) {
		QnAService qs = new QnAService();
	
		qs.deletePostQnA(q_num);
		return "board/delete_process";
	}//deleteProcess
	@RequestMapping(value="board/modify_form.do",method=POST)
	public String modifyForm() {
		
		return "board/modify_form";
	}
	@RequestMapping(value="board/modify_process.do",method=POST)
	public String modifyProcess(QnAModifyVO qVo) {
		QnAService qs = new QnAService();
		
		qs.updatePostQnA(qVo);
		return "board/modify_process";
	}
}//class
