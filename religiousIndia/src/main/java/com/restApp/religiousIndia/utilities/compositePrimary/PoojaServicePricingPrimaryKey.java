package com.restApp.religiousIndia.utilities.compositePrimary;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class PoojaServicePricingPrimaryKey implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotNull
	private String serviceId;

	@NotNull
	@Column(name = "POOJA_PACKAGE_CATEGORY_ID")
	private String poojaPackageCategoryId;

	public PoojaServicePricingPrimaryKey() {
	}

	public PoojaServicePricingPrimaryKey(String serviceId, String poojaPackageCategoryId) {
		this.serviceId = serviceId;
		this.poojaPackageCategoryId = poojaPackageCategoryId;
	}

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public String getPoojaPackageCategoryId() {
		return poojaPackageCategoryId;
	}

	public void setPoojaPackageCategoryId(String poojaPackageCategoryId) {
		this.poojaPackageCategoryId = poojaPackageCategoryId;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;

		PoojaServicePricingPrimaryKey that = (PoojaServicePricingPrimaryKey) obj;

		if (!serviceId.equals(that.serviceId))
			return false;
		return poojaPackageCategoryId.equals(that.poojaPackageCategoryId);
	}

	@Override
	public int hashCode() {
		int result = serviceId.hashCode();
		result = 31 * result + poojaPackageCategoryId.hashCode();
		return result;
	}
}
