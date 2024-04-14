package com.kh.theater.model.vo;

import java.util.List;

import com.kh.movie.model.vo.Movie;

public class Screen {
	private int screenNo;
	private int theaterNo;
	private int movieNo;
	private String watchDate;
	private String screenName;
	private String theaterName;
	private String movieTitle;
	private int movieRt;
	
	
	private List<Integer> screenNoList;
	private List<String> screenNameList;
	
	private List<String> watchDateList;
	private List<Movie> movieList;
	private List<Movie> movieNameList;
	
	
	public Screen() {
		super();
	}
	public Screen(int screenNo, int theaterNo, int movieNo, String watchDate, String screenName) {
		super();
		this.screenNo = screenNo;
		this.theaterNo = theaterNo;
		this.movieNo = movieNo;
		this.watchDate = watchDate;
		this.screenName = screenName;
	}
	public List<Movie> getMovieNameList() {
		return movieNameList;
	}
	public void setMovieNameList(List<Movie> movieNameList) {
		this.movieNameList = movieNameList;
	}
	public List<Movie> getMovieList() {
		return movieList;
	}
	public void setMovieList(List<Movie> movieList) {
		this.movieList = movieList;
	}
	public String getMovieTitle() {
		return movieTitle;
	}
	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}
	public int getScreenNo() {
		return screenNo;
	}
	public void setScreenNo(int screenNo) {
		this.screenNo = screenNo;
	}
	public int getTheaterNo() {
		return theaterNo;
	}
	public void setTheaterNo(int theaterNo) {
		this.theaterNo = theaterNo;
	}
	public int getMovieNo() {
		return movieNo;
	}
	public void setMovieNo(int movieNo) {
		this.movieNo = movieNo;
	}
	public String getWatchDate() {
		return watchDate;
	}
	public void setWatchDate(String watchDate) {
		this.watchDate = watchDate;
	}
	public String getScreenName() {
		return screenName;
	}
	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}
	public String getTheaterName() {
		return theaterName;
	}
	public void setTheaterName(String theaterName) {
		this.theaterName = theaterName;
	}
	public int getMovieRt() {
		return movieRt;
	}
	public void setMovieRt(int movieRt) {
		this.movieRt = movieRt;
	}
	public List<String> getWatchDateList() {
		return watchDateList;
	}
	public void setWatchDateList(List<String> watchDateList) {
		this.watchDateList = watchDateList;
	}
	public List<Integer> getScreenNoList() {
		return screenNoList;
	}
	public void setScreenNoList(List<Integer> screenNoList) {
		this.screenNoList = screenNoList;
	}
	public List<String> getScreenNameList() {
		return screenNameList;
	}
	public void setScreenNameList(List<String> screenNameList) {
		this.screenNameList = screenNameList;
	}
	@Override
	public String toString() {
		return "Screen [screenNo=" + screenNo + ", theaterNo=" + theaterNo + ", movieNo=" + movieNo + ", watchDate="
				+ watchDate + ", screenName=" + screenName + ", theaterName=" + theaterName + ", movieRt=" + movieRt
				+ "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + movieNo;
		result = prime * result + ((screenName == null) ? 0 : screenName.hashCode());
		result = prime * result + screenNo;
		result = prime * result + theaterNo;
		result = prime * result + ((watchDate == null) ? 0 : watchDate.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Screen other = (Screen) obj;
		if (movieNo != other.movieNo)
			return false;
		if (screenName == null) {
			if (other.screenName != null)
				return false;
		} else if (!screenName.equals(other.screenName))
			return false;
		if (screenNo != other.screenNo)
			return false;
		if (theaterNo != other.theaterNo)
			return false;
		if (watchDate == null) {
			if (other.watchDate != null)
				return false;
		} else if (!watchDate.equals(other.watchDate))
			return false;
		return true;
	}
	
	
	
}
