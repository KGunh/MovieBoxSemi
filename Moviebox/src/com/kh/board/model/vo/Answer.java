package com.kh.board.model.vo;

public class Answer {
	private int answerNo;
	private String answerContent;
	private String createDate;
	private String status;
	private int boardNo;
	private String memberNo;
	
	
	public Answer() {
		super();
	}
	public Answer(int answerNo, String answerContent, String createDate, String status, int boardNo, String memberNo) {
		super();
		this.answerNo = answerNo;
		this.answerContent = answerContent;
		this.createDate = createDate;
		this.status = status;
		this.boardNo = boardNo;
		this.memberNo = memberNo;
	}
	
	
	
	public String getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}
	public int getAnswerNo() {
		return answerNo;
	}
	public void setAnswerNo(int answerNo) {
		this.answerNo = answerNo;
	}
	public String getAnswerContent() {
		return answerContent;
	}
	public void setAnswerContent(String answerContent) {
		this.answerContent = answerContent;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	@Override
	public String toString() {
		return "Answer [answerNo=" + answerNo + ", answerContent=" + answerContent + ", createDate=" + createDate
				+ ", status=" + status + ", boardNo=" + boardNo + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((answerContent == null) ? 0 : answerContent.hashCode());
		result = prime * result + answerNo;
		result = prime * result + boardNo;
		result = prime * result + ((createDate == null) ? 0 : createDate.hashCode());
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
		Answer other = (Answer) obj;
		if (answerContent == null) {
			if (other.answerContent != null)
				return false;
		} else if (!answerContent.equals(other.answerContent))
			return false;
		if (answerNo != other.answerNo)
			return false;
		if (boardNo != other.boardNo)
			return false;
		if (createDate == null) {
			if (other.createDate != null)
				return false;
		} else if (!createDate.equals(other.createDate))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}
	
	
	
	
}
