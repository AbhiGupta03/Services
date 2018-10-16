package com.restApp.religiousIndia.data.entities.temple.donation;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "ri_temple_donation_food_donation")
public class FoodDonation {
	@Id
	@Column(name = "DONATION_SUB_CATEGORY_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String donationSubCategoryId;

	@Column(name = "DONATION_SUB_CATEGORY_NAME")
	private String donationSubCategoryName;

	private String description;

	@Column(name = "STARTDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date startDate;

	@Column(name = "ENDDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date endDate;

	private double requiredMoney;

	private double collectedMoney;

	@Column(name = "NO_OF_CONTIBUITORS")
	private int noOfContribuitors;

	private String templeId;

	private String isActive;

	@Column(name = "TEMPLE_DONATION_CATEGORY_ID")
	private String templeDonationCategoryId;

	private String imageId;

	private String addressId;

	public String getDonationSubCategoryId() {
		return donationSubCategoryId;
	}

	public void setDonationSubCategoryId(String donationSubCategoryId) {
		this.donationSubCategoryId = donationSubCategoryId;
	}

	public String getDonationSubCategoryName() {
		return donationSubCategoryName;
	}

	public void setDonationSubCategoryName(String donationSubCategoryName) {
		this.donationSubCategoryName = donationSubCategoryName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public double getRequiredMoney() {
		return requiredMoney;
	}

	public void setRequiredMoney(double requiredMoney) {
		this.requiredMoney = requiredMoney;
	}

	public double getCollectedMoney() {
		return collectedMoney;
	}

	public void setCollectedMoney(double collectedMoney) {
		this.collectedMoney = collectedMoney;
	}

	public int getNoOfContribuitors() {
		return noOfContribuitors;
	}

	public void setNoOfContribuitors(int noOfContribuitors) {
		this.noOfContribuitors = noOfContribuitors;
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

	public String getTempleDonationCategoryId() {
		return templeDonationCategoryId;
	}

	public void setTempleDonationCategoryId(String templeDonationCategoryId) {
		this.templeDonationCategoryId = templeDonationCategoryId;
	}

	public String getImageId() {
		return imageId;
	}

	public void setImageId(String imageId) {
		this.imageId = imageId;
	}

	public String getAddressId() {
		return addressId;
	}

	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}

}
