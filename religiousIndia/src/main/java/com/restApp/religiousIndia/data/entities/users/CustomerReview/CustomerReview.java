package com.restApp.religiousIndia.data.entities.users.CustomerReview;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import com.restApp.religiousIndia.utilities.audits.AuditFields;

@Entity
@Table(name = "RI_CUSTOMER_REVIEWS")
public class CustomerReview extends AuditFields<String> {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long reviewId;

	private String rating;

	@Version
	private int versionId;

	@Column(name = "USER_REVIEW_ABOUT")
	private String userReview;

	@Column(name = "USER_REVIEW_DESC", columnDefinition = "TEXT")
	private String reviewDesc;

	private String userId;

	@Column(nullable = true)
	private String panditId;

	@Column(nullable = true)
	private String poojaId;

	@Column(nullable = true)
	private String bookingId;

	@Column(nullable = true)
	private String bookingType;

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public int getVersionId() {
		return versionId;
	}

	public void setVersionId(int versionId) {
		this.versionId = versionId;
	}

	public String getUserReview() {
		return userReview;
	}

	public void setUserReview(String userReview) {
		this.userReview = userReview;
	}

	public String getReviewDesc() {
		return reviewDesc;
	}

	public void setReviewDesc(String reviewDesc) {
		this.reviewDesc = reviewDesc;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPanditId() {
		return panditId;
	}

	public void setPanditId(String panditId) {
		this.panditId = panditId;
	}

	public String getPoojaId() {
		return poojaId;
	}

	public void setPoojaId(String poojaId) {
		this.poojaId = poojaId;
	}

	public String getBookingId() {
		return bookingId;
	}

	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}

	public String getBookingType() {
		return bookingType;
	}

	public void setBookingType(String bookingType) {
		this.bookingType = bookingType;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public Long getReviewId() {
		return reviewId;
	}

	public void setReviewId(Long reviewId) {
		this.reviewId = reviewId;
	}

	private String isActive;
}
