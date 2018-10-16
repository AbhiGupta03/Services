package com.restApp.religiousIndia.data.repositry;

import org.springframework.data.repository.CrudRepository;

import com.restApp.religiousIndia.data.entities.Image;

public interface ImagesRepositry extends CrudRepository<Image, String> {
	
}
