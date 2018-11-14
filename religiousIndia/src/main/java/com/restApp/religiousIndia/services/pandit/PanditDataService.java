package com.restApp.religiousIndia.services.pandit;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
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
import com.restApp.religiousIndia.data.entities.pandit.PanditDetails;
import com.restApp.religiousIndia.data.entities.pandit.PanditTempleAssociation;
import com.restApp.religiousIndia.data.entities.pandit.availability.PanditDailyAvailibility;
import com.restApp.religiousIndia.data.entities.pandit.availability.UnavailabilityDetails;
import com.restApp.religiousIndia.data.entities.pooja.Pooja;
import com.restApp.religiousIndia.data.entities.pooja.PoojaBookingDetails;
import com.restApp.religiousIndia.data.entities.pooja.PoojaServicesPricing;
import com.restApp.religiousIndia.data.entities.users.UserDetailsImpl;
import com.restApp.religiousIndia.data.entities.users.CustomerReview.CustomerReview;
import com.restApp.religiousIndia.data.repositry.AddresssRepositry;
import com.restApp.religiousIndia.data.repositry.CityRepositry;
import com.restApp.religiousIndia.data.repositry.language.LanguageRepositry;
import com.restApp.religiousIndia.data.repositry.pandit.PanditDetailsRepositry;
import com.restApp.religiousIndia.data.repositry.pandit.availability.UnavailabilityDetailsRepositry;
import com.restApp.religiousIndia.data.repositry.poojeServices.PanditTempleAssociationRepositry;
import com.restApp.religiousIndia.data.repositry.poojeServices.PoojaBookingDetailsRepositry;
import com.restApp.religiousIndia.data.repositry.poojeServices.PoojaServicePricingRepositry;
import com.restApp.religiousIndia.data.repositry.poojeServices.PoojaServiceRepositry;
import com.restApp.religiousIndia.data.repositry.users.UserDetailsRepositry;
import com.restApp.religiousIndia.data.repositry.users.customerReview.CustomerReviewRepositry;
import com.restApp.religiousIndia.request.filter.PostRequest;
import com.restApp.religiousIndia.response.Response;
import com.restApp.religiousIndia.response.status.ResponseStatus;
import com.restApp.religiousIndia.services.imageServices.RetriveImageService;
import com.restApp.religiousIndia.services.pooja.PoojaServices;
import com.restApp.religiousIndia.services.temple.TempleServices;
import com.restApp.religiousIndia.services.temple.nearBy.NearByDetails;
import com.restApp.religiousIndia.services.users.UserServices;
import com.restApp.religiousIndia.utilities.compositePrimary.PoojaServicePricingPrimaryKey;

@Service
public class PanditDataService {
	private static Logger logger = Logger.getLogger(PanditDataService.class);

	@Autowired
	private PanditTempleAssociationRepositry panditTempleAssociationRepositry;

	@Autowired
	private PanditDetailsRepositry panditDetailsRepositry;

	@Autowired
	private NearByDetails nearByDetails;

	@Autowired
	private CityRepositry cityRepositry;

	@Autowired
	private PoojaServiceRepositry poojaServiceRepositry;

	@Autowired
	private AddresssRepositry addressRepositry;

	@Autowired
	private RetriveImageService retriveImageService;

	@Autowired
	private UserDetailsRepositry userDetailsRepositry;

	@Autowired
	private CustomerReviewRepositry customerReviewRepositry;

	@Autowired
	private PoojaServices poojaServices;

	@Autowired
	private TempleServices templeServices;

	@Autowired
	private LanguageRepositry languageRepositry;

	@Autowired
	private PoojaServicePricingRepositry poojaServicePricingRepositry;

	@Autowired
	private UnavailabilityDetailsRepositry unavailabilityDetailsRepositry;

	@Autowired
	private PoojaBookingDetailsRepositry poojaBookingDetailsRepositry;

	@Autowired
	private UserServices userServices;

	public List<Map<String, Object>> getPanditByFilters(PostRequest filterRequest) {
		logger.info("Method: getPanditByFilters for request:" + filterRequest);
		try {

			List<PanditDetails> panditByFilterName = new LinkedList<PanditDetails>();

			logger.info("Retriving pandit(s) withIn the filter request");

			Map<String, List<String>> requestParam = filterRequest.getRequestParam();

			try {
				if (filterRequest.getRequestType().equalsIgnoreCase("filterPandit")) {
					if (requestParam.size() != 0) {
						List<String> listOfServices = requestParam.get("serviceNames");
						List<String> listOfCities = requestParam.get("cityNames");
						List<String> range = requestParam.get("range");
						List<String> byDate = requestParam.get("availableDate");

						String ratingData = (requestParam.get("rating") != null) ? requestParam.get("rating").get(0)
								: null;

						String panditName = (requestParam.get("panditName") != null
								&& requestParam.get("panditName").size() != 0) ? requestParam.get("panditName").get(0)
										: null;

						String shortBy = (requestParam.get("shortBy") != null) ? requestParam.get("shortBy").get(0)
								: "Popularity";

						List<PanditDetails> panditByServiceNames = null;
						List<PanditDetails> panditByCityName = null;
						List<PanditDetails> panditByNameLike = null;
						List<PanditDetails> panditByRating = null;

						if (ratingData != null && !ratingData.equals("")) {
							Double rating = new Double(ratingData);
							panditByRating = getPanditByRating(rating, shortBy);
						}

						if (panditName != null && !panditName.equals("")) {
							List<Integer> userByName = userServices.getUserByNameLike(panditName);

							if (shortBy.equals("Popularity")) {
								panditByNameLike = panditDetailsRepositry.findByisActiveAndUserIdIn("1", userByName);
							} else {
								panditByNameLike = panditDetailsRepositry
										.findByisActiveAndUserIdInOrderByPanditRatingDesc("1", userByName);
							}
						}

						if (listOfServices != null && listOfServices.size() != 0) {
							panditByServiceNames = getPanditByServiceNames(listOfServices, shortBy);
						}

						// All cities withIn the range and selected city
						if (range != null && range.size() != 0 && listOfCities.size() != 0) {
							getNearByCities(range.get(0), listOfCities.get(0))
									.forEach(cities -> listOfCities.add(cities.getCityName()));
						}

						// remove duplicate cities
						/*
						 * Set<String> set = new HashSet<String>(listOfCities); List<String>
						 * listOftotalCities = new ArrayList<>(set);
						 */
						if (listOfCities != null && listOfCities.size() != 0) {
							panditByCityName = getPanditByCityName(listOfCities, shortBy);
						}

						if (panditByCityName != null && panditByCityName.size() != 0) {
							List<PanditDetails> allPanditList = new ArrayList<PanditDetails>(panditByCityName);

							if (panditByServiceNames != null) {
								allPanditList.retainAll(panditByServiceNames);
							}
							if (panditByNameLike != null) {
								allPanditList.retainAll(panditByNameLike);
							}
							if (panditByRating != null) {
								allPanditList.retainAll(panditByRating);
							}

							panditByFilterName.addAll(allPanditList);
							if (byDate != null) {
								Date date = new SimpleDateFormat("dd-MM-yyyy").parse(byDate.get(0));
								checkPanditByDate(panditByFilterName, date);
							}
						}
					}
				}
			} catch (Exception e) {
				logger.error("Error:" + e + " in getPanditByFilters");
				return null;
			}

			return getPanditListInDetails(panditByFilterName);

		} catch (Exception e) {
			return null;
		}
	}

	private void checkPanditByDate(List<PanditDetails> panditByFilterName, Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int day = cal.get(Calendar.DAY_OF_WEEK);
		for (PanditDetails panditDetails : panditByFilterName) {
			int[] panditJiWeeklyUnavaibality = panditJiWeeklyUnavaibality(panditDetails);
			if (panditJiWeeklyUnavaibality[day - 1] == 0) {
				panditByFilterName.remove(panditDetails);
			}
		}
		Map<String, Object> panditSchedule;
		Date bookedFrom;
		Date bookedTo;

		for (PanditDetails panditDetails : panditByFilterName) {
			boolean isPanditRemoved = false;
			panditSchedule = getPanditSchedule(panditDetails.getPanditId());

			List<Map<String, Object>> bookings = (List<Map<String, Object>>) panditSchedule.get("Bookings");
			List<Map<String, Object>> unavailable = (List<Map<String, Object>>) panditSchedule.get("Unavailable");
			if (bookings != null && !bookings.isEmpty()) {
				for (Map<String, Object> bookingMap : bookings) {
					bookedFrom = (Date) bookingMap.get("Booked_From");
					bookedTo = (Date) bookingMap.get("Booked_To");

					if (date.compareTo(bookedFrom) >= 0 && date.compareTo(bookedTo) <= 0) {
						isPanditRemoved = true;
						panditByFilterName.remove(panditDetails);
					}
				}
			}

			if (!isPanditRemoved) {
				Date unavailableFrom;
				Date unavailableTo;

				if (unavailable != null && !unavailable.isEmpty()) {
					for (Map<String, Object> unavailabliMap : unavailable) {
						unavailableFrom = (Date) unavailabliMap.get("Unavailable_From");
						unavailableTo = (Date) unavailabliMap.get("Unavailable_To");

						if (date.compareTo(unavailableFrom) >= 0 && date.compareTo(unavailableTo) <= 0) {
							panditByFilterName.remove(panditDetails);
						}
					}
				}
			}
		}
	}

	private List<PanditDetails> getPanditByRating(Double rating, String shortBy) {
		if (shortBy.equals("Popularity")) {
			return panditDetailsRepositry.findByPanditRatingGreaterThanEqualOrderByPanditRatingDesc(rating);
		} else {
			return panditDetailsRepositry.findByPanditRatingGreaterThanEqual(rating);
		}
	}

	public List<Cities> getNearByCities(String radius, String cityName) {
		logger.info("Method: getNearByCities by:" + cityName);
		Map<String, String> coordinates = nearByDetails.getCoordinates(cityName);
		String latitude = coordinates.get("latitude");
		String longitude = coordinates.get("longitude");

		// No Of record desired from API.
		int recordsLimit = 20;
		List<String> nearByCities = nearByDetails.getNearByCities(latitude, longitude, radius, recordsLimit);

		if (nearByCities == null) {
			return null;
		}
		logger.info("Geting matching city in our DB.");
		return cityRepositry.findByCityNameIn(nearByCities);
	}

	public List<PanditDetails> getPanditByServiceNames(List<String> listOfServices, String shortBy) {
		logger.info("Method: getPanditByServiceNames");
		List<String> panditIdByServiceName = findPanditIdByServiceName(listOfServices);

		if (shortBy.equals("Popularity")) {
			return panditDetailsRepositry.findByisActiveAndPanditIdIn("1", panditIdByServiceName);
		} else {
			return panditDetailsRepositry.findByisActiveAndPanditIdInOrderByPanditRatingDesc("1",
					panditIdByServiceName);
		}

	}

	public List<String> findPanditIdByServiceName(List<String> serviceName) {
		logger.info("Method: findPanditIdByServiceName for services:" + serviceName);
		List<Pooja> poojaListByServiceName = poojaServiceRepositry.findByServiceNameIn(serviceName);
		List<String> panditIdList = new ArrayList<>();
		String panditId = null;
		for (Pooja pooja : poojaListByServiceName) {
			panditId = pooja.getPanditId();
			if (panditId != null) {
				panditIdList.add(panditId);
			}
		}
		return panditIdList;

	}

	public List<PanditDetails> getPanditByCityName(List<String> cityList, String shortBy) {
		logger.info("Method: getPanditByCityName for cityList:" + cityList);
		if (cityList.size() == 1 && cityList.get(0).equalsIgnoreCase("All")) {
			logger.info("Getting All Pandit(s) List");
			return getAllActivePanditList();
		}

		logger.info("Retriving all associated pandit(s) address in the city ");
		List<String> addressId = new ArrayList<>();
		addressRepositry.findByisTempleAddressAndCityIn("0", cityList)
				.forEach(address -> addressId.add(address.getId() + ""));

		List<Integer> userIdList = new ArrayList<>();
		List<UserDetailsImpl> usersInCity = userDetailsRepositry.findByAddressIdIn(addressId);
		for (UserDetailsImpl userDetails : usersInCity) {
			userIdList.add(userDetails.getUserId());
		}
		if (shortBy.equals("Popularity")) {
			return panditDetailsRepositry.findByisActiveAndUserIdInOrderByPanditRatingDesc("1", userIdList);
		} else {
			return panditDetailsRepositry.findByisActiveAndUserIdIn("1", userIdList);
		}
	}

	public List<Map<String, Object>> getPanditListInDetails(List<PanditDetails> activePandits) {
		logger.info("Method: getPanditListInDetails");
		List<Map<String, Object>> panditDetailsList = new ArrayList<>();
		String panditId = "";
		UserDetailsImpl userDetails = null;
		Address address = null;
		String addressDetail = "";
		String imagePath = "";
		String Name = "";
		for (PanditDetails pandit : activePandits) {
			Map<String, Object> panditDetails = new HashMap<>();
			panditId = pandit.getPanditId();
			panditDetails.put("Pandit_ID", panditId);
			panditDetails.put("Rating", pandit.getPanditRating());

			// Get the user details
			userDetails = userDetailsRepositry.findByPanditId(panditId);

			// Get the address of user(Pandit)
			address = addressRepositry.findOne(new Integer(userDetails.getAddressId()));
			addressDetail = address.getAddressDetail();

			panditDetails.put("Address_Detail", addressDetail);
			Name = userDetails.getFirstName() + "" + userDetails.getMiddleName() + " " + userDetails.getLastName();
			panditDetails.put("Name", Name);
			panditDetails.put("Primary_Contact_No", userDetails.getPrimaryPhone());

			// Get the image of the pandit
			imagePath = retriveImageService.getImagePath(userDetails.getPhotoId());
			panditDetails.put("Image_Id", imagePath);

			panditDetails.put("Location", address.getCity());

			String poojaServices = pandit.getPoojaServices();

			if (poojaServices != null) {
				if (!poojaServices.isEmpty()) {
					List<String> poojServedList = Arrays.asList(poojaServices.split(","));

					List<String> poojaServicesNames = new ArrayList<>();

					poojaServiceRepositry.findByServiceIdIn(poojServedList)
							.forEach(pooja -> poojaServicesNames.add(pooja.getServiceName()));

					panditDetails.put("Pooja_Services", poojaServicesNames);
				}
			}
			/*
			 * List<String> poojaServicesNames = new ArrayList<>();
			 * poojaServices.getPanditPoojaServicesDetails(panditId) .forEach(pooja ->
			 * poojaServicesNames.add(pooja.getServiceName()));
			 */

			// panditDetails.put("Pooja_Services", poojaServicesNames);
			panditDetails.put("Desc", pandit.getPanditDesc());
			panditDetailsList.add(panditDetails);
		}
		return panditDetailsList;
	}

	public List<PanditDetails> getAllActivePanditList() {
		logger.info("Method: getAllActivePanditList");
		return panditDetailsRepositry.findByisActiveEquals("1");
	}

	public List<PanditTempleAssociation> getPanditsInTemple(String templeId) {
		logger.info("Method: getPanditsInTemple for tampleId:" + templeId);
		return panditTempleAssociationRepositry.findByIsActiveAndTempleId("1", templeId);
	}

	public boolean savePanditReview(Map<String, String> requestParam, Integer userId) {
		logger.info("Method: savePanditReview for request:" + requestParam);
		try {
			String panditId = requestParam.get("panditId");
			String rating = requestParam.get("rating");
			CustomerReview panditReview = new CustomerReview();
			panditReview.setIsActive("1");

			panditReview.setRating(rating);
			panditReview.setReviewDesc(requestParam.get("reviewDesc"));
			panditReview.setPanditId(panditId);
			panditReview.setUserReview(requestParam.get("userReview"));
			panditReview.setUserId(userId + "");
			CustomerReview isSave = customerReviewRepositry.save(panditReview);
			if (isSave == null) {
				return false;
			}
			PanditDetails panditDetails = panditDetailsRepositry.findOne(panditId);
			if (panditDetails != null) {
				int reviewers = panditDetails.getReviewers();
				Double avgRating = ((panditDetails.getPanditRating() * reviewers) + (new Double(rating)))
						/ (reviewers + 1);
				panditDetails.setPanditRating(avgRating);
				panditDetails.setReviewers(panditDetails.getReviewers() + 1);
				panditDetailsRepositry.save(panditDetails);
			}
			logger.info("Review saved successfully..");
			return true;
		} catch (Exception e) {
			logger.error("Error:" + e + " in savePanditReview");
			return false;

		}

	}

	public Response getPanditReview(String panditId) {
		logger.info("Method: getPanditReview for panditId:" + panditId);
		Response response = new Response();
		List<CustomerReview> panditReviewList = customerReviewRepositry.findReview(panditId);
		List<Map<String, Object>> reviewDetailsList = new ArrayList<>();
		Map<String, Object> review = new HashMap<>(2);
		Map<String, Integer> ratingMap = new HashMap<>(5);

		ratingMap.put("1", 0);
		ratingMap.put("2", 0);
		ratingMap.put("3", 0);
		ratingMap.put("4", 0);
		ratingMap.put("5", 0);
		ratingMap.put("Total_reviews", panditReviewList.size());

		if (panditReviewList != null && panditReviewList.size() != 0) {
			Integer userId = null;
			UserDetailsImpl userDetails = null;
			String name = "";
			String addressId = "";
			Address address = null;
			String imageId = "";
			String imagePath = "";
			String rating = "";
			try {
				for (CustomerReview panditReview : panditReviewList) {
					Map<String, Object> map = new HashMap<>();
					userId = new Integer(panditReview.getUserId());
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
					rating = panditReview.getRating();
					map.put("Rating", rating);
					ratingMap.put(rating, ratingMap.get(rating) + 1);
					map.put("ReviewDesc", panditReview.getReviewDesc());
					map.put("UserReview", panditReview.getUserReview());
					Long reviewId = panditReview.getReviewId();
					map.put("Review_Id", reviewId);
					Date reviewDate = customerReviewRepositry.findReviewUpdatedDate(reviewId);
					if (reviewDate != null) {
						map.put("Review_Date", reviewDate);
					} else {
						map.put("Review_Date", customerReviewRepositry.findReviewCreatedDate(reviewId));
					}

					reviewDetailsList.add(map);
				}
				review.put("ReviewOverview", ratingMap);
				review.put("ReviewInDetail", reviewDetailsList);
				response.setStatus(ResponseStatus.OK);
				response.setResponse(review);
				return response;

			} catch (Exception e) {
				logger.error("Error:" + e + " in getPanditReview");
				response.setStatus(ResponseStatus.INTERNAL_SERVER_ERROR);
				response.setResponse("Something went wrong,Please try again in some time");
				return response;
			}
		}
		response.setStatus(ResponseStatus.NO_DATA_FOUND);
		response.setResponse("No Data Found");
		return response;
	}

	public Map<String, Object> getPanditDetails(String panditId, Integer userId) {
		logger.info("Method: getPanditDetails for panditId:" + panditId);
		Map<String, Object> panditDetails = new HashMap<String, Object>();
		Map<String, Object> schedule = new HashMap<String, Object>();
		try {
			PanditDetails pandit = panditDetailsRepositry.findOne(panditId);
			if (pandit == null) {
				logger.error("No such record found for panditId:" + panditId);
				return panditDetails;
			}

			String imageId = pandit.getImageId();
			if (imageId != null) {
				String imagePath = retriveImageService.getImagePath(imageId);

				if (imagePath == null) {
					panditDetails.put("Error", "image is not there in the directory");
					panditDetails.put("Image_Path", "");
				} else {
					panditDetails.put("Image_Path", imagePath);
				}
			} else {
				panditDetails.put("Error", "No Image");
				panditDetails.put("Image_Path", "");
			}

			panditDetails.put("PanditAvgRating", pandit.getPanditRating());

			panditDetails.put("Education_Qualification", pandit.getQualification());

			List<String> languages = new ArrayList<>();
			languageRepositry.findByisActiveAndPanditId("1", panditId)
					.forEach(panditLanguage -> languages.add(panditLanguage.getLanguages().getLanguageName()));

			panditDetails.put("Languages", languages);

			UserDetailsImpl userDetails = userDetailsRepositry.findByUserId(pandit.getUserId());
			String name = userDetails.getFirstName() + " " + userDetails.getMiddleName() + " "
					+ userDetails.getLastName();

			panditDetails.put("Pandit_Name", name);

			panditDetails.put("Pandit_Desc", pandit.getPanditDesc());

			String location = addressRepositry.findOne(new Integer(userDetails.getAddressId())).getCity();

			panditDetails.put("Location", location);

			panditDetails.put("Total_Clients", pandit.getTotalClients());

			panditDetails.put("Specilaization", pandit.getSpecilaization());

			// Distance from user location
			String userLocation = "New Delhi";
			if (userId != 0) {
				userLocation = nearByDetails.getUserLocation(userId);
			}
			String distance = nearByDetails.getDistance(location, userLocation);

			String[] specilaizations = pandit.getSpecilaization().split(",");

			panditDetails.put("Distance", distance);
			panditDetails.put("Specilaization", specilaizations);
			Map<String, Object> availabilityTimings = panditDailyAvailability(pandit);

			schedule.put("Daily_Availability", availabilityTimings);
			schedule.put("Non_Availability", getPanditSchedule(panditId));
			panditDetails.put("Schedule", schedule);
			/*
			 * List<String> poojaServices = new ArrayList<>();
			 * poojaServiceRepositry.findByisActiveAndPanditId("1", panditId) .forEach(pooja
			 * -> poojaServices.add(pooja.getServiceName()));
			 * 
			 * panditDetails.put("Pooja_Services", poojaServices);
			 */

			if (pandit.getIsAssociatedWithTemple().equals("1")) {
				List<String> templeIdList = new ArrayList<>();
				String[] associatedtemplesIdList = pandit.getTempleIdList().split(",");

				for (String templeId : associatedtemplesIdList) {
					templeIdList.add(templeId);
				}
				List<Temple> templesByTempleIdList = templeServices.getTemplesByTempleIdList(templeIdList);
				List<Map<String, Object>> templeListInDetails = templeServices
						.getTempleListInDetails(templesByTempleIdList);

				panditDetails.put("Temples", templeListInDetails);
			}

		} catch (Exception e) {
			logger.error("Error:" + e + " in getPanditDetails");
			return null;
		}
		return panditDetails;
	}

	public Response getPanditAwardsDetails(String panditId) {
		logger.info("Method: getPanditAwardsDetails for panditId:" + panditId);
		List<Map<String, String>> allAwardsDetailsList = new ArrayList<>();
		Response response = new Response();

		try {
			PanditDetails pandit = panditDetailsRepositry.findOne(panditId);

			if (pandit != null) {
				String awardsDetailsJson = pandit.getAwardsDetails();

				if (awardsDetailsJson != null) {
					try {

						JSONArray awardsDetailsArray = new JSONArray(awardsDetailsJson);
						int length = awardsDetailsArray.length();
						JSONObject singleAwardDetail = null;
						Map<String, String> awardsDetails = new HashMap<>();

						String imageId = "";
						String desc = "";
						String awardName = "";

						for (int i = 0; i < length; i++) {

							singleAwardDetail = (JSONObject) awardsDetailsArray.get(i);

							imageId = (String) singleAwardDetail.get("Image_Id");
							desc = (String) singleAwardDetail.get("Desc");
							awardName = (String) singleAwardDetail.get("Name");

							awardsDetails.put("Image_Id", retriveImageService.getImagePath(imageId));
							awardsDetails.put("Desc", desc);
							awardsDetails.put("Award_Name", awardName);

							allAwardsDetailsList.add(awardsDetails);
						}
						response.setStatus(ResponseStatus.OK);
						response.setResponse(allAwardsDetailsList);
						return response;

					} catch (Exception e) {
						logger.error("Error:" + e + " in getPanditAwardsDetails");
						response.setStatus(ResponseStatus.INTERNAL_SERVER_ERROR);
						response.setResponse("Something went wrong.");
						return response;
					}
				} else {
					logger.info("No awards found for panditId:" + panditId);
					response.setStatus(ResponseStatus.NO_DATA_FOUND);
					response.setResponse("No awards found");
					return response;
				}

			} else {
				logger.info("Not such record found for panditId:" + panditId);
				response.setStatus(ResponseStatus.NO_DATA_FOUND);
				response.setResponse("No such pandit found");
				return response;
			}
		} catch (Exception e) {
			logger.error("Error:" + e + "in getPanditAwardsDetails");
			response.setStatus(ResponseStatus.INTERNAL_SERVER_ERROR);
			response.setResponse("Something went wrong.Please try after some time.");
			return response;
		}
	}

	public Response getPanditPoojaServices(String panditId) {
		logger.info("Method: getPanditPoojaServices for panditId:" + panditId);
		Response response = new Response();
		List<Map<String, String>> poojaServices = new ArrayList<>();
		List<Pooja> poojaServicesList = poojaServiceRepositry.findByisActiveAndPanditId("1", panditId);
		if (poojaServicesList != null) {
			String serviceId = "";
			PoojaServicesPricing servicesPricing = null;
			// get the pricing for the premium package
			final String poojaPackageCategoryId = "3";

			try {
				for (Pooja pooja : poojaServicesList) {
					Map<String, String> map = new HashMap<>();
					pooja.setImageId(retriveImageService.getImagePath(pooja.getImageId()));
					serviceId = pooja.getServiceId();
					map.put("Image_Id", pooja.getImageId());
					map.put("Service_Id", serviceId);
					map.put("Pooja_Name", pooja.getServiceName());
					map.put("Service_Desc", pooja.getServiceDesc());
					servicesPricing = poojaServicePricingRepositry
							.findOne(new PoojaServicePricingPrimaryKey(serviceId, poojaPackageCategoryId));
					map.put("Pooja_Discounted_Price",
							(servicesPricing.getPrice() - servicesPricing.getDiscount()) + "");
					map.put("Pooja_Package_Id",
							servicesPricing.getPoojaServicePricingPrimaryKey().getPoojaPackageCategoryId());
					poojaServices.add(map);
				}
			} catch (Exception e) {
				logger.error("Error:" + e + "in getPanditPoojaServices");
				response.setStatus(ResponseStatus.INTERNAL_SERVER_ERROR);
				response.setResponse("Something went wrong.Please try after some time.");
			}

			response.setStatus(ResponseStatus.OK);
			response.setResponse(poojaServices);
		} else {
			response.setStatus(ResponseStatus.NO_DATA_FOUND);
			response.setResponse("Data not Found");
		}
		return response;

	}

	public Response getPanditArticles(String panditId) {
		logger.info("getPanditArticles for panditId:" + panditId);
		Response response = new Response();

		PanditDetails panditDetails = panditDetailsRepositry.findOne(panditId);
		if (panditDetails != null) {

			String articlesDetails = panditDetails.getArticlesDetails();

			if (articlesDetails != null && !articlesDetails.equals("")) {

				try {
					JSONArray articalesDetailsJsonArray = new JSONArray(articlesDetails);
					int totalArticales = articalesDetailsJsonArray.length();

					List<Map<String, String>> articlesList = new ArrayList<>();
					JSONObject articalesDetailsJson = null;

					String articleName = "";
					String articleURL = "";

					for (int i = 0; i < totalArticales; i++) {
						Map<String, String> articlesDetailsMap = new HashMap<>();
						articalesDetailsJson = (JSONObject) articalesDetailsJsonArray.get(i);

						articleName = articalesDetailsJson.getString("Article_Name");
						articleURL = articalesDetailsJson.getString("URL");

						articlesDetailsMap.put("Article_Name", articleName);
						articlesDetailsMap.put("Article_URL", articleURL);
						articlesList.add(articlesDetailsMap);
					}

					response.setStatus(ResponseStatus.OK);
					response.setResponse(articlesList);

				} catch (JSONException e) {
					logger.error("Error:" + e + "in getPanditArticles");
					response.setStatus(ResponseStatus.INTERNAL_SERVER_ERROR);
					response.setResponse("Something went wrong.Please try after some time");
				}
			} else {
				response.setStatus(ResponseStatus.NO_DATA_FOUND);
				response.setResponse("No articles found ");
			}

		} else {
			response.setStatus(ResponseStatus.INVALID);
			response.setResponse("Invalid search Id");
		}
		return response;
	}

	public Map<String, Object> getPanditSchedule(String panditId) {
		logger.info("Method: getPanditSchedule for panditId:" + panditId);
		Map<String, Object> schedule = new HashMap<>();

		List<Map<String, Object>> panditBookingDetails = getPanditBookingDetails(panditId);
		if (panditBookingDetails != null) {
			schedule.put("Bookings", panditBookingDetails);
		} else {
			schedule.put("Bookings", null);
		}

		List<UnavailabilityDetails> unavailabilityDetailList = unavailabilityDetailsRepositry
				.findByisActiveAndPanditId("1", panditId);
		List<Map<String, Object>> list = new ArrayList<>();
		if (unavailabilityDetailList != null) {
			try {
				for (UnavailabilityDetails unavailabilityDetails : unavailabilityDetailList) {
					Map<String, Object> map = new HashMap<>();

					map.put("Unavailable_From", unavailabilityDetails.getFromDate());
					map.put("Unavailable_To", unavailabilityDetails.getToDate());
					list.add(map);
				}
				schedule.put("Unavailable", list);
				return schedule;
			} catch (Exception e) {
				logger.error("Error:" + e + "in getPanditSchedule");
				return schedule;
			}
		} else {
			return schedule;
		}
	}

	public List<Map<String, Object>> getPanditBookingDetails(String panditId) {
		logger.info("Method: getPanditBookingDetails for panditId:" + panditId);
		List<PoojaBookingDetails> poojaBookingDetailsList = poojaBookingDetailsRepositry.findByisActiveAndPanditId("1",
				panditId);
		List<Map<String, Object>> listOfBookings = new ArrayList<>();
		try {
			for (PoojaBookingDetails poojaBookingDetails : poojaBookingDetailsList) {
				Map<String, Object> bookingDetails = new HashMap<>();
				if (poojaBookingDetails != null) {
					String noOfDays = poojaBookingDetails.getNoOfDays();
					bookingDetails.put("Booked_For_Days", noOfDays);
					if (poojaBookingDetails.getIsMultiDays().equalsIgnoreCase("1")) {
						bookingDetails.put("Booked_On", poojaBookingDetails.getDateBooked());
					}

					// Date dateCompleted =
					// poojaBookingDetails.getDateCompleted();
					bookingDetails.put("Booked_From", poojaBookingDetails.getDateConducted());

					/*
					 * Calendar cal = Calendar.getInstance(); cal.setTime(dateCompleted);
					 * cal.add(Calendar.DATE, new Integer(noOfDays) - 1);
					 */

					bookingDetails.put("Booked_To", poojaBookingDetails.getDateCompleted());
					bookingDetails.put("Timing", poojaBookingDetails.getTiming());
					bookingDetails.put("Pooja_Desc", poojaBookingDetails.getPoojaDesc());
				}
				listOfBookings.add(bookingDetails);
			}
			return listOfBookings;
		} catch (Exception e) {
			logger.error("Error:" + e + " in getPanditBookingDetails");
			return listOfBookings;
		}
	}

	public Map<String, Object> panditDailyAvailability(PanditDetails pandit) {
		Map<String, Object> availabilityTimings = new HashMap<>();

		availabilityTimings.put("MONDAY", pandit.getPanditDailyAvailablityTiming().getMondayTiming());
		availabilityTimings.put("TUESDAY", pandit.getPanditDailyAvailablityTiming().getThuesdayTiming());
		availabilityTimings.put("WEDNESDAY", pandit.getPanditDailyAvailablityTiming().getWednesdayTiming());
		availabilityTimings.put("THURSDAY", pandit.getPanditDailyAvailablityTiming().getThursdayTiming());
		availabilityTimings.put("FRIDAY", pandit.getPanditDailyAvailablityTiming().getFridayTiming());
		availabilityTimings.put("SATURDAY", pandit.getPanditDailyAvailablityTiming().getSaturdayTiming());
		availabilityTimings.put("SUNDAY", pandit.getPanditDailyAvailablityTiming().getSundayTiming());

		return availabilityTimings;
	}

	private int[] panditJiWeeklyUnavaibality(PanditDetails panditDetails) {
		PanditDailyAvailibility panditDailyAvailablityTiming = panditDetails.getPanditDailyAvailablityTiming();
		if (panditDailyAvailablityTiming.getIsAvailableOnALlDays().equals("1")) {
			return (new int[] { 1, 1, 1, 1, 1, 1, 1 });
		} else {
			int[] intArray = new int[7];

			// Sunday is assumed as start day of the week
			if (panditDailyAvailablityTiming.getSundayTiming() != null) {
				intArray[0] = 1;
			}
			if (panditDailyAvailablityTiming.getMondayTiming() != null) {
				intArray[1] = 1;
			}
			if (panditDailyAvailablityTiming.getThuesdayTiming() != null) {
				intArray[2] = 1;
			}
			if (panditDailyAvailablityTiming.getWednesdayTiming() != null) {
				intArray[3] = 1;
			}
			if (panditDailyAvailablityTiming.getThursdayTiming() != null) {
				intArray[4] = 1;
			}
			if (panditDailyAvailablityTiming.getFridayTiming() != null) {
				intArray[5] = 1;
			}
			if (panditDailyAvailablityTiming.getSaturdayTiming() != null) {
				intArray[6] = 1;
			}
			return intArray;
		}
	}

	public Response getTopPanditsInCity(String city) {
		Response response = new Response();
		List<String> cityList = new ArrayList<>();

		List<PanditDetails> fiveTopRatedPandits = new ArrayList<>();
		cityList.add(city);

		List<PanditDetails> panditByCityName = getPanditByCityName(cityList, "popularity");
		List<Map<String, Object>> topPanditList = new ArrayList();

		if (panditByCityName == null || panditByCityName.isEmpty()) {
			response.setStatus(ResponseStatus.NO_DATA_FOUND);
			response.setResponse("No temples found for the city:" + city);
		} else {
			Collections.sort(panditByCityName,
					(pandit1, pandit2) -> pandit1.getPanditRating().compareTo(pandit2.getPanditRating()));

			if (panditByCityName.size() > 5) {
				panditByCityName.subList(0, 4);
			}

			for (PanditDetails pandit : panditByCityName) {

				Map<String, Object> map = new HashMap<>();
				UserDetailsImpl userDetailsImpl = userDetailsRepositry.findByUserId(pandit.getUserId());

				String name = userDetailsImpl.getFirstName() + " " + userDetailsImpl.getMiddleName() + " "
						+ userDetailsImpl.getLastName();
				map.put("Pandit_Name", name);

				map.put("Image_Path", retriveImageService.getImagePath(pandit.getImageId()));
				map.put("Rating", pandit.getPanditRating());
				map.put("City", city);
				map.put("Pandit_Id", pandit.getPanditId());

				topPanditList.add(map);

			}

			response.setStatus(ResponseStatus.OK);
			response.setResponse(topPanditList);
		}

		return response;
	}

	public String[] getPoojaServedByandit(String panditId) {
		PanditDetails panditDetails = panditDetailsRepositry.findByPanditId(panditId);
		String[] poojaServices = null;
		if (panditDetails != null) {
			poojaServices = panditDetails.getPoojaServices().split(",");
		}
		return poojaServices;
	}

	public Response getPanditPoojaServicesDetails(String panditId) {
		logger.info("Method: getPanditPoojaServicesDetails for panditId:" + panditId);
		Response response = new Response();
		List<Map<String, String>> poojaServices = new ArrayList<>();
		PanditDetails panditDetails = panditDetailsRepositry.findByPanditId(panditId);

		List<String> poojaIdList = null;

		if (panditDetails != null) {
			poojaIdList = Arrays.asList(panditDetails.getPoojaServices().split(","));
		}

		List<Pooja> poojaServicesList = poojaServiceRepositry.findByServiceIdIn(poojaIdList);
		if (poojaServicesList != null) {
			String serviceId = "";
			PoojaServicesPricing servicesPricing = null;
			// get the pricing for the premium package
			final String poojaPackageCategoryId = "3";

			try {
				for (Pooja pooja : poojaServicesList) {
					Map<String, String> map = new HashMap<>();
					pooja.setImageId(retriveImageService.getImagePath(pooja.getImageId()));
					serviceId = pooja.getServiceId();
					map.put("Image_Id", pooja.getImageId());
					map.put("Service_Id", serviceId);
					map.put("Pooja_Name", pooja.getServiceName());
					map.put("Service_Desc", pooja.getServiceDesc());
					servicesPricing = poojaServicePricingRepositry
							.findOne(new PoojaServicePricingPrimaryKey(serviceId, poojaPackageCategoryId));
					map.put("Pooja_Discounted_Price",
							(servicesPricing.getPrice() - servicesPricing.getDiscount()) + "");
					map.put("Pooja_Package_Id",
							servicesPricing.getPoojaServicePricingPrimaryKey().getPoojaPackageCategoryId());
					poojaServices.add(map);
				}
			} catch (Exception e) {
				logger.error("Error:" + e + "in getPanditPoojaServices");
				response.setStatus(ResponseStatus.INTERNAL_SERVER_ERROR);
				response.setResponse("Something went wrong.Please try after some time.");
			}

			response.setStatus(ResponseStatus.OK);
			response.setResponse(poojaServices);
		} else {
			response.setStatus(ResponseStatus.NO_DATA_FOUND);
			response.setResponse("Data not Found");
		}
		return response;

	}

	public List<PanditDetails> getPanditByPanditName(String panditName) {
		List<Integer> userByName = userServices.getUserByNameLike(panditName);

		return panditDetailsRepositry.findByisActiveAndUserIdIn("1", userByName);
	}

	public Response searchPandit(String searchParam) {
		Response response = new Response();
		List<PanditDetails> panditByPanditName = getPanditByPanditName(searchParam);

		if (panditByPanditName != null) {
			if (!panditByPanditName.isEmpty()) {
				List<Map<String, Object>> panditListInDetails = getPanditListInDetails(panditByPanditName);

				response.setStatus(ResponseStatus.OK);
				response.setResponse(panditListInDetails);
			} else {
				response.setStatus(ResponseStatus.NO_DATA_FOUND);
				response.setResponse("No record with matching param");
			}

		} else {
			response.setStatus(ResponseStatus.NO_DATA_FOUND);
			response.setResponse("No record with matching param");
		}
		return response;
	}
}
