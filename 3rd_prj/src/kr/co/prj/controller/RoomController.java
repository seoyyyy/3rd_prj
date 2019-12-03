package kr.co.prj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.co.prj.domain.RoomInfoDomain;
import kr.co.prj.service.RoomService;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;

@Controller
public class RoomController {
	
	@RequestMapping(value = "introduce/introduce.do",method =GET)
	public String RoomInfo(Model model) {
		RoomService rs=new RoomService();
		List<RoomInfoDomain> RoomInfolist = rs.RoomInfo();
			 model.addAttribute("RoomInfo", RoomInfolist);
		return "introduce/about";
	}//addEmpForm
	
}//class
