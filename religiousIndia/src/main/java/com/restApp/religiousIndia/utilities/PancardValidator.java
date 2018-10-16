package com.restApp.religiousIndia.utilities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

public class PancardValidator {
	private static Logger logger = Logger.getLogger(PancardValidator.class);
	private static final String PAN_REGEX = "[A-Z]{5}[0-9]{4}[A-Z]{1}";

	// static Pattern object, since pattern is fixed
	private static Pattern pattern;

	// non-static Matcher object because it's created from the input String
	private static Matcher matcher;

	public PancardValidator() {

	}

	/**
	 * This method validates the input email address with EMAIL_REGEX pattern
	 * 
	 * @param email
	 * @return boolean
	 */

	public static boolean validatePan(String pan) {
		logger.info("Validatin pancard No");

		// initialize the Pattern object
		pattern = Pattern.compile(PAN_REGEX, Pattern.CASE_INSENSITIVE);
		matcher = pattern.matcher(pan);
		return matcher.matches();
	}
}
