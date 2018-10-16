package com.restApp.religiousIndia.data.entities.language;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import com.restApp.religiousIndia.utilities.audits.AuditFields;

@Entity
@Table(name = "RI_PANDIT_LANGUAGE_MAPPING")
public class PanditLanguage extends AuditFields<String> {

	@Version
	private long versionId;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@OneToOne
	@JoinColumn(name = "language_id")
	private Languages languages;

	private String panditId;

	private String isActive;

	public long getVersionId() {
		return versionId;
	}

	public void setVersionId(long versionId) {
		this.versionId = versionId;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public Languages getLanguages() {
		return languages;
	}

	public void setLanguages(Languages languages) {
		this.languages = languages;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPanditId() {
		return panditId;
	}

	public void setPanditId(String panditId) {
		this.panditId = panditId;
	}
}
