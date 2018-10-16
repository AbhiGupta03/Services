package com.restApp.religiousIndia.data.entities.temple;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ri_aarti")
public class Aarti {
	@Id
	@Column(name="AARTI_ID")
	private String aartiId;

	private String aartiName;

	private String aartiDesc;

	private String aartiDay;

	private String startTime;

	private String endTime;

	private String templeId;
	
	@Column(name="IS_ACTIVE")
	private String isActive;

	public String getAartiId() {
		return aartiId;
	}

	public void setAartiId(String aartiId) {
		this.aartiId = aartiId;
	}

	public String getAartiName() {
		return aartiName;
	}

	public void setAartiName(String aartiName) {
		this.aartiName = aartiName;
	}

	public String getAartiDesc() {
		return aartiDesc;
	}

	public void setAartiDesc(String aartiDesc) {
		this.aartiDesc = aartiDesc;
	}

	public String getAartiDay() {
		return aartiDay;
	}

	public void setAartiDay(String aartiDay) {
		this.aartiDay = aartiDay;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getTempleId() {
		return templeId;
	}

	public void setTempleId(String templeId) {
		this.templeId = templeId;
	}

	@Override
	public String toString() {
		return "Aarti [aartiId=" + aartiId + ", aartiName=" + aartiName + ", aartiDesc=" + aartiDesc + ", aartiDay="
				+ aartiDay + ", startTime=" + startTime + ", endTime=" + endTime + ", templeId=" + templeId + "]";
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

}
