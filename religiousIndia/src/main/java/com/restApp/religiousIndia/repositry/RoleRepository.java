package com.restApp.religiousIndia.repositry;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restApp.religiousIndia.model.Role;
import com.restApp.religiousIndia.model.roleName.RoleName;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
	Optional<Role> findByName(RoleName roleName);

	Optional<Role> findByRoleId(Integer roleId);
}
