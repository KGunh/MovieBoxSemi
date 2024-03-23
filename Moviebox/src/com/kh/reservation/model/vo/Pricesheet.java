package com.kh.reservation.model.vo;

public class Pricesheet {
	private int grade;
	private int ticketNo;	
	
	public Pricesheet() {
		super();
	}
	public Pricesheet(int grade, int ticketNo) {
		super();
		this.grade = grade;
		this.ticketNo = ticketNo;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public int getTicketNo() {
		return ticketNo;
	}
	public void setTicketNo(int ticketNo) {
		this.ticketNo = ticketNo;
	}
	@Override
	public String toString() {
		return "Pricesheet [grade=" + grade + ", ticketNo=" + ticketNo + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + grade;
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
		Pricesheet other = (Pricesheet) obj;
		if (grade != other.grade)
			return false;
		if (ticketNo != other.ticketNo)
			return false;
		return true;
	}
	
	
}
