package com.restApp.religiousIndia.data.entities.temple.reviews;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import com.restApp.religiousIndia.utilities.audits.AuditFields;

@Entity
@Table(name = "RI_TEMPLE_REVIEWS")
public class TempleReview extends AuditFields<String> {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer reviewId;

	private String rating;

	@Version
	private int versionId;

	@Column(name = "USER_REVIEW_ABOUT")
	private String userReview;

	@Column(name = "USER_REVIEW_DESC", columnDefinition = "TEXT")
	private String reviewDesc;

	private String userId;

	private String templeId;

	private String isActive;

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

	public String getTempleId() {
		return templeId;
	}

	public void setTempleId(String templeId) {
		this.templeId = templeId;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public Integer getReviewId() {
		return reviewId;
	}

	public void setReviewId(Integer reviewId) {
		this.reviewId = reviewId;
	}

}
