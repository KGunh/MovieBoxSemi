package com.kh.theater.model.service;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.kh.common.JDBCTemplate;
import com.kh.common.model.vo.Attachment;
import com.kh.movie.model.dao.MovieDao;
import com.kh.movie.model.vo.Movie;
import com.kh.theater.model.dao.TheaterDao;
import com.kh.theater.model.vo.Theater;
public class TheaterService {

	// 재인
	public ArrayList<Theater> searchTheaterAll() {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Theater> list = new TheaterDao().searchTheaterAll(conn);
		JDBCTemplate.close(conn);
		return list;
	}

	// 재인
	public ArrayList<Theater> selectTheaterLocation(String location) {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Theater> list = new TheaterDao().selectTheaterLocation(conn, location);
		JDBCTemplate.close(conn);
		return list;
	}

	// 재인
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

	// 테스트중
	public ArrayList<Theater> selectTheaterDetail(int theaterNo) {
		
		Connection conn = getConnection();
		ArrayList<Theater> theater = new TheaterDao().selectTheaterDetail(conn, theaterNo);
		close(conn);
		
		return theater;
	}

	// 영화관 리스트
	public ArrayList<Theater> theaterAll() {
		Connection conn = getConnection();
		ArrayList<Theater> list = new TheaterDao().theaterAll(conn);
		close(conn);
		return list;
	}

	// 영화 정보
	public List<Movie> getMoviesByTheater(int theaterNo) {
		Connection conn = getConnection();
		List<Movie> movies = new MovieDao().selectMovieList(conn);
		close(conn);
		return movies;
	}


	// 포스터 정보
	public ArrayList<Attachment> theaterImg(int movieNo) {
		Connection conn = getConnection();
		ArrayList<Attachment> attachment = new TheaterDao().theaterImg(conn, movieNo);
		close(conn);
		
		return attachment;
	}



	
	
	
	
	
	
	
	
	
	
	
	
}
