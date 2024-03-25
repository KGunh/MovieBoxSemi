package com.kh.notice.model.dao;

import static com.kh.common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.notice.model.vo.Notice;

public class NoticeDao {
	
	private Properties prop = new Properties();

	public ArrayList<Notice> selectNoticeList(Connection conn) {
		
		ArrayList<Notice> noticeList = new ArrayList();
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("selectNoticeList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			// next()
			
			while(rset.next()) {
				
				Notice notice = new Notice();
				
				notice.setNoticeNo(rset.getInt("NOTICE_NO"));
				notice.setNoticeCategory(rset.getString("NOTICE_CATEGORY"));
				notice.setNoticeTitle(rset.getString("NOTICE_TITLE"));
				notice.setNoticeDate(rset.getDate("CREATE_DATE"));
				notice.setNoticeCount(rset.getInt("COUNT"));
				
				noticeList.add(notice);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return noticeList;
		
	}

}
