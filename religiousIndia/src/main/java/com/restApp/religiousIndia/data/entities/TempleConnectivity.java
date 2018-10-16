package com.restApp.religiousIndia.data.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ri_temple_connectivity")
public class TempleConnectivity {

	@Id
	private String addressId;

	private String parkingLotDesc;

	private String nearestBusStand;

	private String nearestRailwayStation;

	
	private String nearestAirport;

	private String isActive;

	public String getAddressId() {
		return addressId;
	}

	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}

	public String getParkingLotDesc() {
		return parkingLotDesc;
	}

	public void setParkingLotDesc(String parkingLotDesc) {
		this.parkingLotDesc = parkingLotDesc;
	}

	public String getNearestBusStand() {
		return nearestBusStand;
	}

	public void setNearestBusStand(String nearestBusStand) {
		this.nearestBusStand = nearestBusStand;
	}

	public String getNearestRailwayStation() {
		return nearestRailwayStation;
	}

	public void setNearestRailwayStation(String nearestRailwayStation) {
		this.nearestRailwayStation = nearestRailwayStation;
	}

	public String getNearestAirport() {
		return nearestAirport;
	}

	public void setNearestAirport(String nearestAirport) {
		this.nearestAirport = nearestAirport;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "TempleConnectivity [addressId=" + addressId + ", parkingLotDesc=" + parkingLotDesc
				+ ", nearestBusStand=" + nearestBusStand + ", nearestRailwayStation=" + nearestRailwayStation
				+ ", nearestAirport=" + nearestAirport + ", isActive=" + isActive + "]";
	}

}
