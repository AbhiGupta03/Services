package com.restApp.religiousIndia.utilities;

import java.util.Random;

public class OTPGenrator {

	public static String generateOTP(int otpLength) {
		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		Random random = new Random();
		int length = characters.length();
		StringBuilder OTP = new StringBuilder(otpLength);
		for (int i = 0; i < otpLength; i++) {
			OTP.append(characters.charAt(random.nextInt(length)));
		}

		return OTP.toString();
	}
}
