package kr.co.prj.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ConfirmController {

	@RequestMapping(value="payment/confirm_parameter.do", method=RequestMethod.POST)
	//매개변수로 HttpServletRequest를 선언 : Spring MVC Framework에서
	//WAS에서 접속자가 요청할 때 생성되는 요청객체를 얻어 method arguments로
	//할당한다.
	public String useRequestParameter(HttpServletRequest request) {
//		//post한글처리 : filter설정을 한 이후에는 할 필요가 없습니다. 
//		try {
//			request.setCharacterEncoding("UTF-8");
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}//end catch
		
		//이름이 유일한 parameter 값 받기
		String name=request.getParameter("rsv_person");
		String[] phone=request.getParameterValues("phone");
		String email=request.getParameter("email");
		//이름이 동일한 parameter 값 받기
		String[] timetouse=request.getParameterValues("timetouse");
		String rsvRequest=request.getParameter("rsvRequest");
		
		request.setAttribute("phone", phone); //view로 값을 전달하기 위해 Scope객체에 값을 설정
		request.setAttribute("timetouse", timetouse); //view로 값을 전달하기 위해 Scope객체에 값을 설정
		
		System.out.println("이름 : "+name+"/ 이메일 : "+email );
		
			if(timetouse !=null ) {
				for ( int i=0; i <timetouse.length ; i++) {
					System.out.println(timetouse[i]);
				}//end if
			} else {
				System.out.println("선택한 취미 없음");
			}//end else
		
		
		return "payment/confirm_popup";
	
	}
}//class
	