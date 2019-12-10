package kr.co.prj.controller;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.prj.domain.MyCardDomain;
import kr.co.prj.domain.MypageQnaDomain;
import kr.co.prj.service.MypageService;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

import javax.servlet.http.HttpSession;


@Controller
public class MypageController {
	
	@RequestMapping(value = "login/mypage.do", method =GET )
	public String mypageMain(HttpSession session, Model model) {
		
		MypageService ss=new MypageService();
		//��ϵ� ī��
		String id= (String)session.getAttribute("memberId");
		List<MyCardDomain> cardList=ss.selectAllCard(id);
		
		//����Ȯ�� 
		List<MypageQnaDomain> qnaList=ss.selectQna(id);

		model.addAttribute("cardData", cardList);
		model.addAttribute("qnaData", qnaList);
		
		String url = "mypage/loginMyPage";
		
		if (id == null) {
			url = "main/home";
		}//end if
		
		//System.out.println((String)session.getAttribute("memberId")); 		
		return url;
	}//mypageMain
	
	//��ϵ� ī�� ����
	@RequestMapping(value = "login/deleteCard.do",method =RequestMethod.POST)
	public String deleteCard(String chk) {
		System.out.println("Dasda");
		System.out.println(chk.trim()+"ī�� ��ȣ");
		MypageService ss=new MypageService();
		
		boolean deleteCard=ss.removeCard(chk);
		
		
		return "redirect:mypage.do";
	}

}//class
