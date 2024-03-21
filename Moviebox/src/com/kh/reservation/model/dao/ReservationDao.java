package com.kh.reservation.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

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

	public void selectMovieList() {
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
