package com.restApp.religiousIndia.data.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RI_Cities")
public class Cities implements Comparable<Cities> {

	@Id
	private Long id;

	@Column(name = "cityname")
	private String cityName;
	private String state;

	private int popular;

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	@Override
	public String toString() {
		return "Cities [id=" + id + ", cityName=" + cityName + ", state=" + state + ", popular=" + popular + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPopular() {
		return popular;
	}

	public void setPopular(int popular) {
		this.popular = popular;
	}

	@Override
	public int compareTo(Cities comparesto) {
		int comparepoPularity = (comparesto).getPopular();
		return comparepoPularity - this.popular;
	}
}