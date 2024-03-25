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
		
		if(screenLocation.equals("전체")) screenLocation = "";
		
		int movieNo = Integer.parseInt(request.getParameter("movieNo"));
		
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



	
}
