package com.kh.theater.model.vo;

import java.util.Date;

public class Theater {
	private int theaterNo;
	private String theaterName;
	private String theaterAddr;
	private String mapLink;
	private String localCode;
	private Date updateDate;
	private String locationName;
	
	public String getLocationName() {
		return locationName;
	}
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	public Theater() {
		super();
	}
	public Theater(int theaterNo, String theaterName, String theaterAddr, String mapLink, String localCode,Date updateDate) {
		super();
		this.theaterNo = theaterNo;
		this.theaterName = theaterName;
		this.theaterAddr = theaterAddr;
		this.mapLink = mapLink;
		this.localCode = localCode;
		this.updateDate= updateDate;
	}
	public int getTheaterNo() {
		return theaterNo;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public void setTheaterNo(int theaterNo) {
		this.theaterNo = theaterNo;
	}
	public String getTheaterName() {
		return theaterName;
	}
	public void setTheaterName(String theaterName) {
		this.theaterName = theaterName;
	}
	public String getTheaterAddr() {
		return theaterAddr;
	}
	public void setTheaterAddr(String theaterAddr) {
		this.theaterAddr = theaterAddr;
	}
	public String getMapLink() {
		return mapLink;
	}
	public void setMapLink(String mapLink) {
		this.mapLink = mapLink;
	}
	public String getLocalCode() {
		return localCode;
	}
	public void setLocalCode(String localCode) {
		this.localCode = localCode;
	}
	
	
	
	
	
	@Override
	public String toString() {
		return "Theater [theaterNo=" + theaterNo + ", theaterName=" + theaterName + ", theaterAddr=" + theaterAddr
				+ ", mapLink=" + mapLink + ", localCode=" + localCode + ", updateDate=" + updateDate + ", locationName="
				+ locationName + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((localCode == null) ? 0 : localCode.hashCode());
		result = prime * result + ((mapLink == null) ? 0 : mapLink.hashCode());
		result = prime * result + ((theaterAddr == null) ? 0 : theaterAddr.hashCode());
		result = prime * result + ((theaterName == null) ? 0 : theaterName.hashCode());
		result = prime * result + theaterNo;
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
		Theater other = (Theater) obj;
		if (localCode == null) {
			if (other.localCode != null)
				return false;
		} else if (!localCode.equals(other.localCode))
			return false;
		if (mapLink == null) {
			if (other.mapLink != null)
				return false;
		} else if (!mapLink.equals(other.mapLink))
			return false;
		if (theaterAddr == null) {
			if (other.theaterAddr != null)
				return false;
		} else if (!theaterAddr.equals(other.theaterAddr))
			return false;
		if (theaterName == null) {
			if (other.theaterName != null)
				return false;
		} else if (!theaterName.equals(other.theaterName))
			return false;
		if (theaterNo != other.theaterNo)
			return false;
		return true;
	}
	
	
	
	
	
}
