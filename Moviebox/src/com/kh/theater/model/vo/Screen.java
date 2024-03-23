package com.kh.theater.model.vo;

import java.util.Date;

public class Screen {
	private int screenNo;
	private int theaterNo;
	private int movieNo;
	private String watchDate;
	private String screenName;
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
	@Override
	public String toString() {
		return "Screen [screenNo=" + screenNo + ", theaterNo=" + theaterNo + ", movieNo=" + movieNo + ", watchDate="
				+ watchDate + ", screenName=" + screenName + "]";
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
