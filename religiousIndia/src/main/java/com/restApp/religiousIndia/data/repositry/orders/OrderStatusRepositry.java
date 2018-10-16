package com.restApp.religiousIndia.data.repositry.orders;

import org.springframework.data.repository.CrudRepository;

import com.restApp.religiousIndia.data.entities.orders.OrderStatus;

public interface OrderStatusRepositry extends CrudRepository<OrderStatus, String> {

}
