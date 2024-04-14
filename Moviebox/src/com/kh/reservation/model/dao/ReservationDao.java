package com.kh.reservation.model.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.common.model.vo.Location;
import com.kh.common.model.vo.Reservation;
import com.kh.reservation.model.vo.Seat;
import com.kh.theater.model.vo.Screen;

public class ReservationDao {
	
	// 마이바티스 적용
	public List<Location> selectLocationList(SqlSession sqlSession) {
		
		return sqlSession.selectList("reservationMapper.selectLocationList");
	}
	// 마이바티스 적용
	public List<Screen> selectScreen(SqlSession sqlSession, HashMap<String, String> map) {
		
		return sqlSession.selectList("reservationMapper.selectScreen", map);
	}
	// 마이바티스 적용
	public List<Seat> selectSeatList(SqlSession sqlSession, int screenNo) {
				
		return sqlSession.selectList("reservationMapper.selectSeatList", screenNo);
	}
	// 마이바티스 적용
	public Reservation printReservationInfo(SqlSession sqlSession, HashMap<String, Integer> map) {
				
		return sqlSession.selectOne("reservationMapper.printReservationInfo", map);
	}
	// 마이바티스 적용
	public int insertReservation(SqlSession sqlSession, Reservation reservation) {
		
		return sqlSession.insert("reservationMapper.insertReservation", reservation);
	}
	// 마이바티스 적용
	public int insertPriceSheet(SqlSession sqlSession, Reservation reservation) {
		
		return sqlSession.insert("reservationMapper.insertPriceSheet", reservation);
	}
	// 마이바티스 적용
	public int insertSeat(SqlSession sqlSession, Reservation reservation) {
				
		return sqlSession.insert("reservationMapper.insertSeat", reservation);
	}
	// 마이바티스 적용
	public Reservation checkReservationInfo(SqlSession sqlSession, int ticketNo) {
				
		return sqlSession.selectOne("reservationMapper.checkReservationInfo", ticketNo);
	}
	
	
}
