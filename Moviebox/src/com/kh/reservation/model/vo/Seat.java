package com.kh.reservation.model.vo;

public class Seat {
	private String seatNo;
	private int screenNo;
	private int ticketNo;
	public Seat() {
		super();
	}
	public Seat(String seatNo, int screenNo, int ticketNo) {
		super();
		this.seatNo = seatNo;
		this.screenNo = screenNo;
		this.ticketNo = ticketNo;
	}
	public String getSeatNo() {
		return seatNo;
	}
	public void setSeatNo(String seatNo) {
		this.seatNo = seatNo;
	}
	public int getScreenNo() {
		return screenNo;
	}
	public void setScreenNo(int screenNo) {
		this.screenNo = screenNo;
	}
	public int getTicketNo() {
		return ticketNo;
	}
	public void setTicketNo(int ticketNo) {
		this.ticketNo = ticketNo;
	}
	@Override
	public String toString() {
		return "Seat [seatNo=" + seatNo + ", screenNo=" + screenNo + ", ticketNo=" + ticketNo + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + screenNo;
		result = prime * result + ((seatNo == null) ? 0 : seatNo.hashCode());
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
		Seat other = (Seat) obj;
		if (screenNo != other.screenNo)
			return false;
		if (seatNo == null) {
			if (other.seatNo != null)
				return false;
		} else if (!seatNo.equals(other.seatNo))
			return false;
		if (ticketNo != other.ticketNo)
			return false;
		return true;
	}
	
	
}
