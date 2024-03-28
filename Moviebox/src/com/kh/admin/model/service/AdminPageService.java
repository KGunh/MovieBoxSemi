package com.kh.admin.model.service;

import static com.kh.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.admin.model.dao.AdminPageDao;
import com.kh.movie.model.vo.Movie;

public class AdminPageService {

	
	public ArrayList<Movie> adminSelectMovieList(){
		
		Connection conn = getConnection();
		ArrayList<Movie> list = new AdminPageDao().adminSelectMovieList(conn);
		
		close(conn);
		
		return list;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
