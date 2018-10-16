package com.restApp.religiousIndia.data.repositry.users;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.restApp.religiousIndia.data.entities.users.UserDetailsImpl;

public interface UserDetailsRepositry extends CrudRepository<UserDetailsImpl, Integer> {
	Optional<UserDetailsImpl> findByEmail(String mailId);

	UserDetailsImpl findByUserId(Integer id);

	UserDetailsImpl findByPanditId(String panditId);

	List<UserDetailsImpl> findByUserIdIn(List<Integer> userId);
	
	List<UserDetailsImpl> findByAddressIdIn(List<String> addressId);

	List<UserDetailsImpl> findByisActiveAndFirstNameContainingOrIsActiveAndMiddleNameContainingOrIsActiveAndLastNameContaining(String isActive,
			String firstName,String isActive1, String middleName,String isActive2, String lastName);
}
