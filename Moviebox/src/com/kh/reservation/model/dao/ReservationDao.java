package com.kh.reservation.model.dao;

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
import static com.kh.common.JDBCTemplate.*;

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
				
				list.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
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
	
	
	
	
	
	
	
	
	
	
	
}
