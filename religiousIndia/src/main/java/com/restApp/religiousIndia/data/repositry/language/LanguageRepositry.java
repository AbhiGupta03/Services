package com.restApp.religiousIndia.data.repositry.language;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restApp.religiousIndia.data.entities.language.PanditLanguage;

public interface LanguageRepositry extends JpaRepository<PanditLanguage, Integer> {

	List<PanditLanguage> findByisActiveAndPanditId(String isActive, String panditId);

}
