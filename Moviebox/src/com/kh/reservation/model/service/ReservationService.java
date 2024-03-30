package com.kh.reservation.model.service;

import static com.kh.common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.kh.common.model.vo.Location;
import com.kh.common.model.vo.Reservation;
import com.kh.movie.model.vo.Movie;
import com.kh.reservation.model.dao.ReservationDao;
import com.kh.reservation.model.vo.Seat;
import com.kh.theater.model.vo.Screen;

import oracle.jdbc.OracleConnection.CommitOption;

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

	public void insertReservation(Reservation reservation, int teenPersonNo, int adultPersonNo) {
		Connection conn = getConnection();
	        
		int priceSheetResult = 0;
		int seatResult = 0;
		// 예약테이블에 insert후 pk값 반환받기
        int reservationKey = new ReservationDao().insertReservation(conn, reservation);
        // 청소년/성인요금 테이블에 insert
        if (reservationKey > 0) priceSheetResult = new ReservationDao().insertPriceSheet(conn, reservationKey, teenPersonNo, adultPersonNo);
        // 예약 좌석 테이블에 insert
        if (priceSheetResult > 0) seatResult = new ReservationDao().insertSeat(conn, reservation, reservationKey);
        // 숏서킷
        if (reservationKey > 0 && priceSheetResult > 0 && seatResult > 0) {
            commit(conn);
        } else {
            rollback(conn);
        }
        
        close(conn);
	}


}
