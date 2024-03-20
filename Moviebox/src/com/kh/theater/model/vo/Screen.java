package com.kh.theater.model.vo;

import java.util.Date;

public class Screen {
	private int screenNo;
	private int theaterNo;
	private int movieNo;
	private Date watchDate;
	
	public Screen() {
		super();
	}
	public Screen(int screenNo, int theaterNo, int movieNo, Date watchDate) {
		super();
		this.screenNo = screenNo;
		this.theaterNo = theaterNo;
		this.movieNo = movieNo;
		this.watchDate = watchDate;
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
	public Date getWatchDate() {
		return watchDate;
	}
	public void setWatchDate(Date watchDate) {
		this.watchDate = watchDate;
	}
	@Override
	public String toString() {
		return "Screen [screenNo=" + screenNo + ", theaterNo=" + theaterNo + ", movieNo=" + movieNo + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + movieNo;
		result = prime * result + screenNo;
		result = prime * result + theaterNo;
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
		if (screenNo != other.screenNo)
			return false;
		if (theaterNo != other.theaterNo)
			return false;
		return true;
	}
	
	
}
