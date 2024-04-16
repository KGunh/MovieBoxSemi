package com.kh.reservation.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import com.kh.common.model.vo.Reservation;
import com.kh.movie.model.service.MovieService;
import com.kh.reservation.model.service.ReservationService;
import com.kh.reservation.model.vo.Seat;
import com.kh.theater.model.vo.Screen;

public class ReservationController {
	
	public String selectReservationInfo(HttpServletRequest request) {
		request.setAttribute("locationList", new ReservationService().selectLocationList()); 
		request.setAttribute("movieList", new MovieService().selectMovieList()); 
		
		return "views/reservation/movieReservation.jsp";
	}
	
	public List<Screen> selectScreen(HttpServletRequest request) {
		String[] dateStr = request.getParameter("date").split("-");
		String screenLocation = request.getParameter("location");
		String theaterName = request.getParameter("theaterName");
		String screenDate = "";
		String movieNo = "";
		
		if(dateStr.length >= 3) {
			screenDate = dateStr[0].substring(2) + "/" + dateStr[1] + "/" + dateStr[2];
		}
		
		if(!request.getParameter("movieNo").equals("")) {
			movieNo = request.getParameter("movieNo");
		}

		if(screenLocation.equals("전체")) screenLocation = "";
		
		HashMap<String,String> map = new HashMap<String, String>();
		
		map.put("screenDate", screenDate);
		map.put("screenLocation", screenLocation);
		map.put("movieNo", movieNo);
		map.put("theaterName", theaterName);
		
		List<Screen> list = new ReservationService().selectScreen(map); 
		/*
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
		*/
		return list;
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
		HashMap<String, Integer> map = new HashMap<String, Integer>(); 
		
		if(request.getParameter("movieNo") != "") {
			map.put("movieNo", Integer.parseInt(request.getParameter("movieNo")));
		}

		map.put("screenNo", Integer.parseInt(request.getParameter("screenNo")));
		map.put("adultAge", Integer.parseInt(request.getParameter("adultAge")));
		map.put("teenAge", Integer.parseInt(request.getParameter("teenAge")));
		
		return new ReservationService().printReservationInfo(map); 
	}

	public String insertReservation(HttpServletRequest request) {
		List<Seat> seatList = new ArrayList<Seat>();
		Reservation reservation = new Reservation();
		
		String seatNo = request.getParameter("seatNo");
		String[] seatArray = seatNo.split(", ");
		int memberNo = Integer.parseInt(request.getParameter("memberNo"));
		int adultPersonNo = 0;
		int teenPersonNo = 0;
		int screenNo = 0;
		int movieNo = 0;

		if(request.getParameter("adult") != "") adultPersonNo = Integer.parseInt(request.getParameter("adult"));
		
		if(request.getParameter("teen") != "") teenPersonNo = Integer.parseInt(request.getParameter("teen"));

		if(request.getParameter("screenNo") != null && request.getParameter("movieNo")!= null) {
			screenNo = Integer.parseInt(request.getParameter("screenNo"));
			movieNo = Integer.parseInt(request.getParameter("movieNo"));
		} else {
			return "views/common/errorPage.jsp";
		}
		
		for(int i = 0; i < seatArray.length; i++) {
			Seat seat = new Seat();

			seat.setSeatNo(seatArray[i]);
			
			seatList.add(seat);
		}

		reservation.setPersonNum(teenPersonNo + adultPersonNo);
		reservation.setAdultPersonNo(adultPersonNo);
		reservation.setTeenPersonNo(teenPersonNo);
		reservation.setSeatList(seatList);
		reservation.setScreenNo(screenNo);
		reservation.setMemberNo(memberNo);
		reservation.setMovieNo(movieNo);
		
		int ticketNo = new ReservationService().insertReservation(reservation);
		
		request.setAttribute("ticketNo", ticketNo);
		
		return "views/reservation/infoReservation.jsp";
	}

	public Reservation checkReservationInfo(HttpServletRequest request) {
		int ticketNo = Integer.parseInt(request.getParameter("ticketNo"));
				
		Reservation reservation = new ReservationService().checkReservationInfo(ticketNo);
		
		return reservation;
	}

	
	
}
