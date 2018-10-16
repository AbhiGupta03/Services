package com.restApp.religiousIndia.data.entities.pooja;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.restApp.religiousIndia.utilities.audits.AuditFields;

@Entity
@Table(name = "RI_POOJA_SERVICES")
public class Pooja extends AuditFields<String>{
	@Id
	private String serviceId;

	@Column(name = "SERVICE_NAME", columnDefinition = "TEXT")
	private String serviceName;

	private String panditId;

	private String templeId;

	private String isActive;

	private String imageId;

	private String serviceDesc;

	public String getServiceId() {
		return serviceId;
	}

	public String getImageId() {
		return imageId;
	}

	public void setImageId(String imageId) {
		this.imageId = imageId;
	}

	public String getServiceDesc() {
		return serviceDesc;
	}

	public void setServiceDesc(String serviceDesc) {
		this.serviceDesc = serviceDesc;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getPanditId() {
		return panditId;
	}

	public void setPanditId(String panditId) {
		this.panditId = panditId;
	}

	public String getTempleId() {
		return templeId;
	}

	public void setTempleId(String templeId) {
		this.templeId = templeId;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "PoojaServices [serviceId=" + serviceId + ", serviceName=" + serviceName + ", panditId=" + panditId
				+ ", templeId=" + templeId + ", isActive=" + isActive + "]";
	}
}
