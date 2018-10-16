package com.restApp.religiousIndia.data.repositry;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.restApp.religiousIndia.data.entities.HomeBanner;

public interface HomeBannerRepositry extends CrudRepository<HomeBanner, Long> {
		List<HomeBanner> findByisActiveEquals(String isActive);
}
