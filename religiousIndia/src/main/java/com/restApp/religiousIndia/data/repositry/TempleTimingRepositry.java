package com.restApp.religiousIndia.data.repositry;

import org.springframework.data.repository.CrudRepository;

import com.restApp.religiousIndia.data.entities.TempleTimings;

public interface TempleTimingRepositry extends CrudRepository<TempleTimings, String>{
	TempleTimings findByIsActiveAndTempleID(String isActive, String templeID);
}
