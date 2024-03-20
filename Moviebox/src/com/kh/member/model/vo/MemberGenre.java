package com.kh.member.model.vo;

public class MemberGenre {
	private String memNo;
	private int genreCode;
	public MemberGenre() {
		super();
	}
	public MemberGenre(String memNo, int genreCode) {
		super();
		this.memNo = memNo;
		this.genreCode = genreCode;
	}
	public String getMemNo() {
		return memNo;
	}
	public void setMemNo(String memNo) {
		this.memNo = memNo;
	}
	public int getGenreCode() {
		return genreCode;
	}
	public void setGenreCode(int genreCode) {
		this.genreCode = genreCode;
	}
	@Override
	public String toString() {
		return "MemberGenre [memNo=" + memNo + ", genreCode=" + genreCode + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + genreCode;
		result = prime * result + ((memNo == null) ? 0 : memNo.hashCode());
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
		MemberGenre other = (MemberGenre) obj;
		if (genreCode != other.genreCode)
			return false;
		if (memNo == null) {
			if (other.memNo != null)
				return false;
		} else if (!memNo.equals(other.memNo))
			return false;
		return true;
	}
	
	
	
}
