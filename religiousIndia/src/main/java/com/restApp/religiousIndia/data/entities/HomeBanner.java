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

	private String isTemple;

	private String isPandit;

	private String isEvent;

	private String templeId;

	private String panditId;

	private String eventId;

	public String getIsPandit() {
		return isPandit;
	}

	public void setIsPandit(String isPandit) {
		this.isPandit = isPandit;
	}

	public String getIsEvent() {
		return isEvent;
	}

	public void setIsEvent(String isEvent) {
		this.isEvent = isEvent;
	}

	public String getTempleId() {
		return templeId;
	}

	public void setTempleId(String templeId) {
		this.templeId = templeId;
	}

	public String getPanditId() {
		return panditId;
	}

	public void setPanditId(String panditId) {
		this.panditId = panditId;
	}

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

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

	public String getIsTemple() {
		return isTemple;
	}

	public void setIsTemple(String isTemple) {
		this.isTemple = isTemple;
	}

}
