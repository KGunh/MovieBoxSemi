package com.kh.reservation.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import com.kh.common.model.vo.Reservation;
import com.kh.member.model.service.MemberService;
import com.kh.reservation.model.dao.ReservationDao;
import com.kh.reservation.model.service.ReservationService;
import com.kh.reservation.model.vo.Seat;
import com.kh.theater.model.vo.Screen;

public class ReservationController {
	
	// 영화 선택 화면의 영화, 지역정보 리스트 조회
	public String selectReservationInfo(HttpServletRequest request) {
		request.setAttribute("locationList", new ReservationService().selectLocationList()); 
		request.setAttribute("movieList", new ReservationService().selectMovieList()); 
		
		return "views/reservation/movieReservation.jsp";
	}
	
	// 예매페이지 영화 상영 시간의 리스트 조회
	public List<Screen> selectScreen(HttpServletRequest request) {
		// 날짜데이터를 '-' 기준으로 자르기
		String[] dateStr = request.getParameter("date").split("-");
		String screenLocation = request.getParameter("location");
		String screenDate = "";
		int movieNo = 0;
		
		// DB 컬럼 포맷에 맞춰 가공 ex)2024/01/01
		if(dateStr.length >= 3) {
			screenDate = dateStr[0].substring(2) + "/" + dateStr[1] + "/" + dateStr[2];
		}
		
		if(!request.getParameter("movieNo").equals("")) {
			movieNo = Integer.parseInt(request.getParameter("movieNo"));
		}
		// DB에서 전체 카테고리로 조회하기 위해서 빈문자로 값을 가공해서 전달
		if(screenLocation.equals("전체")) screenLocation = "";
		
		List<Screen> list = new ReservationService().selectScreen(screenDate, screenLocation, movieNo); 

		Set<Screen> set = new LinkedHashSet<>();
	    // set으로 중복값 제거
		for(Screen screen : list) {
			Screen sc = new Screen();
			
			sc.setTheaterName(screen.getTheaterName());
			sc.setTheaterNo(screen.getTheaterNo());
			sc.setMovieNo(screen.getMovieNo());
			sc.setMovieRt(screen.getMovieRt());
			
            set.add(sc);
        }
        
		// 중복이 제거후 list에 담기
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
		
		// 영화관마다 상영중인 시간 list필드에 담기
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

	// 영화 선택 후 좌석 선택화면으로 보내는 메소드
	public String connectSeatList(HttpServletRequest request) {
		request.setAttribute("theaterName", request.getParameter("theaterName"));
		request.setAttribute("movieTitle", request.getParameter("movieTitle"));
		request.setAttribute("screenDate", request.getParameter("screenDate"));
		request.setAttribute("screenName", request.getParameter("screenName"));
		request.setAttribute("screenNo", request.getParameter("screenNo"));
		request.setAttribute("movieNo", request.getParameter("movieNo"));
		
		return "views/reservation/seatReservation.jsp";
	}
	// 상영관 예매된 좌석 조회
	public List<Seat> selectSeatList(HttpServletRequest request) {
		int screenNo = Integer.parseInt(request.getParameter("screenNo"));

		return new ReservationService().selectSeatList(screenNo);		
	}
	// 예약내용 확인
	public Reservation printReservationInfo(HttpServletRequest request) {
		int screenNo = Integer.parseInt(request.getParameter("screenNo"));
		int adultAge = Integer.parseInt(request.getParameter("adultAge"));
		int movieNo = Integer.parseInt(request.getParameter("movieNo"));
		int teenAge = Integer.parseInt(request.getParameter("teenAge"));
		
		return new ReservationService().printReservationInfo(screenNo, movieNo, teenAge, adultAge); 
	}
	// 예약
	public String insertReservation(HttpServletRequest request) {
		List<Seat> seatList = new ArrayList<Seat>();
		Reservation reservation = new Reservation();
		
		int screenNo = Integer.parseInt(request.getParameter("screenNo"));
		int memberNo = Integer.parseInt(request.getParameter("memberNo"));
		int movieNo = Integer.parseInt(request.getParameter("movieNo"));
		// 선택한 좌석 데이터 가공 -> 문자배열 -> seat객체에 필드set -> seatList에 add 
		String seatNo = request.getParameter("seatNo");
		String[] seatArray = seatNo.split(","); // 좌석 ex) A1,A2... 나누기
		
		for(int i = 0; i < seatArray.length; i++) {
			Seat seat = new Seat();

			seat.setSeatNo(seatArray[i]);
			
			seatList.add(seat);
		}
		
		// reservation VO에 set
		reservation.setSeatList(seatList);
		reservation.setScreenNo(screenNo);
		reservation.setMemberNo(memberNo);
		reservation.setMovieNo(movieNo);
		
		// 예매 연령의 인원수는 따로 보냄
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
