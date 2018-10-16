package com.restApp.religiousIndia.data.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ri_temple_timings")
public class TempleTimings {

	@Id
	@Column(name = "TEMPLE_ID")
	private String templeID;

	private String templeTime;

	private String seasonId;
	
	private String isActive;

	public String getTempleID() {
		return templeID;
	}

	public void setTempleID(String templeID) {
		this.templeID = templeID;
	}

	public String getTempleTime() {
		return templeTime;
	}

	public void setTempleTime(String templeTime) {
		this.templeTime = templeTime;
	}

	public String getSeasonId() {
		return seasonId;
	}

	public void setSeasonId(String seasonId) {
		this.seasonId = seasonId;
	}

	@Override
	public String toString() {
		return "TempleTimeings [templeID=" + templeID + ", templeTime=" + templeTime + ", seasonId=" + seasonId + "]";
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

}
