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
				
				m.setMovieTitle(rset.getString("MOVIE_TITLE"));
				m.setFileName(rset.getString("CHANGE_NAME"));
				m.setFilePath(rset.getString("FILE_PATH"));
				m.setMovieNo(rset.getInt("MOVIE_NO"));
				
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
				Location location = new Location();
				
				location.setLocationCode(rset.getString("LOCATION_CODE"));
				location.setLocationName(rset.getString("LOCATION_NAME"));
				
				list.add(location);
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
				Screen screen = new Screen();
				
				screen.setTheaterName(rset.getString("THEATER_NAME"));
				screen.setScreenName(rset.getString("SCREEN_NAME"));
				screen.setWatchDate(rset.getString("WATCH_DATE"));
				screen.setTheaterNo(rset.getInt("THEATER_NO"));
				screen.setScreenNo(rset.getInt("SCREEN_NO"));
				screen.setMovieNo(rset.getInt("MOVIE_NO"));
				screen.setMovieRt(rset.getInt("MOVIE_RT"));
				
				list.add(screen);
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
				seat.setTicketNo(rset.getInt("TICKET_NO"));
				seat.setSeatNo(rset.getString("SEAT_NO"));
				
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
			
			pstmt.setInt(2, adultAge);
			pstmt.setInt(4, screenNo);
			pstmt.setInt(1, teenAge);
			pstmt.setInt(3, movieNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				reservation.setTheaterName(rset.getString("THEATER_NAME"));
				reservation.setMovieTitle(rset.getString("MOVIE_TITLE"));
				reservation.setScreenName(rset.getNString("SCREEN_NAME"));
				reservation.setWatchDate(rset.getString("WATCH_DATE"));
				reservation.setMemberNo(rset.getInt("MOVIE_NO"));
				
				Movie movie = new Movie();
				
				movie.setMovieRelease(rset.getNString("MOVIE_RELEASE"));
				movie.setFileName(rset.getString("CHANGE_NAME"));
				movie.setGenreName(rset.getString("GENRE_NAME"));
				movie.setFilePath(rset.getString("FILE_PATH"));
				movie.setMovieRt(rset.getString("MOVIE_RT"));
				
				Price price = new Price();
				
				price.setTotalPrice(rset.getInt("TOTAL_PRICE"));
				
			    reservation.setMovie(movie);
			    reservation.setPrice(price);
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
		PreparedStatement pstmt =null;
		ResultSet rset = null;
		int result = 0;
		int key = 0;
		
		String sql = prop.getProperty("insertReservation");
		
		try {
			pstmt = conn.prepareStatement("SELECT SEQ_TKNO.NEXTVAL AS KEY FROM DUAL");
			rset = pstmt.executeQuery();
			
			if(rset.next()) key = rset.getInt("KEY");
				
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(2, reservation.getSeatList().size());			
			pstmt.setInt(3, reservation.getMemberNo());
			pstmt.setInt(4, reservation.getScreenNo());
			pstmt.setInt(1, key);

			result = pstmt.executeUpdate();
			
			reservationKey.put("result", result);
			reservationKey.put("ticketNo", key);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return reservationKey;
	}

	public int insertPriceSheet(Connection conn, int ticketNo, int teenPersonNo, int adultPersonNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String sql = prop.getProperty("insertPriceSheet");

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

	public int insertSeat(Connection conn, Reservation reservation, int ticketNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String sql = prop.getProperty("insertSeat");
		
		try {
			pstmt = conn.prepareStatement(sql);

			for(int i = 0; i < reservation.getSeatList().size(); i++) {
				pstmt.setString(1, reservation.getSeatList().get(i).getSeatNo());
				pstmt.setInt(2, reservation.getScreenNo());
				pstmt.setInt(3, ticketNo);
				
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
				
				m.setMovieRelease(rset.getString("MOVIE_RELEASE"));
				m.setMovieTitle(rset.getString("MOVIE_TITLE"));
				m.setFileName(rset.getString("CHANGE_NAME"));
				m.setGenreName(rset.getString("GENRE_NAME"));
				m.setFilePath(rset.getString("FILE_PATH"));
				m.setMovieRt(rset.getString("MOVIE_RT"));
				m.setMovieNo(rset.getInt("MOVIE_NO"));
				
				Price p = new Price();
				
				p.setStudentCount(rset.getInt("TEEN_PEOPLE"));
				p.setCommonCount(rset.getInt("ADULT_PEOPLE"));
				p.setStudentPrice(rset.getInt("TEEN_PRICE"));
				p.setCommonPrice(rset.getInt("ADULT_PRICE"));
				p.setTotalPrice(rset.getInt("TOTAL_PRICE"));
				
				reservation.setReservationDate(rset.getString("RESERVATION_DATE"));
				reservation.setTheaterName(rset.getString("THEATER_NAME"));
				reservation.setScreenName(rset.getString("SCREEN_NAME"));
				reservation.setWatchDate(rset.getString("WATCH_DATE"));
				reservation.setTicketNo(rset.getInt("TICKET_NO"));
				reservation.setPrice(p);
				reservation.setMovie(m);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return reservation;
	}
	
	
	
	
	
	
	
	
	
	
	
}
