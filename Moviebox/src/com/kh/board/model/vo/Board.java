package com.kh.board.model.vo;


public class Board {
	private int boardNo;
	private String boardTitle;
	private String boardContent;
	private String createDate;
	private int count;
	private String status;
	private String boardWriter;
	private String boardCategory;
	
	private int categoryNo;
	private int userNo;
	
	public Board() {
		super();
	}

	public Board(int boardNo, String boardTitle, String boardContent, String createDate, int count, String status,
			String boardWriter, String boardCategory) {
		super();
		this.boardNo = boardNo;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.createDate = createDate;
		this.count = count;
		this.status = status;
		this.boardWriter = boardWriter;
		this.boardCategory = boardCategory;
	}
	
	
	
	
	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public int getCategoryNo() {
		return categoryNo;
	}

	public void setCategoryNo(int categoryNo) {
		this.categoryNo = categoryNo;
	}

	public String getBoardCategory() {
		return boardCategory;
	}

	public void setBoardCategory(String boardCategory) {
		this.boardCategory = boardCategory;
	}


	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	public String getBoardWriter() {
		return boardWriter;
	}

	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
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

	@Override
	public String toString() {
		return "Board [boardNo=" + boardNo + ", boardTitle=" + boardTitle + ", boardContent=" + boardContent
				+ ", boardWriter=" + boardWriter + ", count=" + count + ", createString=" + createDate + ", status="
				+ status + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((boardContent == null) ? 0 : boardContent.hashCode());
		result = prime * result + boardNo;
		result = prime * result + ((boardTitle == null) ? 0 : boardTitle.hashCode());
		result = prime * result + ((boardWriter == null) ? 0 : boardWriter.hashCode());
		result = prime * result + count;
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
		Board other = (Board) obj;
		if (boardContent == null) {
			if (other.boardContent != null)
				return false;
		} else if (!boardContent.equals(other.boardContent))
			return false;
		if (boardNo != other.boardNo)
			return false;
		if (boardTitle == null) {
			if (other.boardTitle != null)
				return false;
		} else if (!boardTitle.equals(other.boardTitle))
			return false;
		if (boardWriter == null) {
			if (other.boardWriter != null)
				return false;
		} else if (!boardWriter.equals(other.boardWriter))
			return false;
		if (count != other.count)
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
