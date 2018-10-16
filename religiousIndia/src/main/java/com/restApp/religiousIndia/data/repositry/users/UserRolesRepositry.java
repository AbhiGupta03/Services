package com.restApp.religiousIndia.data.repositry.users;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.restApp.religiousIndia.data.entities.users.UserRoles;
import com.restApp.religiousIndia.model.roleName.RoleName;

public interface UserRolesRepositry extends CrudRepository<UserRoles, String> {
	Optional<UserRoles> findByName(RoleName roleName);
}
