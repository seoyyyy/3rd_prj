package kr.co.prj.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;


import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.prj.service.SelectService;


/**
 * Spring 장점 : 가벼운 프레임워크, POJO(Plain Old Java Object)지원
 * Spring MVC는 요청처리를 method로 한다.
 * @author sist
 */
@Controller
public class RsvInputController {	
	@RequestMapping(value="reservation/rsv_input.do", method=RequestMethod.GET)
	public String revInputForm() {
		return "reservation/rsv_input";
	}//hello
	
	@RequestMapping(value="reservation/rsv_input1.do", method=RequestMethod.GET, produces = "application/json; charset=utf8")
	@ResponseBody
	public String searchMemberInfo(String user_id) {
		SelectService ss=new SelectService();
		JSONObject json=ss.multiColumn(user_id);
		System.out.println(json.toJSONString());
		return json.toJSONString();
	}//hello


}//class
