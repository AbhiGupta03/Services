package com.restApp.religiousIndia.data.repositry.temple.donation;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.restApp.religiousIndia.data.entities.temple.donation.ClothesDonation;

public interface ClothDonationRepositry extends CrudRepository<ClothesDonation, String> {
	ArrayList<ClothesDonation> findByTempleId(String templeId);
}
