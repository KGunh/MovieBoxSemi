package com.kh.admin.model.dao;
import static com.kh.common.JDBCTemplate.*;


import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.kh.common.model.vo.Location;
import com.kh.member.model.dao.MemberDao;
import com.kh.member.model.vo.Member;
import com.kh.theater.model.vo.Theater;

public class MemberAdminDao {
	
	private Properties prop = new Properties();
	
	
	public MemberAdminDao() {
			String sqlFile = MemberAdminDao.class.getResource("/sql/admin/memberAdmin-mapper.xml").getPath();
			try {
				prop.loadFromXML(new FileInputStream(sqlFile));
			} catch (IOException e) {
				e.printStackTrace();
			}
				
				
	}
			
			
	
	public ArrayList<Member> selectMemberAdmin(Connection conn){
		ArrayList<Member> member = new ArrayList<Member>();

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectAdmin");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
		while(rset.next()) {
				Member m = new Member();
							m.setMemberNo(rset.getInt("MEMBER_NO"));
							m.setMemberName(rset.getString("MEMBER_NAME"));
							m.setEnrollDate(rset.getDate("ENROLL_DATE"));
							m.setStatus(rset.getString("STATUS"));
							m.setPhone(rset.getString("PHONE"));
							
							member.add(m);
		}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		
		
		return member;	
			
	}
	
	public Member detailAdmin(Connection conn, int memberNo){
		
		Member m = new Member(); 
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("editAdmin");

		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memberNo);
			
			rset = pstmt.executeQuery();
			
		if(rset.next()) { 
			
			
						m.setMemberNo(rset.getInt("MEMBER_NO"));
						m.setMemberId(rset.getString("MEMBER_ID"));
						m.setMemberPwd(rset.getString("MEMBER_PWD"));
						m.setMemberName(rset.getString("MEMBER_NAME"));
						m.setGender(rset.getString("GENDER"));
						m.setBirthday(rset.getString("BIRTHDAY"));
						m.setEmail(rset.getString("EMAIL"));
						m.setAddress(rset.getString("ADDRESS"));
						m.setPhone(rset.getString("PHONE"));
						m.setEnrollDate(rset.getDate("ENROLL_DATE"));
						m.setStatus(rset.getString("STATUS"));
						
						
						
		}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			close(rset);
			close(pstmt);
		}
		
		
		
		
		
		
		return m;
		
		
	}
	
	
	
	
	public int updateAdmin(Member member, Connection conn) {
		
		
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("updateMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, member.getMemberName());
			pstmt.setString(2, member.getEmail());
			pstmt.setString(3, member.getAddress());
			pstmt.setString(4, member.getPhone());
			pstmt.setString(5, member.getStatus());
			pstmt.setString(6, member.getMemberId());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		
		return result; 
		
	}
	
	public int deleteAdmin(Connection conn,int memberNo) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("deleteAdmin");
		
		
		
		return result;
	}
	
	
	
	public ArrayList<Theater> cinemaCheck(Connection conn){
		
		ArrayList<Theater> theater = new ArrayList<Theater>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("cinemaCheck");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Theater Cinema = new Theater(); 
						Cinema.setTheaterNo(rset.getInt("THEATER_NO"));
						Cinema.setUpdateDate(rset.getString("THEATER_UPDATE"));
						Cinema.setLocationName(rset.getString("LOCATION_NAME"));
						Cinema.setTheaterName(rset.getString("THEATER_NAME"));
						Cinema.setLocalCode(rset.getString("LOCATION_CODE"));
						Cinema.setMapLink(rset.getString("MAP_LINK"));
						
					theater.add(Cinema);	
						
						
			}	
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return theater;
		
		
	}
	
	public int cinemaInsert(Connection conn,Theater theater) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("cinemaInsert");
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			
			pstmt.setString(1, theater.getTheaterName());
			pstmt.setString(2, theater.getTheaterAddr());
			pstmt.setString(3, theater.getMapLink());
			pstmt.setString(4, theater.getLocalCode());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			close(pstmt);
			
		}
		
		
		
		return result; 
		
		
	}
	
	
	public ArrayList<Location> category(Connection conn) {
		
		ArrayList<Location> location = new ArrayList<Location>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("category");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				Location loca = new Location();
								loca.setLocationCode(rset.getString("LOCATION_CODE"));
								loca.setLocationName(rset.getString("LOCATION_NAME"));	
			
								location.add(loca);
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		
		
		return location;
		
		
		
		
		
	}
	
	
	public Theater cinemaEdit(Connection conn, int theaterNo) {
		
		Theater theater = new Theater();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("cinemaEdit");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, theaterNo);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
						theater.setTheaterNo(rset.getInt("THEATER_NO"));
						theater.setTheaterName(rset.getString("THEATER_NAME"));
						theater.setTheaterAddr(rset.getString("THEATER_ADDR"));
						theater.setLocationName(rset.getString("LOCATION_NAME"));
						theater.setMapLink(rset.getString("MAP_LINK"));
						theater.setLocalCode(rset.getString("LOCATION_CODE"));
						theater.setUpdateDate(rset.getString("THEATER_UPDATE"));
						
					
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return theater;
		
		
		
	}
	
	public int modify(Connection conn, Theater theater) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("modify");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, theater.getTheaterName());
			pstmt.setString(2, theater.getTheaterAddr());
			pstmt.setString(3, theater.getMapLink());
			pstmt.setString(4, theater.getLocalCode());
			pstmt.setInt(5, theater.getTheaterNo());
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result; 
	}
	
	public int dele(Connection conn,int theaterNo) {
		System.out.println(theaterNo);
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("dele");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, theaterNo);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
	
		
		
		return result; 
		
	}
	
	
	public ArrayList<Member> search(Connection conn,String search, String category){
		Member member = new Member();
		ArrayList<Member> list = new ArrayList<Member>();
		
		System.out.println(search+category);
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("search");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, category);
			pstmt.setString(2, search);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				member.setMemberNo(rset.getInt("MEMBER_NO"));
				member.setMemberName(rset.getString("MEMBER_NAME"));
				member.setEnrollDate(rset.getDate("ENROLL_DATE"));
				member.setStatus(rset.getString("STATUS"));
				member.setPhone(rset.getString("PHONE"));
				
				list.add(member);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		
		return list; 
		
		
	}
	
	
	
	
}
	
	
	

