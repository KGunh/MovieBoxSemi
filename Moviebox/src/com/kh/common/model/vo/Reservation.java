package com.kh.common.model.vo;

import java.util.List;

import com.kh.movie.model.vo.Movie;
import com.kh.reservation.model.vo.Seat;

public class Reservation {
	private int ticketNo;
	private int personNum;
	private int memberNo;
	private int screenNo;
	private int movieNo;
	private String runningTime;
	private String status;
	private String movieTitle;
	private String theaterName;
	private String watchDate;
	private String reservationDate;
	private Price price;
	private List<Seat> seatList;
	private Movie movie;
	private String screenName;
	private boolean beforeCurrent;
	private int teenPersonNo;
	private int adultPersonNo;
	
	public Reservation() {
		super();
	}
	public Reservation(int ticketNo, int personNum, int memberNo, int screenNo, String status) {
		super();
		this.ticketNo = ticketNo;
		this.personNum = personNum;
		this.memberNo = memberNo;
		this.screenNo = screenNo;
		this.status = status;
	}
	
	public int getTeenPersonNo() {
		return teenPersonNo;
	}
	public void setTeenPersonNo(int teenPersonNo) {
		this.teenPersonNo = teenPersonNo;
	}
	public int getAdultPersonNo() {
		return adultPersonNo;
	}
	public void setAdultPersonNo(int adultPersonNo) {
		this.adultPersonNo = adultPersonNo;
	}
	public boolean isBeforeCurrent() {
		return beforeCurrent;
	}
	public void setBeforeCurrent(boolean beforeCurrent) {
		this.beforeCurrent = beforeCurrent;
	}
	public String getReservationDate() {
		return reservationDate;
	}
	public void setReservationDate(String reservationDate) {
		this.reservationDate = reservationDate;
	}
	public List<Seat> getSeatList() {
		return seatList;
	}
	public void setSeatList(List<Seat> seatList) {
		this.seatList = seatList;
	}
	public String getRunningTime() {
		return runningTime;
	}
	public void setRunningTime(String runningTime) {
		this.runningTime = runningTime;
	}
	public Price getPrice() {
		return price;
	}
	public void setPrice(Price price) {
		this.price = price;
	}
	public String getWatchDate() {
		return watchDate;
	}
	public void setWatchDate(String whtchDate) {
		this.watchDate = whtchDate;
	}
	public String getMovieTitle() {
		return movieTitle;
	}
	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}
	public String getTheaterName() {
		return theaterName;
	}
	public void setTheaterName(String theaterName) {
		this.theaterName = theaterName;
	}
	public int getTicketNo() {
		return ticketNo;
	}
	public void setTicketNo(int ticketNo) {
		this.ticketNo = ticketNo;
	}
	public int getPersonNum() {
		return personNum;
	}
	public void setPersonNum(int personNum) {
		this.personNum = personNum;
	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public int getScreenNo() {
		return screenNo;
	}
	public void setScreenNo(int screenNo) {
		this.screenNo = screenNo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	
	
	
	public int getMovieNo() {
		return movieNo;
	}
	public void setMovieNo(int movieNo) {
		this.movieNo = movieNo;
	}
	public String getScreenName() {
		return screenName;
	}
	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}
	@Override
	public String toString() {
		return "Reservation [ticketNo=" + ticketNo + ", personNum=" + personNum + ", memberNo=" + memberNo
				+ ", screenNo=" + screenNo + ", status=" + status + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + memberNo;
		result = prime * result + personNum;
		result = prime * result + screenNo;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ticketNo;
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
		Reservation other = (Reservation) obj;
		if (memberNo != other.memberNo)
			return false;
		if (personNum != other.personNum)
			return false;
		if (screenNo != other.screenNo)
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (ticketNo != other.ticketNo)
			return false;
		return true;
	}

	
	
}
