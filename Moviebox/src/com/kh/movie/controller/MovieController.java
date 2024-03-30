package com.kh.movie.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.kh.movie.model.service.MovieService;
import com.kh.movie.model.vo.Movie;

public class MovieController {
	
	public String selectMovieList(HttpServletRequest request) {
		
		ArrayList<Movie> movieList = new MovieService().selectMovieList();
		request.setAttribute("movieList", movieList);
		
		String view = "views/movie/movieList.jsp";
		
		return view;
	}

}
