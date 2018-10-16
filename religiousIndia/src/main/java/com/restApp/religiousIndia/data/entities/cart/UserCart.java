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
@Table(name = "ri_user_cart")
public class UserCart extends AuditFields<String> {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer cartId;

	@Version
	private int versionId;

	private Integer userId;

	private String addressId;

	
	@Column(name = "items_details", columnDefinition = "TEXT")
	private String itemsDetails;

	public int getVersionId() {
		return versionId;
	}

	public void setVersionId(int versionId) {
		this.versionId = versionId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getAddressId() {
		return addressId;
	}

	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}

	public String getItemsDetails() {
		return itemsDetails;
	}

	public void setItemsDetails(String itemsDetails) {
		this.itemsDetails = itemsDetails;
	}

	public Integer getCartId() {
		return cartId;
	}

	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}

}
