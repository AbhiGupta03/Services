package com.restApp.religiousIndia.data.entities.pandit;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import com.restApp.religiousIndia.common.PanditCategoryId;
import com.restApp.religiousIndia.common.TypeOfAvailability;
import com.restApp.religiousIndia.data.entities.pandit.availability.PanditDailyAvailibility;
import com.restApp.religiousIndia.utilities.audits.AuditFields;

@Entity
@Table(name = "RI_PANDIT_DETAILS")
public class PanditDetails extends AuditFields<String> {

	@Version
	private int versionId;

	@Id
	private String panditId;

	private Integer userId;

	@Column(name = "SUBSCRIPTION_DETAILS_ID")
	private String subsscriptionDetailsId;

	@Column
	@Enumerated(EnumType.STRING)
	private PanditCategoryId panditCategoryId;

	@Column(name = "TYPE_OF_AVAILABILITY")
	@Enumerated(EnumType.STRING)
	private TypeOfAvailability typeOfAvailbility;

	private String isFreeLancer;

	private String panditDesc;

	@Column(nullable = true)
	private int reviewers;

	private String isAssociatedWithTemple;

	@Column(columnDefinition = "TEXT")
	private String specilaization;

	private String specilaizationPooja;

	private String imageId;

	@Column(name = "RI_PANDIT_RATING")
	private Double panditRating;

	private String isActive;

	@Column(name = "Temple_Id", nullable = true)
	private String templeIdList;

	private int totalClients;

	@Column(name = "PANDIT_EDUCATIONAL_DETAILS", columnDefinition = "TEXT", nullable = true)
	private String qualification;

	@Column(name = "FAMOUS_ARTICLES_LINK", columnDefinition = "TEXT", nullable = true)
	private String articlesDetails;

	@Column(name = "AWARD_RECEIVED_DETAILS", columnDefinition = "TEXT", nullable = true)
	private String awardsDetails;

	@OneToOne
	@JoinColumn(name = "PANDIT_DAILY_AVAILABILITY_TIMINGS_ID")
	private PanditDailyAvailibility panditDailyAvailablityTiming;

	public int getVersion() {
		return versionId;
	}

	public void setVersion(int version) {
		this.versionId = version;
	}

	public String getImageId() {
		return imageId;
	}

	public void setImageId(String imageId) {
		this.imageId = imageId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getPanditId() {
		return panditId;
	}

	public void setPanditId(String panditId) {
		this.panditId = panditId;
	}

	public String getSubsscriptionDetailsId() {
		return subsscriptionDetailsId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setSubsscriptionDetailsId(String subsscriptionDetailsId) {
		this.subsscriptionDetailsId = subsscriptionDetailsId;
	}

	public PanditCategoryId getPanditCategoryId() {
		return panditCategoryId;
	}

	public void setPanditCategoryId(PanditCategoryId panditCategoryId) {
		this.panditCategoryId = panditCategoryId;
	}

	public String getIsFreeLancer() {
		return isFreeLancer;
	}

	public void setIsFreeLancer(String isFreeLancer) {
		this.isFreeLancer = isFreeLancer;
	}

	public TypeOfAvailability getTypeOfAvailbility() {
		return typeOfAvailbility;
	}

	public void setTypeOfAvailbility(TypeOfAvailability typeOfAvailbility) {
		this.typeOfAvailbility = typeOfAvailbility;
	}

	public String getIsAssociatedWithTemple() {
		return isAssociatedWithTemple;
	}

	public void setIsAssociatedWithTemple(String isAssociatedWithTemple) {
		this.isAssociatedWithTemple = isAssociatedWithTemple;
	}

	public String getSpecilaization() {
		return specilaization;
	}

	public void setSpecilaization(String specilaization) {
		this.specilaization = specilaization;
	}

	public String getSpecilaizationPooja() {
		return specilaizationPooja;
	}

	public void setSpecilaizationPooja(String specilaizationPooja) {
		this.specilaizationPooja = specilaizationPooja;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public int getReviewers() {
		return reviewers;
	}

	public void setReviewers(int reviewers) {
		this.reviewers = reviewers;
	}

	public String getTempleIdList() {
		return templeIdList;
	}

	public void setTempleIdList(String templeIdList) {
		this.templeIdList = templeIdList;
	}

	public Double getPanditRating() {
		return panditRating;
	}

	public void setPanditRating(Double panditRating) {
		this.panditRating = panditRating;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getPanditDesc() {
		return panditDesc;
	}

	public void setPanditDesc(String panditDesc) {
		this.panditDesc = panditDesc;
	}

	public String getAwardsDetails() {
		return awardsDetails;
	}

	public void setAwardsDetails(String awardsDetails) {
		this.awardsDetails = awardsDetails;
	}

	public String getArticlesDetails() {
		return articlesDetails;
	}

	public void setArticlesDetails(String articlesDetails) {
		this.articlesDetails = articlesDetails;
	}

	public PanditDailyAvailibility getPanditDailyAvailablityTiming() {
		return panditDailyAvailablityTiming;
	}

	public void setPanditDailyAvailablityTiming(PanditDailyAvailibility panditDailyAvailablityTiming) {
		this.panditDailyAvailablityTiming = panditDailyAvailablityTiming;
	}

	public int getTotalClients() {
		return totalClients;
	}

	public void setTotalClients(int totalClients) {
		this.totalClients = totalClients;
	}

	/*
	 * public PanditDailyAvailibility getPanditDailyAvailablityTiming() { return
	 * panditDailyAvailablityTiming; }
	 * 
	 * public void setPanditDailyAvailablityTiming(PanditDailyAvailibility
	 * panditDailyAvailablityTiming) { this.panditDailyAvailablityTiming =
	 * panditDailyAvailablityTiming; }
	 */
	/*
	 * public String getVersion() { return version; }
	 * 
	 * public void setVersion(String version) { this.version = version; }
	 */

}
