package com.kh.member.model.service;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.commit;
import static com.kh.common.JDBCTemplate.getConnection;
import static com.kh.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.board.model.vo.Answer;
import com.kh.board.model.vo.Board;
import com.kh.common.model.vo.Genre;
import com.kh.common.model.vo.Reservation;
import com.kh.goods.model.vo.Goods;
import com.kh.goods.model.vo.Order;
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
	
	public int insert(Member m, List<Genre> genreList) {
		
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
	
	public List<Board> myPageBoardPrint(Member loginUser){
		Connection conn = getConnection();
		
		List<Board> boardList = new MemberDao().myPageBoardPrint(conn, loginUser);
		
		close(conn);
		
		return boardList;
		
	}
	
	public Answer myPageBoardAnswer(Board board) {
		Connection conn = getConnection();
		
		Answer a = new MemberDao().myPageBoardAnswer(conn,board);
		
		close(conn);
		
		return a;
	}
	
	public List<Order> myPageOrderPrint(Member loginUser){
		Connection conn = getConnection();
		
		List<Order> orderList = new MemberDao().myPageOrderPrint(conn,loginUser);
		
		
		if(!orderList.isEmpty()) {
			for(int i= 0;i<orderList.size();i++) {
				int orderNo = orderList.get(i).getOrderNo();
				List<Goods> goodsList = new MemberDao().orderGoods(conn,orderNo);
				
				orderList.get(i).setGoodsList(goodsList);
				
			}
			
		}

		close(conn);
		
		return orderList;
		
	}
	
	public int update(Member m,List<Genre> genreList) {
		Connection conn = getConnection();
		String local = new MemberDao().selectlocal(conn,m);
		m.setLocalCode(local);
		
		
		int memberResult = new MemberDao().updateMember(conn, m);
		
		
		int memberGenreList = 1;
		int genreResult = 1;
		if(!genreList.isEmpty()) {
			memberGenreList += new MemberDao().deleteGenreList(conn,m);
			for(int i = 0; i < genreList.size(); i++) {
				Genre g = new Genre();
				g.setGenreName(genreList.get(i).getGenreName());
				genreResult += new MemberDao().genreUpdateInsert(conn,g,m);
			}
		}
		
		if(memberResult * genreResult * memberGenreList > 0) {			
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		return (memberResult * genreResult * memberGenreList);
		
	
		
		
		
	}
	
	public int updatePwd(Member m) {
		Connection conn = getConnection();
		
		int result = new MemberDao().updatePwd(conn, m);
		
		
		if(result > 0) commit(conn);
		
		close(conn);
		
		return result;
	}
	

}
