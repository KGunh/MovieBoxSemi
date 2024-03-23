package com.kh.reservation.model.dao;

import static com.kh.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.common.model.vo.Location;
import com.kh.movie.model.vo.Movie;
import com.kh.theater.model.vo.Screen;

public class ReservationDao {
	
	private Properties prop = new Properties();
	
	public ReservationDao() {
		String filePath = ReservationDao
						.class
						.getResource("/sql/reservation/reservation-mapper.xml")
						.getPath();
		try {
			prop.loadFromXML(new FileInputStream(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Movie> selectMovieList(Connection conn) {
		ArrayList<Movie> list = new ArrayList<Movie>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectMovieList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Movie m = new Movie();
				m.setMovieNo(rset.getInt("MOVIE_NO"));
				m.setMovieTitle(rset.getString("MOVIE_TITLE"));
			    m.setFilePath(rset.getString("FILE_PATH"));
			    m.setFileName(rset.getString("CHANGE_NAME"));
				
				list.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public ArrayList<Location> selectLocationList(Connection conn) {
		ArrayList<Location> list = new ArrayList<Location>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectLocationList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Location l = new Location();
				l.setLocationCode(rset.getString("LOCATION_CODE"));
				l.setLocationName(rset.getString("LOCATION_NAME"));
				
				list.add(l);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public ArrayList<Screen> selectScreen(Connection conn, String screenDate, String screenLocation, int movieNo) {
		ArrayList<Screen> list = new ArrayList<Screen>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectScreen");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, movieNo);
			pstmt.setString(2, screenLocation);
			pstmt.setString(3, screenDate);
			
			rset = pstmt.executeQuery();
			
			while (rset.next()) {
				Screen s = new Screen();
				s.setMovieNo(rset.getInt("MOVIE_NO"));
				s.setScreenNo(rset.getInt("SCREEN_NO"));
				s.setScreenName(rset.getString("SCREEN_NAME"));
				s.setWatchDate(rset.getString("WATCH_DATE"));
				s.setTheaterNo(rset.getInt("THEATER_NO"));
				s.setTheaterName(rset.getString("THEATER_NAME"));
				s.setMovieRt(rset.getInt("MOVIE_RT"));
				
				list.add(s);
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
