package com.kh.reservation.model.service;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.common.Template;
import com.kh.common.model.vo.Location;
import com.kh.common.model.vo.Reservation;
import com.kh.member.model.dao.MemberDao;
import com.kh.reservation.model.dao.ReservationDao;
import com.kh.reservation.model.vo.Seat;
import com.kh.theater.model.vo.Screen;

public class ReservationService {
	
	private ReservationDao reservationDao = new ReservationDao();
	// 마이바티스 적용
	public List<Location> selectLocationList() {
		SqlSession sqlSession = Template.getSqlSession();
		
		List<Location> locationList = reservationDao.selectLocationList(sqlSession); 
		
		sqlSession.close();
		
		return locationList;
	}
	// 마이바티스 적용
	public List<Screen> selectScreen(HashMap<String, String> map) {
		SqlSession sqlSession = Template.getSqlSession();
		
		List<Screen> screenList = reservationDao.selectScreen(sqlSession, map);

		sqlSession.close();
		
		return screenList;
	}
	// 마이바티스 적용
	public List<Seat> selectSeatList(int screenNo) {
		SqlSession sqlSession = Template.getSqlSession();
		
		List<Seat> seatlist = reservationDao.selectSeatList(sqlSession, screenNo);
		
		sqlSession.close();
		
		return seatlist;
	}
	// 마이바티스 적용
	public Reservation printReservationInfo(HashMap<String, Integer> map) {
		SqlSession sqlSession = Template.getSqlSession();
		
		Reservation reservation = reservationDao.printReservationInfo(sqlSession, map);

		sqlSession.close();
		
		return reservation;
	}
	// 마이바티스 적용
	public int insertReservation(Reservation reservation) {
		SqlSession sqlSession = Template.getSqlSession();
		int priceSheetResult = 0;
		int seatResult = 0;
		
		int result = reservationDao.insertReservation(sqlSession, reservation);
		
		if (result > 0) {
        	priceSheetResult = reservationDao.insertPriceSheet(sqlSession, reservation);
        }

        if (priceSheetResult > 0) {
        	seatResult = reservationDao.insertSeat(sqlSession, reservation);
        }

        if (result > 0 && priceSheetResult > 0 && seatResult > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }
        
        sqlSession.close();
        
        return reservation.getTicketNo();
	}
	// 마이바티스 적용
	public Reservation checkReservationInfo(int ticketNo) {
		SqlSession sqlSession = Template.getSqlSession();
		
		Reservation reservation = reservationDao.checkReservationInfo(sqlSession, ticketNo);
		
		List<Seat> seatList = new MemberDao().seatList(sqlSession, ticketNo);
		
		reservation.setSeatList(seatList);
		
		sqlSession.close();
		
		return reservation;
	}


}
