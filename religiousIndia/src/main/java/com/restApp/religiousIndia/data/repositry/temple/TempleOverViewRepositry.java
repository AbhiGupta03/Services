package com.restApp.religiousIndia.data.repositry.temple;

import org.springframework.data.repository.CrudRepository;

import com.restApp.religiousIndia.data.entities.temple.TempleOverView;

public interface TempleOverViewRepositry extends CrudRepository<TempleOverView, String> {

	public TempleOverView findBytempleIdAndIsActive(String templeId, String isActive);
}
