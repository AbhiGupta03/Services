package com.restApp.religiousIndia.data.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.restApp.religiousIndia.utilities.audits.AuditFields;

@Entity
@Table(name = "RI_TEMPLE")
public class Temple extends AuditFields<String> {
	@Id
	@GenericGenerator(name = "sequence_id", strategy = "com.restApp.religiousIndia.utilities.TempleIdGenrator")
	@GeneratedValue(generator = "sequence_id")
	@Column(name = "temple_id")
	private String templeId;

	private String templeName;
	private String templeDesc;
	private String authChannelPartner;
	private String isActive;

	@Column(name = "MAIN_IMAGE_ID")
	private String mainImageID;

	private String contactNo;

	@Column(name = "TEMPLE_ADDRESS_ID")
	private String templeAddressId;

	@Column(columnDefinition = "TEXT", name = "Image_Gallery", nullable = true)
	private String imageGallery;

	private int hitsCount;

	public String getTempleAddressId() {
		return templeAddressId;
	}

	public void setTempleAddressId(String templeAddressId) {
		this.templeAddressId = templeAddressId;
	}

	public String getTempleId() {
		return templeId;
	}

	public void setTempleId(String templeId) {
		this.templeId = templeId;
	}

	public String getTempleName() {
		return templeName;
	}

	public void setTempleName(String templeName) {
		this.templeName = templeName;
	}

	public String getTempleDesc() {
		return templeDesc;
	}

	public void setTempleDesc(String templeDesc) {
		this.templeDesc = templeDesc;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public String getAuthChannelPartner() {
		return authChannelPartner;
	}

	public void setAuthChannelPartner(String authChannelPartner) {
		this.authChannelPartner = authChannelPartner;
	}

	public String getMainImageID() {
		return mainImageID;
	}

	public void setMainImageID(String mainImageID) {
		this.mainImageID = mainImageID;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	@Override
	public String toString() {
		return "Temple [templeId=" + templeId + ", templeName=" + templeName + ", templeDesc=" + templeDesc
				+ ", authChannelPartner=" + authChannelPartner + ", isActive=" + isActive + ", mainImageID="
				+ mainImageID + ", contactNo=" + contactNo + "]";
	}

	public String getImageGallery() {
		return imageGallery;
	}

	public void setImageGallery(String imageGallery) {
		this.imageGallery = imageGallery;
	}

	public int getHitsCount() {
		return hitsCount;
	}

	public void setHitsCount(int hitsCount) {
		this.hitsCount = hitsCount;
	}
}
