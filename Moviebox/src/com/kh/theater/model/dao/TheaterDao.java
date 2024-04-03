package com.kh.theater.model.dao;

import static com.kh.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.common.JDBCTemplate;
import com.kh.common.model.vo.Attachment;
import com.kh.movie.model.dao.MovieDao;
import com.kh.movie.model.vo.Movie;
import com.kh.theater.model.vo.Theater;
public class TheaterDao {

	private Properties prop = new Properties();
	
	public TheaterDao() {
		String filePath = TheaterDao
						.class
						.getResource("/sql/theater/theater-mapper.xml")
						.getPath();
		try {
			prop.loadFromXML(new FileInputStream(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Theater> searchTheaterAll(Connection conn) {
		ArrayList<Theater> list = new ArrayList<Theater>();
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("searchTheaterAll");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Theater theater = new Theater(rset.getInt("THEATER_NO"),
											  rset.getString("THEATER_NAME"),
											  rset.getString("THEATER_ADDR"),
											  rset.getString("MAP_LINK"),
											  rset.getString("LOCATION_NAME"));
				
				list.add(theater);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	public ArrayList<Theater> selectTheaterLocation(Connection conn, String location) {
		ArrayList<Theater> list = new ArrayList<Theater>();
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("selectTheaterLocation");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, location);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Theater theater = new Theater(rset.getInt("THEATER_NO"),
											  rset.getString("THEATER_NAME"),
											  rset.getString("THEATER_ADDR"),
											  rset.getString("MAP_LINK"),
											  rset.getString("LOCATION_NAME"));

				list.add(theater);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	public ArrayList<Theater> selectTheaterName(Connection conn, String theaterName) {
		ArrayList<Theater> list = new ArrayList<Theater>();
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("selectTheaterName");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, theaterName);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Theater theater = new Theater(rset.getInt("THEATER_NO"),
											  rset.getString("THEATER_NAME"),
											  rset.getString("THEATER_ADDR"),
											  rset.getString("MAP_LINK"),
											  rset.getString("LOCATION_NAME"));
				list.add(theater);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}
	
	public Theater detailTheater(Connection conn, int theaterNo) {
		Theater th = new Theater();
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("detailTheater");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, theaterNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				th.setTheaterNo(rset.getInt("THEATER_NO"));
				th.setTheaterName(rset.getString("THEATER_NAME"));
				th.setTheaterAddr(rset.getString("THEATER_ADDR"));
				th.setMapLink(rset.getString("MAP_LINK"));
				th.setLocationName(rset.getString("LOCATION_NAME"));
				th.setUpdateDate(rset.getString("THEATER_UPDATE"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return th;
		
	}

	public Theater selectTheaterDetail(Connection conn, int theaterNo) {
		Theater th = new Theater();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectTheaterDetail");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, theaterNo);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				th.setScreenNo(rset.getInt("SCREEN_NO"));
				th.setTheaterNo(rset.getInt("THEATER_NO"));
				th.setMovieNo(rset.getInt("MOVIE_NO"));
				th.setMovieTitle(rset.getString("MOVIE_TITLE"));
				th.setTheaterName(rset.getString("THEATER_NAME"));
				th.setTheaterAddr(rset.getString("THEATER_ADDR"));
				th.setMapLink(rset.getString("MAP_LINK"));
				th.setFilePath(rset.getString("FILE_PATH"));
				th.setChangeName(rset.getString("CHANGE_NAME"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return th;
	}

	public ArrayList<Theater> theaterAll(Connection conn) {
		
		ArrayList<Theater> list = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectTheaterList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Theater t = new Theater();
				t.setTheaterNo(rset.getInt("THEATER_NO"));
				t.setTheaterName(rset.getString("THEATER_NAME"));
				t.setTheaterAddr(rset.getString("THEATER_ADDR"));
				t.setMapLink(rset.getString("MAP_LINK"));
				t.setLocalCode(rset.getString("LOCATION_CODE"));
				t.setUpdateDate(rset.getString("THEATER_UPDATE"));
				
				list.add(t);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		
		return list;
	}

	public ArrayList<Attachment> theaterImg(Connection conn, int movieNo) {
		
		ArrayList<Attachment> list = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("theaterImg");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, movieNo);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Attachment attachment = new Attachment();
				
				attachment.setMovieNo(rset.getInt("MOVIE_NO"));
				attachment.setChangeName(rset.getString("CHANGE_NAME"));
				
				list.add(attachment);
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
