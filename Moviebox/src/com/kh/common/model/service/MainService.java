package com.kh.common.model.service;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.kh.common.model.dao.MainDao;
import com.kh.common.model.vo.Attachment;
import com.kh.common.model.vo.Location;
import com.kh.notice.model.vo.Notice;
import com.kh.theater.model.vo.Theater;

public class MainService {
	
	public List<Attachment> adPrint(){
		Connection conn = getConnection();
		
		List<Attachment> list = new MainDao().adPrint(conn);
		
		close(conn);
		
		
		return list;
	}
	
	public List<Attachment> chartPrint(){
		Connection conn = getConnection();
		
		List<Attachment> list = new MainDao().chartPrint(conn);
		
		close(conn);
		
		
		return list;
	}
	
	public List<Notice> boardPrint(){
		Connection conn = getConnection();
		
		List<Notice> list = new MainDao().boardPrint(conn);
		
		close(conn);
		
		
		return list;
		
	}

	public List<Location> locationList(){
		Connection conn = getConnection();
		
		List<Location> list = new MainDao().locationList(conn);
		
		
		close(conn);
		
		return list;
	}
	
	
}
