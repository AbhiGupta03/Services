package com.restApp.religiousIndia.data.repositry;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.restApp.religiousIndia.data.entities.Image;

public interface ImagesRepositry extends CrudRepository<Image, String> {

	public static final String latest_Images = "select * from ri_image having is_active=?1 order by updated_on  desc limit 10;";

	@Query(value = latest_Images, nativeQuery = true)
	public List<Image> getLatestUploadedImages(String isActive);
}
