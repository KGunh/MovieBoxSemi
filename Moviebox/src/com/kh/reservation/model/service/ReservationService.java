package com.kh.reservation.model.service;

import static com.kh.common.JDBCTemplate.getConnection;

import java.sql.Connection;

import com.kh.reservation.model.dao.ReservationDao;

public class ReservationService {

	public void selectMovieList() {
		Connection conn = getConnection();
		
		new ReservationDao().selectMovieList(conn);
		
		new ReservationDao().selectLocationList(conn);
		
		
	}
	
	// 지역 조회
	
	// 영화관, 스크린은 AJAX로
			

}
