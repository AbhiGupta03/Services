package com.restApp.religiousIndia.data.entities.cmsEntities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.restApp.religiousIndia.utilities.audits.AuditFields;

@Entity
@Table(name = "RI_TEMPLE_TEMP")
public class CmsTemple extends AuditFields<String> {

	@Id
	@GenericGenerator(name = "sequence_id", strategy = "com.restApp.religiousIndia.utilities.TempleIdGenrator")
	@GeneratedValue(generator = "sequence_id")
	@Column(name = "temple_id")
	private String templeId;

	private String templeName;
	
	private String templeDesc; 
	
	private String authChannelPartner;
	
	private String isVerified;

	@Column(name = "MAIN_IMAGE_Detail", columnDefinition = "TEXT")
	private String mainImageData;

	private String contactNo;

	@Column(name = "TEMPLE_ADDRESS_Detail", columnDefinition = "TEXT")
	private String templeAddressData;

	@Column(columnDefinition = "TEXT", name = "Image_Gallery", nullable = true)
	private String imageGallery;

	private int hitsCount;

	@Column(nullable = false)
	private String templeTiming;

	@Column(nullable = false)
	private String aartiTiming;

	public String getTempleAddressData() {
		return templeAddressData;
	}

	public void setTempleAddressData(String templeAddressData) {
		this.templeAddressData = templeAddressData;
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

	public String getAuthChannelPartner() {
		return authChannelPartner;
	}

	public void setAuthChannelPartner(String authChannelPartner) {
		this.authChannelPartner = authChannelPartner;
	}

	public String getMainImageData() {
		return mainImageData;
	}

	public void setMainImageData(String mainImageID) {
		this.mainImageData = mainImageID;
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
				+ ", authChannelPartner=" + authChannelPartner + ", isVerified=" + isVerified + ", mainImageID="
				+ mainImageData + ", contactNo=" + contactNo + "]";
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

	public String getTempleTiming() {
		return templeTiming;
	}

	public void setTempleTiming(String templeTiming) {
		this.templeTiming = templeTiming;
	}

	public String getAartiTiming() {
		return aartiTiming;
	}

	public void setAartiTiming(String aartiTiming) {
		this.aartiTiming = aartiTiming;
	}

	public String getIsVerified() {
		return isVerified;
	}

	public void setIsVerified(String isVerified) {
		this.isVerified = isVerified;
	}
}
