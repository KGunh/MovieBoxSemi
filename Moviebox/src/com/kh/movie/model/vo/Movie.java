package com.kh.movie.model.vo;

import java.sql.Date;

public class Movie {

	private int movieNo;
	private String movieTitle;
	private String director;
	private String movieRated;
	private Date movieRelease;
	private String movieStory;
	private String status;
	private String genreNo;
	private String filePath;
	private String fileName;
	
	
	public Movie() {
		super();
	}
	
	public Movie(int movieNo, String movieTitle, String director, String movieRated, Date movieRelease,
			String movieStory, String status, String genreNo, String filePath, String fileName) {
		super();
		this.movieNo = movieNo;
		this.movieTitle = movieTitle;
		this.director = director;
		this.movieRated = movieRated;
		this.movieRelease = movieRelease;
		this.movieStory = movieStory;
		this.status = status;
		this.genreNo = genreNo;
		this.filePath = filePath;
		this.fileName = fileName;
	}

	public int getMovieNo() {
		return movieNo;
	}
	public void setMovieNo(int movieNo) {
		this.movieNo = movieNo;
	}
	public String getMovieTitle() {
		return movieTitle;
	}
	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getMovieRated() {
		return movieRated;
	}
	public void setMovieRated(String movieRated) {
		this.movieRated = movieRated;
	}
	public Date getMovieRelease() {
		return movieRelease;
	}
	public void setMovieRelease(Date movieRelease) {
		this.movieRelease = movieRelease;
	}
	public String getMovieStory() {
		return movieStory;
	}
	public void setMovieStory(String movieStory) {
		this.movieStory = movieStory;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getGenreNo() {
		return genreNo;
	}
	public void setGenreNo(String genreNo) {
		this.genreNo = genreNo;
	}
	
	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public String toString() {
		return "Movie [movieNo=" + movieNo + ", movieTitle=" + movieTitle + ", director=" + director + ", movieRated="
				+ movieRated + ", movieRelease=" + movieRelease + ", movieStory=" + movieStory + ", status=" + status
				+ ", genreNo=" + genreNo + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((director == null) ? 0 : director.hashCode());
		result = prime * result + ((genreNo == null) ? 0 : genreNo.hashCode());
		result = prime * result + movieNo;
		result = prime * result + ((movieRated == null) ? 0 : movieRated.hashCode());
		result = prime * result + ((movieRelease == null) ? 0 : movieRelease.hashCode());
		result = prime * result + ((movieStory == null) ? 0 : movieStory.hashCode());
		result = prime * result + ((movieTitle == null) ? 0 : movieTitle.hashCode());
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
		Movie other = (Movie) obj;
		if (director == null) {
			if (other.director != null)
				return false;
		} else if (!director.equals(other.director))
			return false;
		if (genreNo == null) {
			if (other.genreNo != null)
				return false;
		} else if (!genreNo.equals(other.genreNo))
			return false;
		if (movieNo != other.movieNo)
			return false;
		if (movieRated == null) {
			if (other.movieRated != null)
				return false;
		} else if (!movieRated.equals(other.movieRated))
			return false;
		if (movieRelease == null) {
			if (other.movieRelease != null)
				return false;
		} else if (!movieRelease.equals(other.movieRelease))
			return false;
		if (movieStory == null) {
			if (other.movieStory != null)
				return false;
		} else if (!movieStory.equals(other.movieStory))
			return false;
		if (movieTitle == null) {
			if (other.movieTitle != null)
				return false;
		} else if (!movieTitle.equals(other.movieTitle))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}
	
	
	
	
}
