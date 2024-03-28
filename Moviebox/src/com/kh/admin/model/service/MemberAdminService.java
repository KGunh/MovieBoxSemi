package com.kh.admin.model.service;
import com.kh.member.model.vo.Member;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.kh.admin.model.dao.MemberAdminDao;
import com.kh.common.JDBCTemplate;
import com.kh.common.JDBCTemplate.*;

public class MemberAdminService {
	

	public ArrayList<Member>selectMemberAdmin(){
		
		 
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Member> member = new MemberAdminDao().selectMemberAdmin(conn);
		
		
		JDBCTemplate.close(conn);
		
		
		
		return member;
		
	}
	
	public Member editAdmin(int memberNo){
		
		Connection conn = JDBCTemplate.getConnection();
		
		
		Member member = new MemberAdminDao().editAdmin(conn,memberNo);
		
		JDBCTemplate.close(conn);
		
		return member;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
