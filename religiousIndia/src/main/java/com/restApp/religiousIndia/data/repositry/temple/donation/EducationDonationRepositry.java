package com.restApp.religiousIndia.data.repositry.temple.donation;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.restApp.religiousIndia.data.entities.temple.donation.EducationDonation;

public interface EducationDonationRepositry extends CrudRepository<EducationDonation, String> {
	ArrayList<EducationDonation> findByTempleId(String templeId);
}
