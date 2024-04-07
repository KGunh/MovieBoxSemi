package com.kh.movie.model.service;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.kh.common.model.vo.Attachment;
import com.kh.movie.model.dao.MovieDao;
import com.kh.movie.model.vo.Movie;

public class MovieService {

	public List<Movie> selectMovieList() {
		Connection conn = getConnection();
		
		List<Movie> movieList = new MovieDao().selectMovieList(conn);
		
		close(conn);
		
		return movieList;
	}

	public ArrayList<Movie> movieCategory(String genre) {
		
		Connection conn = getConnection();
		ArrayList<Movie> list = new MovieDao().movieCategory(conn, genre);
		
		close(conn);
		
		return list;
	}

	public Movie detailMovie(int movieNo) {
		Connection conn = getConnection();
		Movie movie = new MovieDao().detailMovie(conn, movieNo);
		close(conn);
		return movie;
	}

	public String detailMovieCast(int movieNo) {
		Connection conn = getConnection();
		
		String cast = new MovieDao().detailMovieCast(conn, movieNo);
		
		close(conn);
		
		return cast;
	}

	public ArrayList<Attachment> stilCut(int movieNo) {

		Connection conn = getConnection();
		ArrayList<Attachment> stilCutList = new MovieDao().stilCut(conn, movieNo);

		close(conn);
		
		return stilCutList;
	}



}
