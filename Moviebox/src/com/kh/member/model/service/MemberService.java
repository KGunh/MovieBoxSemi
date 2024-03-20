package com.kh.member.model.service;

import java.sql.Connection;

import static com.kh.common.JDBCTemplate.*;
import com.kh.member.model.dao.MemberDao;
import com.kh.member.model.vo.Member;

public class MemberService {
	
	public Member login(Member member) {
		
		Connection conn = getConnection();

		Member m = new MemberDao().login(conn, member);

		close(conn);

		return m;
		
	}
	

}
