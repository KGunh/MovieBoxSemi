package com.kh.reservation.controller;

import javax.servlet.http.HttpServletRequest;

import com.kh.reservation.model.service.ReservationService;

public class ReservationController {
	
	public void selectReservationInfo(HttpServletRequest request) {
		new ReservationService().selectMovieList();
		new ReservationService().selectLocationList();
		
		//리퀘스트 셋
		
	}

	public void setSeat(HttpServletRequest request) {
		request.getParameter("");
		// 좌석선택 화면으로 이동
		
	}
	
	public void insertReservation() {
		//예약내용 insert
	}


	
}
