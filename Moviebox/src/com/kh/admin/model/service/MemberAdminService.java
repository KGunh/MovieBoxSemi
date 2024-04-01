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
	
	
	
	

}
