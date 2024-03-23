package com.kh.common.model.vo;

public class Reservation {
	private int ticketNo;
	private int personNum;
	private int memberNo;
	private int screenNo;
	private String status;
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
