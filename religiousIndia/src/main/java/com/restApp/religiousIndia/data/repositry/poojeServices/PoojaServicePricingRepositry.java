package com.restApp.religiousIndia.data.repositry.poojeServices;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.restApp.religiousIndia.data.entities.pooja.PoojaServicesPricing;
import com.restApp.religiousIndia.utilities.compositePrimary.PoojaServicePricingPrimaryKey;

public interface PoojaServicePricingRepositry
		extends JpaRepository<PoojaServicesPricing, PoojaServicePricingPrimaryKey> {

	static String Pooja_Packages = "select * from ri_pooja_services_pricing where service_id=?1 and is_active=1";

	@Query(value = Pooja_Packages, nativeQuery = true)
	public List<PoojaServicesPricing> findPoojaPackages(String poojaServiceId);
}
