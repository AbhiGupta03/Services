package com.restApp.religiousIndia.services.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restApp.religiousIndia.data.repositry.orders.OrderStatusRepositry;

@Service
public class OrderServicesImpl implements OrderServices {

	@Autowired
	OrderStatusRepositry orderStatusRepositry;

	public String getOrderStatus(String statusId) {
		return orderStatusRepositry.findOne(statusId).getStatus();
	}

}
