package com.kh.reservation.model.service;

import static com.kh.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.common.model.vo.Location;
import com.kh.reservation.model.dao.ReservationDao;

public class ReservationService {

	public void selectMovieList() {
		Connection conn = getConnection();
		
		new ReservationDao().selectMovieList(conn);
		
		ArrayList<Location> list =  new ReservationDao().selectLocationList(conn);
		
		
	}

	public void selectLocationList() {
		// TODO Auto-generated method stub
		
	}
	
	// 지역 조회
	
	// 영화관, 스크린은 AJAX로
			

}
