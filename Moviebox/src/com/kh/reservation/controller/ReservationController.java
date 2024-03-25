package com.kh.reservation.controller;

import javax.servlet.http.HttpServletRequest;

public class ReservationController {
	
	public String a(HttpServletRequest request) {
		
		request.getParameter("a");
		
		
		// 가공 ~
		
		// 서비스 호출 ~
		
		//request.getRequestDispatcher("view/~어ㅓㅉ고저쪽~~").forward(request, response);
		
		return "view/~어ㅓㅉ고저쪽~~";
		
	}
	
	public String b(HttpServletRequest request) {
		
		
		return "views/common/errorPage.jsp";
	}

	
}
