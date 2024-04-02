package com.kh.theater.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.movie.model.service.MovieService;
import com.kh.movie.model.vo.Movie;
import com.kh.theater.model.service.TheaterService;
import com.kh.theater.model.vo.Theater;

public class TheaterController {
	
	public String listDetail(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<Theater> list = new TheaterService().theaterAll();
		request.setAttribute("theaterList", list);
		String view = "views/theater/theaterDetail.jsp";
		return view;
	}
	
	// 영화관 선택 시 해당 영화관 상세정보 출력
	public String selectTheaterDetail(HttpServletRequest request, HttpServletResponse response) {
		int theaterNo = Integer.parseInt(request.getParameter("theaterNo"));
		
		Theater theater = new TheaterService().selectTheaterDetail(theaterNo);
		
//		테스트중
		ArrayList<Movie> movies = new TheaterService().getMoviesByTheater(theaterNo);
//		theater.setMovies(movies);
		
		request.setAttribute("movie", movies);
		request.setAttribute("theater", theater);
		
		String view = "views/theater/theaterDetail.jsp";
		
		return view;
	}


	// 영화 정보 보내기 테스트
//	public String selectMovieList(HttpServletRequest request) {
//		
//		ArrayList<Movie> movieList = new MovieService().selectMovieList();
//		request.setAttribute("movieList", movieList);
//		
//		String view = "views/theater/theaterDetail.jsp";
//		
//		return view;
//	}
}
