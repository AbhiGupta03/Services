package com.restApp.religiousIndia.data.entities.pooja;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import com.restApp.religiousIndia.utilities.compositePrimary.PoojaServicePricingPrimaryKey;

@Entity
@Table(name = "RI_POOJA_SERVICES_PRICING")
public class PoojaServicesPricing {
	@Version
	private int versionId;

	@EmbeddedId
	private PoojaServicePricingPrimaryKey poojaServicePricingPrimaryKey;

	private double price;

	private double discount;

	private String isActive;

	public int getVersionId() {
		return versionId;
	}

	public void setVersionId(int versionId) {
		this.versionId = versionId;
	}

	public double getPrice() {
		return price;
	}

	public PoojaServicePricingPrimaryKey getPoojaServicePricingPrimaryKey() {
		return poojaServicePricingPrimaryKey;
	}

	public void setPoojaServicePricingPrimaryKey(PoojaServicePricingPrimaryKey poojaServicePricingPrimaryKey) {
		this.poojaServicePricingPrimaryKey = poojaServicePricingPrimaryKey;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

}
