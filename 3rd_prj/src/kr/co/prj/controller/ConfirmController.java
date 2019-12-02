package kr.co.prj.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ConfirmController {

	@RequestMapping(value="payment/confirm_parameter.do", method=RequestMethod.POST)
	//�Ű������� HttpServletRequest�� ���� : Spring MVC Framework����
	//WAS���� �����ڰ� ��û�� �� �����Ǵ� ��û��ü�� ��� method arguments��
	//�Ҵ��Ѵ�.
	public String useRequestParameter(HttpServletRequest request) {
//		//post�ѱ�ó�� : filter������ �� ���Ŀ��� �� �ʿ䰡 �����ϴ�. 
//		try {
//			request.setCharacterEncoding("UTF-8");
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}//end catch
		
		//�̸��� ������ parameter �� �ޱ�
		String name=request.getParameter("rsv_person");
		String[] phone=request.getParameterValues("phone");
		String email=request.getParameter("email");
		//�̸��� ������ parameter �� �ޱ�
		String[] timetouse=request.getParameterValues("timetouse");
		String rsvRequest=request.getParameter("rsvRequest");
		
		request.setAttribute("phone", phone); //view�� ���� �����ϱ� ���� Scope��ü�� ���� ����
		request.setAttribute("timetouse", timetouse); //view�� ���� �����ϱ� ���� Scope��ü�� ���� ����
		
		System.out.println("�̸� : "+name+"/ �̸��� : "+email );
		
			if(timetouse !=null ) {
				for ( int i=0; i <timetouse.length ; i++) {
					System.out.println(timetouse[i]);
				}//end if
			} else {
				System.out.println("������ ��� ����");
			}//end else
		
		
		return "payment/confirm_popup";
	
	}
}//class
	