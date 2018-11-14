package com.restApp.religiousIndia.data.entities.pandit;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.GenericGenerator;

import com.restApp.religiousIndia.common.PanditCategoryId;
import com.restApp.religiousIndia.common.TypeOfAvailability;
import com.restApp.religiousIndia.utilities.audits.AuditFields;

@Entity
@Table(name = "ri_pandit_details_temp")
public class CmsPanditDetails extends AuditFields<String> {

	@Version
	private int versionId;

	@Id
	@GenericGenerator(name = "sequence__id", strategy = "com.restApp.religiousIndia.utilities.CmsPanditIdGenrator")
	@GeneratedValue(generator = "sequence__id")
	private String panditId;

	private Integer userId;

	@Column
	@Enumerated(EnumType.STRING)
	private PanditCategoryId panditCategoryId;

	@Column(name = "TYPE_OF_AVAILABILITY")
	@Enumerated(EnumType.STRING)
	private TypeOfAvailability typeOfAvailbility;

	private String isFreeLancer;

	@Column(name = "Is_New_User")
	private String isNewUser;

	private String panditDesc;

	private String isAssociatedWithTemple;

	@Column(columnDefinition = "TEXT")
	private String specilaization;

	private String specilaizationPooja;

	private String imageId;

	@Column(name = "Temple_Id", nullable = true)
	private String templeIdList;

	@Column(name = "PANDIT_EDUCATIONAL_DETAILS", columnDefinition = "TEXT", nullable = true)
	private String qualification;

	@Column(name = "FAMOUS_ARTICLES_LINK", columnDefinition = "TEXT", nullable = true)
	private String articlesDetails;

	@Column(name = "AWARD_RECEIVED_DETAILS", columnDefinition = "TEXT", nullable = true)
	private String awardsDetails;

	@Column(name = "PANDIT_DAILY_AVAILABILITY_TIMINGS", columnDefinition = "TEXT")
	private String panditDailyAvailablityTiming;

	@Column(name = "isAvailableOnAllDays")
	private String isAvailableOnAllDays;

	@Column(name = "general_availablity_timing")
	private String generalAvailablityTiming;

	@Column(columnDefinition = "TEXT",name="Pooja_Service_List")
	private String poojaServiceList;

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

	public Integer getUserId() {
		return userId;
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

	public String getTempleIdList() {
		return templeIdList;
	}

	public void setTempleIdList(String templeIdList) {
		this.templeIdList = templeIdList;
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

	public String getPanditDailyAvailablityTiming() {
		return panditDailyAvailablityTiming;
	}

	public void setPanditDailyAvailablityTiming(String panditDailyAvailablityTiming) {
		this.panditDailyAvailablityTiming = panditDailyAvailablityTiming;
	}

	public String getIsAvailableOnALlDays() {
		return isAvailableOnAllDays;
	}

	public void setIsAvailableOnALlDays(String isAvailableOnALlDays) {
		this.isAvailableOnAllDays = isAvailableOnALlDays;
	}

	public String getGeneralAvailablityTiming() {
		return generalAvailablityTiming;
	}

	public void setGeneralAvailablityTiming(String generalAvailablityTiming) {
		this.generalAvailablityTiming = generalAvailablityTiming;
	}

	public String getIsNewUser() {
		return isNewUser;
	}

	public void setIsNewUser(String isNewUser) {
		this.isNewUser = isNewUser;
	}

	public String getPoojaServiceList() {
		return poojaServiceList;
	}

	public void setPoojaServiceList(String poojaServiceList) {
		this.poojaServiceList = poojaServiceList;
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
