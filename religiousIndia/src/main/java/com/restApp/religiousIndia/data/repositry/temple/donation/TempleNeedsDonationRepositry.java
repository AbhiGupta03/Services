package com.restApp.religiousIndia.data.repositry.temple.donation;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.restApp.religiousIndia.data.entities.temple.donation.TempleNeedsDonation;

public interface TempleNeedsDonationRepositry extends CrudRepository<TempleNeedsDonation, String> {
	ArrayList<TempleNeedsDonation> findByTempleId(String templeId);

	TempleNeedsDonation findByDonationSubCategoryId(String donationSubCategoryId);
}
