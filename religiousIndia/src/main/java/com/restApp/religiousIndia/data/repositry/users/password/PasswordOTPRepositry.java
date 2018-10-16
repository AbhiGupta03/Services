package com.restApp.religiousIndia.data.repositry.users.password;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.restApp.religiousIndia.data.entities.users.password.PasswordOTPDetails;

public interface PasswordOTPRepositry extends CrudRepository<PasswordOTPDetails, Integer> {
	public static final String CheckOTPValidity = "SELECT * FROM RI_USER_PASSWORD_OTP where USER_ID=?1  ORDER BY id DESC LIMIT 1";

	@Query(value = CheckOTPValidity, nativeQuery = true)
	public PasswordOTPDetails findOTP(String userId);

	public static final String delete10MinOldOtp = "DELETE FROM RI_USER_PASSWORD_OTP WHERE CREATED_ON < (NOW() - INTERVAL 10 MINUTE)";

	@Transactional
	@Modifying
	@Query(value = delete10MinOldOtp, nativeQuery = true)
	public void delete10MinOldOtp();
}
