package com.restApp.religiousIndia.data.repositry.temple.donation;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.restApp.religiousIndia.data.entities.temple.donation.FoodDonation;

public interface FoodDonationRepositry extends CrudRepository<FoodDonation, String> {
	ArrayList<FoodDonation> findByTempleId(String templeId);

}
