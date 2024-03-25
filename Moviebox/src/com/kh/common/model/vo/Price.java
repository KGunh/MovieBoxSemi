package com.kh.common.model.vo;

public class Price {
	private int studentCount;
	private int commonCount;
	private int studentPrice;
	private int commonPrice;
	private int totalPrice;
	public Price() {
		super();
	}
	public Price(int studentCount, int commonCount, int studentPrice, int commonPrice, int totalPrice) {
		super();
		this.studentCount = studentCount;
		this.commonCount = commonCount;
		this.studentPrice = studentPrice;
		this.commonPrice = commonPrice;
		this.totalPrice = totalPrice;
	}
	public int getStudentCount() {
		return studentCount;
	}
	public void setStudentCount(int studentCount) {
		this.studentCount = studentCount;
	}
	public int getCommonCount() {
		return commonCount;
	}
	public void setCommonCount(int commonCount) {
		this.commonCount = commonCount;
	}
	public int getStudentPrice() {
		return studentPrice;
	}
	public void setStudentPrice(int studentPrice) {
		this.studentPrice = studentPrice;
	}
	public int getCommonPrice() {
		return commonPrice;
	}
	public void setCommonPrice(int commonPrice) {
		this.commonPrice = commonPrice;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	@Override
	public String toString() {
		return "Price [studentCount=" + studentCount + ", commonCount=" + commonCount + ", studentPrice=" + studentPrice
				+ ", commonPrice=" + commonPrice + ", totalPrice=" + totalPrice + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + commonCount;
		result = prime * result + commonPrice;
		result = prime * result + studentCount;
		result = prime * result + studentPrice;
		result = prime * result + totalPrice;
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
		Price other = (Price) obj;
		if (commonCount != other.commonCount)
			return false;
		if (commonPrice != other.commonPrice)
			return false;
		if (studentCount != other.studentCount)
			return false;
		if (studentPrice != other.studentPrice)
			return false;
		if (totalPrice != other.totalPrice)
			return false;
		return true;
	}
	
	
}
