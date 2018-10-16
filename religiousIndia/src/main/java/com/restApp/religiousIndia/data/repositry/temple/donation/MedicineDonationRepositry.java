package com.restApp.religiousIndia.data.repositry.temple.donation;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.restApp.religiousIndia.data.entities.temple.donation.MedicineDonation;

public interface MedicineDonationRepositry extends CrudRepository<MedicineDonation, String> {
	ArrayList<MedicineDonation> findByTempleId(String templeId);
}
