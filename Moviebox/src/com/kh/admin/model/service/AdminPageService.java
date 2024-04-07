package com.kh.admin.model.service;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.commit;
import static com.kh.common.JDBCTemplate.getConnection;
import static com.kh.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.kh.admin.model.dao.AdminPageDao;
import com.kh.board.model.vo.Board;
import com.kh.common.model.vo.Attachment;
import com.kh.common.model.vo.Genre;
import com.kh.common.model.vo.PageInfo;
import com.kh.movie.model.vo.Movie;
import com.kh.notice.model.dao.NoticeDao;
import com.kh.notice.model.vo.Notice;
import com.kh.theater.model.vo.Screen;
import com.kh.theater.model.vo.Theater;

public class AdminPageService {
	

	// 영화
	public ArrayList<Movie> adminSelectMovieList(PageInfo pi){
		
		Connection conn = getConnection();
		
		ArrayList<Movie> list = new AdminPageDao().adminSelectMovieList(conn, pi);
		
		close(conn);
		
		return list;
	}
	

	public int selectListCount() {
		
		Connection conn = getConnection();
		
		int result = new AdminPageDao().selectListCount(conn);
		
		close(conn);
		
		return result;
	}
	

	// 공지 
	public ArrayList<Notice> adminSelectNoticeList(PageInfo pi){
		
		Connection conn = getConnection();
		
		ArrayList<Notice> list = new AdminPageDao().adminSelectNoticeList(conn, pi);
		
		close(conn);
		
		return list;
	}
	

	public int selectListCountNotice() {
		
		Connection conn = getConnection();
		
		int result = new AdminPageDao().selectListCountNotice(conn);
		
		close(conn);
		
		return result;
	}
	
	
	
	// 문의
	public ArrayList<Board> adminSelectQnAList(PageInfo pi){
		
		Connection conn = getConnection();
		
		ArrayList<Board> list = new AdminPageDao().adminSelectQnAList(conn, pi);
		
		close(conn);
		
		return list;
	}
	

	public int selectListCountQnA() {
		
		Connection conn = getConnection();
		
		int result = new AdminPageDao().selectListCountQnA(conn);
		
		close(conn);
		
		return result;
	}
	
	
	
	
	
	//장르카테고리(영화등록 시 필요)
	public ArrayList<Genre> SelectGenreList() {
		
		Connection conn = getConnection();
		
		ArrayList<Genre> genrelist = new AdminPageDao().SelectGenreList(conn);
		
		close(conn);
		
		return genrelist;
	}
	
	
	
	//감독체크(영화등록 시 필요)
	public int SelectDirectorName(String directorName) {
		
		Connection conn = getConnection();
		
		int directorNo = new AdminPageDao().SelectDirectorName(conn, directorName);
		
		close(conn);
		
		return directorNo;
		
	}
	
	//감독 등록전 시퀀스 조회(영화등록 시 필요)
	public int SelectDirectorNo() {
		Connection conn = getConnection();
		
		int directorNo = new AdminPageDao().SelectDirectorNo(conn);
		
		close(conn);
		
		return directorNo; 
	}
	
	
	//감독 등록(영화등록 시 필요)
	public int InsertDirector(int directorNo, String directorName) {
		Connection conn = getConnection();
		
		int result = new AdminPageDao().InsertDirector(conn, directorNo, directorName);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	
	
	
	//출연진 이름으로 출연진NO조회(영화등록 시 필요)
	public int SelectActorName(String actorName) {
		
		Connection conn = getConnection();
		
		int actorNo = new AdminPageDao().SelectActorName(conn, actorName);
		
		close(conn);
		
		return actorNo;
		
	}
	
	
	
	//출연진 등록전 시퀀스 조회(영화등록 시 필요)
	public int SelectActorNo() {
		Connection conn = getConnection();
		
		int actorNo = new AdminPageDao().SelectActorNo(conn);
		
		close(conn);
		
		return actorNo; 
	}
	
	
	//출연진 등록(영화등록 시 필요)
	public int InsertActor(int actorNo, String actorName) {
		Connection conn = getConnection();
		
		int result = new AdminPageDao().InsertActor(conn, actorNo, actorName);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	
	
	//영화 등록전 시퀀스 조회(영화등록 시 필요)
	public int SelectMovieNo() {
		Connection conn = getConnection();
		
		int movieNo = new AdminPageDao().SelectMovieNo(conn);
		
		close(conn);
		
		return movieNo; 
	}
	
	//영화 등록(영화등록 시 필요)
	public int InsertMovie(Movie movie) {
		Connection conn = getConnection();
		
		int result = new AdminPageDao().InsertMovie(conn, movie);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	
	//영화 수정
	public int updateMovie(Movie movie) {
		Connection conn = getConnection();
		
		int result = new AdminPageDao().updateMovie(conn, movie);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	
	
	public int selectDuplicateCast(int movieNo, int actorNo) {
		Connection conn = getConnection();
		
		int result = new AdminPageDao().selectDuplicateCast(conn, movieNo, actorNo);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	
	//Cast등록(영화등록 시 필요)
	public int InsertCast(int movieNo, int actorNo) {
		Connection conn = getConnection();
		
		int listCount = new AdminPageDao().InsertCast(conn, movieNo, actorNo);
		
		close(conn);
		
		return listCount;
	}

	//
	public Movie adminMovieDetail(int movieNo) {
		
		Connection conn = getConnection();
		
		Movie movie = new AdminPageDao().adminMovieDetail(conn,movieNo);
		
		close(conn);
		
		return movie;
	}
	
	
	public String adminMovieCast(int movieNo) {
		Connection conn = getConnection();
		
		String casts = new AdminPageDao().adminMovieCast(conn, movieNo);
		
		close(conn);
		
		return casts;
	}
	
	public List<Theater> selectTheaterList(String locationCode){
		Connection conn = getConnection();
		List<Theater> list = new AdminPageDao().selectTheaterList(conn, locationCode);
		close(conn);
		
		return list;
	}
	
	
	public List<Screen> adminDetailTheater(Screen sc){
		Connection conn = getConnection();
		
		List<Screen> screenList = new AdminPageDao().adminDetailScreenName(conn, sc);
		
		if(!screenList.isEmpty()) {
			for(int i=0;i<screenList.size();i++) {
				String screenName = screenList.get(i).getScreenName();
				
				List<Movie> movieList = new AdminPageDao().adminMovieList(conn,screenName, sc);
				screenList.get(i).setMovieList(movieList);
				
			}
		}
		
		
		
		
		close(conn);
		
		return screenList;
		
	}
	
										  //=서블릿에서 getParameter()써주기
	public List<Movie> searchTitle(String keyword, PageInfo pi){
		Connection conn = getConnection();
//		System.out.println(keyword);
		List<Movie> movieList = new AdminPageDao().searchTitle(conn, keyword, pi);
		close(conn);
		return movieList;
	}
	
	public int insertScreen(Screen sc) {
		Connection conn = getConnection();
		
		int count = new AdminPageDao().selectScreen(conn,sc);
		int result = 0;
		if(count == 0) {
			result = new AdminPageDao().insertScreen(conn, sc);
			
			if(result>0) commit(conn);
		}
		
		
		
		close(conn);
		
		return result;
	}
	
	public int adminMovieDelete(int movieNo) {
		Connection conn = getConnection();
		int result = new AdminPageDao().adminMovieDelete(conn, movieNo);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		return result;
	}
	
	
	
	
	
	public String adminMoviePoster(int movieNo) {
		Connection conn = getConnection();
		String poster = new AdminPageDao().adminMoviePoster(conn, movieNo);
		close(conn);
		return poster;
	}
	
	// 포스터 등록전 fileNo
	public int SelectFileNo() {
		Connection conn = getConnection();
		
		int fileNo = new AdminPageDao().SelectFileNo(conn);
		
		close(conn);
		
		return fileNo; 
	}
	
	//Attachment에 등록(영화등록 시 필요)
	public int InsertAttach(int movieNo, ArrayList<Attachment> list) {
		Connection conn = getConnection();
		
		int result = new AdminPageDao().InsertAttach(conn, movieNo, list);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	
	
	// 공지 게시글 상세보기
	public Notice adminBoardDetail(int noticeNo) {
		
		Connection conn = getConnection();
		
		Notice notice = new AdminPageDao().adminBoardDetail(conn, noticeNo);
		
		close(conn);
		
		return notice;
	}
	
	
	// 문의 게시글 상세보기
	public Board adminQnADetail(int boardNo) {
		
		Connection conn = getConnection();
		
		Board board = new AdminPageDao().adminQnADetail(conn, boardNo);
		
		close(conn);
		
		return board;
	}
	
	//공지 삭제
	public int adminBoardDelete(int noticeNo) {
		Connection conn = getConnection();
		int result = new AdminPageDao().adminBoardDelete(conn, noticeNo);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		return result;
	}
	
	
	
	//문의 삭제
	public int adminQnADelete(int boardNo) {
		Connection conn = getConnection();
		int result = new AdminPageDao().adminQnADelete(conn, boardNo);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		return result;
	}
	
	
	//공지등록
	public int adminBoardInsert(Notice notice) {
		Connection conn = getConnection();
		int result = new AdminPageDao().adminBoardInsert(conn, notice);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		return result;
	}
	
	public int adminBoardUpdate(Notice notice) {
		
		Connection conn = getConnection();
		
		int result = new AdminPageDao().adminBoardUpdate(conn, notice);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

