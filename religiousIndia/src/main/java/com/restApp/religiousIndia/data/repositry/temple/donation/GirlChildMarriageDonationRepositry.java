package com.restApp.religiousIndia.data.repositry.temple.donation;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.restApp.religiousIndia.data.entities.temple.donation.GirlChildMarriageDonation;

public interface GirlChildMarriageDonationRepositry extends CrudRepository<GirlChildMarriageDonation, String> {
	ArrayList<GirlChildMarriageDonation> findByTempleId(String templeId);
}
