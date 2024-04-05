package com.kh.reservation.model.service;

import static com.kh.common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import com.kh.common.model.vo.Location;
import com.kh.common.model.vo.Reservation;
import com.kh.member.model.dao.MemberDao;
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

	public Reservation printReservationInfo(int screenNo, int movieNo, int teenAge, int adultAge) {
		Connection conn = getConnection();
		
		Reservation reservation = new ReservationDao().printReservationInfo(conn, screenNo, movieNo, teenAge, adultAge);
		
		close(conn);
		
		return reservation;
	}

	public HashMap<String,Integer> insertReservation(Reservation reservation, int teenPersonNo, int adultPersonNo) {
		Connection conn = getConnection();
		int priceSheetResult = 0;
		int seatResult = 0;
	    
		// 예약테이블에 insert후 pk값 반환받기
		HashMap<String, Integer> reservationKey = new ReservationDao().insertReservation(conn, reservation);
		
		// 청소년or성인요금 테이블에 insert
        if (reservationKey.get("result") > 0) {
        	priceSheetResult = new ReservationDao().insertPriceSheet(conn, reservationKey.get("ticketNo"), teenPersonNo, adultPersonNo);
        }

        // 예약 좌석 테이블에 insert
        if (priceSheetResult > 0) {
        	seatResult = new ReservationDao().insertSeat(conn, reservation, reservationKey.get("ticketNo"));
        }
        // 트랜잭션 처리
        if (reservationKey.get("result") > 0 && priceSheetResult > 0 && seatResult > 0) {
            commit(conn);
        } else {
            rollback(conn);
        }
        
        close(conn);
        
        return reservationKey;
	}

	public Reservation checkReservationInfo(int ticketNo) {
		Connection conn = getConnection();
		
		Reservation reservation = new ReservationDao().checkReservationInfo(conn, ticketNo);
		
		List<Seat> seatList = new MemberDao().seatList(conn, ticketNo);
		
		reservation.setSeatList(seatList);
		
		close(conn);
		
		return reservation;
	}


}
