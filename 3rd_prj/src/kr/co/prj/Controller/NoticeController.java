package kr.co.prj.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.prj.domain.NoticeBoardDetailDomain;
import kr.co.prj.domain.NoticeListDomain;
import kr.co.prj.service.NoticeService;
import kr.co.prj.vo.SearchRangeVO;
import kr.co.prj.vo.SearchVO;


@Controller
public class NoticeController {

	@RequestMapping(value="board/notice_list.do" ,method =RequestMethod.GET )
	public String searchNoticeBoard(HttpServletRequest request,Model model) {
		
		String currentPage = request.getParameter("page");
		String field = request.getParameter("field");
		String keyword = request.getParameter("keyword");
		
		int tempPage=1;
		if( currentPage != null ) {//유효성 검증
			tempPage=Integer.parseInt(currentPage);
		}//end if
		
		NoticeService ns = new NoticeService();
		
		int pageScale=ns.pageScale(); //한 화면에 보여줄 글 수 
		int startNum=ns.startNum(pageScale, tempPage);// 시작번호
		int endNum=ns.endNum(pageScale, startNum); //끝 번호
		SearchVO sVO = new SearchVO(field,keyword,tempPage,startNum,endNum);
		int totalCount=ns.selectTotalCount(sVO); // 전체 글 조회
		int totalPage=ns.totalPage(pageScale, totalCount); //총 페이지 수
		
		SearchRangeVO srVO = new SearchRangeVO(startNum,endNum);
		List<NoticeListDomain> list= ns.searchAllNotice(sVO);
		model.addAttribute("list",list);
		model.addAttribute("totalPage", totalPage);
		
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
