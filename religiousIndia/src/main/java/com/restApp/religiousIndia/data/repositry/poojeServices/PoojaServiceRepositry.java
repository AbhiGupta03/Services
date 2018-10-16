package com.restApp.religiousIndia.data.repositry.poojeServices;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.restApp.religiousIndia.data.entities.pooja.Pooja;

public interface PoojaServiceRepositry extends CrudRepository<Pooja, String> {
	List<Pooja> findByisActiveAndTempleId(String isActive, String templeId);

	List<Pooja> findByisActive(String isActive);

	List<Pooja> findByServiceNameIn(List<String> serviceName);

	List<Pooja> findByisActiveAndPanditId(String isActive, String panditId);
}
