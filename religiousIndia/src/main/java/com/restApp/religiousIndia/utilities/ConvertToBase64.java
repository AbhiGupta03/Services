package com.restApp.religiousIndia.utilities;

import org.apache.commons.codec.binary.Base64;

public class ConvertToBase64 {

	public static String convertToBase64(String toConvert) {
		byte[] bytes = Base64.encodeBase64(toConvert.getBytes());
		return new String(bytes);
	}

	public static String base64ToString(String toConvert) {
		byte[] decodeBase64 = Base64.decodeBase64(toConvert);
		return new String(decodeBase64);
	}
}
