package com.kh.common.model.vo;

public class Attachment {
	
	private int fileNo;
	private int movieNo;
	private String orginName;
	private String changeName;
	private String filePath;
	private int fileLevel;
	private String uploadDate;
	
	public Attachment() {
		super();
	}
	

	public Attachment(int fileNo, int movieNo, String orginName, String changeName, String filePath, int fileLevel,
			String uploadDate) {
		super();
		this.fileNo = fileNo;
		this.movieNo = movieNo;
		this.orginName = orginName;
		this.changeName = changeName;
		this.filePath = filePath;
		this.fileLevel = fileLevel;
		this.uploadDate = uploadDate;
	}
	public int getFileNo() {
		return fileNo;
	}
	public void setFileNo(int fileNo) {
		this.fileNo = fileNo;
	}
	public int getMovieNo() {
		return movieNo;
	}
	public void setMovieNo(int movieNo) {
		this.movieNo = movieNo;
	}
	public String getOrginName() {
		return orginName;
	}
	public void setOrginName(String orginName) {
		this.orginName = orginName;
	}
	public String getChangeName() {
		return changeName;
	}
	public void setChangeName(String changeName) {
		this.changeName = changeName;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public int getFileLevel() {
		return fileLevel;
	}
	public void setFileLevel(int fileLevel) {
		this.fileLevel = fileLevel;
	}
	public String getUploadDate() {
		return uploadDate;
	}
	public void setUploadDate(String uploadDate) {
		this.uploadDate = uploadDate;
	}
	@Override
	public String toString() {
		return "Attachment [fileNo=" + fileNo + ", movieNo=" + movieNo + ", orginName=" + orginName + ", changeName="
				+ changeName + ", filePath=" + filePath + ", fileLevel=" + fileLevel + ", uploadDate=" + uploadDate
				+ "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((changeName == null) ? 0 : changeName.hashCode());
		result = prime * result + fileLevel;
		result = prime * result + fileNo;
		result = prime * result + ((filePath == null) ? 0 : filePath.hashCode());
		result = prime * result + movieNo;
		result = prime * result + ((orginName == null) ? 0 : orginName.hashCode());
		result = prime * result + ((uploadDate == null) ? 0 : uploadDate.hashCode());
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
		Attachment other = (Attachment) obj;
		if (changeName == null) {
			if (other.changeName != null)
				return false;
		} else if (!changeName.equals(other.changeName))
			return false;
		if (fileLevel != other.fileLevel)
			return false;
		if (fileNo != other.fileNo)
			return false;
		if (filePath == null) {
			if (other.filePath != null)
				return false;
		} else if (!filePath.equals(other.filePath))
			return false;
		if (movieNo != other.movieNo)
			return false;
		if (orginName == null) {
			if (other.orginName != null)
				return false;
		} else if (!orginName.equals(other.orginName))
			return false;
		if (uploadDate == null) {
			if (other.uploadDate != null)
				return false;
		} else if (!uploadDate.equals(other.uploadDate))
			return false;
		return true;
	}
	
	
	
}
