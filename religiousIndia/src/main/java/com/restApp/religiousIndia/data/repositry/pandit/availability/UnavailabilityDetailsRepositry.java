package com.restApp.religiousIndia.data.repositry.pandit.availability;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.restApp.religiousIndia.data.entities.pandit.availability.UnavailabilityDetails;

public interface UnavailabilityDetailsRepositry extends CrudRepository<UnavailabilityDetails, Double> {

	public List<UnavailabilityDetails> findByisActiveAndPanditId(String isActive, String panditId);

}
