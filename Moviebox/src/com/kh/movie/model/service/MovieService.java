package com.kh.movie.model.service;

import static com.kh.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.common.model.vo.Genre;
import com.kh.movie.model.dao.MovieDao;
import com.kh.movie.model.vo.Movie;

public class MovieService {

	public ArrayList<Movie> selectMovieList() {
		Connection conn = getConnection();
		ArrayList<Movie> movieList = new MovieDao().selectMovieList(conn);
		
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



}
