package com.restApp.religiousIndia.controllers.orders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.restApp.religiousIndia.services.order.OrderServices;

@RestController
@CrossOrigin
public class OrdersController {
	@Autowired
	OrderServices orderServices;

	// Input: status-Id
	// Output: Status & Status Description
	@GetMapping("/getOrderStatus/{statusId}")
	public String getOrderStatus(@PathVariable("statusId") String statusId) {
		return orderServices.getOrderStatus(statusId);
	}
}
