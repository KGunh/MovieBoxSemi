package com.kh.goods.model.vo;

import java.util.List;

public class Order {
	private int orderNo;
	private int memberNo;
	private String status;
	private String orderDate;
	
	private List<Goods> goodsList;

	public Order() {
		super();
	}

	public Order(int orderNo, int memberNo, String status, String orderDate, List<Goods> goodsList) {
		super();
		this.orderNo = orderNo;
		this.memberNo = memberNo;
		this.status = status;
		this.orderDate = orderDate;
		this.goodsList = goodsList;
	}

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public List<Goods> getGoodsList() {
		return goodsList;
	}

	public void setGoodsList(List<Goods> goodsList) {
		this.goodsList = goodsList;
	}

	@Override
	public String toString() {
		return "Order [orderNo=" + orderNo + ", memberNo=" + memberNo + ", status=" + status + ", orderDate="
				+ orderDate + ", goodsList=" + goodsList + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((goodsList == null) ? 0 : goodsList.hashCode());
		result = prime * result + memberNo;
		result = prime * result + ((orderDate == null) ? 0 : orderDate.hashCode());
		result = prime * result + orderNo;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		Order other = (Order) obj;
		if (goodsList == null) {
			if (other.goodsList != null)
				return false;
		} else if (!goodsList.equals(other.goodsList))
			return false;
		if (memberNo != other.memberNo)
			return false;
		if (orderDate == null) {
			if (other.orderDate != null)
				return false;
		} else if (!orderDate.equals(other.orderDate))
			return false;
		if (orderNo != other.orderNo)
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

	
	
	
	
}
