package com.restApp.religiousIndia.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.restApp.religiousIndia.response.Response;
import com.restApp.religiousIndia.response.status.ResponseStatus;
import com.restApp.religiousIndia.security.CurrentUser;
import com.restApp.religiousIndia.security.UserPrincipal;
import com.restApp.religiousIndia.services.cart.CartServices;

@RestController
@CrossOrigin
public class CartController {
	private static Logger logger = Logger.getLogger(CartController.class);
	@Autowired
	CartServices cartService;

	@GetMapping("/cart/getUserCart")
	@PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
	public ResponseEntity<Response> getUserCart(@CurrentUser UserPrincipal currentUser) {
		Response response = new Response();

		Integer userId = currentUser.getId();
		response.setStatus(ResponseStatus.OK);
		response.setResponse(cartService.getUserCart(userId));
		return ResponseEntity.ok(response);
	}

	@GetMapping("/cart/removeCartItem/{itemId}")
	@PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
	public ResponseEntity<Response> removeCartItem(@CurrentUser UserPrincipal currentUser,
			@PathVariable("itemId") Integer itemId) {

		Integer userId = currentUser.getId();
		Response response = cartService.removeCartItem(userId, itemId,true);

		return ResponseEntity.ok(response);
	}

	@GetMapping("/cart/changeDonationAmt")
	@PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
	public ResponseEntity<Response> changeDonationAmt(@RequestParam("item") Integer itemId,
			@RequestParam("amt") Double newAmt, @CurrentUser UserPrincipal currentUser) {
		Integer userId = currentUser.getId();
		Response response = cartService.changeDonationAmt(userId, itemId, newAmt);
		return ResponseEntity.ok(response);

	}

	@GetMapping("/cart/moveItemToWishList")
	@PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
	public ResponseEntity<Response> moveItemToWishList(@RequestParam("item") Integer itemId,@RequestParam("price") Double price,
			@CurrentUser UserPrincipal currentUser) {
		Integer userId = currentUser.getId();
		Response response = cartService.moveItemToWishList(itemId, userId,price);
		return ResponseEntity.ok(response);
	}

	@GetMapping("/cart/getUserWishList")
	@PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
	public ResponseEntity<Response> getUserWishList(@CurrentUser UserPrincipal currentUser) {
		logger.info("/getUserWishList");
		Integer userId = currentUser.getId();
		Response response = cartService.getUserWishList(userId);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/cart/moveItemToCart")
	@PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
	public ResponseEntity<Response> moveItemToCart(@CurrentUser UserPrincipal currentUser,@RequestParam("item") Integer itemId) {
		logger.info("/moveItemToCart");
		Integer userId = currentUser.getId();
		Response response = cartService.moveItemToCart(userId,itemId);
		return ResponseEntity.ok(response);
	}

}
