package com.restApp.religiousIndia.data.repositry.users;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.restApp.religiousIndia.data.entities.users.Login;

public interface LogInRepositry extends JpaRepository<Login, String> {

	public Login findByUserIdAndPass(String id, String pass);

	public Optional<Login> findByUserId(String userId);

	public static final String saveAccessKey = "UPDATE RI_LOGIN_DETAILS SET ACCESS_KEY=?1 WHERE USER_ID=?2";

	@Transactional
	@Modifying
	@Query(value = saveAccessKey, nativeQuery = true)
	public void saveAccessKey(String accessKeyValue, String userID);
}
