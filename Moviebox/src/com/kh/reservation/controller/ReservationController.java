package com.kh.reservation.controller;

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
		String screenDate = dateStr[0].substring(2) + "/" + dateStr[1] + "/" + dateStr[2];
		
		String screenLocation = request.getParameter("location");
		
		int movieNo = Integer.parseInt(request.getParameter("movieNo"));
		
		ArrayList<Screen> screenList = new ReservationService().selectScreen(screenDate, screenLocation, movieNo); 
		System.out.println(screenDate);
		System.out.println(screenLocation);
		System.out.println(movieNo);
		System.out.println(screenList);
		return screenList;
	}

	public void setSeat(HttpServletRequest request) {
		request.getParameter("");
		// 좌석선택 화면으로 이동
		
	}
	
	public void insertReservation() {
		//예약내용 insert
	}



	
}
