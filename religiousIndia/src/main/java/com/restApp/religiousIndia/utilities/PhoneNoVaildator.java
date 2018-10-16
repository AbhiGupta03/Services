package com.restApp.religiousIndia.utilities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

public class PhoneNoVaildator {
	private static Logger logger = Logger.getLogger(PhoneNoVaildator.class);

	private static final String PHONE_REGEX = "(0/91)?[7-9][0-9]{9}";

	// static Pattern object, since pattern is fixed
	private static Pattern pattern;

	// non-static Matcher object because it's created from the input String
	private static Matcher matcher;

	public PhoneNoVaildator() {

	}

	/**
	 * This method validates the input email address with EMAIL_REGEX pattern
	 * 
	 * @param email
	 * @return boolean
	 */

	public static boolean validatePhone(String phoneNo) {
		logger.info("Validating Phone No");

		// initialize the Pattern object
		pattern = Pattern.compile(PHONE_REGEX);
		
		matcher = pattern.matcher(phoneNo);
		return matcher.find() && matcher.group().equals(phoneNo);
	}

}
