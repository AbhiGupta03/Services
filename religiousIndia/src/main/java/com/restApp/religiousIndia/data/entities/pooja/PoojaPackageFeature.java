package com.restApp.religiousIndia.data.entities.pooja;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "ri_pooja_package_features")
public class PoojaPackageFeature {

	@Version
	private int versionId;

	@Id
	@GenericGenerator(name = "sequence__id", strategy = "com.restApp.religiousIndia.utilities.PoojaPackageIdGenrator")
	@Column(name = "POOJA_PACKAGE_CATEGORY_ID")
	private String pacjageId;

	@Column(name = "POOJA_INCLUDED")
	private String poojaIncluded;

	@Column(name = "POOJA_SAMAGRI_INCLUDED")
	private String poojaSamagriInculded;

	@Column(name = "POOJA_VIDEO_INCLUDED")
	private String poojaVideoIncluded;

	@Column(name = "POOJA_PHOTOS_INCLUDED")
	private String poojaPhotoIncluded;

	@Column(name = "POOJA_MEDIA_CONTENT_ONLINE_UPLOAD")
	private String mediaOnlineUpdate;

	@Column(name = "CUSTOMER_SUPPORT")
	private String customerSupport;

	@Column(name = "PACKAGE_DESCRIPTION")
	private String packageDescription;

	@Column(name = "REWARD_POINTS")
	private String rewardPointsInThis;

	@Column(name = "LIVE_POOJA_VIDEO_STREAM")
	private String liveVideoStream;

	@Column(name = "DISCOUNT_ON_NEXT_SERVICE")
	private String discountOnNextService;

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

	public String getPoojaIncluded() {
		return poojaIncluded;
	}

	public void setPoojaIncluded(String poojaIncluded) {
		this.poojaIncluded = poojaIncluded;
	}

	public String getPoojaSamagriInculded() {
		return poojaSamagriInculded;
	}

	public void setPoojaSamagriInculded(String poojaSamagriInculded) {
		this.poojaSamagriInculded = poojaSamagriInculded;
	}

	public String getPoojaVideoIncluded() {
		return poojaVideoIncluded;
	}

	public void setPoojaVideoIncluded(String poojaVideoIncluded) {
		this.poojaVideoIncluded = poojaVideoIncluded;
	}

	public String getPoojaPhotoIncluded() {
		return poojaPhotoIncluded;
	}

	public void setPoojaPhotoIncluded(String poojaPhotoIncluded) {
		this.poojaPhotoIncluded = poojaPhotoIncluded;
	}

	public String getMediaOnlineUpdate() {
		return mediaOnlineUpdate;
	}

	public void setMediaOnlineUpdate(String mediaOnlineUpdate) {
		this.mediaOnlineUpdate = mediaOnlineUpdate;
	}

	public String getCustomerSupport() {
		return customerSupport;
	}

	public void setCustomerSupport(String customerSupport) {
		this.customerSupport = customerSupport;
	}

	public String getPackageDescription() {
		return packageDescription;
	}

	public void setPackageDescription(String packageDescription) {
		this.packageDescription = packageDescription;
	}

	public String getRewardPointsInThis() {
		return rewardPointsInThis;
	}

	public void setRewardPointsInThis(String rewardPointsInThis) {
		this.rewardPointsInThis = rewardPointsInThis;
	}

	public String getLiveVideoStream() {
		return liveVideoStream;
	}

	public void setLiveVideoStream(String liveVideoStream) {
		this.liveVideoStream = liveVideoStream;
	}

	public String getDiscountOnNextService() {
		return discountOnNextService;
	}

	public void setDiscountOnNextService(String discountOnNextService) {
		this.discountOnNextService = discountOnNextService;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

}
