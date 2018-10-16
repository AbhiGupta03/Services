package com.restApp.religiousIndia.data.repositry.poojeServices;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.restApp.religiousIndia.data.entities.pooja.PoojaBookingDetails;

public interface PoojaBookingDetailsRepositry extends CrudRepository<PoojaBookingDetails, Integer> {
	public List<PoojaBookingDetails> findByisActiveAndPanditId(String isActive, String panditId);

}
