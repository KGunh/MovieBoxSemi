package com.kh.movie.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.common.model.vo.Attachment;
import com.kh.movie.model.service.MovieService;
import com.kh.movie.model.vo.Movie;

public class MovieController {
	
	// 전체 목록 출력
	public String selectMovieList(HttpServletRequest request) {
		
		List<Movie> movieList = new MovieService().selectMovieList();
		request.setAttribute("movieList", movieList);
		
		String view = "views/movie/movieList.jsp";
		
		return view;
	}

	
	// 영화 카테고리 네비바
	public String movieCategory(HttpServletRequest request, HttpServletResponse response) {
		
		List<Movie> list = new MovieService().selectMovieList();
		
		String genre = request.getParameter("genre");
		String type = request.getParameter("type");
		
		if(genre != null) {
			if(!genre.equals("전체")) {
				list = new MovieService().movieCategory(genre);
			}
		}
		request.setAttribute("genre", genre);
		request.setAttribute("type", type);
		request.setAttribute("movieList", list);
		
		String view = "views/movie/movieList.jsp";
		
		return view;
	}
	
	
	
	// 영화 상세정보
	public String detailMovie(HttpServletRequest request, HttpServletResponse response) {

		int movieNo = Integer.parseInt(request.getParameter("movieNo"));
		String view ="";
		
		Movie movie = new MovieService().detailMovie(movieNo);
		String cast = new MovieService().detailMovieCast(movieNo);
		
		if(movie != null) {
			request.setAttribute("movie", movie);
			request.setAttribute("cast", cast);

			view = "views/movie/movieDetail.jsp";
		} else {
			view = "index.jsp";
		
		}
		
		return view;
	}
	
	public String detailMovieList(HttpServletRequest request, HttpServletResponse response) {
		
		List<Movie> movieList = new MovieService().selectMovieList();
		request.setAttribute("movieList", movieList);
		
		String view = "views/movie/movieDetail.jsp";
		
		return view;
	}
	
	
	// 스틸컷
	public String stilCut(HttpServletRequest request, HttpServletResponse response) {
		
		int movieNo = Integer.parseInt(request.getParameter("movieNo"));

		List<Attachment> stilCutList = new MovieService().stilCut(movieNo);
		System.out.println(stilCutList);
		request.setAttribute("stilCutList", stilCutList);
		
		
		String view = "views/movie/movieDetail.jsp";
		
		return view;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
