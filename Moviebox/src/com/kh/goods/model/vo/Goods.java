package com.kh.goods.model.vo;

public class Goods {
	private int goodsNo;
	private String goodsName;
	private int goodsPrice;
	private int qty;
	public Goods() {
		super();
	}
	public Goods(int goodsNo, String goodsName, int goodsPrice, int qty) {
		super();
		this.goodsNo = goodsNo;
		this.goodsName = goodsName;
		this.goodsPrice = goodsPrice;
		this.qty = qty;
	}
	public int getGoodsNo() {
		return goodsNo;
	}
	public void setGoodsNo(int goodsNo) {
		this.goodsNo = goodsNo;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public int getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(int goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	@Override
	public String toString() {
		return "Goods [goodsNo=" + goodsNo + ", goodsName=" + goodsName + ", goodsPrice=" + goodsPrice + ", qty=" + qty
				+ "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((goodsName == null) ? 0 : goodsName.hashCode());
		result = prime * result + goodsNo;
		result = prime * result + goodsPrice;
		result = prime * result + qty;
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
		Goods other = (Goods) obj;
		if (goodsName == null) {
			if (other.goodsName != null)
				return false;
		} else if (!goodsName.equals(other.goodsName))
			return false;
		if (goodsNo != other.goodsNo)
			return false;
		if (goodsPrice != other.goodsPrice)
			return false;
		if (qty != other.qty)
			return false;
		return true;
	}
	
	
	
	
	
}
