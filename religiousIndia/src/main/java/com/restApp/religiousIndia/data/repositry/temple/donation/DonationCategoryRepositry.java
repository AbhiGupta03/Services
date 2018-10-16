package com.restApp.religiousIndia.data.repositry.temple.donation;

import org.springframework.data.repository.CrudRepository;

import com.restApp.religiousIndia.data.entities.temple.donation.TempleDonationCategory;

public interface DonationCategoryRepositry extends CrudRepository<TempleDonationCategory, String> {
	Iterable<TempleDonationCategory> findByisActive(String isActive);
}
