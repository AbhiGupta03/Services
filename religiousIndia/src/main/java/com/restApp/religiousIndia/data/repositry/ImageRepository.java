package com.restApp.religiousIndia.data.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restApp.religiousIndia.data.entities.Images;

public interface ImageRepository extends JpaRepository<Images, Long> {
	
	Images findByImageId(String id);

}
