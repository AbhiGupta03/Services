package com.restApp.religiousIndia.utilities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

/**
 * Java email validation program
 * 
 * @author Abhishek Kumar Gupta
 *
 */
public class EmailValidator {
	private static Logger logger = Logger.getLogger(EmailValidator.class);

	// Email Regex java
	private static final String EMAIL_REGEX = "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";

	// static Pattern object, since pattern is fixed
	private static Pattern pattern;

	// non-static Matcher object because it's created from the input String
	private static Matcher matcher;

	public EmailValidator() {

	}

	/**
	 * This method validates the input email address with EMAIL_REGEX pattern
	 * 
	 * @param email
	 * @return boolean
	 */

	public static boolean validateEmail(String email) {
		logger.info("Validating Email address");

		// initialize the Pattern object
		pattern = Pattern.compile(EMAIL_REGEX, Pattern.CASE_INSENSITIVE);

		matcher = pattern.matcher(email);
		return matcher.matches();
	}
}