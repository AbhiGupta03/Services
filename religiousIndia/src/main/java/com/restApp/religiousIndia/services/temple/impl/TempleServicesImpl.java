package com.restApp.religiousIndia.services.temple.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restApp.religiousIndia.data.entities.Address;
import com.restApp.religiousIndia.data.entities.Cities;
import com.restApp.religiousIndia.data.entities.Temple;
import com.restApp.religiousIndia.data.entities.TempleConnectivity;
import com.restApp.religiousIndia.data.entities.TempleTimings;
import com.restApp.religiousIndia.data.entities.pooja.Pooja;
import com.restApp.religiousIndia.data.entities.temple.Aarti;
import com.restApp.religiousIndia.data.entities.temple.TempleOverView;
import com.restApp.religiousIndia.data.entities.temple.reviews.TempleReview;
import com.restApp.religiousIndia.data.entities.users.UserDetailsImpl;
import com.restApp.religiousIndia.data.repositry.AartiRepositry;
import com.restApp.religiousIndia.data.repositry.AddresssRepositry;
import com.restApp.religiousIndia.data.repositry.CityRepositry;
import com.restApp.religiousIndia.data.repositry.TempleConnectivityRepositry;
import com.restApp.religiousIndia.data.repositry.TempleRepositry;
import com.restApp.religiousIndia.data.repositry.TempleTimingRepositry;
import com.restApp.religiousIndia.data.repositry.poojeServices.PoojaServiceRepositry;
import com.restApp.religiousIndia.data.repositry.temple.TempleOverViewRepositry;
import com.restApp.religiousIndia.data.repositry.temple.review.TempleReviewRepositry;
import com.restApp.religiousIndia.data.repositry.users.UserDetailsRepositry;
import com.restApp.religiousIndia.request.filter.PostRequest;
import com.restApp.religiousIndia.response.Response;
import com.restApp.religiousIndia.response.status.ResponseStatus;
import com.restApp.religiousIndia.services.imageServices.RetriveImageService;
import com.restApp.religiousIndia.services.temple.TempleServices;
import com.restApp.religiousIndia.services.temple.nearBy.NearByDetails;

@Service
public class TempleServicesImpl implements TempleServices {
	private static Logger logger = Logger.getLogger(TempleServicesImpl.class);

	@Autowired
	TempleRepositry templeRepositry;

	@Autowired
	TempleTimingRepositry templeTimingRepositry;

	@Autowired
	TempleConnectivityRepositry templeConnectivityepositry;

	@Autowired
	NearByDetails templeNearByDetails;

	@Autowired
	AartiRepositry aartiRepositry;

	@Autowired
	AddresssRepositry addressRepositry;

	@Autowired
	RetriveImageService retriveImageService;

	@Autowired
	CityRepositry cityRepositry;

	@Autowired
	PoojaServiceRepositry poojaServiceRepositry;

	@Autowired
	TempleOverViewRepositry templeOverViewRepositry;

	@Autowired
	TempleReviewRepositry templeReviewRepositry;

	@Autowired
	UserDetailsRepositry userDetailsRepositry;

	@Override
	public List<Aarti> getAartiTiming(String templeId) {
		logger.info("Aarti timings for templeId:" + templeId);

		return aartiRepositry.findByIsActiveAndTempleId("1", templeId);
	}

	@Override
	public TempleTimings getTempleTimings(String templeId) {
		logger.info("Temple timings for templeId:" + templeId);

		return templeTimingRepositry.findByIsActiveAndTempleID("1", templeId);
	}

	public TempleConnectivity getConnectivity(String addressId, String templeId) {
		TempleConnectivity connectivity = templeConnectivityepositry.findOne(addressId);
		if (connectivity == null) {
			connectivity = new TempleConnectivity();

			connectivity.setAddressId(addressId);
			connectivity.setIsActive("1");
			connectivity.setNearestAirport("");
			connectivity.setNearestBusStand("");
			connectivity.setNearestRailwayStation("");
			connectivity.setParkingLotDesc("");
			connectivity = templeConnectivityepositry.save(connectivity);
		}
		if (connectivity.getNearestAirport().isEmpty() || connectivity.getNearestBusStand().isEmpty()
				|| connectivity.getNearestRailwayStation().isEmpty()) {
			logger.info("get Connectivity details from Google map api");
			logger.info("Address Id is:" + connectivity.getAddressId());

			TempleConnectivity connectivityObject = getConnectivityObject(connectivity);

			logger.info("Saving connectivity data in DB");
			connectivity = templeConnectivityepositry.save(connectivityObject);
		}

		return connectivity;
	}

	@Override
	public Map<String, Object> templeDetails(String templeId) {
		Map<String, Object> templeDetails = new LinkedHashMap<String, Object>();
		try {
			Temple temple = templeRepositry.findOne(templeId);
			increaseHitCount(temple);
			if (temple == null) {
				templeDetails.put("Error", "Temple details Not found In DB");
				return templeDetails;
			}

			String imagePath = retriveImageService.getImagePath(temple.getMainImageID());

			templeDetails.put("Temple_Name", temple.getTempleName());

			if (imagePath == null) {
				templeDetails.put("Error", "image path not found");
				templeDetails.put("Image_Path", "");
			} else {
				templeDetails.put("Image_Path", imagePath);
			}

			List<Aarti> aartiTiming = getAartiTiming(templeId);
			if (aartiTiming == null) {
				templeDetails.put("Error", "Aarti timing data is  not found in  DB");
				templeDetails.put("Aarti", "");
			} else {
				String aartiDetails = "";
				int count = 0;
				int totalAatri = aartiTiming.size();
				String seprator = ",";
				for (Aarti aarti : aartiTiming) {
					count++;
					if (count == totalAatri) {
						seprator = "";
					}
					aartiDetails += aarti.getStartTime() + "-" + aarti.getEndTime() + seprator;
				}
				templeDetails.put("Aarti_Timings", aartiDetails);
			}

			TempleTimings templeTimings = getTempleTimings(templeId);
			if (templeTimings == null) {
				templeDetails.put("Error", "Temple timing not found in DB");
				templeDetails.put("Temple_Timings", "");
			} else {
				templeDetails.put("Temple_Timings", templeTimings.getTempleTime());
			}

			Address templeAddress = addressRepositry.findByIsActiveAndAddressID("1",
					new Integer(temple.getTempleAddressId()));
			if (templeAddress == null) {
				templeDetails.clear();
				templeDetails.put("Error", "Temple Address not found in DB");
				return templeDetails;
			}
			String addressDetails = templeAddress.getAddressDetail();

			templeDetails.put("Temple_Detail_Address", addressDetails);
			templeDetails.put("Temple_Dist", templeAddress.getDist());
			templeDetails.put("Temple_city", templeAddress.getCity());
			templeDetails.put("Devotees", "321");
			return templeDetails;

		} catch (Exception e) {
			logger.error("Error:" + e + "in templeDetails");
			templeDetails.put("Error", "Temple details Not found In DB");
			return templeDetails;
		}
	}

	private void increaseHitCount(Temple temple) {
		temple.setHitsCount(temple.getHitsCount() + 1);
		templeRepositry.save(temple);
	}

	@Override
	public Map<String, Object> getTempleConnectivityDetails(String templeId, String currentCity) {
		Map<String, Object> templeDetails = new LinkedHashMap<String, Object>();
		Temple temple = templeRepositry.findOne(templeId);
		if (temple == null) {
			templeDetails.put("Error", "Temple details Not found In DB");
			return templeDetails;
		}
		Address templeAddress = addressRepositry.findByIsActiveAndAddressID("1",
				new Integer(temple.getTempleAddressId()));
		if (templeAddress == null) {
			templeDetails.clear();
			templeDetails.put("Error", "Temple Address not found in DB");
			return templeDetails;
		}
		String addressDetails = templeAddress.getAddressDetail();

		if (templeAddress.getPincode() == null || templeAddress.getPincode().equals("")) {
			String pinCodeForAddress = templeNearByDetails
					.getPinCodeForAddress(addressDetails + templeAddress.getState());

			templeAddress.setPincode(pinCodeForAddress);

			addressRepositry.save(templeAddress);
		}
		// get the connectivity details
		TempleConnectivity templeConnectivity = getConnectivity(temple.getTempleAddressId(), templeId);
		if (templeConnectivity == null) {
			templeDetails.clear();
			templeDetails.put("Error", "Temple Connectivity details not found in DB");
			return templeDetails;
		} else {
			String nearestRailwayStation = templeConnectivity.getNearestRailwayStation();

			if (!nearestRailwayStation.equalsIgnoreCase("No railway station in the 50Km range")) {
				String distanceFromRailwayStation = templeNearByDetails.getDistance(nearestRailwayStation,
						addressDetails);
				templeDetails.put("Train_Connectivity",
						nearestRailwayStation + " Railway station is " + distanceFromRailwayStation + " away");
			}

			String nearestBusStand = templeConnectivity.getNearestBusStand();
			if (!nearestBusStand.equalsIgnoreCase("No bus Stop in the 50Km range")) {
				String distanceFromBusStand = templeNearByDetails.getDistance(nearestBusStand, addressDetails);
				templeDetails.put("Bus_Stand", nearestBusStand + " Bus stand is " + distanceFromBusStand + " away");
			}

			String nearestAirport = templeConnectivity.getNearestAirport();
			if (!nearestAirport.equalsIgnoreCase("No airport in the 50Km range")) {
				String distanceFromAirport = templeNearByDetails.getDistance(nearestBusStand, addressDetails);
				templeDetails.put("Airport_Connectivity",
						nearestAirport + " Airport is " + distanceFromAirport + " away");
			}
			if (!templeConnectivity.getParkingLotDesc().isEmpty()) {
				templeDetails.put("Parking_Desc", templeConnectivity.getParkingLotDesc());
			}
		}

		// Distance from current city to temple
		String distance = templeNearByDetails.getDistance(currentCity, addressDetails);
		templeDetails.put("Distance", distance);
		return templeDetails;
	}

	public List<Map<String, Object>> getTempleListInDetails(List<Temple> activeTemples) {
		List<Map<String, Object>> templeDetailsList = new ArrayList<>();
		Address address = null;
		String addressDetail = "";
		String imagePath = "";
		for (Temple temple : activeTemples) {
			Map<String, Object> templeDetails = new HashMap<>();
			templeDetails.put("Temple_Id", temple.getTempleId());
			templeDetails.put("Temple_Name", temple.getTempleName());
			address = addressRepositry.findOne(new Integer(temple.getTempleAddressId()));
			addressDetail = address.getAddressDetail();
			templeDetails.put("Address_Detail", addressDetail);
			templeDetails.put("Contact_No", temple.getContactNo());
			templeDetails.put("Is_Authenticated", temple.getAuthChannelPartner());
			imagePath = retriveImageService.getImagePath(temple.getMainImageID());
			templeDetails.put("Image_Path", imagePath);

			// To-Do Static Data for Pooja Services
			String poojaServices = "Shiva Pooja, Vishnu Pooja, Engagement Pooja, Namkaran, Shanti Pooja, Marriage rituals";

			templeDetails.put("Pooja_Services", poojaServices);

			// To-Do get the location
			String distance = templeNearByDetails.getDistance("New Delhi", addressDetail);
			templeDetails.put("Distance", distance);
			// To-Do get the pooja tabs
			ArrayList<String> poojaTabs = new ArrayList<>();
			poojaTabs.add("Surya");
			poojaTabs.add("Vishnu");
			poojaTabs.add("Kriushna");
			templeDetails.put("Pooja_tabs", poojaTabs);
			String Url = address.getState() + "/" + address.getDist() + "/" + "temple-details" + "/"
					+ temple.getTempleName() + "/" + addressDetail + "/" + temple.getTempleId();
			templeDetails.put("URL", Url);
			templeDetailsList.add(templeDetails);
		}
		return templeDetailsList;
	}

	public Temple getTemple(String templId) {
		return templeRepositry.findByisActiveAndTempleId("1", templId);
	}

	public Address getTempleAddressDetails(String addressId) {
		Address address = addressRepositry.findByIsActiveAndAddressID("1", new Integer(addressId));
		return address;
	}

	private TempleConnectivity getConnectivityObject(TempleConnectivity templeConnectivity) {
		Address addressDetails = addressRepositry.findOne(new Integer(templeConnectivity.getAddressId()));
		String address = addressDetails.getAddressDetail();

		logger.info("Address for which getting details from Google Api's");
		// get the latitude and longitude of the address
		Map<String, String> coordinates = templeNearByDetails.getCoordinates(address);
		String latitude = coordinates.get("latitude");
		String longitude = coordinates.get("longitude");

		logger.info("Co-ordinates:" + latitude + "," + longitude);
		// find out airport from map api if not in the db.
		if (templeConnectivity.getNearestAirport().isEmpty()) {
			logger.info("Getting nearest Airport");
			String nearestAirport = templeNearByDetails.getNearestAirport(latitude, longitude);
			templeConnectivity.setNearestAirport(nearestAirport);
			logger.info("Nearest Airport is:" + nearestAirport);
		}

		// find out Bus stand from map api if not in the db.
		if (templeConnectivity.getNearestBusStand().isEmpty()) {
			logger.info("Getting nearest BusStand");
			String nearestBusStand = templeNearByDetails.getNearestBusStop(latitude, longitude);
			templeConnectivity.setNearestBusStand(nearestBusStand);
			logger.info("Nearest BusStand is:" + nearestBusStand);
		}

		// find out railway station from map api if not in the db.
		if (templeConnectivity.getNearestRailwayStation().isEmpty()) {
			logger.info("Getting nearest RailwayStation");
			String nearestRailway = templeNearByDetails.getNearestRailway(latitude, longitude);
			templeConnectivity.setNearestRailwayStation(nearestRailway);
			logger.info("Nearest RailwayStation is:" + nearestRailway);
		}
		return templeConnectivity;
	}

	public List<Cities> getNearByCities(String radius, String cityName) {
		try {
			Map<String, String> coordinates = templeNearByDetails.getCoordinates(cityName);
			String latitude = coordinates.get("latitude");
			String longitude = coordinates.get("longitude");

			// No Of record desired from API.
			int recordsLimit = 20;
			List<String> nearByCities = templeNearByDetails.getNearByCities(latitude, longitude, radius, recordsLimit);

			if (nearByCities == null) {
				return (List<Cities>) new Cities();
			}
			logger.info("Geting matching city in our DB.");
			return cityRepositry.findByCityNameIn(nearByCities);
		} catch (Exception e) {
			logger.error("Error:" + e + "in getNearByCities");
			return null;
		}
	}

	public List<Map<String, Object>> getTemplesByCityName(List<String> cityList, String shortBy) {

		if (cityList.size() == 1 && cityList.get(0).equalsIgnoreCase("All")) {
			logger.info("Getting All Temples List");
			return getAllActiveTempleList();
		}

		logger.info("Retriving all associated temples address in the city ");
		List<Address> addressInCity = addressRepositry.findByCityIn(cityList);

		List<String> addressId = new ArrayList<>();
		for (Address address : addressInCity) {

			addressId.add(address.getId() + "");
		}

		List<Temple> templeList = null;
		if (shortBy.equalsIgnoreCase("popularity")) {
			templeList = templeRepositry.findByTempleAddressIdInOrderByHitsCount(addressId);
		} else {
			templeList = templeRepositry.findByTempleAddressIdIn(addressId);
		}
		List<Map<String, Object>> templeListInDetails = getTempleListInDetails(templeList);
		return templeListInDetails;
	}

	public List<Map<String, Object>> getTemplesByFilters(PostRequest filterRequest) {

		List<Map<String, Object>> templesByFilterName = new ArrayList<>();

		logger.info("Retriving temples withIn the filter request");

		Map<String, List<String>> requestParam = filterRequest.getRequestParam();

		try {
			if (filterRequest.getRequestType().equalsIgnoreCase("filter")) {
				if (requestParam.size() != 0) {
					List<String> listOfServices = requestParam.get("serviceNames");
					List<String> listOfCities = requestParam.get("cityNames");
					List<String> range = requestParam.get("range");
					List<String> shorting = requestParam.get("shortBy");

					if (shorting == null) {
						shorting = new ArrayList<>();
						shorting.add("popularity");
					}
					String shortBy = shorting.get(0);

					List<Map<String, Object>> templesByServiceNames = null;
					List<Map<String, Object>> templesByCityName = null;

					if (listOfServices != null && listOfServices.size() != 0) {
						templesByServiceNames = getTemplesByServiceNames(listOfServices, shortBy);
					}

					// All cities withIn the range and selected city
					if (range != null && range.size() != 0 && listOfCities.size() != 0) {
						List<Cities> nearByCities = getNearByCities(range.get(0), listOfCities.get(0));
						for (Cities cities : nearByCities) {
							listOfCities.add(cities.getCityName());
						}
					}

					// remove duplicate cities
					/*
					 * Set<String> set = new HashSet<String>(listOfCities);
					 * List<String> listOftotalCities = new ArrayList<>(set);
					 */
					if (listOfCities != null && listOfCities.size() != 0) {
						templesByCityName = getTemplesByCityName(listOfCities, shortBy);
					}

					if (templesByServiceNames != null && templesByServiceNames.size() != 0) {
						List<Map<String, Object>> allTempleList = new ArrayList<Map<String, Object>>(
								templesByServiceNames);

						// Get matching temples from the services filter and
						// city &
						// range filter
						allTempleList.retainAll(templesByCityName);

						templesByFilterName.addAll(allTempleList);
					} else {
						templesByFilterName.addAll(templesByCityName);
					}
				}
			}
		} catch (Exception e) {
			logger.error("Error:" + e + "in getTemplesByFilters");
		}

		return templesByFilterName;
	}

	@Override
	public List<Map<String, Object>> getAllActiveTempleList() {
		logger.info("Retriving all active temples list");
		try {
			List<Temple> activeTemples = templeRepositry.findByisActiveEquals("1");
			return getTempleListInDetails(activeTemples);
		} catch (Exception e) {
			logger.error("Error in getAllActiveTempleList:" + e + "in getAllActiveTempleList");
			return null;
		}
	}

	public List<Map<String, Object>> getTemplesByServiceNames(List<String> listOfServices, String shortBy) {
		try {
			List<String> templeIdByServiceName = findTempleIdByServiceName(listOfServices);
			List<Temple> templesList = null;
			if (shortBy.equalsIgnoreCase("popularity")) {
				templesList = templeRepositry.findByisActiveAndTempleIdInOrderByHitsCount("1", templeIdByServiceName);
			} else {
				templesList = templeRepositry.findByisActiveAndTempleIdIn("1", templeIdByServiceName);
			}

			return getTempleListInDetails(templesList);
		} catch (Exception e) {
			logger.error("Error in getTemplesByServiceNames:" + e + "in getTemplesByServiceNames");
			return null;
		}
	}

	@Override
	public List<String> findTempleIdByServiceName(List<String> serviceName) {
		try {
			List<Pooja> poojaListByServiceName = poojaServiceRepositry.findByServiceNameIn(serviceName);
			List<String> templeIdList = new ArrayList<>();
			for (Pooja pooja : poojaListByServiceName) {
				String templeId = pooja.getTempleId();
				if (templeId != null) {
					templeIdList.add(templeId);
				}
			}
			return templeIdList;
		} catch (Exception e) {
			logger.error("Error in findTempleIdByServiceName:" + e + "in findTempleIdByServiceName");
			return null;
		}

	}

	public Map<String, Object> templeOverView(String templeId) {
		try {

			TempleOverView templeOverViewDetails = templeOverViewRepositry.findBytempleIdAndIsActive(templeId, "1");
			Map<String, Object> templeOverView = new HashMap<>();

			templeOverView.put("Temple_History", templeOverViewDetails.getTempleHistory());

			if (!templeOverViewDetails.getTempleHasVideo().equals("0")) {
				templeOverView.put("Temple_Video_Link", templeOverViewDetails.getTempleVideoLink());
			}

			templeOverView.put("Temple_Intro", templeOverViewDetails.getTempleIntroLine());

			templeOverViewDetails.getTempleIntroDetails();

			try {
				JSONArray templeIntroDetailsArray = new JSONArray(templeOverViewDetails.getTempleIntroDetails());
				int length = templeIntroDetailsArray.length();
				JSONObject templeIntroDetailsJson = null;
				Map<String, List<String>> templeIntroDetails = new HashMap<>();
				List<String> templeIntroDetailsImagesPath = new ArrayList<String>();
				List<String> templeIntroDetailsDesc = new ArrayList<String>();
				for (int i = 0; i < length; i++) {
					templeIntroDetailsJson = (JSONObject) templeIntroDetailsArray.get(i);
					Integer image = (Integer) templeIntroDetailsJson.get("Image");
					String desc = (String) templeIntroDetailsJson.get("Desc");

					templeIntroDetailsImagesPath.add(retriveImageService.getImagePath(image + ""));

					templeIntroDetailsDesc.add(desc);
				}
				templeIntroDetails.put("Images", templeIntroDetailsImagesPath);
				templeIntroDetails.put("Desc", templeIntroDetailsDesc);
				templeOverView.put("Temple_Intro_Details", templeIntroDetails);
			} catch (JSONException e) {
				e.printStackTrace();
			}

			try {
				JSONArray templeMissionStmtDetailsArray = new JSONArray(
						templeOverViewDetails.getTempleMissionStmtDetails());
				int length = templeMissionStmtDetailsArray.length();
				JSONObject templeMissionStmtDetailsJson = null;
				Map<String, List<String>> templeMissionStmtDetails = new HashMap<>();
				List<String> templeMissionStmtDetailsImages = new ArrayList<String>();
				List<String> templeMissionStmtDetailsDesc = new ArrayList<String>();
				for (int i = 0; i < length; i++) {
					templeMissionStmtDetailsJson = (JSONObject) templeMissionStmtDetailsArray.get(i);
					Integer image = (Integer) templeMissionStmtDetailsJson.get("Image");
					String desc = (String) templeMissionStmtDetailsJson.get("Desc");

					templeMissionStmtDetailsImages.add(retriveImageService.getImagePath(image + ""));
					templeMissionStmtDetailsDesc.add(desc);

				}
				templeMissionStmtDetails.put("Images", templeMissionStmtDetailsImages);
				templeMissionStmtDetails.put("Desc", templeMissionStmtDetailsDesc);

				templeOverView.put("Temple_Mission_Stmt", templeMissionStmtDetails);

			} catch (JSONException e) {
				e.printStackTrace();
			}
			return templeOverView;

		} catch (Exception e) {
			logger.error("Error in templeOverView:" + e);
			return null;
		}
	}

	public List<Map<String, Object>> getNearByTemplesFrom(String cityName, Integer addessId) {

		// get cities within 100km ranges
		final String range = "100";

		List<Cities> nearByCities = getNearByCities(range, cityName);

		List<String> listOfcities = new ArrayList<>();
		for (Cities cities : nearByCities) {
			listOfcities.add(cities.getCityName());
		}
		return getTemplesByCityNameExcept(listOfcities, addessId);
	}

	public List<Map<String, Object>> getNearByTemples(String templeId) {
		Temple temple = templeRepositry.findByisActiveAndTempleId("1", templeId);

		Address address = addressRepositry.findByIsActiveAndAddressID("1", new Integer(temple.getTempleAddressId()));

		String city = address.getCity();

		Integer addressId = address.getId();

		return getNearByTemplesFrom(city, addressId);

	}

	public List<Map<String, Object>> getTemplesByCityNameExcept(List<String> cityList, Integer addressIdToLeave) {

		if (cityList.size() == 1 && cityList.get(0).equals("All")) {
			logger.info("Getting All Temples List");
			return getAllActiveTempleList();
		}

		logger.info("Retriving all associated temples address in the city ");
		List<Address> addressInCity = addressRepositry.findByCityIn(cityList);

		List<String> addressId = new ArrayList<>();
		for (Address address : addressInCity) {
			if (address.getId() == addressIdToLeave) {
				addressId.add(address.getId() + "");
			}
		}

		List<Temple> templeList = templeRepositry.findByTempleAddressIdIn(addressId);
		List<Map<String, Object>> templeListInDetails = getTempleListInDetails(templeList);
		return templeListInDetails;
	}

	public List<String> getTempleImageGallery(String templeId) {
		String imageGallery = templeRepositry.findImageGallery(templeId);
		String imagePath = "";
		List<String> imageGalleryList = new ArrayList<>();

		if (imageGallery != null) {
			try {
				logger.info("Extracting image list from json object");
				JSONArray imageIdListArray = new JSONArray(imageGallery);
				int length = imageIdListArray.length();
				JSONObject imageIdObject = null;

				for (int i = 0; i < length; i++) {
					imageIdObject = (JSONObject) imageIdListArray.get(i);
					String imageId = (String) imageIdObject.get("imageId");
					imagePath = retriveImageService.getImagePath(imageId);
					imageGalleryList.add(imagePath);
				}

			} catch (JSONException e) {
				logger.error("Error in getTempleImageGallery:" + e);
				e.printStackTrace();
			}
			return imageGalleryList;
		} else {
			imageGalleryList.add(imagePath);
			return null;
		}
	}

	@Override
	public boolean saveTempleReview(Map<String, String> requestParam) {
		try {
			TempleReview templeReview = new TempleReview();
			templeReview.setIsActive("1");

			templeReview.setRating(requestParam.get("rating"));
			templeReview.setReviewDesc(requestParam.get("reviewDesc"));
			templeReview.setTempleId(requestParam.get("templeId"));
			templeReview.setUserReview(requestParam.get("userReview"));
			templeReview.setUserId(requestParam.get("userId"));
			TempleReview isSave = templeReviewRepositry.save(templeReview);
			if (isSave == null) {
				return false;
			}
			logger.info("Review saved successfully..");
			return true;
		} catch (Exception e) {
			logger.error("Error in saveTempleReview:" + e);
			return false;
		}
	}

	@Override
	public Response getTempleReviews(String templeId) {
		Response response = new Response();
		List<TempleReview> templeReviewList = templeReviewRepositry.findByisActiveAndTempleIdOrderByReviewIdDesc("1",
				templeId);
		List<Map<String, Object>> reviewDetailsList = new ArrayList<>();
		Map<String, Object> review = new HashMap<>(2);
		Map<String, Integer> ratingMap = new HashMap<>(5);

		ratingMap.put("1", 0);
		ratingMap.put("2", 0);
		ratingMap.put("3", 0);
		ratingMap.put("4", 0);
		ratingMap.put("5", 0);
		ratingMap.put("Total_reviews", templeReviewList.size());

		if (templeReviewList != null && templeReviewList.size() != 0) {
			Integer userId = null;
			UserDetailsImpl userDetails = null;
			String name = "";
			String addressId = "";
			Address address = null;
			String imageId = "";
			String imagePath = "";
			String rating = "";
			try {
				for (TempleReview templeReview : templeReviewList) {
					Map<String, Object> map = new HashMap<>();
					userId = new Integer(templeReview.getUserId());
					userDetails = userDetailsRepositry.findByUserId(userId);
					name = userDetails.getFirstName() + " " + userDetails.getMiddleName() + " "
							+ userDetails.getLastName();
					addressId = userDetails.getAddressId();
					imageId = userDetails.getPhotoId();
					imagePath = retriveImageService.getImagePath(imageId);
					address = addressRepositry.findOne(new Integer(addressId));
					map.put("User_Image", imagePath);
					map.put("User_Name", name);
					map.put("User_Location", address.getCity() + "," + address.getState());

					rating = templeReview.getRating();
					map.put("Rating", rating);
					ratingMap.put(rating, ratingMap.get(rating) + 1);
					map.put("ReviewDesc", templeReview.getReviewDesc());
					map.put("UserReview", templeReview.getUserReview());
					map.put("Review_Id", templeReview.getReviewId());
					reviewDetailsList.add(map);
				}
				review.put("ReviewOverview", ratingMap);
				review.put("ReviewInDetail", reviewDetailsList);
				response.setStatus(ResponseStatus.OK);
				response.setResponse(review);
				return response;
			} catch (Exception e) {
				logger.error("Error in getTempleReviews:" + e);
				response.setStatus(ResponseStatus.INTERNAL_SERVER_ERROR);
				response.setResponse("Something went wrong,Please try again in some time");
				return response;
			}
		}
		response.setStatus(ResponseStatus.NO_DATA_FOUND);
		response.setResponse("No Data Found");
		return response;
	}

	public List<Temple> getTemplesByTempleIdList(List<String> templesIdList) {
		return templeRepositry.findByTempleIdIn(templesIdList);
	}

	public Temple getTemplesByTempleId(String templesId) {
		return templeRepositry.findByisActiveAndTempleId("1", templesId);
	}

	public Temple getTempleFromDonationSubCategory(String donationSubCategoryId) {
		return null;
	}

	@Override
	public Response getPopularTemples() {
		Response response = new Response();
		List<Temple> mostHitsTemples = templeRepositry.findByMostHits();
		List<Map<String, Object>> listInDetails = getPopularTemplesList(mostHitsTemples);
		if (mostHitsTemples != null) {
			response.setResponse(listInDetails);
			response.setStatus(ResponseStatus.OK);
		}
		return response;
	}

	private List<Map<String, Object>> getPopularTemplesList(List<Temple> mostHitsTemples) {
		List<Map<String, Object>> list = new ArrayList();
		Address address = null;
		for (Temple temple : mostHitsTemples) {
			Map<String, Object> map = new HashMap<>();

			map.put("Image_Path", retriveImageService.getImagePath(temple.getMainImageID()));
			map.put("Temple_Name", temple.getTempleName());
			address = addressRepositry.findByIsActiveAndAddressID("1", new Integer(temple.getTempleAddressId()));

			map.put("City", address.getCity());
			map.put("Temple_Id", temple.getTempleId());
			map.put("Temple_Detail_Desc", temple.getTempleDesc());
			list.add(map);
		}
		return list;
	}
}
