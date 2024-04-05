package com.kh.reservation.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.kh.common.model.vo.Reservation;
import com.kh.reservation.model.service.ReservationService;
import com.kh.reservation.model.vo.Seat;
import com.kh.theater.model.vo.Screen;

public class ReservationController {
	
	public String selectReservationInfo(HttpServletRequest request) {
		request.setAttribute("locationList", new ReservationService().selectLocationList()); 
		request.setAttribute("movieList", new ReservationService().selectMovieList()); 
		
		return "views/reservation/movieReservation.jsp";
	}
	
	public List<Screen> selectScreen(HttpServletRequest request) {
		String[] dateStr = request.getParameter("date").split("-");
		String screenLocation = request.getParameter("location");
		String screenDate = "";
		int movieNo = 0;
		
		if(dateStr.length >= 3) {
			screenDate = dateStr[0].substring(2) + "/" + dateStr[1] + "/" + dateStr[2];
		}
		
		if(!request.getParameter("movieNo").equals("")) {
			movieNo = Integer.parseInt(request.getParameter("movieNo"));
		}

		if(screenLocation.equals("전체")) screenLocation = "";
		
		List<Screen> list = new ReservationService().selectScreen(screenDate, screenLocation, movieNo); 

		Set<Screen> set = new LinkedHashSet<>();

		for(Screen screen : list) {
			Screen sc = new Screen();
			
			sc.setTheaterName(screen.getTheaterName());
			sc.setTheaterNo(screen.getTheaterNo());
			sc.setMovieNo(screen.getMovieNo());
			sc.setMovieRt(screen.getMovieRt());
			
            set.add(sc);
        }
        
		List<Screen> screenList = new ArrayList<Screen>();
		
		for(Screen sc : set) {
			Screen screen = new Screen();
			
			screen.setTheaterName(sc.getTheaterName());
			screen.setTheaterNo(sc.getTheaterNo());
			screen.setScreenNo(sc.getScreenNo());
			screen.setMovieNo(sc.getMovieNo());
			screen.setMovieRt(sc.getMovieRt());
			
			screenList.add(screen);
		}
		
		for(int i = 0; i < screenList.size(); i++) {
			List<String> screenNameList = new ArrayList<>();
		    List<String> watchDateList = new ArrayList<>();
		    List<Integer> screenNoList = new ArrayList<>();

		    for(int j = 0; j < list.size(); j++) {
		        if(list.get(j).getTheaterNo() == screenList.get(i).getTheaterNo()) {
		        	screenNameList.add(list.get(j).getScreenName());
		            watchDateList.add(list.get(j).getWatchDate());
		            screenNoList.add(list.get(j).getScreenNo());
		        }
		    }

		    screenList.get(i).setScreenNameList(screenNameList);
		    screenList.get(i).setWatchDateList(watchDateList);
		    screenList.get(i).setScreenNoList(screenNoList);
		}
		
		return screenList;
	}

	public String connectSeatList(HttpServletRequest request) {
		request.setAttribute("theaterName", request.getParameter("theaterName"));
		request.setAttribute("movieTitle", request.getParameter("movieTitle"));
		request.setAttribute("screenDate", request.getParameter("screenDate"));
		request.setAttribute("screenName", request.getParameter("screenName"));
		
		if(request.getParameter("screenNo") != null && request.getParameter("movieNo") != null) {
			request.setAttribute("screenNo", request.getParameter("screenNo"));
			request.setAttribute("movieNo", request.getParameter("movieNo"));
		} else {
			HttpSession session = request.getSession();
			
			session.setAttribute("alertMsg", "잘못된 요청입니다.");
			
			return "views/common/errorPage.jsp";
		}
		
		return "views/reservation/seatReservation.jsp";
	}

	public List<Seat> selectSeatList(HttpServletRequest request) {
		int screenNo = 0;
		
		if(request.getParameter("screenNo") != "") {
			screenNo = Integer.parseInt(request.getParameter("screenNo"));
		}
		
		return new ReservationService().selectSeatList(screenNo);		
	}

	public Reservation printReservationInfo(HttpServletRequest request) {
		// 오류 넘버
		int screenNo = Integer.parseInt(request.getParameter("screenNo"));
		int adultAge = Integer.parseInt(request.getParameter("adultAge"));
		
		int movieNo = 0;
		if(request.getParameter("movieNo") != "") {
			movieNo = Integer.parseInt(request.getParameter("movieNo"));
		}
		
		int teenAge = Integer.parseInt(request.getParameter("teenAge"));
		
		return new ReservationService().printReservationInfo(screenNo, movieNo, teenAge, adultAge); 
	}

	public String insertReservation(HttpServletRequest request) {
		List<Seat> seatList = new ArrayList<Seat>();
		Reservation reservation = new Reservation();
		
		int screenNo = Integer.parseInt(request.getParameter("screenNo"));
		int memberNo = Integer.parseInt(request.getParameter("memberNo"));
		int movieNo = Integer.parseInt(request.getParameter("movieNo"));
		String seatNo = request.getParameter("seatNo");
		String[] seatArray = seatNo.split(",");
		
		for(int i = 0; i < seatArray.length; i++) {
			Seat seat = new Seat();

			seat.setSeatNo(seatArray[i]);
			
			seatList.add(seat);
		}
		
		reservation.setSeatList(seatList);
		reservation.setScreenNo(screenNo);
		reservation.setMemberNo(memberNo);
		reservation.setMovieNo(movieNo);
		
		int adultPersonNo = 0;
		if(request.getParameter("adult") != "") adultPersonNo = Integer.parseInt(request.getParameter("adult"));

		int teenPersonNo = 0;
		if(request.getParameter("teen") != "") teenPersonNo = Integer.parseInt(request.getParameter("teen"));
		
		HashMap<String, Integer> reservationKey = new ReservationService().insertReservation(reservation, teenPersonNo, adultPersonNo);
		
		request.setAttribute("ticketNo", reservationKey.get("ticketNo"));
		
		return "views/reservation/infoReservation.jsp";
	}

	public Reservation checkReservationInfo(HttpServletRequest request) {
		int ticketNo = Integer.parseInt(request.getParameter("ticketNo"));
				
		Reservation reservation = new ReservationService().checkReservationInfo(ticketNo);
		
		return reservation;
	}

	
	
}
