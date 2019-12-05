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
import kr.co.prj.vo.QnAAddRpVO;
import kr.co.prj.vo.QnAModifyVO;
import kr.co.prj.vo.QnAWriteVO;
import kr.co.prj.vo.RpModifyVO;
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
		if( currentPage != null ) {//유효성 검증
			tempPage=Integer.parseInt(currentPage);
		}//end if
		
		QnAService qs = new QnAService();
		int pageScale=qs.pageScale(); //한 화면에 보여줄 글 수 
		int startNum=qs.startNum(pageScale, tempPage);// 시작번호
		int endNum=qs.endNum(pageScale, startNum); //끝 번호
		SearchVO sVO = new SearchVO(field,keyword,tempPage,startNum,endNum);
		int totalCount=qs.selectTotalCount(sVO); // 전체 글 조회
		int totalPage=qs.totalPage(pageScale, totalCount); //총 페이지 수
		
		
		
	

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
	}//modifyForm
	@RequestMapping(value="board/modify_process.do",method=POST)
	public String modifyProcess(QnAModifyVO qVo) {
		QnAService qs = new QnAService();
		
		qs.updatePostQnA(qVo);
		return "board/modify_process";
	}//modifyProcess
	@RequestMapping(value="board/addRp.do" , method=POST)
	public String addRp_process(QnAAddRpVO qarVO,Model model) {
		QnAService qs = new QnAService();
		qs.updateQnARp(qarVO);
		model.addAttribute("q_num",qarVO.getQ_num());
		return "board/addRp_process";
	}//addRp_process
	@RequestMapping(value="board/rp_modify.do", method=POST)
	public String rpModifyProcess(RpModifyVO rmVO,Model model) {
		QnAService qs = new QnAService();
		qs.replyModify(rmVO);
		model.addAttribute("q_num",rmVO.getQ_num());
		System.out.println(rmVO.getQ_answer()+"dd");
		return "board/reply_process";
	}//rpModifyProcess
}//class
