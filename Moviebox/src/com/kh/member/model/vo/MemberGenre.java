package com.kh.member.model.vo;

public class MemberGenre {
	private int memNo;
	private String genreCode;
	
	public MemberGenre() {
		super();
	}

	public MemberGenre(int memNo, String genreCode) {
		super();
		this.memNo = memNo;
		this.genreCode = genreCode;
	}

	public int getMemNo() {
		return memNo;
	}

	public void setMemNo(int memNo) {
		this.memNo = memNo;
	}

	public String getGenreCode() {
		return genreCode;
	}

	public void setGenreCode(String genreCode) {
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
		result = prime * result + ((genreCode == null) ? 0 : genreCode.hashCode());
		result = prime * result + memNo;
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
		if (genreCode == null) {
			if (other.genreCode != null)
				return false;
		} else if (!genreCode.equals(other.genreCode))
			return false;
		if (memNo != other.memNo)
			return false;
		return true;
	}
	
	
	
	
}
