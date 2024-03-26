package com.kh.reservation.controller;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import com.kh.reservation.model.service.ReservationService;
import com.kh.reservation.model.vo.Seat;
import com.kh.theater.model.vo.Screen;

public class ReservationController {
	
	public String selectReservationInfo(HttpServletRequest request) {
		request.setAttribute("movieList", new ReservationService().selectMovieList()); 
		request.setAttribute("locationList", new ReservationService().selectLocationList()); 
		
		String view = "views/reservation/movieReservation.jsp";
		
		return view;
	}
	// 예매페이지 ajax용 메소드
	public List<Screen> selectScreen(HttpServletRequest request) {
		String[] dateStr = request.getParameter("date").split("-");
		String screenLocation = request.getParameter("location");
		String screenDate = "";
		int movieNo = 0;
		
		if(dateStr.length >= 3) { // 예외처리
			screenDate = dateStr[0].substring(2) + "/" + dateStr[1] + "/" + dateStr[2];
		};
		
		if(!request.getParameter("movieNo").equals("")) { // 예외처리
			movieNo = Integer.parseInt(request.getParameter("movieNo"));
		};
		
		if(screenLocation.equals("전체")) screenLocation = ""; //예외처리
		
		List<Screen> list = new ReservationService().selectScreen(screenDate, screenLocation, movieNo); 

		Set<Screen> set = new LinkedHashSet<>();
	    // set으로 중복값 제거
		for (Screen screen : list) {
			Screen sc = new Screen();
			
			sc.setTheaterNo(screen.getTheaterNo());
			sc.setTheaterName(screen.getTheaterName());
			sc.setMovieNo(screen.getMovieNo());
			sc.setMovieRt(screen.getMovieRt());
			
            set.add(sc);
        };
        
		// 중복이 제거후 list에 담기
		List<Screen> screenList = new ArrayList<Screen>();
		
		for(Screen sc : set) {
			Screen screen = new Screen();
			
			screen.setTheaterNo(sc.getTheaterNo());
			screen.setTheaterName(sc.getTheaterName());
			screen.setMovieNo(sc.getMovieNo());
			screen.setMovieRt(sc.getMovieRt());
			screen.setScreenNo(sc.getScreenNo());
			
			screenList.add(screen);
		};
		
		// 영화관마다 상영중인 시간 list필드에 담기
		for(int i = 0; i < screenList.size(); i++) {
		    List<String> watchDateList = new ArrayList<>();
		    List<Integer> screenNoList = new ArrayList<>();

		    for(int j = 0; j < list.size(); j++) {
		        if(list.get(j).getTheaterNo() == screenList.get(i).getTheaterNo()) {
		            watchDateList.add(list.get(j).getWatchDate());
		            screenNoList.add(list.get(j).getScreenNo());
		        };
		    };

		    screenList.get(i).setScreenNoList(screenNoList);
		    screenList.get(i).setWatchDateList(watchDateList);
		};
		
		return screenList;
	}

	public String setSeat(HttpServletRequest request) {
		int screenNo = Integer.parseInt(request.getParameter("screenNo"));
		
		List<Seat> seatlist = new ReservationService().selectSeatList(screenNo);
		
		request.setAttribute("seatList", seatlist);
		
		String view = "views/reservation/seatReservation.jsp";
		
		return view;		
	}
	
	public void insertReservation() {
		// 예약 정보를 가지고 결제 페이지로 연결
		// 예약내용 insert
	}

	
}
