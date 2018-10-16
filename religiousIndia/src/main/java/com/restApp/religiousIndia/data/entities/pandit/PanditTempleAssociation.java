package com.restApp.religiousIndia.data.entities.pandit;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "ri_pandit_temple_association")
public class PanditTempleAssociation {

	@Version
	private int versionId;

	@Id
	private String id;

	private String panditId;

	private String templeId;

	private String isListedTemple;

	@Column(name = "PANDIT_POST_IN_TEMPLE")
	private String panditPostInTemple;

	private String isActive;

	public int getVersionId() {
		return versionId;
	}

	public void setVersionId(int versionId) {
		this.versionId = versionId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getIsListedTemple() {
		return isListedTemple;
	}

	public void setIsListedTemple(String isListedTemple) {
		this.isListedTemple = isListedTemple;
	}

	public String getPanditPostInTemple() {
		return panditPostInTemple;
	}

	public void setPanditPostInTemple(String panditPostInTemple) {
		this.panditPostInTemple = panditPostInTemple;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
}
