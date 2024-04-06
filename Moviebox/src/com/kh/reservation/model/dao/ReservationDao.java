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

	public List<Location> selectLocationList(Connection conn) {
		List<Location> list = new ArrayList<Location>();
		
		try(PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("selectLocationList"));
			ResultSet rset = pstmt.executeQuery();) {
			
			while(rset.next()) {
				Location location = new Location();
				
				location.setLocationCode(rset.getString("LOCATION_CODE"));
				location.setLocationName(rset.getString("LOCATION_NAME"));
				
				list.add(location);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		return list;
	}

	public List<Screen> selectScreen(Connection conn, String screenDate, String screenLocation, int movieNo) {
		List<Screen> list = new ArrayList<Screen>();
		
		try(PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("selectScreen"))) {
		    
		    pstmt.setInt(1, movieNo);
		    pstmt.setString(2, screenLocation);
		    pstmt.setString(3, screenDate);
		    
		    try(ResultSet rset = pstmt.executeQuery()) {
			
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
		    }
		    
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	public List<Seat> selectSeatList(Connection conn, int screenNo) {
		List<Seat> seatList = new ArrayList<>();
		System.out.println(screenNo);
		try(PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("selectSeatList"))) {

			pstmt.setInt(1, screenNo);

			try(ResultSet rset = pstmt.executeQuery()){

				while(rset.next()) {
					Seat seat = new Seat();
					
					seat.setScreenNo(rset.getInt("SCREEN_NO"));
					seat.setTicketNo(rset.getInt("TICKET_NO"));
					seat.setSeatNo(rset.getString("SEAT_NO"));
					
					seatList.add(seat);
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return seatList;
	}

	public Reservation printReservationInfo(Connection conn, int screenNo, int movieNo, int teenAge, int adultAge) {
		Reservation reservation = new Reservation();
		
		
		try(PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("printReservationInfo"))) {

			pstmt.setInt(2, adultAge);
			pstmt.setInt(4, screenNo);
			pstmt.setInt(1, teenAge);
			pstmt.setInt(3, movieNo);

			try(ResultSet rset = pstmt.executeQuery();){
				
				if(rset.next()) {
					reservation.setTheaterName(rset.getString("THEATER_NAME"));
					reservation.setScreenName(rset.getNString("SCREEN_NAME"));
					reservation.setMovieTitle(rset.getString("MOVIE_TITLE"));
					reservation.setWatchDate(rset.getString("WATCH_DATE"));
					reservation.setMemberNo(rset.getInt("MOVIE_NO"));
					
					Movie movie = new Movie();
					
					movie.setMovieRelease(rset.getNString("MOVIE_RELEASE"));
					movie.setChangeName(rset.getString("CHANGE_NAME"));
					movie.setGenreName(rset.getString("GENRE_NAME"));
					movie.setFilePath(rset.getString("FILE_PATH"));
					movie.setMovieRt(rset.getString("MOVIE_RT"));
					
					Price price = new Price();
					
					price.setTotalPrice(rset.getInt("TOTAL_PRICE"));
					
				    reservation.setMovie(movie);
				    reservation.setPrice(price);
				}		
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return reservation;
	}

	public HashMap<String,Integer> insertReservation(Connection conn, Reservation reservation) {
		HashMap<String, Integer> reservationKey = new HashMap<>();
	    int result = 0;
	    int key = 0;

	    try (PreparedStatement seqPstmt = conn.prepareStatement("SELECT SEQ_TKNO.NEXTVAL AS KEY FROM DUAL");
	         ResultSet rset = seqPstmt.executeQuery();
	         PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("insertReservation"))) {

	        if (rset.next()) {
	            key = rset.getInt("KEY");
	        }

	        pstmt.setInt(2, reservation.getSeatList().size());
	        pstmt.setInt(3, reservation.getMemberNo());
	        pstmt.setInt(4, reservation.getScreenNo());
	        pstmt.setInt(1, key);

	        result = pstmt.executeUpdate();

	        reservationKey.put("result", result);
	        reservationKey.put("ticketNo", key);

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
		
		return reservationKey;
	}

	public int insertPriceSheet(Connection conn, int ticketNo, int teenPersonNo, int adultPersonNo) {
		int result = 0;

		try(PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("insertPriceSheet"))) {
			
			for(int i = 0; i < teenPersonNo; i++) {
				pstmt.setInt(1, 1);
				pstmt.setInt(2, ticketNo);
				
				result += pstmt.executeUpdate();
			}
		
			for(int i = 0; i < adultPersonNo; i++) {
				pstmt.setInt(1, 2);
				pstmt.setInt(2, ticketNo);
				
				result += pstmt.executeUpdate();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result == (teenPersonNo + adultPersonNo) ? 1 : 0;
	}

	public int insertSeat(Connection conn, Reservation reservation, int ticketNo) {
		int result = 0;
		
		try(PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("insertSeat"))) {

			for(int i = 0; i < reservation.getSeatList().size(); i++) {
				pstmt.setString(1, reservation.getSeatList().get(i).getSeatNo());
				pstmt.setInt(2, reservation.getScreenNo());
				pstmt.setInt(3, ticketNo);
				
				result += pstmt.executeUpdate();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result == reservation.getSeatList().size() ? 1 : 0;
	}

	public Reservation checkReservationInfo(Connection conn, int ticketNo) {
		Reservation reservation = new Reservation();
		
		try(PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("checkReservationInfo"))) {
			
			pstmt.setInt(1, ticketNo);

			try(ResultSet rset = pstmt.executeQuery()){

				if(rset.next()) {
					Movie m = new Movie();
					
					m.setMovieRelease(rset.getString("MOVIE_RELEASE"));
					m.setMovieTitle(rset.getString("MOVIE_TITLE"));
					m.setChangeName(rset.getString("CHANGE_NAME"));
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
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return reservation;
	}
	
	
}
