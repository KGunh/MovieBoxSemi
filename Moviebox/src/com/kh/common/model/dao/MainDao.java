package com.kh.common.model.dao;

import static com.kh.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.kh.common.model.vo.Attachment;
import com.kh.common.model.vo.Location;
import com.kh.member.model.dao.MemberDao;
import com.kh.notice.model.vo.Notice;

public class MainDao {
private Properties prop = new Properties();
	
	public MainDao() {
		String sqlFile = MemberDao.class.getResource("/sql/common/main-mapper.xml").getPath();
	
				
		try {
			prop.loadFromXML(new FileInputStream(sqlFile));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<Attachment> adPrint(Connection conn){
		List<Attachment> list = new ArrayList();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("adPrint");
	
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Attachment attach = new Attachment();
				
				attach.setMovieNo(rset.getInt("MOVIE_NO"));
				attach.setChangeName(rset.getString("CHANGE_NAME"));
				attach.setFilePath(rset.getString("FILE_PATH"));
				
				list.add(attach);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
			
		}
		
		return list;
		
	}
	public List<Attachment> chartPrint(Connection conn){
		List<Attachment> list = new ArrayList();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("chartPrint");
	
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Attachment attach = new Attachment();
				
				attach.setMovieNo(rset.getInt("MOVIE_NO"));
				attach.setChangeName(rset.getString("CHANGE_NAME"));
				attach.setFilePath(rset.getString("FILE_PATH"));
				
				list.add(attach);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
			
		}
		
		return list;
		
	}
	
	public List<Notice> boardPrint(Connection conn){
		List<Notice> list = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("boardPrint");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Notice n = new Notice();
				n.setNoticeNo(rset.getInt("NOTICE_NO"));
				n.setNoticeTitle(rset.getString("NOTICE_TITLE"));
				n.setCreateDate(rset.getString("CREATE_DATE"));
				
				list.add(n);
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
			
		}
		
		return list;
	}
	
	public List<Location> locationList(Connection conn){
		List<Location> list = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("locationList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Location l = new Location();
				
				l.setLocationCode(rset.getString(""));
				l.setLocationName(rset.getString(""));
				
				list.add(l);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}
	
	
	
	
	
	
	
	
	
	
}
