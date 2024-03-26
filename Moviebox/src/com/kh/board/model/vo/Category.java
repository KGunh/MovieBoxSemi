package com.kh.board.model.vo;

public class Category {

	private int categoryNo;
	private String categoryName;
	
	
	public Category() {
		super();
	}


	public Category(int categoryNo, String categoryName) {
		super();
		this.categoryNo = categoryNo;
		this.categoryName = categoryName;
	}

	
	
	public int getCategoryNo() {
		return categoryNo;
	}


	public void setCategoryNo(int categoryNo) {
		this.categoryNo = categoryNo;
	}


	public String getCategoryName() {
		return categoryName;
	}


	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}


	@Override
	public String toString() {
		return "Category [categoryNo=" + categoryNo + ", categoryName=" + categoryName + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categoryName == null) ? 0 : categoryName.hashCode());
		result = prime * result + categoryNo;
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
		Category other = (Category) obj;
		if (categoryName == null) {
			if (other.categoryName != null)
				return false;
		} else if (!categoryName.equals(other.categoryName))
			return false;
		if (categoryNo != other.categoryNo)
			return false;
		return true;
	}
	
	
	
}
