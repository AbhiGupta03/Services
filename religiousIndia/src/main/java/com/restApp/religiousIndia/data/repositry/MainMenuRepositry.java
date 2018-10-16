package com.restApp.religiousIndia.data.repositry;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.restApp.religiousIndia.data.entities.MainMenuItem;


public interface MainMenuRepositry extends CrudRepository<MainMenuItem, String> {
	List<MainMenuItem> findByisActiveEquals(String isActive);
}
