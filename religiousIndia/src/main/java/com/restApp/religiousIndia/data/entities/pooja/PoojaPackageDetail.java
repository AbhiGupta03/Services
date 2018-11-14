package com.restApp.religiousIndia.data.entities.pooja;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.GenericGenerator;

import com.restApp.religiousIndia.utilities.audits.AuditFields;

@Entity
@Table(name = "ri_pooja_package_types")
public class PoojaPackageDetail extends AuditFields<String> {

	@Version
	private int versionId;

	@Id
	@GenericGenerator(name = "sequence__id", strategy = "com.restApp.religiousIndia.utilities.PoojaPackageIdGenrator")
	@Column(name = "POOJA_PACKAGE_CATEGORY_ID")
	private String pacjageId;

	@OneToOne
	@JoinColumn(name = "POOJA_PACKAGE_CATEGORY_ID")
	private PoojaPackageFeature packageFeatures;

	@Column(name="PACKAGE_NAME")
	private String packageName;

	private String packageDescription;

	private String isActive;

	public int getVersionId() {
		return versionId;
	}

	public void setVersionId(int versionId) {
		this.versionId = versionId;
	}

	public String getPacjageId() {
		return pacjageId;
	}

	public void setPacjageId(String pacjageId) {
		this.pacjageId = pacjageId;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getPackageDescription() {
		return packageDescription;
	}

	public void setPackageDescription(String packageDescription) {
		this.packageDescription = packageDescription;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public PoojaPackageFeature getPackageFeatures() {
		return packageFeatures;
	}

	public void setPackageFeatures(PoojaPackageFeature packageFeatures) {
		this.packageFeatures = packageFeatures;
	}
}
