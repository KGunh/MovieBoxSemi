package com.kh.reservation.model.service;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.catalina.core.ApplicationContext;

import com.kh.common.model.vo.Location;
import com.kh.movie.model.vo.Movie;
import com.kh.reservation.model.dao.ReservationDao;
import com.kh.theater.model.vo.Screen;

public class ReservationService {

	public ArrayList<Movie> selectMovieList() {
		// 영화조회쪽이랑 상의해서 메소드 통일해야함!
		Connection conn = getConnection();
		
		ArrayList<Movie> movieList = new ReservationDao().selectMovieList(conn);
		
		close(conn);
		
		return movieList;
	}

	public ArrayList<Location> selectLocationList() {
		Connection conn = getConnection();
	
		ArrayList<Location> locationList =  new ReservationDao().selectLocationList(conn);
	
		close(conn);
		
		return locationList;
	}

	public ArrayList<Screen> selectScreen(String screenDate, String screenLocation,  int movieNo) {
		// 영화조회쪽이랑 상의해서 메소드 통일해야함!
		Connection conn = getConnection();
		
		ArrayList<Screen> screenList = new ReservationDao().selectScreen(conn, screenDate, screenLocation, movieNo);
		System.out.println(screenList);
		close(conn);
		
		return screenList;
		
		
	}

	
	// 지역 조회
	
	// 영화관, 스크린은 AJAX로
			

}
