package com.restApp.religiousIndia.controllers.temple;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.restApp.religiousIndia.data.entities.pooja.Pooja;
import com.restApp.religiousIndia.request.filter.PostRequest;
import com.restApp.religiousIndia.request.filter.PostRequestWithOutArray;
import com.restApp.religiousIndia.response.Response;
import com.restApp.religiousIndia.response.status.ResponseStatus;
import com.restApp.religiousIndia.services.pooja.PoojaServices;
import com.restApp.religiousIndia.services.temple.TempleServices;

@RestController
@CrossOrigin
public class TempleController {
	private static Logger logger = Logger.getLogger(TempleController.class);
	@Autowired
	TempleServices templeDataServices;

	@Autowired
	PoojaServices poojaServices;

	@GetMapping("/getAllTempleList")
	public List<Map<String, Object>> getTempleDetails() {
		return templeDataServices.getAllActiveTempleList();
	}

	@GetMapping("/getAllPoojaServices")
	public List<Pooja> getAllPoojaServices() {
		logger.info("All Pooja Services");
		return poojaServices.getTemplePoojaServices();
	}

	@GetMapping("/getAllPoojaServices/{templeId}")
	public ResponseEntity<Response> getPoojaServicesForTemple(@PathVariable("templeId") String templeId) {
		logger.info("Pooja Services for templeId:" + templeId);
		return ResponseEntity.ok(poojaServices.getTemplePoojaServices(templeId));

	}

	@GetMapping("/getTempleDetails/{id}")
	public ResponseEntity<Map<String, Object>> getTempleDetails(@PathVariable("id") String templeId) {
		logger.info("Temple Details for TempleId:" + templeId);

		Map<String, Object> templeDetails = templeDataServices.templeDetails(templeId);

		String error = (String) templeDetails.get("Error");
		if (error != null) {
			logger.error("Error in Temple Details for Temple Id:" + templeId);
		}
		return ResponseEntity.ok(templeDetails);
	}

	@GetMapping("/getTempleConnectivityDetails/{city}/{id}")
	public ResponseEntity<Map<String, Object>> getTempleCOnnectivityDetails(@PathVariable("id") String templeId,
			@PathVariable("city") String city) {
		logger.info("Temple Connectivity details for templeId:" + templeId);

		Map<String, Object> templeDetails = templeDataServices.getTempleConnectivityDetails(templeId, city);

		String error = (String) templeDetails.get("Error");
		if (error != null) {
			logger.error("Error in Temple Connectivity Details for Temple Id:" + templeId);

		}
		return ResponseEntity.ok(templeDetails);
	}

	@PostMapping("/getTemplesByFilters")
	public List<Map<String, Object>> getTemplesByFilters(@RequestBody PostRequest filterRequest) {
		List<Map<String, Object>> templesByFilters = null;
		if (filterRequest != null) {
			logger.info("Temples under Filter criteria:" + filterRequest.getRequestParam());

			templesByFilters = templeDataServices.getTemplesByFilters(filterRequest);
		} else {
			logger.debug("No Temples Found in the particular filter data");
			return templesByFilters;
		}
		return templesByFilters;
	}

	@GetMapping("/getNearByTemples/{templeId}")
	public List getNearByTemplesFrom(@PathVariable("templeId") String templeId) {
		logger.info("NearBy temples of TempleId:" + templeId);

		return templeDataServices.getNearByTemples(templeId);
	}

	@GetMapping("/templeOverViewByTempleId/{templeID}")
	public Map<String, Object> templeOverViewDetailsByTempleId(@PathVariable("templeID") String templeId) {
		logger.info("Temple Over view Details for the TempleId:" + templeId);

		return templeDataServices.templeOverView(templeId);
	}

	@GetMapping("/getTempleImageGallery/{templeId}")
	protected ResponseEntity<Response> getTempleImageGallery(@PathVariable("templeId") String templeId) {
		logger.info("Getting images from gallery of templeId:" + templeId);

		Response response = new Response();

		List<String> templeImageGallery = templeDataServices.getTempleImageGallery(templeId);
		List<String> templeVideoGallery = null;
		Map<String, List> gallery = new HashMap<>(2);
		if (templeImageGallery == null) {
			response.setStatus(ResponseStatus.NO_DATA_FOUND);
			response.setResponse("No Data Found");
		} else {
			gallery.put("Images", templeImageGallery);
			gallery.put("Videos", templeVideoGallery);
			response.setStatus(ResponseStatus.OK);
			response.setResponse(gallery);
		}
		return ResponseEntity.ok(response);
	}

	@PostMapping("/saveTempleReview")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<Response> saveTempleReview(@RequestBody PostRequestWithOutArray reviewRequest) {
		Response response = new Response();
		if (reviewRequest.getRequestType().equals("save")) {
			Map<String, String> requestParam = reviewRequest.getRequestParam();
			boolean isSaved = templeDataServices.saveTempleReview(requestParam);
			if (isSaved) {
				response.setStatus(ResponseStatus.OK);
				response.setResponse("Saved Successfully");
				return ResponseEntity.ok(response);
			} else {
				response.setStatus(ResponseStatus.INTERNAL_SERVER_ERROR);
				response.setResponse("Something went wrong.Please try later");
				return ResponseEntity.ok(response);
			}
		}

		response.setStatus(ResponseStatus.INVALID);
		response.setResponse("No such request param found");
		return ResponseEntity.ok(response);
	}

	@GetMapping("/getPopularTemples")
	public ResponseEntity<Response> getPopularTemples() {
		Response response = templeDataServices.getPopularTemples();
		if (response.getStatus().equals(ResponseStatus.OK)) {
			return ResponseEntity.ok(response);
		} else {
			response.setStatus(ResponseStatus.NO_DATA_FOUND);
			response.setResponse("No popular temples found");
			return ResponseEntity.ok(response);
		}
	}
}
