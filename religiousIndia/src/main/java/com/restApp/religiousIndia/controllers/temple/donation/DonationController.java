package com.restApp.religiousIndia.controllers.temple.donation;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.restApp.religiousIndia.data.entities.temple.donation.TempleDonationCategory;
import com.restApp.religiousIndia.data.repositry.temple.donation.ClothDonationRepositry;
import com.restApp.religiousIndia.data.repositry.temple.donation.TempleDonationDetailsRepositry;
import com.restApp.religiousIndia.request.filter.PostRequest;
import com.restApp.religiousIndia.response.Response;
import com.restApp.religiousIndia.security.CurrentUser;
import com.restApp.religiousIndia.security.UserPrincipal;
import com.restApp.religiousIndia.services.temple.donation.DonationService;

@RestController
@CrossOrigin
public class DonationController {

	@Autowired
	TempleDonationDetailsRepositry templeDonationDetailsRepositry;

	@Autowired
	DonationService donationService;

	@Autowired
	ClothDonationRepositry clothDonationRepositry;

	@GetMapping("/getAllDonationCategory")
	public Iterable<TempleDonationCategory> getAllDonationCategory() {
		return donationService.getAllDonationCategory();
	}

	@GetMapping("/getAllDonationDetails/{templeId}")
	public Map<String, Object> getAllDonationDetails(@PathVariable("templeId") String templeId) {
		return donationService.getAllDonationDetails(templeId);
	}

	@PostMapping("/addToCart")
	@PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
	public ResponseEntity<Response> donateMoney(@RequestBody PostRequest donateRequest,
			@CurrentUser UserPrincipal currentUser) {
		Response response = donationService.addTempleDonationToCart(donateRequest, currentUser);

		return ResponseEntity.ok(response);
	}
}
