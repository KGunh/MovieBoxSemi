package com.kh.common.model.vo;

public class Genre {
	private String genreCode;
	private String genreName;
	
	public Genre() {
		super();
	}
	public Genre(String genreCode, String genreName) {
		super();
		this.genreCode = genreCode;
		this.genreName = genreName;
	}
	public String getGenreCode() {
		return genreCode;
	}
	public void setGenreCode(String genreCode) {
		this.genreCode = genreCode;
	}
	public String getGenreName() {
		return genreName;
	}
	public void setGenreName(String genreName) {
		this.genreName = genreName;
	}
	@Override
	public String toString() {
		return "Genre [genreCode=" + genreCode + ", genreName=" + genreName + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((genreCode == null) ? 0 : genreCode.hashCode());
		result = prime * result + ((genreName == null) ? 0 : genreName.hashCode());
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
		Genre other = (Genre) obj;
		if (genreCode == null) {
			if (other.genreCode != null)
				return false;
		} else if (!genreCode.equals(other.genreCode))
			return false;
		if (genreName == null) {
			if (other.genreName != null)
				return false;
		} else if (!genreName.equals(other.genreName))
			return false;
		return true;
	}
	
	
	
	
	
}
