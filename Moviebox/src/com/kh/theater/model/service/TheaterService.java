package com.kh.theater.model.service;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.common.JDBCTemplate;
import com.kh.movie.model.dao.MovieDao;
import com.kh.movie.model.vo.Movie;
import com.kh.theater.model.dao.TheaterDao;
import com.kh.theater.model.vo.Theater;
public class TheaterService {

	public ArrayList<Theater> searchTheaterAll() {
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Theater> list = new TheaterDao().searchTheaterAll(conn);
		
		JDBCTemplate.close(conn);
		
		return list;
	}

	public ArrayList<Theater> selectTheaterLocation(String location) {
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Theater> list = new TheaterDao().selectTheaterLocation(conn, location);
		
		JDBCTemplate.close(conn);
		
		return list;
	}

	public ArrayList<Theater> searchTheaterName(String theaterName) {
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Theater> list = new TheaterDao().selectTheaterName(conn, theaterName);
		
		JDBCTemplate.close(conn);
		
		return list;
	}
	
	public Theater detailTheater(int theaterNo) {
		Connection conn = getConnection();
		Theater th = new TheaterDao().detailTheater(conn, theaterNo);
		
		close(conn);
		
		return th;
	}

	public Theater selectTheaterDetail(int theaterNo) {
		Connection conn = getConnection();
		Theater theater = new TheaterDao().selectTheaterDetail(conn, theaterNo);
		close(conn);
		
		return theater;
	}

	public ArrayList<Theater> theaterAll() {
		Connection conn = getConnection();
		ArrayList<Theater> list = new TheaterDao().theaterAll(conn);
		close(conn);
		return list;
	}

	// 영화관에 정보 끌고오기
	public ArrayList<Movie> getMoviesByTheater(int theaterNo) {
		
		Connection conn = getConnection();
		ArrayList<Movie> movies = new MovieDao().selectMovieList(conn);
		close(conn);
		return movies;
	}


	
	
	
	
	
	
	
	
	
	
	
	
}
