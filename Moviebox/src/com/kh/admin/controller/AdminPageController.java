package com.kh.admin.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.kh.admin.model.service.AdminPageService;
import com.kh.board.model.vo.Board;
import com.kh.common.PosterFileRenamePolicy;
import com.kh.common.model.service.MainService;
import com.kh.common.model.vo.Genre;
import com.kh.common.model.vo.Location;
import com.kh.common.model.vo.PageInfo;
import com.kh.movie.model.vo.Movie;
import com.kh.notice.model.vo.Notice;
import com.kh.theater.model.vo.Theater;
import com.oreilly.servlet.MultipartRequest;

public class AdminPageController {
	
	public String adminSelectMovieList(HttpServletRequest request, HttpServletResponse response) {

		int listCount;
		int currentPage;
		int pageLimit;
		int boardLimit;
		int maxPage;
		int startPage;
		int endPage;

		listCount = new AdminPageService().selectListCount();
		currentPage = Integer.parseInt(request.getParameter("currentPage"));
		pageLimit = 10;
		boardLimit = 10;

		maxPage = (int) Math.ceil((double) listCount / boardLimit);

		startPage = (currentPage - 1) / pageLimit * pageLimit + 1;

		endPage = startPage + pageLimit - 1;

		if (endPage > maxPage) {
			endPage = maxPage;
		}

		// vo가공
		PageInfo pi = new PageInfo(listCount, currentPage, pageLimit, boardLimit, maxPage, startPage, endPage);

		// 서비스호출
		ArrayList<Movie> list = new AdminPageService().adminSelectMovieList(pi);
		// 응답화면지정
		request.setAttribute("adminMovieCheckList", list);
		request.setAttribute("pageInfo", pi);
		String view = "views/admin/adminMovieCheck.jsp";

		return view;
	}

	// 공지 목록 전체 출력
	public String adminBoardCheckList(HttpServletRequest request, HttpServletResponse response) {

		int listCount;
		int currentPage;
		int pageLimit;
		int boardLimit;
		int maxPage;
		int startPage;
		int endPage;

		listCount = new AdminPageService().selectListCountNotice();
		currentPage = Integer.parseInt(request.getParameter("currentPage"));
		pageLimit = 10;
		boardLimit = 10;

		maxPage = (int) Math.ceil((double) listCount / boardLimit);

		startPage = (currentPage - 1) / pageLimit * pageLimit + 1;

		endPage = startPage + pageLimit - 1;

		if (endPage > maxPage) {
			endPage = maxPage;
		}

		PageInfo pi = new PageInfo(listCount, currentPage, pageLimit, boardLimit, maxPage, startPage, endPage);

		ArrayList<Notice> list = new AdminPageService().adminSelectNoticeList(pi);
		request.setAttribute("adminBoardCheckList", list);
		request.setAttribute("pageInfo", pi);
		String view = "views/admin/adminBoardCheck.jsp";

		return view;
	}

	// 문의 목록 전체 출력
	public String adminSelectQnAList(HttpServletRequest request, HttpServletResponse response) {

		int listCount;
		int currentPage;
		int pageLimit;
		int boardLimit;
		int maxPage;
		int startPage;
		int endPage;

		listCount = new AdminPageService().selectListCountQnA();
		currentPage = Integer.parseInt(request.getParameter("currentPage"));
		pageLimit = 10;
		boardLimit = 10;

		maxPage = (int) Math.ceil((double) listCount / boardLimit);

		startPage = (currentPage - 1) / pageLimit * pageLimit + 1;

		endPage = startPage + pageLimit - 1;

		if (endPage > maxPage) {
			endPage = maxPage;
		}

		PageInfo pi = new PageInfo(listCount, currentPage, pageLimit, boardLimit, maxPage, startPage, endPage);

		// 서비스호출
		ArrayList<Board> list = new AdminPageService().adminSelectQnAList(pi);
		// 응답화면지정
		request.setAttribute("adminQnACheckList", list);
		request.setAttribute("pageInfo", pi);
		String view = "views/admin/adminQnACheck.jsp";

		return view;
	}

	public String adminMovieEnrollForm(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 입력 양식에서 장르선택은 보여지게
		// 장르선택
		ArrayList<Genre> genrelist = new AdminPageService().SelectGenreList();
		request.setAttribute("genreList", genrelist);

		String view = "views/admin/adminMovieInsert.jsp";
		return view;
	}

	public String adminMovieInsert(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		String view = "views/admin/adminMovieInsert.jsp";
		if (ServletFileUpload.isMultipartContent(request)) {
			// 1) 전송되는 파일을 처리할 작업
			int maxSize = 1024 * 1024 * 10;

			ServletContext application = session.getServletContext();
			String savePath = application.getRealPath("/resources/img/upposter/");
			// 2) 서버에 업로드

			// enctype="multipart/form-data" 는 아래처럼 request를 한번 더 가공 해줘야함!
			MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8",
					new PosterFileRenamePolicy());
			// ------------------ 파일업로드 ------------------

			// enctype="multipart/form-data" 는 아래처럼 request를 한번 더 가공 해줬기 때문에
			// String title = request.getParameter("title");
			// 이렇게 request로 쓰면 null이 나옴...
			// 그래서 multiRequest로 뽑아줘야함!!!

			String title = multiRequest.getParameter("title");
			String genreCode = multiRequest.getParameter("genre");
			String runningTime = multiRequest.getParameter("running_time");
			String rated = multiRequest.getParameter("rated");
			String releaseDate = multiRequest.getParameter("release_date");
			String directorName = multiRequest.getParameter("director_name");
			String actors = multiRequest.getParameter("actors");
			String story = multiRequest.getParameter("story");
			String genre = multiRequest.getParameter("genre");
			// 위쪽까지 form 데이터 받기완료

			// 등록정리
			// 1. TB_DIRECTOR 테이블에 감독정보가 들어가야함 - 존재할 경우 감독번호(DIRECTOR_NO)만 들고있기
			// 2. TB_ACTOR 테이블에 배우 정보가 들어가야함 - 존재할 경우 배우번호(ACTOR_NO)만 들고있기
			// 3. TB_MOVIE 테이블에 영화에 대한 정보가 전부 들어가야함 -영화번호(MOVIE_NO)만 들고있기 -> 들고있던 감독번호도
			// 넣어준다.
			// 4. TB_CAST 테이블에 캐스팅 정보가 들어가야함 - 들고있던 영화번호, 배우번호 넣기 (LOOP로)
			int directorResult;
			int actorResult;
			int castResult;
			int movieResult;

			// 1.)을 하기위해 감독이름이 한글로 들어오기 때문에, 한글로 DB에 감독 이름 검색
			// 기존에 있다면 감독 번호가 나오고, 없다면 0
			int directorNo = new AdminPageService().SelectDirectorName(directorName);
			if (directorNo == 0) {
				// 0이라면 IF문으로 들어오게되고 감독번호 INSERT하기전에 SEQ를 생성해줘야함 SEQ 생성해주고 directorNo 넣어두자.
				directorNo = new AdminPageService().SelectDirectorNo();
				// 감독 insert
				directorResult = new AdminPageService().InsertDirector(directorNo, directorName);
			}

			// 2.)를 하기 위해서는 출연진은 여러명이기 때문에 콤마를 구분으로 들어오는걸 약속해둬야함!
			String[] actorArray = actors.split(",");
			// 최종 TB_CAST테이블에 넣을때 사용할 것
			int[] resultActorNo = new int[actorArray.length];
//	        System.out.println("actorArray length: " + actorArray.length);

			// 배우가 등록되어 있는지 여부를 판단하고, 없으면 넣어줘야함.
			for (int i = 0; i < actorArray.length; i++) {
				// trim -> 콤마로 구분시 공백이 들어온다면 공백제거용
				actorArray[i] = actorArray[i].trim();
				// 배우 이름이 한글로 들어오기 때문에, 한글로 DB에 배우 이름을 검색하는 로직
				// 기존에 있다면 배우 번호가 나오고 없다면 0
				int actorNo = new AdminPageService().SelectActorName(actorArray[i]);

				if (actorNo == 0) {
					// 배우 번호 시퀀스를 뽑기
					actorNo = new AdminPageService().SelectActorNo();
					// 뽑아준 배우 번호와 입력받은 배우 이름을 TB_ACTOR테이블에 INSERT
					actorResult = new AdminPageService().InsertActor(actorNo, actorArray[i]);
				}
				resultActorNo[i] = actorNo;
			}

			// 3.)TB_MOVIE테이블에 INSERT
			int movieNo = new AdminPageService().SelectMovieNo();
			Movie movie = new Movie();
			movie.setMovieNo(movieNo);
			movie.setMovieTitle(title);
			movie.setMovieRt(runningTime);
			movie.setMovieRated(rated);
			movie.setMovieRelease(releaseDate);
			movie.setMovieStory(story);
			movie.setGenreNo(genreCode);
			movie.setDirectorNo(directorNo);
			movieResult = new AdminPageService().InsertMovie(movie);
			for (int i = 0; i < resultActorNo.length; i++) {
				castResult = new AdminPageService().InsertCast(movieNo, resultActorNo[i]);
			}
			if (movieResult > 0) {
				session.setAttribute("alertMsg", "영화가 등록되었습니다.");
				view = "/adminMovieCheck.admin?currentPage=1";
			} else {
				session.setAttribute("alertMsg", "영화 등록에 실패했습니다..");
				view = "views/admin/adminMovieInsert.jsp";
			}
		}

		ArrayList<Genre> genrelist = new AdminPageService().SelectGenreList();
		request.setAttribute("genreList", genrelist);

		return view;
	}

	// 영화 상세보기
	public String adminMovieDetail(HttpServletRequest request, HttpServletResponse response) {

		int movieNo = Integer.parseInt(request.getParameter("movieNo"));
		String view = "";

		Movie m = new AdminPageService().adminMovieDetail(movieNo);
		String cast = new AdminPageService().adminMovieCast(movieNo);
		
		
		
		if(m != null) {
			request.setAttribute("movie", m);
			request.setAttribute("cast", cast);
			view = "views/admin/adminMovieDetail.jsp";
		} else {
			view = "index.jsp";
		}

		return view;

	}
	
	public String adminScreenList(HttpServletRequest request, HttpServletResponse response) {
		
		String view = "";
		
		List<Location> list = new MainService().locationList();
		
		
		if(!list.isEmpty()) {
			request.setAttribute("locationList", list);
			view = "views/admin/adminScreenList.jsp";
		} else {
			view = "index.jsp";
		}
		
		return view;
	}
	
	public List<Theater> selectTheaterList(HttpServletRequest request) {
		String locationCode = request.getParameter("locationCode");
		
		List<Theater> list = new MainService().selectTheaterList(locationCode);
				
		return list;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
