package com.kh.movie.model.dao;

import static com.kh.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.movie.model.vo.Movie;

public class MovieDao {
	
	private Properties prop = new Properties();
	
	public MovieDao() {
		String fileName = MovieDao.class.getResource("/sql/movie/movie-mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Movie> selectMovieList(Connection conn) {
		
		ArrayList<Movie> movieList = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectMovieList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset= pstmt.executeQuery();
			
			while(rset.next()) {
				Movie movie = new Movie();
				movie.setMovieNo(rset.getInt("MOVIE_NO"));
				movie.setMovieTitle(rset.getString("MOVIE_TITLE"));
				movie.setStatus(rset.getString("STATUS"));
				movie.setGenreName(rset.getString("GENRE_CODE"));
				movie.setMovieUpdate(rset.getString("MOVIE_UPDATE"));
				
				movieList.add(movie);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		
		return movieList;
	}

	public ArrayList<Movie> movieCategory(Connection conn, String genre) {
		
		ArrayList<Movie> list = new ArrayList<Movie>();
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("movieCategory");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, genre);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Movie movie = new Movie(rset.getInt("MOVIE_NO"),
										rset.getString("MOVIE_TITLE"),
										rset.getString("MOVIE_RT"),
										rset.getString("MOVIE_RATED"),
										rset.getString("MOVIE_RELEASE"),
										rset.getString("MOVIE_STORY"),
										rset.getString("STATUS"),
										rset.getString("GENRE_NAME"),
										rset.getInt("DIRECTOR_NO"));
				
				list.add(movie);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		
		return list;
	}


}
