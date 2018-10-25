package com.restApp.religiousIndia.controllers;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.restApp.religiousIndia.data.entities.Cities;
import com.restApp.religiousIndia.data.entities.FamousThoughts;
import com.restApp.religiousIndia.data.entities.MainMenuItem;
import com.restApp.religiousIndia.data.entities.users.UserDetailsImpl;
import com.restApp.religiousIndia.data.repositry.pandit.PanditDetailsRepositry;
import com.restApp.religiousIndia.response.Response;
import com.restApp.religiousIndia.services.common.CommonDataService;
import com.restApp.religiousIndia.services.homeDataService.HomeDataService;
import com.restApp.religiousIndia.services.imageServices.RetriveImageService;
import com.restApp.religiousIndia.services.pandit.PanditDataService;
import com.restApp.religiousIndia.services.pooja.PoojaServices;
import com.restApp.religiousIndia.services.temple.TempleServices;
import com.restApp.religiousIndia.services.temple.nearBy.NearByDetails;
import com.restApp.religiousIndia.services.users.UserServices;

@RestController
@CrossOrigin
public class CommonControllers {
	private static Logger logger = Logger.getLogger(CommonControllers.class);
	@Autowired
	CommonDataService commonDataService;

	@Autowired
	HomeDataService homeDataService;

	@Autowired
	UserServices userServices;

	@Autowired
	RetriveImageService retriveImageService;

	@Autowired
	TempleServices templeServices;

	@Autowired
	NearByDetails nearByDetails;

	@Autowired
	PoojaServices poojaServices;

	@Autowired
	PanditDetailsRepositry panditDetailsRepositry;

	@Autowired
	PanditDataService panditDataService;

	@GetMapping("/getAllCities")
	public List<Cities> getAllCities() {
		logger.info("All Cities Service.");
		return commonDataService.getAllCities();
	}

	@GetMapping("/getAllStates")
	public List<String> getAllStates() {
		logger.info("All States Service.");
		return commonDataService.getAllStates();
	}

	@GetMapping("/getAllThoughts")
	public Iterable<FamousThoughts> getAllThoughts() {
		logger.info("All thoughts service.");
		Iterable<FamousThoughts> allThoughts = homeDataService.getAllThoughts();

		if (allThoughts != null) {
			return allThoughts;
		} else {
			return null;
		}
	}

	@GetMapping("/getAllHomeMenuTabs")
	public List<MainMenuItem> getActiveMainMenuItems() {
		logger.info("All Home Menu tabs");
		List<MainMenuItem> tabs = homeDataService.getHomeMenuActiveTab();
		if (tabs != null) {
			return tabs;
		} else {
			return null;
		}
	}

	@GetMapping("/getHomeBannerDetails")
	public List<Map<String, String>> getHomeBannerDetails() {
		logger.info("Home Page Banner Details");
		return homeDataService.getBannerDetails();
	}

	@GetMapping("/getBannerDetails")
	public List<Map<String, String>> getBannerDetails() {
		logger.info("Getting Banner Details");
		return homeDataService.getHomeBannerDetails();
	}
	
	/*@GetMapping("/getBannerDetails")
	public List<Map<String, String>> getBannerDetails() {
		logger.info("Getting Banner Details");
		return homeDataService.getBannerDetails();
	}*/

	@GetMapping("/getLogInType/{loginId}")
	public String getLogInType(@PathVariable("loginId") String loginId) {
		return commonDataService.getLoginType(loginId);
	}

	// TO-DO
	@GetMapping("/getUserDetails/{userId}")
	public UserDetailsImpl getUserDetails(@PathVariable("userId") String userId) {
		return userServices.getUserDetails(userId);
	}

	// TO-Do
	@GetMapping("/getPanditDetails")
	public Object getPanditDetails() {
		return panditDetailsRepositry.findOne("1");
		// return panditDetailsRepositry.getAllUsers();
	}

	@GetMapping("/getReview")
	public ResponseEntity<Response> getReview(@RequestParam("type") String type, @RequestParam("id") String id) {
		Response review = null;
		if (type.equalsIgnoreCase("pandit")) {
			review = panditDataService.getPanditReview(id);
		} else if (type.equalsIgnoreCase("services")) {
			// TO_DO
		} else if (type.equalsIgnoreCase("temple")) {
			review = templeServices.getTempleReviews(id);
		}
		return ResponseEntity.ok(review);

	}

	@GetMapping("/getLatestUploadedImages")
	public ResponseEntity<Response> getLatestUploadedImages() {
		return ResponseEntity.ok(commonDataService.getLatestUploadedImages());
	}
}
