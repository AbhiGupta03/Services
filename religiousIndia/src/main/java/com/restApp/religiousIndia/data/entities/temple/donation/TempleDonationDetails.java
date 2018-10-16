package com.restApp.religiousIndia.data.entities.temple.donation;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.springframework.data.annotation.CreatedDate;

import com.restApp.religiousIndia.utilities.audits.AuditFields;

@Entity
@Table(name = "RI_TEMPLE_DONATIONS_DETAILS")
public class TempleDonationDetails extends AuditFields<String> {
	@Version
	private int versionId;

	@Id
	private String donationId;

	private String templeId;

	@Column(name = "DONATION_CATEGORY_ID")
	private String donationCategoryId;

	@Column(name = "DONATION_SUB_CATEGORY_ID")
	private String donationSubCategoryId;

	private String userId;

	@Column(name = "AMOUNT_DONATED")
	private double ammountDonated;

	private String paymentId;

	private String donationStatusId;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCompleted;

	private String userReviewId;

	@CreatedDate
	@Temporal(TemporalType.TIMESTAMP)
	private Date donationDate;

	public int getVersionId() {
		return versionId;
	}

	public void setVersionId(int versionId) {
		this.versionId = versionId;
	}

	public String getDonationId() {
		return donationId;
	}

	public void setDonationId(String donationId) {
		this.donationId = donationId;
	}

	public String getTempleId() {
		return templeId;
	}

	public void setTempleId(String templeId) {
		this.templeId = templeId;
	}

	public String getDonationCategoryId() {
		return donationCategoryId;
	}

	public void setDonationCategoryId(String donationCategoryId) {
		this.donationCategoryId = donationCategoryId;
	}

	public String getDonationSubCategoryId() {
		return donationSubCategoryId;
	}

	public void setDonationSubCategoryId(String donationSubCategoryId) {
		this.donationSubCategoryId = donationSubCategoryId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}

	public String getDonationStatusId() {
		return donationStatusId;
	}

	public void setDonationStatusId(String donationStatusId) {
		this.donationStatusId = donationStatusId;
	}

	public Date getDonationDate() {
		return donationDate;
	}

	public void setDonationDate(Date donationDate) {
		this.donationDate = donationDate;
	}

	public Date getDateCompleted() {
		return dateCompleted;
	}

	public void setDateCompleted(Date dateCompleted) {
		this.dateCompleted = dateCompleted;
	}

	public String getUserReviewId() {
		return userReviewId;
	}

	public void setUserReviewId(String userReviewId) {
		this.userReviewId = userReviewId;
	}

	public double getAmmountDonated() {
		return ammountDonated;
	}

	public void setAmmountDonated(double ammountDonated) {
		this.ammountDonated = ammountDonated;
	}

}
