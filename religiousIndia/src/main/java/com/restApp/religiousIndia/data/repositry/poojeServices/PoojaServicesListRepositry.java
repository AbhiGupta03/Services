package com.restApp.religiousIndia.data.repositry.poojeServices;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.restApp.religiousIndia.data.entities.pooja.Pooja;
import com.restApp.religiousIndia.data.entities.pooja.PoojaServicesList;

public interface PoojaServicesListRepositry extends CrudRepository<PoojaServicesList, String> {
	List<Pooja> findByisActive(String isActive);

	public static String Service_Name_Query = "select service_name from ri_pooja_services_list";

	@Query(value = Service_Name_Query, nativeQuery = true)
	List<String> getAllServicesName();
}
