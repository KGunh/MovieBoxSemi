package com.kh.movie.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.common.model.vo.Genre;
import com.kh.movie.model.service.MovieService;
import com.kh.movie.model.vo.Movie;

public class MovieController {
	
	// 전체 목록 출력
	public String selectMovieList(HttpServletRequest request) {
		
		ArrayList<Movie> movieList = new MovieService().selectMovieList();
		request.setAttribute("movieList", movieList);
		
		String view = "views/movie/movieList.jsp";
		
		return view;
	}

	
	// 영화 카테고리
	public String movieCategory(HttpServletRequest request, HttpServletResponse response) {
		
		ArrayList<Movie> list = new MovieService().selectMovieList();
		String genre = request.getParameter("genre");
		String type = request.getParameter("type");
		
		if(genre != null) {
			if(!genre.equals("전체")) {
				list = new MovieService().movieCategory(genre);
			}
		}
		
		request.setAttribute("genre", genre);
		request.setAttribute("type", type);
		request.setAttribute("list", list);
		
		String view = "views/movie/movieList.jsp";
		
		return view;
	}
}
