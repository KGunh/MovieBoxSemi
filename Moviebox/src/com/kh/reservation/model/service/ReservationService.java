package com.kh.reservation.model.service;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.kh.common.model.vo.Location;
import com.kh.common.model.vo.Reservation;
import com.kh.movie.model.vo.Movie;
import com.kh.reservation.model.dao.ReservationDao;
import com.kh.reservation.model.vo.Seat;
import com.kh.theater.model.vo.Screen;

public class ReservationService {
	
	public List<Movie> selectMovieList() {
		// 영화조회쪽이랑 상의해서 메소드 통일해야함!
		Connection conn = getConnection();
		
		List<Movie> movieList = new ReservationDao().selectMovieList(conn);
		
		close(conn);
		
		return movieList;
	}

	public List<Location> selectLocationList() {
		Connection conn = getConnection();
	
		List<Location> locationList =  new ReservationDao().selectLocationList(conn);
	
		close(conn);
		
		return locationList;
	}

	public List<Screen> selectScreen(String screenDate, String screenLocation,  int movieNo) {
		// 영화조회쪽이랑 상의해서 메소드 통일해야함!
		Connection conn = getConnection();
		
		List<Screen> screenList = new ReservationDao().selectScreen(conn, screenDate, screenLocation, movieNo);

		close(conn);
		
		return screenList;
	}

	public List<Seat> selectSeatList(int screenNo) {
		Connection conn = getConnection();
		
		List<Seat> seatlist = new ReservationDao().selectSeatList(conn, screenNo);
		
		close(conn);
		
		return seatlist;
	}

	public Reservation checkReservationInfo(int screenNo, int movieNo, int teenAge, int adultAge) {
		Connection conn = getConnection();
		
		Reservation reservation = new ReservationDao().checkReservationInfo(conn, screenNo, movieNo, teenAge, adultAge);
		
		close(conn);
		
		return reservation;
	}

	
	// 지역 조회
	
	// 영화관, 스크린은 AJAX로
			

}
