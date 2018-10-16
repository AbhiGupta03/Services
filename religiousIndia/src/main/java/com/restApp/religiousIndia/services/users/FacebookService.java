package com.restApp.religiousIndia.services.users;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.social.facebook.api.EducationExperience;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.Reference;
import org.springframework.social.facebook.api.User;
import org.springframework.social.facebook.api.impl.FacebookTemplate;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.OAuth2Operations;
import org.springframework.social.oauth2.OAuth2Parameters;
import org.springframework.stereotype.Service;

@Service
public class FacebookService {

	@Value("${spring.social.facebook.appId}")
	String facebookAppId;

	@Value("${spring.social.facebook.appSecret}")
	String facebookSecret;

	public String createFacebookAuthorizationURL() {
		FacebookConnectionFactory connectionFactory = new FacebookConnectionFactory(facebookAppId, facebookSecret);
		OAuth2Operations oauthOperations = connectionFactory.getOAuthOperations();
		OAuth2Parameters params = new OAuth2Parameters();
		params.setRedirectUri("http://localhost:8080/fb");
		params.setScope("public_profile,email,user_birthday,user_education_history,user_hometown");
		return oauthOperations.buildAuthorizeUrl(params);
	}

	public void createFacebookAccessToken(String code) {
		FacebookConnectionFactory connectionFactory = new FacebookConnectionFactory(facebookAppId, facebookSecret);
		AccessGrant accessGrant = connectionFactory.getOAuthOperations().exchangeForAccess(code,
				"http://localhost:8080/fb", null);
		String accessToken = accessGrant.getAccessToken();
	}

	public String getProfile(String accessToken) {
		Facebook facebook = new FacebookTemplate(accessToken);
		User profile = facebook.userOperations().getUserProfile();
		String email = profile.getEmail();
		List<EducationExperience> education = profile.getEducation();
		String userName = profile.getFirstName() + profile.getMiddleName() + profile.getLastName();
		Reference hometown = profile.getHometown();
		List<Reference> languages = profile.getLanguages();

		String[] fields = { "id", "name" };
		return facebook.fetchObject("me", String.class, fields);
	}

}