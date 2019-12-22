package kr.co.prj.controller;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.prj.domain.DiaryDomain;
import kr.co.prj.service.ReservationService;
import kr.co.prj.vo.DiaryResultVO;
import kr.co.prj.vo.DiarySearchVO;

/**
 * Spring 장점 : 가벼운 프레임워크, POJO(Plain Old Java Object)지원
 * Spring MVC는 요청처리를 method로 한다.
 * @author sist
 */
@Controller 
public class DiaryController { 
	@RequestMapping(value="diary/diary.do")
	public String diary(HttpSession session,String image1,String room_name,String charge,Integer year,Integer month,Model model) { 
		System.out.println("------gdgd-dfdsdsdssf-"+image1);
		String uri ="reservation/diary/diary";
		if(session.getAttribute("memberId")==null) {
			uri ="redirect:/login/login.do";
		}
		if(room_name !=null && image1 !=null && charge !=null) {
			
			session.setAttribute("room_name", room_name);
			session.setAttribute("image1", image1);
			session.setAttribute("charge", charge);
		}
		int year1 = Calendar.getInstance().get(Calendar.YEAR);
		int month1 = Calendar.getInstance().get(Calendar.MONTH);
		if(year !=null || month !=null) {
			year1 =year;
			month1 =month;
		}
		/*
		 * switch (month1) { case 12: month1=0; break;
		 * 
		 * case -1: month1=11; break;
		 * 
		 * default: break; }
		 */
	System.out.println(session.getAttribute("memberId")+room_name+"/"+image1+"/"+charge);
	System.out.println(year1+"/"+month1);
	
	System.out.println("파라메터로 받은"+year+"/"+month);
	DiarySearchVO dsVO = new DiarySearchVO((String)session.getAttribute("room_name"), year1, month1+1);
	System.out.println(dsVO+"---------------------");
	ReservationService rs = new ReservationService();
	List<DiaryDomain> dList = rs.diaryList(dsVO);
	System.out.println(dList);
	Map<Integer, DiaryResultVO[]> map = new HashMap<Integer, DiaryResultVO[]>();
	DiaryResultVO[] drArr = null;
	
	for (int i = 0; i < dList.size(); i++) {
		if(map.containsKey(dList.get(i).getDay())) {
			map.get(dList.get(i).getDay())[dList.get(i).getR_time()-1]= new DiaryResultVO(dList.get(i).getReservation_num(), dList.get(i).getUser_id(), dList.get(i).getR_time());
		}else {
			drArr = new DiaryResultVO[4];
			drArr[dList.get(i).getR_time()-1]=new DiaryResultVO(dList.get(i).getReservation_num(), dList.get(i).getUser_id(), dList.get(i).getR_time());
			map.put(dList.get(i).getDay(),drArr);
		}
		
	}
	model.addAttribute("rListMap", map);
	
	
		return uri;
	}//hello
}//class




