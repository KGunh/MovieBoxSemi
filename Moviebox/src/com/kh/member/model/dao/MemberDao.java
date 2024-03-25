package com.kh.member.model.dao;

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

import com.kh.common.model.vo.Genre;
import com.kh.common.model.vo.Reservation;
import com.kh.member.model.vo.Member;
import com.kh.member.model.vo.MemberGenre;
import com.kh.movie.model.vo.Movie;

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
	//로그인기능
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
	// 로그인 장르
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

	// 회원가입
	public int memberInsert(Connection conn, Member m) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("memberInsert");

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
	// 회원가입 장르 추가
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
	
	public List<Reservation> myPagePrint(Connection conn, Member loginUser) {
		
		List<Reservation> list = new ArrayList();
				
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("myPagePrint");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1,loginUser.getMemberNo());
			pstmt.setInt(2,loginUser.getMemberNo());
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Reservation r = new Reservation();
				
				r.setTicketNo(rset.getInt("TICKET_NO"));
				r.setPersonNum(rset.getInt("PERSONNEL"));
				r.setMovieTitle(rset.getString("MOVIE_TITLE"));
				r.setTheaterName(rset.getString("THEATER_NAME"));
				r.setWatchDate(rset.getString("WATCH_DATE"));
				r.setStatus(rset.getString("STATUS"));
				r.setStudentCount(rset.getInt("GRADE_1_COUNT"));
				r.setCommonCount(rset.getInt("GRADE_2_COUNT"));
				r.setStudentPrice(rset.getInt("STUDENT_PRICE"));
				r.setCommonPrice(rset.getInt("COMMON_PRICE"));
				r.setTotalPrice(rset.getInt("TOTAL_PRICE"));
				
				list.add(r);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		

		return list;
		
	}
	
	public Movie myPageMoviePoster(Connection conn,Reservation res){
		
		Movie m = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("myPageMoviePoster");
		System.out.println(res.getTicketNo());
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, res.getTicketNo());
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				m = new Movie();
				m.setFilePath(rset.getString("FILE_PATH"));
				m.setFileName(rset.getString("CHANGE_NAME"));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return m;
	}
	
}
