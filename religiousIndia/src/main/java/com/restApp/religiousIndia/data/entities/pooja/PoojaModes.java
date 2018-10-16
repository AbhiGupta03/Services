package com.restApp.religiousIndia.data.entities.pooja;

import javax.persistence.Table;
import javax.persistence.Version;

import com.restApp.religiousIndia.utilities.audits.AuditFields;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table(name = "RI_POOJA_MODE_DETAILS")
public class PoojaModes extends AuditFields<String>{

	@Version
	private int versionId;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "POOJA_MODE_ID")
	private Double poojaModeId;

	public int getVersionId() {
		return versionId;
	}

	public void setVersionId(int versionId) {
		this.versionId = versionId;
	}

	public Double getPoojaModeId() {
		return poojaModeId;
	}

	public void setPoojaModeId(Double poojaModeId) {
		this.poojaModeId = poojaModeId;
	}

	public String getPoojaModeName() {
		return poojaModeName;
	}

	public void setPoojaModeName(String poojaModeName) {
		this.poojaModeName = poojaModeName;
	}

	public String getPoojaModeDesc() {
		return poojaModeDesc;
	}

	public void setPoojaModeDesc(String poojaModeDesc) {
		this.poojaModeDesc = poojaModeDesc;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	private String poojaModeName;

	private String poojaModeDesc;

	private String isActive;
}
