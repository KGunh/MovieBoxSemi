package com.kh.reservation.model.dao;

import static com.kh.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
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

	public Reservation printReservationInfo(Connection conn, int screenNo, int movieNo, int teenAge, int adultAge) {
		Reservation reservation = new Reservation();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("printReservationInfo");
		
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

	public HashMap<String,Integer> insertReservation(Connection conn, Reservation reservation) {
		HashMap<String, Integer> reservationKey = new HashMap<String, Integer>( );
		int result = 0;
		int key = 0;
		PreparedStatement pstmt =null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("insertReservation");
		
		try {
			// 시퀀스 값을 먼저 반환받고
			pstmt = conn.prepareStatement("SELECT SEQ_TKNO.NEXTVAL AS KEY FROM DUAL");
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				key = rset.getInt("KEY");
			}
			// 반환받은 시컨스 값을 사용하여 insert -> 다음 테이블에 key값을 사용하여 insert하기 위해서
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, key);
			pstmt.setInt(2, reservation.getSeatList().size());			
			pstmt.setInt(3, reservation.getMemberNo());
			pstmt.setInt(4, reservation.getScreenNo());

			result = pstmt.executeUpdate();
			
			reservationKey.put("ticketNo", key);
			reservationKey.put("result", result);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return reservationKey;
	}

	public int insertPriceSheet(Connection conn, int ticketNo, int teenPersonNo, int adultPersonNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertPriceSheet");
		// 청소년 성인 구분해서 반복문 돌리기
		try {
			pstmt = conn.prepareStatement(sql);
			
			if(teenPersonNo != 0) {
				for(int i = 0; i < teenPersonNo; i++) {
					pstmt.setInt(1, 1);
					pstmt.setInt(2, ticketNo);
					result += pstmt.executeUpdate();
				}
			}
			
			if(adultPersonNo != 0) {
				for(int i = 0; i < adultPersonNo; i++) {
					pstmt.setInt(1, 2);
					pstmt.setInt(2, ticketNo);
					result += pstmt.executeUpdate();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result == (teenPersonNo + adultPersonNo) ? 1 : 0;
	}

	public int insertSeat(Connection conn, Reservation reservation, int reservationKey) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertSeat");
		
		try {
			pstmt = conn.prepareStatement(sql);
			// 예약된 좌석 만큼 반복
			for(int i = 0; i < reservation.getSeatList().size(); i++) {
				pstmt.setString(1, reservation.getSeatList().get(i).getSeatNo());
				pstmt.setInt(2, reservation.getScreenNo());
				pstmt.setInt(3, reservationKey);
				
				result += pstmt.executeUpdate();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result == reservation.getSeatList().size() ? 1 : 0;
	}

	public Reservation checkReservationInfo(Connection conn, int ticketNo) {
		Reservation reservation = new Reservation();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("checkReservationInfo");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, ticketNo);
			
			rset = pstmt.executeQuery();
			if(rset.next()) {
				Movie m = new Movie();
				m.setMovieNo(rset.getInt("MOVIE_NO"));
				m.setMovieTitle(rset.getString("MOVIE_TITLE"));
				m.setMovieRt(rset.getString("MOVIE_RT"));
				m.setMovieRelease(rset.getString("MOVIE_RELEASE"));
				m.setFilePath(rset.getString("FILE_PATH"));
				m.setFileName(rset.getString("CHANGE_NAME"));
				m.setGenreName(rset.getString("GENRE_NAME"));
				
				
				reservation.setMovie(m);
				reser
				/*
		       TICKET_NO,
		       TEEN_PEOPLE,
		       ADULT_PEOPLE,
		       TEEN_PRICE,
		       ADULT_PRICE,
		       TOTAL_PRICE,
		       ,
		       ,
		       ,
		       SCREEN_NAME,
		       THEATER_NAME,
		       WATCH_DATE,
		       RESERVATION_DATE
		       */
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		return reservation;
	}
	
	
	
	
	
	
	
	
	
	
	
}
