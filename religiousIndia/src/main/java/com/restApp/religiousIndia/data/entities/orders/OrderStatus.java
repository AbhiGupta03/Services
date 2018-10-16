package com.restApp.religiousIndia.data.entities.orders;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RI_ORDER_STATUS")
public class OrderStatus {

	@Id
	private String statusId;

	@Column(name = "STATUS_NAME")
	private String status;

	private String statusDesc;

	public String getStatusID() {
		return statusId;
	}

	public void setStatusID(String statusID) {
		this.statusId = statusID;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatusDesc() {
		return statusDesc;
	}

	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
	}
}
