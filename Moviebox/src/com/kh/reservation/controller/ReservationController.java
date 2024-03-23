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

	public void selectScreen(HttpServletRequest request) {
		// 스크린 정보 
		String screenDate = request.getParameter("date");
		String screenLocation = request.getParameter("location");
		int movieNo = Integer.parseInt(request.getParameter("movieNo"));
		
		ArrayList<Screen> screenList = new ReservationService().selectScreen(screenDate, screenLocation, movieNo); 
		
		request.setAttribute("screenList", screenList);
		
		//return view = "";
	}

	public void setSeat(HttpServletRequest request) {
		request.getParameter("");
		// 좌석선택 화면으로 이동
		
	}
	
	public void insertReservation() {
		//예약내용 insert
	}



	
}
