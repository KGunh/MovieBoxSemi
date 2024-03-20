package com.kh.movie.model.vo;

import java.sql.Date;

public class Movie {

	private int movieNo;
	private String movieTitle;
	private String moviePoster;
	private String runningTime;
	private String director;
	private String movieActor; 
	private String movieRated;
	private Date movieRelease;
	private String movieStory;
	private String movieStill;
	private String status;
	private String genreNo;
	public Movie() {
		super();
	}
	public Movie(int movieNo, String movieTitle, String moviePoster, String runningTime, String director,
			String movieActor, String movieRated, Date movieRelease, String movieStory, String movieStill,
			String status, String genreNo) {
		super();
		this.movieNo = movieNo;
		this.movieTitle = movieTitle;
		this.moviePoster = moviePoster;
		this.runningTime = runningTime;
		this.director = director;
		this.movieActor = movieActor;
		this.movieRated = movieRated;
		this.movieRelease = movieRelease;
		this.movieStory = movieStory;
		this.movieStill = movieStill;
		this.status = status;
		this.genreNo = genreNo;
	}
	public int getMovieNo() {
		return movieNo;
	}
	public String getMovieTitle() {
		return movieTitle;
	}
	public String getMoviePoster() {
		return moviePoster;
	}
	public String getRunningTime() {
		return runningTime;
	}
	public String getDirector() {
		return director;
	}
	public String getMovieActor() {
		return movieActor;
	}
	public String getMovieRated() {
		return movieRated;
	}
	public Date getMovieRelease() {
		return movieRelease;
	}
	public String getMovieStory() {
		return movieStory;
	}
	public String getMovieStill() {
		return movieStill;
	}
	public String getStatus() {
		return status;
	}
	public String getGenreNo() {
		return genreNo;
	}
	@Override
	public String toString() {
		return "Movie [movieNo=" + movieNo + ", movieTitle=" + movieTitle + ", moviePoster=" + moviePoster
				+ ", runningTime=" + runningTime + ", director=" + director + ", movieActor=" + movieActor
				+ ", movieRated=" + movieRated + ", movieRelease=" + movieRelease + ", movieStory=" + movieStory
				+ ", movieStill=" + movieStill + ", status=" + status + ", genreNo=" + genreNo + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((director == null) ? 0 : director.hashCode());
		result = prime * result + ((genreNo == null) ? 0 : genreNo.hashCode());
		result = prime * result + ((movieActor == null) ? 0 : movieActor.hashCode());
		result = prime * result + movieNo;
		result = prime * result + ((moviePoster == null) ? 0 : moviePoster.hashCode());
		result = prime * result + ((movieRated == null) ? 0 : movieRated.hashCode());
		result = prime * result + ((movieRelease == null) ? 0 : movieRelease.hashCode());
		result = prime * result + ((movieStill == null) ? 0 : movieStill.hashCode());
		result = prime * result + ((movieStory == null) ? 0 : movieStory.hashCode());
		result = prime * result + ((movieTitle == null) ? 0 : movieTitle.hashCode());
		result = prime * result + ((runningTime == null) ? 0 : runningTime.hashCode());
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
		if (movieActor == null) {
			if (other.movieActor != null)
				return false;
		} else if (!movieActor.equals(other.movieActor))
			return false;
		if (movieNo != other.movieNo)
			return false;
		if (moviePoster == null) {
			if (other.moviePoster != null)
				return false;
		} else if (!moviePoster.equals(other.moviePoster))
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
		if (movieStill == null) {
			if (other.movieStill != null)
				return false;
		} else if (!movieStill.equals(other.movieStill))
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
		if (runningTime == null) {
			if (other.runningTime != null)
				return false;
		} else if (!runningTime.equals(other.runningTime))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}
	
	
	
	
}
