package com.kh.theater.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.common.JDBCTemplate;
import com.kh.theater.model.dao.TheaterDao;
import com.kh.theater.model.vo.Theater;

public class TheaterService {

	public ArrayList<Theater> searchTheaterAll() {
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Theater> list = new TheaterDao().searchTheaterAll(conn);
		
		JDBCTemplate.close(conn);
		
		return list;
	}

	public ArrayList<Theater> selectTheaterLocation(String location) {
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Theater> list = new TheaterDao().selectTheaterLocation(conn, location);
		
		JDBCTemplate.close(conn);
		
		return list;
	}

	public ArrayList<Theater> searchTheaterName(String theaterName) {
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Theater> list = new TheaterDao().selectTheaterName(conn, theaterName);
		
		JDBCTemplate.close(conn);
		
		return list;
	}
	
}
