package com.restApp.religiousIndia.data.repositry.cart;

import org.springframework.data.repository.CrudRepository;

import com.restApp.religiousIndia.data.entities.cart.UserCart;

public interface CartRepositry extends CrudRepository<UserCart, Integer> {

	UserCart findByUserId(Integer userId);

}
