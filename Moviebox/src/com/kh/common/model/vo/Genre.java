package com.kh.common.model.vo;

public class Genre {
	private String genreCoade;
	private String genreName;
	
	public Genre() {
		super();
	}
	public Genre(String genreCoade, String genreName) {
		super();
		this.genreCoade = genreCoade;
		this.genreName = genreName;
	}
	public String getGenreCoade() {
		return genreCoade;
	}
	public void setGenreCoade(String genreCoade) {
		this.genreCoade = genreCoade;
	}
	public String getGenreName() {
		return genreName;
	}
	public void setGenreName(String genreName) {
		this.genreName = genreName;
	}
	@Override
	public String toString() {
		return "Genre [genreCoade=" + genreCoade + ", genreName=" + genreName + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((genreCoade == null) ? 0 : genreCoade.hashCode());
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
		if (genreCoade == null) {
			if (other.genreCoade != null)
				return false;
		} else if (!genreCoade.equals(other.genreCoade))
			return false;
		if (genreName == null) {
			if (other.genreName != null)
				return false;
		} else if (!genreName.equals(other.genreName))
			return false;
		return true;
	}
	
	
	
	
	
}
