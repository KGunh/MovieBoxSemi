package com.kh.reservation.controller;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.kh.reservation.model.service.ReservationService;
import com.kh.theater.model.vo.Screen;

public class ReservationController {
	
	public String selectReservationInfo(HttpServletRequest request) {
		request.setAttribute("movieList", new ReservationService().selectMovieList()); 
		request.setAttribute("locationList", new ReservationService().selectLocationList()); 
		
		String view = "views/reservation/movieReservation.jsp";
		
		return view;
	}

	public List<Screen> selectScreen(HttpServletRequest request) {
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

		List<Screen> screenList = new ReservationService().selectScreen(screenDate, screenLocation, movieNo); 
		
		LinkedHashSet<Screen> set = new LinkedHashSet<>(screenList);
        List<Screen> list = new ArrayList<>(set);
		
		System.out.println(list);
		for(int i = 0; 0 < screenList.size(); i++) {
			
		}

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
