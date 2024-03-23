package com.kh.member.model.dao;

import static com.kh.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.common.model.vo.Genre;
import com.kh.member.model.vo.Member;
import com.kh.member.model.vo.MemberGenre;

public class MemberDao {
	
	private Properties prop = new Properties();
	
	public MemberDao() {
		String sqlFile = MemberDao.class.getResource("/sql/member/member-mapper.xml").getPath();
	
				
		try {
			prop.loadFromXML(new FileInputStream(sqlFile));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Member login(Connection conn, Member member) {

		
		Member m = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		
		String sql = prop.getProperty("login");
		

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getMemberPwd());
			
		
			
			rset = pstmt.executeQuery();
			

			if(rset.next()) {
				
				
				m = new Member(rset.getInt("MEMBER_NO"),
										 rset.getString("MEMBER_ID"),
										 rset.getString("MEMBER_PWD"),
										 rset.getString("MEMBER_NAME"),
										 rset.getString("BIRTHDAY"),
										 rset.getString("GENDER"),
										 rset.getString("EMAIL"),
										 rset.getString("PHONE"),
										 rset.getString("ADDRESS"),
										 rset.getDate("ENROLL_DATE"),
										 rset.getString("STATUS"),
										 rset.getString("PRIVILEGE"),
										 rset.getString("LOCATION_NAME"));
								
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return m;
		
	}
	
	public int memberInsert(Connection conn, Member m) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("memberInsert");
		
		System.out.println(m.getMemberId());
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, m.getMemberId());
			pstmt.setString(2, m.getMemberPwd());
			pstmt.setString(3, m.getMemberName());
			pstmt.setString(4, m.getBirthday());
			pstmt.setString(5, m.getGender());
			pstmt.setString(6, m.getEmail());
			pstmt.setString(7, m.getPhone());
			pstmt.setString(8, m.getAddress());
			pstmt.setString(9, m.getLocalCode());
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		
		
		
		return result;
	}
	
	public int genreInsert(Connection conn, Genre g) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("genreInsert");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, g.getGenreName());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		
		
		return result;
	}
	
	public ArrayList<MemberGenre> loginGenre(Connection conn,Member m){
		ArrayList<MemberGenre> list = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("loginGenre");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, m.getMemberId());
			pstmt.setString(2, m.getMemberPwd());
			
			rset = pstmt.executeQuery();
			
			
			while(rset.next()) {
				MemberGenre mg = new MemberGenre();
				
				mg.setGenreCode(rset.getString("GENRE_NAME"));
				
				list.add(mg);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
		return list; 
	}

}
