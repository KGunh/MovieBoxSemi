package com.kh.member.model.service;

import static com.kh.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.common.model.vo.Genre;
import com.kh.member.model.dao.MemberDao;
import com.kh.member.model.vo.Member;

public class MemberService {
	
	public Member login(Member member) {
		
		Connection conn = getConnection();

		Member m = new MemberDao().login(conn, member);

		close(conn);
		
		return m;
		
	}
	
	public int insert(Member m, ArrayList<Genre> genreList) {
		
		Connection conn = getConnection();
		
		int memberResult = new MemberDao().memberInsert(conn, m);
		int genreResult = 1;
		for(int i = 0; i < genreList.size(); i++) {
			Genre g = new Genre();
			g.setGenreName(genreList.get(i).getGenreName());
			genreResult += new MemberDao().genreInsert(conn,g);
		}
		if(memberResult * genreResult > 0) {
			
			commit(conn);
			

		} else {
			rollback(conn);
		}
		
		close(conn);
		return (memberResult * genreResult);
		
	}

}
