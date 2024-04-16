package com.kh.theater.model.vo;

import java.util.ArrayList;
import java.util.List;

import com.kh.movie.model.vo.Movie;

public class Theater {
	private int theaterNo;
	private String theaterName;
	private String theaterAddr;
	private String mapLink;
	private String localCode;
	private String updateDate;
	private String locationName;
	
	private int screenNo;
	private int movieNo;
	private String movieTitle;
	private String movieRt;
	private String filePath;
	private String changeName;
	
	private List<Movie> movies;
	private List<Screen> screenList;
	
	
	public String getMovieRt() {
		return movieRt;
	}
	public void setMovieRt(String movieRt) {
		this.movieRt = movieRt;
	}
	public List<Screen> getScreenList() {
		return screenList;
	}
	public void setScreenList(List<Screen> screenList) {
		this.screenList = screenList;
	}
	public String getLocationName() {
		return locationName;
	}
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	public Theater() {
		super();
	}
	
	public Theater(int theaterNo, String theaterName, String theaterAddr, String mapLink, String locationName) {
		super();
		this.theaterNo = theaterNo;
		this.theaterName = theaterName;
		this.theaterAddr = theaterAddr;
		this.mapLink = mapLink;
		this.locationName = locationName;
	}
	public Theater(int theaterNo, String theaterName, String theaterAddr, String mapLink, String localCode,String updateDate) {
		super();
		this.theaterNo = theaterNo;
		this.theaterName = theaterName;
		this.theaterAddr = theaterAddr;
		this.mapLink = mapLink;
		this.localCode = localCode;
		this.updateDate= updateDate;
	}
	
	
	public Theater(int screenNo, int movieNo, String movieTitle) {
		super();
		this.screenNo = screenNo;
		this.movieNo = movieNo;
		this.movieTitle = movieTitle;
	}
	
	public int getScreenNo() {
		return screenNo;
	}
	public void setScreenNo(int screenNo) {
		this.screenNo = screenNo;
	}
	public int getMovieNo() {
		return movieNo;
	}
	public void setMovieNo(int movieNo) {
		this.movieNo = movieNo;
	}
	public String getMovieTitle() {
		return movieTitle;
	}
	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}
	public int getTheaterNo() {
		return theaterNo;
	}
	public String getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	public void setTheaterNo(int theaterNo) {
		this.theaterNo = theaterNo;
	}
	public String getTheaterName() {
		return theaterName;
	}
	public void setTheaterName(String theaterName) {
		this.theaterName = theaterName;
	}
	public String getTheaterAddr() {
		return theaterAddr;
	}
	public void setTheaterAddr(String theaterAddr) {
		this.theaterAddr = theaterAddr;
	}
	public String getMapLink() {
		return mapLink;
	}
	public void setMapLink(String mapLink) {
		this.mapLink = mapLink;
	}
	public String getLocalCode() {
		return localCode;
	}
	public void setLocalCode(String localCode) {
		this.localCode = localCode;
	}
	
	public List<Movie> getMovies() {
		return movies;
	}
	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}
	
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getChangeName() {
		return changeName;
	}
	public void setChangeName(String changeName) {
		this.changeName = changeName;
	}
	
	
	
	@Override
	public String toString() {
		return "Theater [theaterNo=" + theaterNo + ", theaterName=" + theaterName + ", theaterAddr=" + theaterAddr
				+ ", mapLink=" + mapLink + ", localCode=" + localCode + ", updateDate=" + updateDate + ", locationName="
				+ locationName + ", screenNo=" + screenNo + ", movieNo=" + movieNo + ", movieTitle=" + movieTitle
				+ ", filePath=" + filePath + ", changeName=" + changeName + ", movies=" + movies + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((localCode == null) ? 0 : localCode.hashCode());
		result = prime * result + ((mapLink == null) ? 0 : mapLink.hashCode());
		result = prime * result + ((theaterAddr == null) ? 0 : theaterAddr.hashCode());
		result = prime * result + ((theaterName == null) ? 0 : theaterName.hashCode());
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
		Theater other = (Theater) obj;
		if (localCode == null) {
			if (other.localCode != null)
				return false;
		} else if (!localCode.equals(other.localCode))
			return false;
		if (mapLink == null) {
			if (other.mapLink != null)
				return false;
		} else if (!mapLink.equals(other.mapLink))
			return false;
		if (theaterAddr == null) {
			if (other.theaterAddr != null)
				return false;
		} else if (!theaterAddr.equals(other.theaterAddr))
			return false;
		if (theaterName == null) {
			if (other.theaterName != null)
				return false;
		} else if (!theaterName.equals(other.theaterName))
			return false;
		if (theaterNo != other.theaterNo)
			return false;
		return true;
	}
	
	
	
	
	
}
