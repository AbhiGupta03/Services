package com.restApp.religiousIndia.data.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ri_main_menu_items")
public class MainMenuItem {
	@Id
	private String itemId;

	private String itemName;

	@Column(name = "IS_ACTIVE")
	private String isActive;

	private String url;

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "MainMenuItem [itemId=" + itemId + ", itemName=" + itemName + ", isActive=" + isActive + ", url=" + url
				+ "]";
	}

}
