package com.kh.member.model.dao;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.getConnection;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.naming.spi.DirStateFactory.Result;

import org.apache.ibatis.session.SqlSession;

import com.kh.board.model.vo.Answer;
import com.kh.board.model.vo.Board;
import com.kh.common.Template;
import com.kh.common.model.vo.Genre;
import com.kh.common.model.vo.Price;
import com.kh.common.model.vo.Reservation;
import com.kh.goods.model.vo.Goods;
import com.kh.goods.model.vo.Order;
import com.kh.member.model.vo.Member;
import com.kh.member.model.vo.MemberGenre;
import com.kh.movie.model.vo.Movie;
import com.kh.reservation.model.vo.Seat;

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
	
	// 마이바티스 적용
	public Member login(SqlSession sqlSession, Member member) {
		
		return sqlSession.selectOne("memberMapper.login", member);
	}
	// 마이바티스 적용
	public List<MemberGenre> loginGenre(SqlSession sqlSession,Member m){
			
		return sqlSession.selectList("memberMapper.loginGenre", m); 
	}
	// 마이바티스 적용
	public int memberInsert(SqlSession sqlSession, Member m) {
		
		return sqlSession.insert("memberMapper.memberInsert", m);
	}
	// 마이바티스 적용
	public int genreInsert(SqlSession sqlSession, List<Genre> genreList) {
		int result = 0;
		
		for(int i = 0; i < genreList.size(); i++) {
			result += sqlSession.insert("memberMapper.genreInsert", genreList.get(i).getGenreName());
		}
		
		return result == genreList.size() ? 1 : 0;
	}
	
	public List<Reservation> myPagePrint(Connection conn, Member loginUser) {
		SqlSession sqlSession = Template.getSqlSession();
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
				r.setMemberNo(rset.getInt("MEMBER_NO"));
				r.setScreenNo(rset.getInt("SCREEN_NO"));
				r.setScreenName(rset.getString("SCREEN_NAME"));
				r.setMovieTitle(rset.getString("MOVIE_TITLE"));
				r.setRunningTime(rset.getString("RT"));
				r.setTheaterName(rset.getString("THEATER_NAME"));
				r.setWatchDate(rset.getString("WATCH_DATE"));
				r.setStatus(rset.getString("STATUS"));
				r.setReservationDate(rset.getString("RESERVATION_DATE"));
				Price price = new Price();
				price.setStudentCount(rset.getInt("GRADE_1_COUNT"));
				price.setCommonCount(rset.getInt("GRADE_2_COUNT"));
				price.setStudentPrice(rset.getInt("STUDENT_PRICE"));
				price.setCommonPrice(rset.getInt("COMMON_PRICE"));
				price.setTotalPrice(rset.getInt("TOTAL_PRICE"));
				r.setPrice(price);
				r.setSeatList(seatList(sqlSession, r.getTicketNo()));
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
	// 마이바티스 적용
	public List<Seat> seatList(SqlSession sqlSession, int ticketNo){
				 
		return sqlSession.selectList("memberMapper.seatList", ticketNo);
	}
	
	public Movie myPageMoviePoster(Connection conn,Reservation res){
		
		Movie m = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("myPageMoviePoster");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, res.getTicketNo());
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				m = new Movie();
				m.setFilePath(rset.getString("FILE_PATH"));
				m.setChangeName(rset.getString("CHANGE_NAME"));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return m;
	}
	
	
	public List<Board> myPageBoardPrint(Connection conn, Member loginUser){
		
		List<Board> boardList = new ArrayList();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("myPageBoardPrint");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, loginUser.getMemberNo());
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Board b = new Board();
				
				b.setBoardNo(rset.getInt("BOARD_NO"));
				b.setBoardTitle(rset.getString("BOARD_TITLE"));
				b.setCreateDate(rset.getString("CREATE_DATE"));
				
				boardList.add(b);
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		
		return boardList;
	}
	
	
	public Answer myPageBoardAnswer(Connection conn,Board board) {
		Answer a = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("myPageBoardAnswer");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, board.getBoardNo());
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				a = new Answer();
				
				a.setAnswerNo(rset.getInt("ANSWER_NO"));
				a.setBoardNo(rset.getInt("BOARD_NO"));
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return a;
	}
	
	public List<Order> myPageOrderPrint(Connection conn,Member loginUser){
		List<Order> orderList = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("myPageOrderPrint");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, loginUser.getMemberNo());
			
			rset = pstmt.executeQuery();
			
			while(rset.next()){
				Order o = new Order();
				
				o.setOrderNo(rset.getInt("ORDER_NO"));
				o.setMemberNo(rset.getInt("MEMBER_NO"));
				o.setStatus(rset.getString("STATUS"));
				o.setOrderDate(rset.getString("ORDER_DATE"));
				
				
				orderList.add(o);
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
			
		}
		
		return orderList;
	}
	
	public List<Goods> orderGoods(Connection conn,int orderNo){
		List<Goods> goodsList = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("orderGoods");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, orderNo);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Goods g = new Goods();
				g.setGoodsNo(rset.getInt("GOODS_NO"));
				g.setGoodsName(rset.getString("GOODS_NAME"));
				g.setGoodsPrice(rset.getInt("GOODS_PRICE"));
				g.setQty(rset.getInt("QTY"));
				
				goodsList.add(g);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
			
		}
		return goodsList;
	}
	
	public String selectlocal(Connection conn, Member m) {
		String local = "";
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectlocal");
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			
			
			pstmt.setString(1, m.getLocalCode());
			
			rset = pstmt.executeQuery();
			
			rset.next();
			
			local = rset.getString("LOCATION_CODE");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
			
		}
		
		return local;
	}
	
	public int updateMember(Connection conn, Member m) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, m.getLocalCode());
			pstmt.setString(2, m.getAddress());
			pstmt.setString(3, m.getEmail());
			pstmt.setInt(4, m.getMemberNo());
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
		
	}
	
	public int deleteGenreList(Connection conn, Member m) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("deleteGenreList");
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, m.getMemberNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	public int genreUpdateInsert (Connection conn,Genre g, Member m) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("genreUpdateInsert");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, m.getMemberNo());
			pstmt.setString(2, g.getGenreName());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	

	public int updatePwd(Connection conn,Member m) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updatePwd");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			
			
			pstmt.setString(1, m.getMemberPwd());
			pstmt.setInt(2, m.getMemberNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
		
		
	}
	
	
	public String idSerach(Connection conn, Member m) {
		String memberId = "";
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("idSerach");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, m.getMemberName());
			pstmt.setString(2, m.getBirthday());
			pstmt.setString(3, m.getPhone());
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				memberId = rset.getString("MEMBER_ID");
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			close(rset);
			close(pstmt);
		}
		
		return memberId;
	}
	
	public int deleteMember(Connection conn,Member loginUser) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteMember");
	
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, loginUser.getMemberNo());
			
			result = pstmt.executeUpdate();			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
		
	}
	public int memberNoSearch(Connection conn, Member m) {
		int memberNo = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("memberNoSearch");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, m.getMemberId());
			pstmt.setString(2, m.getMemberName());
			pstmt.setString(3, m.getBirthday());
			pstmt.setString(4, m.getPhone());
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				memberNo = rset.getInt("MEMBER_NO");
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			close(rset);
			close(pstmt);
		}
		
		return memberNo;
	}
	
	public int idCheck(Connection conn, String checkId) {
		int count = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("idCheck");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, checkId);
			
			rset = pstmt.executeQuery();
			
			rset.next();
			
			count = rset.getInt("COUNT(*)");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			close(rset);
			close(pstmt);
		}
		
		
		
		return count;
	}
	
	public int reservationCancel(Connection conn, int ticketNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("reservationCancel");
	
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, ticketNo);
			
			result = pstmt.executeUpdate();			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	
	public int seatCancel(Connection conn, int ticketNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("seatCancel");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, ticketNo);
			
			result = pstmt.executeUpdate();	
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		
		
		return result;
	}
	
	
	
	
	
	
	
	
	
}
