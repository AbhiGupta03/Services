package com.restApp.religiousIndia.data.entities.temple.donation;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.restApp.religiousIndia.utilities.audits.AuditFields;

@Entity
@Table(name = "ri_temple_donation_category")
public class TempleDonationCategory extends AuditFields<String> {

	@Id
	@Column(name = "DONATION_CATEGORY_ID")
	private String donationCategoryId;

	@Column(name = "DONATION_CATEGORY_NAME")
	private String donationCategoryName;

	private String isActive;

	public String getDonationCategoryId() {
		return donationCategoryId;
	}

	public void setDonationCategoryId(String donationCategoryId) {
		this.donationCategoryId = donationCategoryId;
	}

	public String getDonationCategoryName() {
		return donationCategoryName;
	}

	public void setDonationCategoryName(String donationCategoryName) {
		this.donationCategoryName = donationCategoryName;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

}
