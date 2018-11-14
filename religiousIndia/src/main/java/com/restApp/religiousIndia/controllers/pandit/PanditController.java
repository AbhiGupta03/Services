package com.restApp.religiousIndia.controllers.pandit;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.restApp.religiousIndia.data.entities.pandit.PanditDetails;
import com.restApp.religiousIndia.data.entities.pandit.PanditTempleAssociation;
import com.restApp.religiousIndia.data.entities.pooja.PoojaServicesPricing;
import com.restApp.religiousIndia.data.entities.users.UserDetailsImpl;
import com.restApp.religiousIndia.data.repositry.language.LanguageRepositry;
import com.restApp.religiousIndia.data.repositry.pandit.PanditDetailsRepositry;
import com.restApp.religiousIndia.data.repositry.users.UserDetailsRepositry;
import com.restApp.religiousIndia.request.filter.PostRequest;
import com.restApp.religiousIndia.request.filter.PostRequestWithOutArray;
import com.restApp.religiousIndia.response.Response;
import com.restApp.religiousIndia.response.status.ResponseStatus;
import com.restApp.religiousIndia.security.CurrentUser;
import com.restApp.religiousIndia.security.UserPrincipal;
import com.restApp.religiousIndia.services.imageServices.RetriveImageService;
import com.restApp.religiousIndia.services.pandit.PanditDataService;
import com.restApp.religiousIndia.services.pooja.PoojaServices;

@RestController
@CrossOrigin
public class PanditController {
	private static Logger logger = Logger.getLogger(PanditController.class);

	@Autowired
	private PanditDetailsRepositry panditDetailsRepositry;

	@Autowired
	private RetriveImageService reetriveImageService;

	@Autowired
	private UserDetailsRepositry userDetailsRepositry;

	@Autowired
	private PanditDataService panditDataService;

	@Autowired
	private PoojaServices poojaServices;

	@Autowired
	private LanguageRepositry languageRepositry;

	@GetMapping("/getPanditAssociatedWithTemple/{templeId}")
	public ResponseEntity<Response> getPanditAssociatedWithTemple(@PathVariable("templeId") String templeId) {
		Response response = new Response();
		try {
			List<PanditTempleAssociation> panditsInTemple = panditDataService.getPanditsInTemple(templeId);
			List<Map<String, Object>> panditDetailsList = new ArrayList<>();
			String panditId = "";
			String imagePath = "";
			UserDetailsImpl userDetails = null;
			for (PanditTempleAssociation panditTempleAssociation : panditsInTemple) {
				Map<String, Object> map = new HashMap<>();
				panditId = panditTempleAssociation.getPanditId();
				PanditDetails panditDetails = panditDetailsRepositry.findByPanditId(panditId);
				userDetails = userDetailsRepositry.findByPanditId(panditId);
				map.put("PanditId", panditId);
				map.put("PostInTemple", panditTempleAssociation.getPanditPostInTemple());
				map.put("PanditCategory", panditDetails.getPanditCategoryId());

				map.put("Location", userDetails.getLocation());
				String middleName = userDetails.getMiddleName();
				if (middleName == null) {
					middleName = "";
				}
				String name = userDetails.getFirstName() + " " + middleName + " " + userDetails.getLastName();

				map.put("Name", name);

				imagePath = reetriveImageService.getImagePath(panditDetails.getImageId());
				map.put("ImageId", imagePath);
				panditDetailsList.add(map);
			}
			response.setStatus(ResponseStatus.OK);
			response.setResponse(panditDetailsList);
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			response.setStatus(ResponseStatus.ERROR);
			response.setResponse("Something went wrong");
			return ResponseEntity.ok(response);
		}
	}

	@PostMapping("/getPanditByFilters")
	public ResponseEntity<Response> getPanditByFilters(@RequestBody PostRequest filterRequest) {
		Response response = new Response();
		try {
			List<Map<String, Object>> panditByFilters = null;
			if (filterRequest != null) {
				logger.info("Pandit(s) under Filter criteria:" + filterRequest.getRequestParam());

				panditByFilters = panditDataService.getPanditByFilters(filterRequest);
				if (panditByFilters != null) {
					response.setStatus(ResponseStatus.OK);
					response.setResponse(panditByFilters);
				} else {
					response.setStatus(ResponseStatus.NO_DATA_FOUND);
					response.setResponse("No record found");
				}
			} else {
				logger.debug("No Pandit Found in the particular filter data");
				response.setStatus(ResponseStatus.BAD_REQUEST);
				response.setResponse("request is invalid");
			}
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			logger.error("Error in getPanditByFilters:" + e);
			response.setStatus(ResponseStatus.INTERNAL_SERVER_ERROR);
			response.setResponse("");
			return ResponseEntity.ok(response);
		}
	}

	@PostMapping("/servicesOrPanditReview")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<Response> saveServicesOrPanditReview(@RequestBody PostRequestWithOutArray reviewRequest,
			@CurrentUser UserPrincipal currentUser) {
		logger.info("/servicesOrPanditReview request");
		Response response = new Response();

		int userId = 0;
		if (currentUser != null) {
			userId = currentUser.getId();
		}

		if (reviewRequest.getRequestType().equalsIgnoreCase("panditReview")) {
			Map<String, String> requestParam = reviewRequest.getRequestParam();
			boolean isSaved = panditDataService.savePanditReview(requestParam, userId);
			if (isSaved) {
				response.setStatus(ResponseStatus.OK);
				response.setResponse("Saved Successfully");
				return ResponseEntity.ok(response);
			} else {
				response.setStatus(ResponseStatus.INTERNAL_SERVER_ERROR);
				response.setResponse("Something went wrong.Please try again later");
				return ResponseEntity.ok(response);
			}
		}

		if (reviewRequest.getRequestType().equalsIgnoreCase("poojaReview")) {
			Map<String, String> requestParam = reviewRequest.getRequestParam();

			boolean isSaved = poojaServices.savePoojaReview(requestParam);
			if (isSaved) {
				response.setStatus(ResponseStatus.OK);
				response.setResponse("Saved Successfully");
				return ResponseEntity.ok(response);
			} else {
				response.setStatus(ResponseStatus.INTERNAL_SERVER_ERROR);
				response.setResponse("Something went wrong.Please try again later");
				return ResponseEntity.ok(response);
			}
		}

		response.setStatus(ResponseStatus.INVALID);
		response.setResponse("No such request param found");
		return ResponseEntity.ok(response);

	}
	// }

	/*
	 * @GetMapping("/getPanditReview/{panditId}") public
	 * ResponseEntity<ResponseWithExtraDetails> getServicesOrPanditReview(
	 * 
	 * @PathVariable("panditId") String panditId) { return
	 * ResponseEntity.ok(panditDataService.getPanditReview(panditId)); }
	 */

	@GetMapping("/getPanditDetails/{panditId}")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<Response> getPanditDetails(@PathVariable("panditId") String panditId,
			@CurrentUser UserPrincipal currentUser) {
		logger.info("Pandit Details for panditId:" + panditId);
		int userId = 0;
		if (currentUser != null) {
			userId = currentUser.getId();
		}
		Response response = new Response();
		Map<String, Object> panditDetails = panditDataService.getPanditDetails(panditId, userId);
		if (panditDetails != null) {
			response.setStatus(ResponseStatus.OK);
			response.setResponse(panditDetails);
			return ResponseEntity.ok(response);
		} else {
			response.setStatus(ResponseStatus.NO_DATA_FOUND);
			response.setResponse("Data not found");
		}
		return ResponseEntity.ok(response);
	}

	/*
	 * @GetMapping("/getPanditSchedule/{panditId}") public ResponseEntity<Response>
	 * getPanditAvailibilityDetails(@PathVariable("panditId") String panditId) {
	 * return ResponseEntity.ok(panditDataService.panditSchedule(panditId)); }
	 */

	@GetMapping("/getPanditAwardsDetails/{panditId}")
	public ResponseEntity<Response> getPanditAwardsDetails(@PathVariable("panditId") String panditId) {
		return ResponseEntity.ok(panditDataService.getPanditAwardsDetails(panditId));
	}

	@GetMapping("/getPanditPoojaServices/{panditId}")
	public ResponseEntity<Response> getPanditPoojaServices(@PathVariable("panditId") String panditId) {
		Response panditPoojaServices = panditDataService.getPanditPoojaServicesDetails(panditId);
		return ResponseEntity.ok(panditPoojaServices);
	}

	@GetMapping("/getPanditArticles/{panditId}")
	public ResponseEntity<Response> getPanditArticles(@PathVariable("panditId") String panditId) {
		Response panditArticles = panditDataService.getPanditArticles(panditId);
		return ResponseEntity.ok(panditArticles);
	}

	@GetMapping("/getTopPanditsInCity/{city}")
	public ResponseEntity<Response> getTopPanditsInCity(@PathVariable("city") String city) {
		Response response = panditDataService.getTopPanditsInCity(city);
		return ResponseEntity.ok(response);
	}

	@GetMapping("/getPoojaServicePackagesDetails")
	public ResponseEntity<Response> getPoojaServicePackagesDetails(@RequestParam("serviceId") String serviceId) {
		Response response = new Response();

		List<PoojaServicesPricing> packagesForPoojaService = poojaServices.getPackagesForPoojaService(serviceId);

		if (packagesForPoojaService != null) {
			if (!packagesForPoojaService.isEmpty()) {
				List<Map<String,Object>> packagesDetail=poojaServices.getPackageInDetails(packagesForPoojaService);
				response.setStatus(ResponseStatus.OK);
				response.setResponse(packagesDetail);
			} else {
				response.setStatus(ResponseStatus.NO_DATA_FOUND);
				response.setResponse("No Package found for requested pooja service");
			}
		} else {
			response.setStatus(ResponseStatus.NO_DATA_FOUND);
			response.setResponse("No Package found for requested pooja service");
		}
		return ResponseEntity.ok(response);

	}

}
