package com.restApp.religiousIndia.data.entities.pandit.availability;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "RI_PANDIT_DAILY_AVAILIBILITY_TIMINGS")
public class PanditDailyAvailibility {

	@Version
	private int versionId;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PANDIT_DAILY_AVAILABILITY_TIMINGS_ID")
	private Double availabiltyId;

	@Column(name = "MONDAY")
	private String mondayTiming;

	@Column(name = "TUESDAY")
	private String thuesdayTiming;

	@Column(name = "WEDNESDAY")
	private String wednesdayTiming;

	@Column(name = "THURSDAY")
	private String thursdayTiming;

	@Column(name = "FRIDAY")
	private String fridayTiming;

	@Column(name = "SATURDAY")
	private String saturdayTiming;

	@Column(name = "SUNDAY")
	private String sundayTiming;

	@Column(name = "IS_AVAILABLE_ON_ALL_DAYS")
	private String isAvailableOnALlDays;

	@Column(name = "GENERAL_AVAILABILITY_TIMING", columnDefinition = "TEXT")
	private String generalAvailablityTiming;

	public String getMondayTiming() {
		return mondayTiming;
	}

	public void setMondayTiming(String mondayTiming) {
		this.mondayTiming = mondayTiming;
	}

	public String getThuesdayTiming() {
		return thuesdayTiming;
	}

	public void setThuesdayTiming(String thuesdayTiming) {
		this.thuesdayTiming = thuesdayTiming;
	}

	public String getWednesdayTiming() {
		return wednesdayTiming;
	}

	public void setWednesdayTiming(String wednesdayTiming) {
		this.wednesdayTiming = wednesdayTiming;
	}

	public String getThursdayTiming() {
		return thursdayTiming;
	}

	public void setThursdayTiming(String thursdayTiming) {
		this.thursdayTiming = thursdayTiming;
	}

	public String getFridayTiming() {
		return fridayTiming;
	}

	public void setFridayTiming(String fridayTiming) {
		this.fridayTiming = fridayTiming;
	}

	public String getSaturdayTiming() {
		return saturdayTiming;
	}

	public void setSaturdayTiming(String saturdayTiming) {
		this.saturdayTiming = saturdayTiming;
	}

	public String getSundayTiming() {
		return sundayTiming;
	}

	public void setSundayTiming(String sundayTiming) {
		this.sundayTiming = sundayTiming;
	}

	public String getIsAvailableOnALlDays() {
		return isAvailableOnALlDays;
	}

	public void setIsAvailableOnALlDays(String isAvailableOnALlDays) {
		this.isAvailableOnALlDays = isAvailableOnALlDays;
	}

	public String getGeneralAvailablityTiming() {
		return generalAvailablityTiming;
	}

	public void setGeneralAvailablityTiming(String generalAvailablityTiming) {
		this.generalAvailablityTiming = generalAvailablityTiming;
	}

	public int getVersionId() {
		return versionId;
	}

	public void setVersionId(int versionId) {
		this.versionId = versionId;
	}

	public Double getAvailabiltyId() {
		return availabiltyId;
	}

	public void setAvailabiltyId(Double availabiltyId) {
		this.availabiltyId = availabiltyId;
	}
}
