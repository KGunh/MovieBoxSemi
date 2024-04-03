package com.kh.goods.model.vo;

public class Goods {
	private int goodsNo;
	private String typeName;
	private String goodsName;
	private int goodsPrice;
	private int qty;
	private String status;
	private int fileNo;
    private String filePath;
    private String changeName;
	
	public Goods() {
		super();
	}
	public Goods(int goodsNo, String typeName, String goodsName, int goodsPrice, int qty, String status) {
		super();
		this.goodsNo = goodsNo;
		this.typeName = typeName;
		this.goodsName = goodsName;
		this.goodsPrice = goodsPrice;
		this.qty = qty;
		this.status = status;
	}
	public int getGoodsNo() {
		return goodsNo;
	}
	public void setGoodsNo(int goodsNo) {
		this.goodsNo = goodsNo;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public int getFileNo() {
		return fileNo;
	}
	public void setFileNo(int fileNo) {
		this.fileNo = fileNo;
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
		return "Goods [goodsNo=" + goodsNo + ", typeName=" + typeName + ", goodsName=" + goodsName + ", goodsPrice="
				+ goodsPrice + ", qty=" + qty + ", status=" + status + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((goodsName == null) ? 0 : goodsName.hashCode());
		result = prime * result + goodsNo;
		result = prime * result + goodsPrice;
		result = prime * result + qty;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((typeName == null) ? 0 : typeName.hashCode());
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
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (typeName == null) {
			if (other.typeName != null)
				return false;
		} else if (!typeName.equals(other.typeName))
			return false;
		return true;
	}
	
	
	
	
	
	
}
