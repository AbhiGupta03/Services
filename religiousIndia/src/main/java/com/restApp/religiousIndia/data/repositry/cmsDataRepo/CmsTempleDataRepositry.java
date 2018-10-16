package com.restApp.religiousIndia.data.repositry.cmsDataRepo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.restApp.religiousIndia.data.entities.cmsEntities.CmsTemple;

public interface CmsTempleDataRepositry extends CrudRepository<CmsTemple, String> {

	public Optional<List<CmsTemple>> findByIsVerified(String isVerFied);

	public Optional<CmsTemple> findByTempleName(String templeName);
}
