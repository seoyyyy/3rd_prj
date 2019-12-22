package kr.co.prj.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.prj.domain.RoomInfoDomain;
import kr.co.prj.service.RoomInfoService;

/**
 * Spring ���� : ������ �����ӿ�ũ, POJO(Plain Old Java Object)����
 * Spring MVC�� ��ûó���� method�� �Ѵ�.
 * @author sist
 */
@Controller
public class RsvMainController {
	@RequestMapping(value="reservation/rsv_main.do", method=RequestMethod.GET)
	public String rsvMain(Model model) {
		
		RoomInfoService ris=new RoomInfoService();
		List<RoomInfoDomain> RoomInfolist = ris.searchRoomInfo();
		
			 model.addAttribute("RoomInfo", RoomInfolist);
			
			 
			 return "reservation/rsv_main";
		
	}//rsvMain
	
	
	
	
}//class











