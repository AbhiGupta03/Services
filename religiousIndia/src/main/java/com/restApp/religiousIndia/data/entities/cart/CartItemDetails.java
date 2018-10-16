package com.restApp.religiousIndia.data.entities.cart;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import com.restApp.religiousIndia.utilities.audits.AuditFields;

@Entity
@Table(name = "ri_cart_items_details")
public class CartItemDetails extends AuditFields<String> {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer itemId;

	@Version
	private int versionId;

	@Column(name = "is_temple_donation")
	private String isTempleDonation="0";

	@Column(name = "is_pandit_booking")
	private String isPanditBooking="0";

	@Column(name = "is_temple_pooja_booking")
	private String isPoojaBooking="0";

	@Column(name = "temle_donation_category_id")
	private String templeDonationCategoryId;

	@Column(name = "donation_sub_category_id")
	private String donationSubCategoryId;

	@Column(name = "is_pandit_subsription")
	private String isPanditSubsription;

	@Column(name = "pandit_subsription_plan_id")
	private String panditSubsriptionPlanId;

	@Column(name = "pandit_id")
	private String panditId;

	@Column(name = "pooja_id")
	private String poojaId;

	@Column(name = "temple_id")
	private String templeId;
	
	@Column(name="is_amt_changeable")
	private String isAmtChangeable="1";

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public int getVersionId() {
		return versionId;
	}

	public void setVersionId(int versionId) {
		this.versionId = versionId;
	}

	public String getIsTempleDonation() {
		return isTempleDonation;
	}

	public void setIsTempleDonation(String isTempleDonation) {
		this.isTempleDonation = isTempleDonation;
	}

	public String getIsPanditBooking() {
		return isPanditBooking;
	}

	public void setIsPanditBooking(String isPanditBooking) {
		this.isPanditBooking = isPanditBooking;
	}

	public String getIsPoojaBooking() {
		return isPoojaBooking;
	}

	public void setIsPoojaBooking(String isPoojaBooking) {
		this.isPoojaBooking = isPoojaBooking;
	}

	public String getTempleDonationCategoryId() {
		return templeDonationCategoryId;
	}

	public void setTempleDonationCategoryId(String templeDonationCategoryId) {
		this.templeDonationCategoryId = templeDonationCategoryId;
	}

	public String getDonationSubCategoryId() {
		return donationSubCategoryId;
	}

	public void setDonationSubCategoryId(String donationSubCategoryId) {
		this.donationSubCategoryId = donationSubCategoryId;
	}

	public String getIsPanditSubsription() {
		return isPanditSubsription;
	}

	public void setIsPanditSubsription(String isPanditSubsription) {
		this.isPanditSubsription = isPanditSubsription;
	}

	public String getPanditSubsriptionPlanId() {
		return panditSubsriptionPlanId;
	}

	public void setPanditSubsriptionPlanId(String panditSubsriptionPlanId) {
		this.panditSubsriptionPlanId = panditSubsriptionPlanId;
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

	public String getTempleId() {
		return templeId;
	}

	public void setTempleId(String templeId) {
		this.templeId = templeId;
	}

	public String getIsAmtChangeable() {
		return isAmtChangeable;
	}

	public void setIsAmtChangeable(String isAmtChangeable) {
		this.isAmtChangeable = isAmtChangeable;
	}

}
