package com.kh.admin.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import static com.kh.common.JDBCTemplate.*;

public class AdminPageDao {

	private Properties prop = new Properties();
	
	public AdminPageDao() {

		String filePath = AdminPageDao.class.getResource("/sql/admin/Admin-mapper.xml")
										.getPath();

		
		try {
			prop.loadFromXML(new FileInputStream(filePath));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int selectListCount(Connection conn) {
		
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectListCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			rset.next();
			
			listCount = rset.getInt("COUNT(*)");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return listCount;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
