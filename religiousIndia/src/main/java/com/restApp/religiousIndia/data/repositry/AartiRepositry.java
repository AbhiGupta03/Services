package com.restApp.religiousIndia.data.repositry;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.restApp.religiousIndia.data.entities.temple.Aarti;

public interface AartiRepositry extends CrudRepository<Aarti, String> {
	List<Aarti> findByIsActiveAndTempleId(String isActive, String templeID);
	
	List<Aarti> findByTempleIdIn(List<String> aartiIdList);
}
