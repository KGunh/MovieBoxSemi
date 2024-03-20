package com.kh.goods.model.vo;

public class Goods {
	private int goodsNo;
	private int goodsName;
	public Goods() {
		super();
	}
	public Goods(int goodsNo, int goodsName) {
		super();
		this.goodsNo = goodsNo;
		this.goodsName = goodsName;
	}
	public int getGoodsNo() {
		return goodsNo;
	}
	public void setGoodsNo(int goodsNo) {
		this.goodsNo = goodsNo;
	}
	public int getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(int goodsName) {
		this.goodsName = goodsName;
	}
	@Override
	public String toString() {
		return "Goods [goodsNo=" + goodsNo + ", goodsName=" + goodsName + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + goodsName;
		result = prime * result + goodsNo;
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
		if (goodsName != other.goodsName)
			return false;
		if (goodsNo != other.goodsNo)
			return false;
		return true;
	}
	
	
}
