package com.kh.notice.model.vo;


public class Notice {
	
	private int noticeNo;
	private String noticeTitle;
	private String noticeWriter;
	private String noticeContent;
	private String createDate;
	private int count;
	private String status;
	
	private String noticeCategory;
	private int userNo;
	
	
	public Notice() {
		super();
	}


	public Notice(int noticeNo, String noticeTitle, String noticeWriter, String noticeContent, String createDate,
			int count, String status, String noticeCategory, int userNo) {
		super();
		this.noticeNo = noticeNo;
		this.noticeTitle = noticeTitle;
		this.noticeWriter = noticeWriter;
		this.noticeContent = noticeContent;
		this.createDate = createDate;
		this.count = count;
		this.status = status;
		this.noticeCategory = noticeCategory;
		this.userNo = userNo;
	}


	public int getNoticeNo() {
		return noticeNo;
	}


	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}


	public String getNoticeTitle() {
		return noticeTitle;
	}


	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}


	public String getNoticeWriter() {
		return noticeWriter;
	}


	public void setNoticeWriter(String noticeWriter) {
		this.noticeWriter = noticeWriter;
	}


	public String getNoticeContent() {
		return noticeContent;
	}


	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}


	public String getCreateDate() {
		return createDate;
	}


	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}


	public int getCount() {
		return count;
	}


	public void setCount(int count) {
		this.count = count;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getNoticeCategory() {
		return noticeCategory;
	}


	public void setNoticeCategory(String noticeCategory) {
		this.noticeCategory = noticeCategory;
	}


	public int getUserNo() {
		return userNo;
	}


	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}


	@Override
	public String toString() {
		return "Notice [noticeNo=" + noticeNo + ", noticeTitle=" + noticeTitle + ", noticeWriter=" + noticeWriter
				+ ", noticeContent=" + noticeContent + ", createDate=" + createDate + ", count=" + count + ", status="
				+ status + ", noticeCategory=" + noticeCategory + ", userNo=" + userNo + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + count;
		result = prime * result + ((createDate == null) ? 0 : createDate.hashCode());
		result = prime * result + ((noticeCategory == null) ? 0 : noticeCategory.hashCode());
		result = prime * result + ((noticeContent == null) ? 0 : noticeContent.hashCode());
		result = prime * result + noticeNo;
		result = prime * result + ((noticeTitle == null) ? 0 : noticeTitle.hashCode());
		result = prime * result + ((noticeWriter == null) ? 0 : noticeWriter.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + userNo;
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
		Notice other = (Notice) obj;
		if (count != other.count)
			return false;
		if (createDate == null) {
			if (other.createDate != null)
				return false;
		} else if (!createDate.equals(other.createDate))
			return false;
		if (noticeCategory == null) {
			if (other.noticeCategory != null)
				return false;
		} else if (!noticeCategory.equals(other.noticeCategory))
			return false;
		if (noticeContent == null) {
			if (other.noticeContent != null)
				return false;
		} else if (!noticeContent.equals(other.noticeContent))
			return false;
		if (noticeNo != other.noticeNo)
			return false;
		if (noticeTitle == null) {
			if (other.noticeTitle != null)
				return false;
		} else if (!noticeTitle.equals(other.noticeTitle))
			return false;
		if (noticeWriter == null) {
			if (other.noticeWriter != null)
				return false;
		} else if (!noticeWriter.equals(other.noticeWriter))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (userNo != other.userNo)
			return false;
		return true;
	}

	


}
