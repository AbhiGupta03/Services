package com.restApp.religiousIndia.data.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.restApp.religiousIndia.utilities.audits.AuditFields;

@Entity
@Table(name = "RI_ADDRESS")
public class Address extends AuditFields<String> {
	@Id
	@Column(name = "ADDRESS_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer addressID;

	private String state;

	private String dist;

	@Override
	public String toString() {
		return "{'addressID':'" + addressID + "', 'state':'" + state + "', 'dist':'" + dist + "', 'city':'" + city
				+ "', 'addressContactNo':'" + contactNo + "', 'addressDetail':'" + addressDetail
				+ "', 'isTempleAddress':'" + isTempleAddress + "', 'isActive':'" + isActive + "', 'pincode':'" + pincode
				+ "', 'cityId':'" + cityId + "'}";
	}

	private String city;

	private String contactNo;

	@Column(name = "ADDRESS_DETAIL")
	private String addressDetail;

	@Column(name = "IS_TEMPLE_ADDRESS")
	private String isTempleAddress;

	private String isActive;

	private String pincode;

	@Column(name = "City_Id")
	private String cityId;

	public int getId() {
		return addressID;
	}

	public void setId(int id) {
		this.addressID = id;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDist() {
		return dist;
	}

	public void setDist(String dist) {
		this.dist = dist;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddressDetail() {
		return addressDetail;
	}

	public void setAddressDetail(String addressDetail) {
		this.addressDetail = addressDetail;
	}

	public String getIsTempleAddress() {
		return isTempleAddress;
	}

	public void setIsTempleAddress(String isTempleAddress) {
		this.isTempleAddress = isTempleAddress;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

}
