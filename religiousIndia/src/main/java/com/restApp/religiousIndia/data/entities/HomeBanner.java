package com.restApp.religiousIndia.data.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RI_HOME_BANNER")
public class HomeBanner {
	@Id
	@Column(name = "IMAGE_ID")
	private String imageId;

	@Column(name = "BANNER_NAME")
	private String bannerName;

	private String itemId;
	private String subItemId;

	private String dataId;

	private String bannerDesc;

	@Column(name = "IS_ACTIVE")
	private String isActive;

	public String getImageId() {
		return imageId;
	}

	public void setImageId(String imageId) {
		this.imageId = imageId;
	}

	public String getBannerName() {
		return bannerName;
	}

	public void setBannerName(String bannerName) {
		this.bannerName = bannerName;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getSubItemId() {
		return subItemId;
	}

	public void setSubItemId(String subItemId) {
		this.subItemId = subItemId;
	}

	public String getDataId() {
		return dataId;
	}

	public void setDataId(String dataId) {
		dataId = this.dataId;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public String getBannerDesc() {
		return bannerDesc;
	}

	public void setBannerDesc(String bannerDesc) {
		this.bannerDesc = bannerDesc;
	}

	@Override
	public String toString() {
		return "HomeBanner [imageId=" + imageId + ", bannerName=" + bannerName + ", itemId=" + itemId + ", subItemId="
				+ subItemId + ", dataId=" + dataId + ", bannerDesc=" + bannerDesc + ", isActive=" + isActive + "]";
	}

}
