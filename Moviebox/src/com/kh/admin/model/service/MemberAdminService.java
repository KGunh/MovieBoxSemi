package com.kh.admin.model.service;
import com.kh.member.model.vo.Member;

import java.sql.Connection;
import java.util.List;

import com.kh.admin.model.dao.MemberAdminDao;
import com.kh.common.JDBCTemplate;
import com.kh.common.JDBCTemplate.*;

public class MemberAdminService {
	

	public List<Member>selectMemberAdmin(){
		
		List<Member> member = null;
		Connection conn = JDBCTemplate.getConnection();
		
		member = new MemberAdminDao().selectMemberAdmin(conn);
		
		
		JDBCTemplate.close(conn);
		
		
		
		return member;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
