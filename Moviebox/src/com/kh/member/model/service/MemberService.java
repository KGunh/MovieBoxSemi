package com.kh.member.model.service;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.commit;
import static com.kh.common.JDBCTemplate.getConnection;
import static com.kh.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.kh.common.model.vo.Genre;
import com.kh.common.model.vo.Reservation;
import com.kh.member.model.dao.MemberDao;
import com.kh.member.model.vo.Member;
import com.kh.member.model.vo.MemberGenre;
import com.kh.movie.model.vo.Movie;

public class MemberService {
	
	public Member login(Member member) {
		
		Connection conn = getConnection();
		// 로그인
		Member m = new MemberDao().login(conn, member);
		// 로그인한 회원 객체에 장르 추가
		if(m != null) {
			ArrayList<MemberGenre> list = new MemberDao().loginGenre(conn, member);
			m.setGenreList(list);
		}
		

		close(conn);
		
		return m;
		
	}
	
	public int insert(Member m, ArrayList<Genre> genreList) {
		
		Connection conn = getConnection();
		// 회원가입
		int memberResult = new MemberDao().memberInsert(conn, m);
		int genreResult = 1;
		if(!genreList.isEmpty()) {
			for(int i = 0; i < genreList.size(); i++) {
				Genre g = new Genre();
				// 회원가입 장르 추가
				g.setGenreName(genreList.get(i).getGenreName());
				genreResult += new MemberDao().genreInsert(conn,g);
			}
		}
		if(memberResult * genreResult > 0) {
			
			commit(conn);
			

		} else {
			rollback(conn);
		}
		
		close(conn);
		return (memberResult * genreResult);
		
	}
	
	public List<Reservation> myPagePrint(Member loginUser) {
		Connection conn = getConnection();
		
		List<Reservation> list = new MemberDao().myPagePrint(conn,loginUser);
		
		
		close(conn);
		return list;
	}
	
	public Movie myPageMoviePoster(Reservation res) {
		Connection conn = getConnection();
		
		Movie m = new MemberDao().myPageMoviePoster(conn,res);
		close(conn);
		return m;
	}

}
