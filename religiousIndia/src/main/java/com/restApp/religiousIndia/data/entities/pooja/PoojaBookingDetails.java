package com.restApp.religiousIndia.data.entities.pooja;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import com.restApp.religiousIndia.data.entities.language.Languages;
import com.restApp.religiousIndia.utilities.audits.AuditFields;

@Entity
@Table(name = "ri_pooja_bookings_details")
public class PoojaBookingDetails extends AuditFields<String> {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer poojaBookingId;

	@Version
	private int versionId;

	@Column(nullable = false, name = "USER_ID")
	private String userId;

	@Column(nullable = false, name = "PANDIT_ID")
	private String panditId;

	@Column(name = "POOJA_ADD_ON_ID")
	private String poojaAddOnId;

	@OneToOne
	@JoinColumn(name = "POOJA_MODE_ID")
	private PoojaModes poojaMode;

	private String poojaDesc;

	public Integer getPoojaBookingId() {
		return poojaBookingId;
	}

	public void setPoojaBookingId(Integer poojaBookingId) {
		this.poojaBookingId = poojaBookingId;
	}

	public int getVersionId() {
		return versionId;
	}

	public void setVersionId(int versionId) {
		this.versionId = versionId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPanditId() {
		return panditId;
	}

	public void setPanditId(String panditId) {
		this.panditId = panditId;
	}

	public String getPoojaAddOnId() {
		return poojaAddOnId;
	}

	public void setPoojaAddOnId(String poojaAddOnId) {
		this.poojaAddOnId = poojaAddOnId;
	}

	public PoojaModes getPoojaMode() {
		return poojaMode;
	}

	public void setPoojaMode(PoojaModes poojaMode) {
		this.poojaMode = poojaMode;
	}

	public String getPoojaServicesSubCategoryId1() {
		return poojaServicesSubCategoryId1;
	}

	public void setPoojaServicesSubCategoryId1(String poojaServicesSubCategoryId1) {
		this.poojaServicesSubCategoryId1 = poojaServicesSubCategoryId1;
	}

	public String getPoojaServicesSubCategoryId2() {
		return poojaServicesSubCategoryId2;
	}

	public void setPoojaServicesSubCategoryId2(String poojaServicesSubCategoryId2) {
		this.poojaServicesSubCategoryId2 = poojaServicesSubCategoryId2;
	}

	public String getPoojaMediaDetailsId() {
		return poojaMediaDetailsId;
	}

	public void setPoojaMediaDetailsId(String poojaMediaDetailsId) {
		this.poojaMediaDetailsId = poojaMediaDetailsId;
	}

	public String getPoojaCommunicationId() {
		return poojaCommunicationId;
	}

	public void setPoojaCommunicationId(String poojaCommunicationId) {
		this.poojaCommunicationId = poojaCommunicationId;
	}

	public String getTiming() {
		return timing;
	}

	public void setTiming(String timing) {
		this.timing = timing;
	}

	public Date getDateConducted() {
		return dateConducted;
	}

	public void setDateConducted(Date dateConducted) {
		this.dateConducted = dateConducted;
	}

	public Date getDateBooked() {
		return dateBooked;
	}

	public void setDateBooked(Date dateBooked) {
		this.dateBooked = dateBooked;
	}

	public String getIsMultiDays() {
		return isMultiDays;
	}

	public void setIsMultiDays(String isMultiDays) {
		this.isMultiDays = isMultiDays;
	}

	public String getNoOfDays() {
		return noOfDays;
	}

	public void setNoOfDays(String noOfDays) {
		this.noOfDays = noOfDays;
	}

	public String getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}

	public String getIsOutStation() {
		return isOutStation;
	}

	public void setIsOutStation(String isOutStation) {
		this.isOutStation = isOutStation;
	}

	public String getOutStationLocation() {
		return outStationLocation;
	}

	public void setOutStationLocation(String outStationLocation) {
		this.outStationLocation = outStationLocation;
	}

	public String getPoojaStatusId() {
		return poojaStatusId;
	}

	public void setPoojaStatusId(String poojaStatusId) {
		this.poojaStatusId = poojaStatusId;
	}

	public Languages getPoojaLanguage() {
		return poojaLanguage;
	}

	public void setPoojaLanguage(Languages pooja_LanguagsId) {
		this.poojaLanguage = pooja_LanguagsId;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public String getCancellationId() {
		return cancellationId;
	}

	public void setCancellationId(String cancellationId) {
		this.cancellationId = cancellationId;
	}

	public String getUserReviewId() {
		return userReviewId;
	}

	public void setUserReviewId(String userReviewId) {
		this.userReviewId = userReviewId;
	}

	public Date getDateCompleted() {
		return dateCompleted;
	}

	public void setDateCompleted(Date dateCompleted) {
		this.dateCompleted = dateCompleted;
	}

	public String getPoojaDesc() {
		return poojaDesc;
	}

	public void setPoojaDesc(String poojaDesc) {
		this.poojaDesc = poojaDesc;
	}

	@Column(name = "POOJA_SERVICE_SUB_CATEGORY_ID_1")
	private String poojaServicesSubCategoryId1;

	@Column(name = "POOJA_SERVICE_SUB_CATEGORY_ID_2")
	private String poojaServicesSubCategoryId2;

	@Column(name = "POOJA_MEDIA_DETAILS_ID")
	private String poojaMediaDetailsId;

	@Column(name = "POOJA_COMMUNICATION_ID")
	private String poojaCommunicationId;

	private String timing;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATE_CONDUCTED")
	private Date dateConducted;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATE_BOOKED")
	private Date dateBooked;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATE_COMPLETED")
	private Date dateCompleted;

	@Column(name = "Is_Multi_Days")
	private String isMultiDays;

	@Column(name = "No_Of_Days")
	private String noOfDays;

	@Column(name = "PAYMENT_ID")
	private String paymentId;

	@Column(name = "Is_Out_Station")
	private String isOutStation;

	@Column(name = "OUTSTATION_LOCATION")
	private String outStationLocation;

	@Column(name = "POOJA_STATUS_ID")
	private String poojaStatusId;

	@OneToOne
	@JoinColumn(name = "POOJA_LANGUAGE")
	private Languages poojaLanguage;

	private String isActive;

	@Column(name = "CANCELLATION_ID")
	private String cancellationId;

	@Column(name = "USER_REVIEW_ID")
	private String userReviewId;

}
