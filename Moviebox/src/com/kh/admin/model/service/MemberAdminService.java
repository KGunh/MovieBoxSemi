package com.kh.admin.model.service;
import com.kh.member.model.dao.MemberDao;
import com.kh.member.model.vo.Member;
import com.kh.theater.model.vo.Theater;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.kh.admin.model.dao.MemberAdminDao;
import com.kh.common.JDBCTemplate;
import com.kh.common.JDBCTemplate.*;
import com.kh.common.model.vo.Location;

public class MemberAdminService {
	
	
	Member member = new Member();
	

	public ArrayList<Member>selectMemberAdmin(){
		
		 
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Member> member = new MemberAdminDao().selectMemberAdmin(conn);
		
		
		JDBCTemplate.close(conn);
		
		
		
		return member;
		
	}
	
	public Member detailAdmin(int memberNo){
		
		Connection conn = JDBCTemplate.getConnection();
		
		
		Member member = new MemberAdminDao().detailAdmin(conn,memberNo);
		
		JDBCTemplate.close(conn);
		
		return member;
	}
	
	
	public void deleteAdmin(int memberNo) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		new MemberAdminDao().deleteAdmin(conn,memberNo);
		
		JDBCTemplate.close(conn);
		
		
	}
	
	
	
	
	public int updateAdmin(Member member) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		Member updateMember = null;
		
		int result = new MemberAdminDao().updateAdmin(member,conn);
		
		if(result>0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
		
		
	}
	
	
	
	public ArrayList<Theater> cinemaCheck() {
		
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Theater> theater = new MemberAdminDao().cinemaCheck(conn);
		
		JDBCTemplate.close(conn);
		
		return theater;
		
	}
	
	
	
	
	public int cinemaInsert(Theater theater) {
		
		Connection conn=JDBCTemplate.getConnection();
		int result = new MemberAdminDao().cinemaInsert(conn,theater);
		
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		
		
		JDBCTemplate.close(conn);
		
		return result;
		
	}
	
	
	public ArrayList<Location> category() {
		
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Location> location = new MemberAdminDao().category(conn);
		
		JDBCTemplate.close(conn);
		
		return location;
		
	}
	
	public Theater cinemaEdit(int theaterNo) {
		
		Connection conn = JDBCTemplate.getConnection();
		Theater theater = new MemberAdminDao().cinemaEdit(conn,theaterNo);
		JDBCTemplate.close(conn);
		
		return theater;
		
		
		
	}
	
	public int modify(Theater theater) {
		
		Connection conn = JDBCTemplate.getConnection();
		int result = new MemberAdminDao().modify(conn, theater);
		JDBCTemplate.close(conn);
		
		
		if(result > 0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		
		
		
		return result; 
		
		
		
	}
	
	public int dele(int theaterNo){
		
		
		Connection conn = JDBCTemplate.getConnection();
		int result = new MemberAdminDao().dele(conn,theaterNo);
		JDBCTemplate.close(conn);
		
		
		if(result>0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		return result; 
		
	}
	
	public ArrayList<Member> search(String search, String category) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Member> list = new MemberAdminDao().search(conn, search, category);
		JDBCTemplate.close(conn);
		
		return list; 
		
	}
	
	public ArrayList<Theater> searchCinema(String category, String search) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Theater> theater = new MemberAdminDao().searchCinema(conn, search, category);
		
		JDBCTemplate.close(conn);
		
		return theater;
	}
	
}
