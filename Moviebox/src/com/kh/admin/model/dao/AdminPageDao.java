package com.kh.admin.model.dao;

import static com.kh.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.kh.board.model.vo.Board;
import com.kh.common.model.vo.Genre;
import com.kh.common.model.vo.PageInfo;
import com.kh.movie.model.vo.Movie;
import com.kh.notice.model.vo.Notice;
import com.kh.theater.model.vo.Screen;
import com.kh.theater.model.vo.Theater;

public class AdminPageDao {

	private Properties prop = new Properties();
	
	public AdminPageDao() {
		
		String fileName = AdminPageDao.class.getResource("/sql/admin/admin-mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	//영화 목록 전체 출력
	public ArrayList<Movie> adminSelectMovieList(Connection conn, PageInfo pi){
		
		
		ArrayList<Movie> list = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("adminSelectMovieList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				Movie movie = new Movie();
				
				movie.setMovieNo(rset.getInt("MOVIE_NO"));
				movie.setMovieRelease(rset.getString("MOVIE_RELEASE"));
				movie.setMovieTitle(rset.getString("MOVIE_TITLE"));
				movie.setMovieRated(rset.getString("MOVIE_RATED"));
				movie.setGenreNo(rset.getString("GENRE_NAME"));
				movie.setMovieUpdate(rset.getString("MOVIE_UPDATE"));
				
				list.add(movie);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
		
	}
	
	
	public int selectListCount(Connection conn) {
		
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectListCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			rset.next();
			
			listCount = rset.getInt("COUNT(*)");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return listCount;
	}
	
	
	
	//공지 목록 전체 출력
	public ArrayList<Notice> adminSelectNoticeList(Connection conn,  PageInfo pi){
		
		ArrayList<Notice> list = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("adminSelectNoticeList");
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				Notice notice = new Notice();
				
				notice.setNoticeNo(rset.getInt("NOTICE_NO"));
				notice.setNoticeCategory(rset.getString("CATEGORY_NAME"));
				notice.setNoticeTitle(rset.getString("NOTICE_TITLE"));
				notice.setCreateDate(rset.getString("CREATE_DATE"));
				notice.setCount(rset.getInt("COUNT"));
				
				list.add(notice);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
		
		
	}	

	
	public int selectListCountNotice(Connection conn) {
		
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectListCountNotice");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			rset.next();
			
			listCount = rset.getInt("COUNT(*)");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return listCount;
	}
	
	
	
	//문의 목록 전체 출력
	public ArrayList<Board> adminSelectQnAList(Connection conn,  PageInfo pi){
		
		ArrayList<Board> list = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("adminSelectQnAList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				Board board = new Board();
				
				board.setBoardNo(rset.getInt("BOARD_NO"));
				board.setBoardCategory(rset.getString("CATEGORY_NO"));
				board.setBoardTitle(rset.getString("BOARD_TITLE"));
				board.setBoardWriter(rset.getString("MEMBER_ID"));
				board.setCreateDate(rset.getString("CREATE_DATE"));
				board.setCount(rset.getInt("COUNT"));
				
				list.add(board);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
		
		
	}	
	
	

	public int selectListCountQnA(Connection conn) {
		
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectListCountQnA");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			rset.next();
			
			listCount = rset.getInt("COUNT(*)");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return listCount;
	}
	
	
	
	
	
	
	
	//장르카테고리
	public ArrayList<Genre> SelectGenreList(Connection conn){
		
		ArrayList<Genre> genrelist = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("SelectGenreList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				genrelist.add(
						new Genre(
								rset.getString("GENRE_CODE"),
								rset.getString("GENRE_NAME")
								));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return genrelist;
		
	}
	
	
	
	
	//감독이름으로 감독NO조회
	public int SelectDirectorName(Connection conn, String directorName) {
		
		int directorNo = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("SelectDirectorName");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, '%' + directorName + '%');
			rset = pstmt.executeQuery();
			
			if (rset.next()) { // 결과가 존재하면
				directorNo = rset.getInt("DIRECTOR_NO");
	        }
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
	        if (rset != null) {
	            try {
	                rset.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	        if (pstmt != null) {
	            try {
	                pstmt.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
		}
		return directorNo;
	}
	
	
	//감독 등록전 시퀀스 조회
	public int SelectDirectorNo(Connection conn) {
		int directorNo = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("SelectDirectorNo");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			rset.next();
			
			directorNo = rset.getInt("DIRECTOR_NO");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return directorNo;
	}
	
	
	//감독 등록
	public int InsertDirector(Connection conn, int directorNo, String directorName) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("InsertDirector");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, directorNo);
			pstmt.setString(2, directorName);

			result = pstmt.executeUpdate();

			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	
	//출연진 이름으로 출연진NO조회
	public int SelectActorName(Connection conn, String actorName) {
		
		int actorNo = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("SelectActorName");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, '%' + actorName + '%');
			rset = pstmt.executeQuery();
			
			if (rset.next()) { // 결과가 존재하면
				actorNo = rset.getInt("ACTOR_NO");
	        }
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
	        if (rset != null) {
	            try {
	                rset.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	        if (pstmt != null) {
	            try {
	                pstmt.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
		}
		return actorNo;
	}
	
	//출연진 등록전 시퀀스 조회
	public int SelectActorNo(Connection conn) {
		int actorNo = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("SelectActorNo");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			rset.next();
			
			actorNo = rset.getInt("ACTOR_NO");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return actorNo;
	}
	
	//출연진 등록
	public int InsertActor(Connection conn, int actorNo, String actorName) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("InsertActor");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, actorNo);
			pstmt.setString(2, actorName);

			result = pstmt.executeUpdate();

			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	//영화 등록전 시퀀스 조회
	public int SelectMovieNo(Connection conn) {
		int movieNo = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("SelectMovieNo");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			rset.next();
			
			movieNo = rset.getInt("MOVIE_NO");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return movieNo;
	}
	
	//영화 등록
	public int InsertMovie(Connection conn, Movie movie) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("InsertMovie");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, movie.getMovieNo());
			pstmt.setString(2, movie.getMovieTitle());
			pstmt.setString(3, movie.getMovieRt());
			pstmt.setString(4, movie.getMovieRated());
			pstmt.setString(5, movie.getMovieRelease());
			pstmt.setString(6, movie.getMovieStory());
			pstmt.setString(7, movie.getGenreNo());
			pstmt.setInt(8, movie.getDirectorNo());
			
			result = pstmt.executeUpdate();

			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	
	
	//Cast 등록
	public int InsertCast(Connection conn, int movieNo, int actorNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("InsertCast");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, movieNo);
			pstmt.setInt(2, actorNo);
			
			result = pstmt.executeUpdate();

			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	
	//영화 상세
	public Movie detailAdmin(Connection conn, int movieNo){
		Movie m = new Movie(); 
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("SelectMovieDetail");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, movieNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) { 
				m.setMovieNo(rset.getInt("MOVIE_NO"));
				m.setMovieTitle(rset.getString("MOVIE_TITLE"));
				m.setMovieRt(rset.getString("MOVIE_RT"));
				m.setMovieRated(rset.getString("MOVIE_RATED"));
				m.setMovieRelease(rset.getString("MOVIE_RELEASE"));
				m.setMovieStory(rset.getString("MOVIE_STORY"));
				m.setStatus(rset.getString("STATUS"));
				m.setGenreNo(rset.getString("GENRE_NO"));
				m.setGenreName(rset.getString("GENRE_NAME"));
				m.setDirectorNo(rset.getInt("DIRECTOR_NO"));
				m.setDirectorName(rset.getString("DIRECTOR_NAME"));
				m.setMovieUpdate(rset.getString("MOVIE_UPDATE"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return m;
	}
	
	public String adminMovieCast(Connection conn, int movieNo) {
		String cast = "";
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("SelectCastInfo");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			
			pstmt.setInt(1, movieNo);
			
			rset = pstmt.executeQuery();
			
			rset.next();
			
			cast = rset.getString("ACTOR_NAMES");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return cast;
	}
	
	public List<Theater> selectTheaterList(Connection conn,String locationCode){
		List<Theater> list = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectTheaterList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, locationCode);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Theater t = new Theater();
				
				t.setTheaterNo(rset.getInt("THEATER_NO"));
				t.setTheaterName(rset.getString("THEATER_NAME"));
				list.add(t);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
		
		
		
	}
	public List<Screen> adminDetailScreenName(Connection conn, Screen sc){
		List<Screen> list = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("adminDetailScreenName");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, sc.getTheaterNo());
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Screen s = new Screen();
				
				s.setScreenName(rset.getString("SCREEN_NAME"));
				
				list.add(s);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}
	public List<Movie> adminMovieList(Connection conn,String screenName, Screen sc){
		List<Movie> list = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("adminMovieList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, sc.getTheaterNo());
			pstmt.setString(2, screenName);
			pstmt.setString(3, sc.getWatchDate());
			rset = pstmt.executeQuery();
			
			while (rset.next()) {
				Movie m = new Movie();
				m.setScreenNo(rset.getInt("SCREEN_NO"));
				m.setMovieNo(rset.getInt("MOVIE_NO"));
				m.setMovieTitle(rset.getString("MOVIE_TITLE"));
				m.setWatchDate(rset.getString("WATCH_DATE"));
				list.add(m);
				
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;

		
		
	}
	
	public List<Screen> adminDetailTheater(Connection conn, Screen sc) {
		List<Screen> list = new ArrayList();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("adminDetailTheater");

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, sc.getTheaterNo());
			pstmt.setString(2, sc.getWatchDate());

			rset = pstmt.executeQuery();

			while (rset.next()) {
				Screen s = new Screen();

				s.setScreenName(rset.getString("SCREEN_NAME"));
				s.setWatchDate(rset.getString("WATCH_DATE"));
				s.setTheaterName(rset.getString("THEATER_NAME"));
				s.setMovieTitle(rset.getString("MOVIE_TITLE"));
				
				
				list.add(s);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return list;

	}

}
