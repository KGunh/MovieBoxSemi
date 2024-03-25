package com.kh.reservation.controller;

<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 26517526f38e10894c270720163ac98e724801ff
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.kh.reservation.model.service.ReservationService;
import com.kh.theater.model.vo.Screen;

public class ReservationController {
	
	public String selectReservationInfo(HttpServletRequest request) {
		request.setAttribute("movieList", new ReservationService().selectMovieList()); 
		request.setAttribute("locationList", new ReservationService().selectLocationList()); 
		
		String view = "views/reservation/seatReservation.jsp";
		
		return view;
	}

	public ArrayList<Screen> selectScreen(HttpServletRequest request) {
		String[] dateStr = request.getParameter("date").split("-");
		String screenLocation = request.getParameter("location");
		String screenDate = "";
		int movieNo = 0;
		
		if (dateStr.length >= 3) { // 예외처리
			screenDate = dateStr[0].substring(2) + "/" + dateStr[1] + "/" + dateStr[2];
		}
		
		if(!request.getParameter("movieNo").equals("")) { // 예외처리
			movieNo = Integer.parseInt(request.getParameter("movieNo"));
		}
		
		if(screenLocation.equals("전체")) screenLocation = ""; //예외처리

		ArrayList<Screen> screenList = new ReservationService().selectScreen(screenDate, screenLocation, movieNo); 
		
		return screenList;
	}

	public void setSeat(HttpServletRequest request) {
		request.getParameter("");
		// 좌석선택 화면으로 이동
		
	}
	
	public void insertReservation() {
		//예약내용 insert
	}

<<<<<<< HEAD

=======
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
>>>>>>> b5cca4dda70eae2c057d74ae145dc247e35c7678

=======
>>>>>>> 26517526f38e10894c270720163ac98e724801ff
	
}
