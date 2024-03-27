package com.kh.admin.model.service;

import static com.kh.common.JDBCTemplate.*;

import java.sql.Connection;

import com.kh.admin.model.dao.AdminPageDao;

public class AdminPageService {

	
	public int selectListCount() {
		
		Connection conn = getConnection();
		int result = new AdminPageDao().selectListCount(conn);
		close(conn);
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
