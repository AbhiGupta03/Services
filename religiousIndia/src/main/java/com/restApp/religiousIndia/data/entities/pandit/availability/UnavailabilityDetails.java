package com.restApp.religiousIndia.data.entities.pandit.availability;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import com.restApp.religiousIndia.utilities.audits.AuditFields;

@Entity
@Table(name = "ri_pandit_unavailability_details")
public class UnavailabilityDetails extends AuditFields<String> {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Double id;

	@Version
	private int versionId;

	private String panditId;

	@Temporal(TemporalType.DATE)
	@Column(name = "UNAVAILABLE_FROM_DATE")
	private Date fromDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "UNAVAILABLE_TO_DATE")
	private Date toDate;

	@Column(name = "REASON_FOR_UNAVAILABILITY", columnDefinition = "TEXT")
	private String reason;

	private String isPersonalBooking;

	private String isActive;

	public Double getId() {
		return id;
	}

	public void setId(Double id) {
		this.id = id;
	}

	public int getVersionId() {
		return versionId;
	}

	public void setVersionId(int versionId) {
		this.versionId = versionId;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getIsPersonalBooking() {
		return isPersonalBooking;
	}

	public void setIsPersonalBooking(String isPersonalBooking) {
		this.isPersonalBooking = isPersonalBooking;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public String getPanditId() {
		return panditId;
	}

	public void setPanditId(String panditId) {
		this.panditId = panditId;
	}

}
