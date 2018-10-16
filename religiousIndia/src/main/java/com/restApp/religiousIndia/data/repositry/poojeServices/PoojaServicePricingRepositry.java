package com.restApp.religiousIndia.data.repositry.poojeServices;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restApp.religiousIndia.data.entities.pooja.PoojaServicesPricing;
import com.restApp.religiousIndia.utilities.compositePrimary.PoojaServicePricingPrimaryKey;

public interface PoojaServicePricingRepositry
		extends JpaRepository<PoojaServicesPricing, PoojaServicePricingPrimaryKey> {
	

}
