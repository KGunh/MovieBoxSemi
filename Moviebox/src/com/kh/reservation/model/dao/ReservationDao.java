package com.kh.reservation.model.dao;

import static com.kh.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.kh.common.model.vo.Location;
import com.kh.common.model.vo.Price;
import com.kh.common.model.vo.Reservation;
import com.kh.movie.model.vo.Movie;
import com.kh.reservation.model.vo.Seat;
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

	public List<Screen> selectScreen(Connection conn, String screenDate, String screenLocation, int movieNo) {
		List<Screen> list = new ArrayList<Screen>();
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

	public List<Seat> selectSeatList(Connection conn, int screenNo) {
		List<Seat> seatList = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectSeatList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, screenNo);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Seat seat = new Seat();
				
				seat.setScreenNo(rset.getInt("SCREEN_NO"));
				seat.setSeatNo(rset.getString("SEAT_NO"));
				seat.setTicketNo(rset.getInt("TICKET_NO"));
				
				seatList.add(seat);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return seatList;
	}

	public Reservation checkReservationInfo(Connection conn, int screenNo, int movieNo, int teenAge, int adultAge) {
		Reservation reservation = new Reservation();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("checkReservationInfo");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, teenAge);
			pstmt.setInt(2, adultAge);
			pstmt.setInt(3, movieNo);
			pstmt.setInt(4, screenNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				reservation.setMemberNo(rset.getInt("MOVIE_NO"));
				reservation.setMovieTitle(rset.getString("MOVIE_TITLE"));
				reservation.setWatchDate(rset.getString("WATCH_DATE"));
				reservation.setTheaterName(rset.getString("THEATER_NAME"));
				reservation.setScreenName(rset.getNString("SCREEN_NAME"));
				
				Movie m = new Movie();
				m.setGenreName(rset.getString("GENRE_NAME"));
				m.setFilePath(rset.getString("FILE_PATH"));
				m.setFileName(rset.getString("CHANGE_NAME"));
				m.setMovieRt(rset.getString("MOVIE_RT"));
				m.setMovieRelease(rset.getNString("MOVIE_RELEASE"));
				
				Price p = new Price();
				p.setTotalPrice(rset.getInt("TOTAL_PRICE"));
				
			    reservation.setMovie(m);
			    reservation.setPrice(p);
			}			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return reservation;
	}

	public int insertReservation(Connection conn, Reservation reservation) {
		int result = 0;
		PreparedStatement pstmt =null;
		
		String sql = prop.getProperty("insertReservation");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
}
