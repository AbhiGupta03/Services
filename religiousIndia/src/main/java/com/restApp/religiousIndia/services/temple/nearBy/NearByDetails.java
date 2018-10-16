package com.restApp.religiousIndia.services.temple.nearBy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.restApp.religiousIndia.data.repositry.CityRepositry;
import com.restApp.religiousIndia.data.repositry.users.UserLocationRepositry;

@Service
public class NearByDetails {
	private static Logger logger = Logger.getLogger(NearByDetails.class);
	final String mapApi = "https://maps.googleapis.com/maps/api/";

	final String distanceMapApi = "https://maps.googleapis.com/maps/api/distancematrix/json?origins=";

	final String pinCodeMapApi = "https://maps.googleapis.com/maps/api/geocode/json?sensor=false&address=";

	// To-Do Test
	final String geoByteApi = "http://gd.geobytes.com/GetNearbyCities/jsonp?";

	@Value("${radius}")
	String radius;

	@Value("${apiKey}")
	String apiKey;

	@Autowired
	CityRepositry cityRepositry;

	@Autowired
	UserLocationRepositry UserLocationRepositry;

	RestTemplate restTemplate = new RestTemplate();

	Map<String, String> details = new HashMap<String, String>();

	public Map<String, String> getCoordinates(final String address) {
		String urlToGetAddDeatils = mapApi + "geocode/json?address=" + address + "&key=" + apiKey;
		LinkedHashMap<String, ArrayList> restResult = (LinkedHashMap<String, ArrayList>) restTemplate
				.getForObject(urlToGetAddDeatils, Object.class);

		ArrayList<LinkedHashMap<String, LinkedHashMap>> resultsList = restResult.get("results");
		LinkedHashMap<String, LinkedHashMap> hashMap = resultsList.get(0);
		LinkedHashMap<String, LinkedHashMap> list = hashMap.get("geometry");
		LinkedHashMap linkedHashMap = list.get("location");

		String latitude = linkedHashMap.get("lat") + "";
		String longitude = linkedHashMap.get("lng") + "";

		details.put("latitude", latitude);
		details.put("longitude", longitude);

		return details;
	}

	public String getNearestRailway(final String latitude, final String longitude) {
		String urlForRailway = mapApi + "place/nearbysearch/json?location=" + latitude + "," + longitude + "&radius="
				+ radius + "&type=train_station&key=" + apiKey;
		String resultData = "";
		LinkedHashMap<String, ArrayList> restResult = (LinkedHashMap<String, ArrayList>) restTemplate
				.getForObject(urlForRailway, Object.class);

		ArrayList<LinkedHashMap<String, String>> resultsList = restResult.get("results");

		if (resultsList.size() != 0) {
			LinkedHashMap<String, String> dataMap = resultsList.get(0);
			resultData = dataMap.get("name");
		} else {
			resultData = "No railway station in the 50Km range";
		}
		return resultData;
	}

	public String getNearestAirport(final String latitude, final String longitude) {
		// form the actual google api using required param values
		String urlForAirports = mapApi + "place/nearbysearch/json?location=" + latitude + "," + longitude + "&radius="
				+ radius + "&type=airport&key=" + apiKey;

		String resultData = "";

		LinkedHashMap<String, ArrayList> restResult = (LinkedHashMap<String, ArrayList>) restTemplate
				.getForObject(urlForAirports, Object.class);

		ArrayList<LinkedHashMap<String, String>> resultsList = restResult.get("results");

		if (resultsList.size() != 0) {
			LinkedHashMap<String, String> dataMap = resultsList.get(0);
			resultData = dataMap.get("name");
		} else {
			resultData = "No airport in the 50Km range";
		}
		return resultData;
	}

	public String getNearestBusStop(final String latitude, final String longitude) {
		// form the actual google api using required param values
		String urlForBusStop = mapApi + "place/nearbysearch/json?location=" + latitude + "," + longitude + "&radius="
				+ radius + "&type=bus_station&key=" + apiKey;

		String resultData = "";

		LinkedHashMap<String, ArrayList> restResult = (LinkedHashMap<String, ArrayList>) restTemplate
				.getForObject(urlForBusStop, Object.class);

		ArrayList<LinkedHashMap<String, String>> resultsList = restResult.get("results");

		if (resultsList.size() != 0) {
			LinkedHashMap<String, String> dataMap = resultsList.get(0);
			resultData = dataMap.get("vicinity");
		} else {
			resultData = "No bus Stop in the 50Km range";
		}
		return resultData;
	}

	public String getDistance(final String origin, final String destination) {
		// form the actual google api using required param values
		final String distanceApi = distanceMapApi + origin + "&destinations=" + destination + "&key=" + apiKey;

		LinkedHashMap<String, ArrayList> restResult = restTemplate.getForObject(distanceApi, LinkedHashMap.class);
		ArrayList<LinkedHashMap> distanceDataObj = restResult.get("rows");

		LinkedHashMap<String, ArrayList> distanceDataObjElements = distanceDataObj.get(0);

		ArrayList<LinkedHashMap> distanceAndDuration = distanceDataObjElements.get("elements");

		LinkedHashMap<String, LinkedHashMap> detailObject = distanceAndDuration.get(0);

		LinkedHashMap distanceObj = detailObject.get("distance");

		String distance = ((Integer) distanceObj.get("value")) / 1000 + " km";

		return distance;
	}

	public String getPinCodeForAddress(String addressDetails) {
		final String pinApi = pinCodeMapApi + addressDetails + "&key=" + apiKey;

		LinkedHashMap<String, ArrayList> restResult = restTemplate.getForObject(pinApi, LinkedHashMap.class);

		LinkedHashMap<String, ArrayList> dataObj = (LinkedHashMap<String, ArrayList>) restResult.get("results").get(0);

		ArrayList<LinkedHashMap> addressData = dataObj.get("address_components");

		String pinCode = (String) addressData.get(addressData.size() - 1).get("long_name");

		return pinCode;
	}

	public List<String> getNearByCities(String latitude, String longitude, String radius, int recordsLimit) {
		List<String> listOfCities = new ArrayList<String>();

		logger.info("Getting nearBy cities for co-ordinates:" + latitude + "," + longitude + "in radius of" + radius
				+ "km recordLimits is upto:" + recordsLimit);
		// form the actual google api using required param values
		final String nearByCityApi = geoByteApi + "&Latitude=" + latitude + "&Longitude=" + longitude + "&radius="
				+ radius + "km&limit=" + recordsLimit;
		List<List<String>> list = null;
		Object object = null;
		try {
			object = restTemplate.getForObject(nearByCityApi, Object.class);
			if (object == null) {
				logger.error("No data found from near by cities API");
				return listOfCities;
			}
		} catch (Exception e) {
			return listOfCities;
		}

		finally {
			list = (List<List<String>>) object;
			for (List<String> array : list) {
				listOfCities.add(array.get(1));
			}
		}
		return listOfCities;
	}

	public String getUserLocation(int userId) {
		return UserLocationRepositry.getUserLocationFromProc(userId);
	}
}
