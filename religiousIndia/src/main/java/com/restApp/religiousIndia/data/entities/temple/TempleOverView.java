package com.restApp.religiousIndia.data.entities.temple;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RI_TEMPLE_OVERVIEW")
public class TempleOverView {

	@Id
	private String templeId;

	@Column(columnDefinition = "TEXT", name = "TEMPLE_HISTORY")
	private String templeHistory;

	@Column(name = "TEMPLE_HAS_VIDEO")
	private String templeHasVideo;

	@Column(name = "Temple_VIDEO_LINK")
	private String templeVideoLink;

	@Column(name = "TEMPLE_INTRO_LINE")
	private String templeIntroLine;

	@Column(name = "TEMPLE_HISTORY_IMAGE")
	private String templeHistoryImage;

	@Column(columnDefinition = "TEXT", name = "TEMPLE_INTRO_DETAILS")
	private String templeIntroDetails;

	@Column(columnDefinition = "TEXT", name = "TEMPLE_MISSION_STMT_DETAILS")
	private String templeMissionStmtDetails;

	@Column(columnDefinition = "TEXT", name = "TEMPLE_SPECIAL_SERVICES_DETAILS")
	private String templeServicesDetails;

	private String isActive;

	public String getTempleId() {
		return templeId;
	}

	public void setTempleId(String templeId) {
		this.templeId = templeId;
	}

	public String getTempleHistory() {
		return templeHistory;
	}

	public void setTempleHistory(String templeHistory) {
		this.templeHistory = templeHistory;
	}

	public String getTempleHasVideo() {
		return templeHasVideo;
	}

	public void setTempleHasVideo(String templeHasVideo) {
		this.templeHasVideo = templeHasVideo;
	}

	public String getTempleVideoLink() {
		return templeVideoLink;
	}

	public void setTempleVideoLink(String templeVideoLink) {
		this.templeVideoLink = templeVideoLink;
	}

	public String getTempleIntroLine() {
		return templeIntroLine;
	}

	public void setTempleIntroLine(String templeIntroLine) {
		this.templeIntroLine = templeIntroLine;
	}

	public String getTempleIntroDetails() {
		return templeIntroDetails;
	}

	public void setTempleIntroDetails(String templeIntroDetails) {
		this.templeIntroDetails = templeIntroDetails;
	}

	public String getTempleMissionStmtDetails() {
		return templeMissionStmtDetails;
	}

	public void setTempleMissionStmtDetails(String templeMissionStmtDetails) {
		this.templeMissionStmtDetails = templeMissionStmtDetails;
	}

	public String getTempleServicesDetails() {
		return templeServicesDetails;
	}

	public void setTempleServicesDetails(String templeServicesDetails) {
		this.templeServicesDetails = templeServicesDetails;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public String getTempleHistoryImage() {
		return templeHistoryImage;
	}

	public void setTempleHistoryImage(String templeHistoryImage) {
		this.templeHistoryImage = templeHistoryImage;
	}
}
