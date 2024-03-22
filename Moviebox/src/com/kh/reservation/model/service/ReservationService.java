package com.kh.reservation.model.service;

import static com.kh.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.common.model.vo.Location;
import com.kh.movie.model.vo.Movie;
import com.kh.reservation.model.dao.ReservationDao;

public class ReservationService {

	public ArrayList<Movie> selectMovieList() {
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
	
	// 지역 조회
	
	// 영화관, 스크린은 AJAX로
			

}
