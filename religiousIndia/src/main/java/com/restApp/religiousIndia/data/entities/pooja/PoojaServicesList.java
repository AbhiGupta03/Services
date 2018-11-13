package com.restApp.religiousIndia.data.entities.pooja;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.restApp.religiousIndia.utilities.audits.AuditFields;

@Entity
@Table(name = "RI_POOJA_SERVICES_LIST")
public class PoojaServicesList {
	@Id
	private String serviceId;

	@Column(name = "SERVICE_NAME", columnDefinition = "TEXT")
	private String serviceName;

	private String isActive;

	private String serviceDesc;

	public String getServiceId() {
		return serviceId;
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

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

}
