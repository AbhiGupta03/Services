package com.restApp.religiousIndia.data.repositry.users;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.restApp.religiousIndia.data.entities.users.UserLocation;

public interface UserLocationRepositry extends CrudRepository<UserLocation, String> {

	@Procedure(name = "get_user_location")
	String getUserLocationFromProc(@Param("userId") Integer userId);
}
