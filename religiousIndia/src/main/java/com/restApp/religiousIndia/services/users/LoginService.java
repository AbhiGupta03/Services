package com.restApp.religiousIndia.services.users;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.restApp.religiousIndia.data.entities.users.Login;
import com.restApp.religiousIndia.data.entities.users.UserDetailsImpl;
import com.restApp.religiousIndia.data.entities.users.password.PasswordOTPDetails;
import com.restApp.religiousIndia.data.repositry.users.LogInRepositry;
import com.restApp.religiousIndia.data.repositry.users.password.PasswordOTPRepositry;
import com.restApp.religiousIndia.exception.AppException;
import com.restApp.religiousIndia.model.Role;
import com.restApp.religiousIndia.model.roleName.RoleName;
import com.restApp.religiousIndia.repositry.RoleRepository;
import com.restApp.religiousIndia.request.filter.PostRequestWithOutArray;
import com.restApp.religiousIndia.response.Response;
import com.restApp.religiousIndia.response.status.ResponseStatus;
import com.restApp.religiousIndia.security.JwtTokenProvider;
import com.restApp.religiousIndia.utilities.EmailValidator;
import com.restApp.religiousIndia.utilities.OTPGenrator;
import com.restApp.religiousIndia.utilities.exception.UserNotSavedException;

@Service
public class LoginService {
	private static Logger logger = Logger.getLogger(LoginService.class);

	@Autowired
	LogInRepositry logInRepositry;

	@Autowired
	PasswordOTPRepositry passwordOTPRepositry;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	UserServices userServices;

	@Autowired
	JwtTokenProvider tokenProvider;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	AuthenticationManager authenticationManager;

	public String saveLogInDetails(Login login) {
		String base64Pass = passwordEncoder.encode(login.getPass());
		login.setPass(base64Pass);
		if (!logInRepositry.exists(login.getUserId())) {
			String passwordHistory = maintainPasswordHistory(base64Pass, login).toString();
			login.setPasswordHistory(passwordHistory);
			Login save = logInRepositry.save(login);
			if (save != null) {
				return "1";
			} else {
				logger.info("Unable to save the record");
				return "-1";
			}
		}
		return "0";
	}

	public void removeLogIn(Login login) {
		logger.info("Removing user login for userId:" + login.getUserId());
		if (logInRepositry.exists(login.getUserId())) {
			logInRepositry.delete(login);
		}
	}

	public String logIn(String id, String pwd) {
		logger.info("logIn request for userId:" + id);
		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(id, pwd));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		return tokenProvider.generateToken(authentication);
	}

	public Response resetPassword(String userId, String oldPwd, String newPwd) {
		logger.info("Reset password request for userId:" + userId);
		Response response = new Response();
		try {
			if (logInRepositry.exists(userId)) {
				Login login = logInRepositry.findByUserId(userId).orElse(null);
				String storedPwd = login.getPass();

				boolean isPwdMatched = passwordEncoder.matches(oldPwd, storedPwd);
				if (isPwdMatched) {
					response = changePassword(userId, newPwd);
				} else {
					logger.info("Old Password not matched for userId:" + userId);
					response.setStatus(ResponseStatus.INVALID);
					response.setResponse("Old password not matched");
				}
			} else {
				logger.info("userId:" + userId + " does not exists");
				response.setStatus(ResponseStatus.INVALID);
				response.setResponse("Id or pass not matched");
			}
		} catch (Exception e) {
			logger.error("Error:" + e + " in resetPassword");
			response.setStatus(ResponseStatus.INTERNAL_SERVER_ERROR);
			response.setResponse("Something went wrong.Please try after some time");
		}

		return response;
	}

	public Response forgetPasswordOTP(String userId) {
		logger.info("Forget password OTP request for userId:" + userId);

		Response response = new Response();

		if (logInRepositry.exists(userId)) {
			// To generate 6 digits OTP
			String OTP = OTPGenrator.generateOTP(6);
			// Save OTP in table
			PasswordOTPDetails passwordDetails = new PasswordOTPDetails();
			passwordDetails.setOTP(OTP);
			passwordDetails.setUserId(userId);
			passwordDetails.setCreatedOn(new Date());

			passwordOTPRepositry.save(passwordDetails);
			response.setStatus(ResponseStatus.OK);
			response.setResponse(OTP);
		} else {
			response.setStatus(ResponseStatus.INVALID);
			response.setResponse("User doest'nt exists");
		}
		return response;
	}

	private String[] getHistoryPassword(Login login) {
		logger.info("getting Password history");
		String passwordHistoryJson = login.getPasswordHistory();

		if (passwordHistoryJson != null) {
			try {
				JSONArray passwordHistoryJsonArray = new JSONArray(passwordHistoryJson);
				int length = passwordHistoryJsonArray.length();
				JSONObject passwordHistoryJsonObject = null;

				String pass[] = new String[3];
				for (int i = 0; i < length; i++) {
					passwordHistoryJsonObject = (JSONObject) passwordHistoryJsonArray.get(i);
					pass[i] = (String) passwordHistoryJsonObject.get("pass");

				}
				return pass;
			} catch (Exception e) {
				logger.error("Error:" + e + " in getHistoryPassword");
				return null;
			}
		} else {
			return null;
		}
	}

	private JSONArray maintainPasswordHistory(String latestPwd, Login login) {
		logger.info("Maintaing Password history");

		// This method will allow only last 3 password to be maintained
		String passwordHistoryJson = login.getPasswordHistory();

		if (passwordHistoryJson == null || passwordHistoryJson.length() == 0) {
			// For the case of signUp
			try {
				JSONArray jsonArray = new JSONArray();
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("pass", latestPwd);
				jsonArray.put(jsonObject);
				return jsonArray;
			} catch (JSONException e) {
				e.printStackTrace();
				return null;
			}

		} else {
			try {
				// Add latest password to the history JSON Object
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("pass", latestPwd);
				JSONArray passwordHistoryJsonArray = new JSONArray(passwordHistoryJson);

				int length = passwordHistoryJsonArray.length();

				if (length == 3 || length == 2) {
					passwordHistoryJsonArray.put(2, passwordHistoryJsonArray.get(1));
					passwordHistoryJsonArray.put(1, passwordHistoryJsonArray.get(0));
				} else if (length == 1) {
					passwordHistoryJsonArray.put(1, passwordHistoryJsonArray.get(0));
				}
				passwordHistoryJsonArray.put(0, jsonObject);

				return passwordHistoryJsonArray;

			} catch (Exception e) {
				logger.error("Error:" + e + " in maintainPasswordHistory");
				return null;
			}
		}
	}

	public Response changePassword(String userId, String pwd) {
		logger.info("Change password request for userId:" + userId);
		Response response = new Response();

		// pwd = passwordEncoder.encode(pwd);

		Login userLogin = logInRepositry.findOne(userId);

		String[] historyPassword = getHistoryPassword(userLogin);
		Boolean isFoundInHistory = false;
		for (String password : historyPassword) {
			if (passwordEncoder.matches(pwd, password)) {
				isFoundInHistory = true;
				break;
			}
		}
		if (isFoundInHistory) {
			response.setStatus(ResponseStatus.INVALID);
			response.setResponse("New Password should not be same as your last-3 password");
		} else {
			pwd = passwordEncoder.encode(pwd);
			userLogin.setPass(pwd);
			userLogin.setPasswordHistory(maintainPasswordHistory(pwd, userLogin).toString());
			userLogin.setAccessKey(null);
			logInRepositry.save(userLogin);

			response.setStatus(ResponseStatus.OK);
			response.setResponse("Password Changed Successfully.");
			logger.info("Password Changed Successfully for userID:" + userId);
		}
		return response;
	}

	public Response verifyOTP(String otp, String userId) {
		logger.info("Verfing OTP for userId:" + userId);
		Response response = new Response();
		// Find out latest OTP send send to userId
		PasswordOTPDetails otpDetails = passwordOTPRepositry.findOTP(userId);

		if (otpDetails != null) {
			// Check the OTP matched with the latest one or not
			if (otp.equals(otpDetails.getOTP())) {
				// Validate OTP Time (Check for the OTP time within 5min)
				double timeDiff = ((new Date().getTime()) - (otpDetails.getCreatedOn().getTime())) / 300000;
				if (timeDiff > 5.0) {
					response.setStatus(ResponseStatus.INVALID);
					response.setResponse("OTP Expired");
				} else {
					// Clear used OTP from DB.(1 OTP could be used only once.)
					otpDetails.setOTP("");
					passwordOTPRepositry.save(otpDetails);
					String accessKeyValue = OTPGenrator.generateOTP(4);
					Map<String, String> accessKey = new HashMap<>(1);
					accessKey.put("Access_Key", accessKeyValue);
					logInRepositry.saveAccessKey(accessKeyValue, userId);
					response.setStatus(ResponseStatus.OK);
					response.setResponse(accessKey);
				}
			} else {
				response.setStatus(ResponseStatus.INVALID);
				response.setResponse("OTP Invalid");
			}
		} else {
			response.setResponse("Please send the OTP and try again.");
			response.setStatus(ResponseStatus.NO_DATA_FOUND);
		}
		return response;
	}

	// To delete old OTP from DB
	public void clearOldOtp() {
		passwordOTPRepositry.delete10MinOldOtp();
	}

	@Transactional
	public Response signUp(@Valid PostRequestWithOutArray signUpRequest) {
		Response response = new Response();
		Login login = new Login();
		Map<String, String> requestParam = signUpRequest.getRequestParam();

		if (signUpRequest.getRequestType().equalsIgnoreCase("signUp")) {
			if (requestParam.size() != 0) {
				String email = requestParam.get("id");
				String pwd = requestParam.get("pwd");
				String logInType = requestParam.get("logInType");
				String roleId = requestParam.get("roleId");

				// Validate the request
				if (email == null || email.equals("")) {
					logger.debug("Sign up Request is not valid");

					response.setStatus(ResponseStatus.BAD_REQUEST);
					response.setResponse("Not a valid request");
					return response;
				}

				login.setIsActive("1");

				// Validating Email
				boolean isValidEmail = EmailValidator.validateEmail(email);
				if (!isValidEmail) {
					logger.info("Email Id is not valid");
					response.setStatus(ResponseStatus.ERROR);
					response.setResponse("Not a valid MailId");
					return response;
				}

				login.setLoginTypeId(logInType);
				login.setPass(pwd);
				login.setUserId(email);
				Role userRole = null;
				if (roleId != null) {
					userRole = roleRepository.findByRoleId(Integer.parseInt(roleId))
							.orElseThrow(() -> new AppException("User Role not set."));
				} else {
					// default userRole id User
					userRole = roleRepository.findByName(RoleName.ROLE_USER)
							.orElseThrow(() -> new AppException("User Role not set."));
				}
				login.setRoles(Collections.singleton(userRole));
				String details = saveLogInDetails(login);

				if (details.equalsIgnoreCase("-1")) {
					logger.error("Unable to save the data");
					response.setStatus(ResponseStatus.INTERNAL_SERVER_ERROR);
					response.setResponse("Something went wrong");
					return response;
				}
				if (details.equalsIgnoreCase("0")) {
					logger.debug("Duplicate Email ID");
					response.setStatus(ResponseStatus.ERROR);
					response.setResponse("Email ID Exists");
					return response;
				}
				if (details.equalsIgnoreCase("1")) {
					Map<String, String> map = new HashMap<>();

					map.put("fName", requestParam.get("fName"));
					map.put("lName", requestParam.get("lName"));
					map.put("gender", requestParam.get("gender"));
					map.put("roleId", requestParam.get("roleId"));
					map.put("email", requestParam.get("email"));

					response = createUserDetails(map);
					return response;
				}
			}
		} else {
			response.setStatus(ResponseStatus.BAD_REQUEST);
			response.setResponse("Request param not valid");
		}
		return response;

	}

	public Response createUserDetails(Map<String, String> map) {
		Response response = new Response();
		UserDetailsImpl userDetails = new UserDetailsImpl();
		userDetails.setEmail(map.get("email"));
		String fName = map.get("fName");
		if (fName == null) {
			response.setStatus(ResponseStatus.ERROR);
			response.setResponse("Please enter your name");
			return response;
		}
		String[] name = fName.split(" ");
		userDetails.setFirstName(name[0]);
		if (name.length >= 2) {
			userDetails.setMiddleName(name[1]);
		} else {
			userDetails.setMiddleName("");
		}

		String LName = map.get("lName");
		if (LName != null) {
			userDetails.setLastName(LName);
		} else {
			userDetails.setLastName("");
		}

		userDetails.setPrimaryPhone(map.get("contactNo"));
		userDetails.setGender(map.get("gender"));
		userDetails.setUserRoleDetails(map.get("roleId"));

		try {
			Integer userId = userServices.saveUserPrimaryDetails(userDetails);
			response.setStatus(ResponseStatus.OK);
			response.setResponse(userDetails);
		} catch (UserNotSavedException e) {
			logger.error("Error:" + e);
			response.setStatus(ResponseStatus.ERROR);
			response.setResponse("UserNotSavedException");
			return response;
		} catch (Exception e) {
			logger.error("Error:" + e);
			response.setStatus(ResponseStatus.ERROR);
			response.setResponse("User Not saved ");
			return response;
		}
		return response;
	}
}
