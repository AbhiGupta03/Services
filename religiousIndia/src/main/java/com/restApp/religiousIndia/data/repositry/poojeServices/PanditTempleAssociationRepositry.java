package com.restApp.religiousIndia.data.repositry.poojeServices;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.restApp.religiousIndia.data.entities.pandit.PanditTempleAssociation;

public interface PanditTempleAssociationRepositry extends CrudRepository<PanditTempleAssociation, String> {
	List<PanditTempleAssociation> findByIsActiveAndTempleId(String isActive, String templeId);
}
