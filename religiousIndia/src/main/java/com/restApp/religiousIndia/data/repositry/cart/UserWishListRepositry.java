package com.restApp.religiousIndia.data.repositry.cart;

import org.springframework.data.repository.CrudRepository;

import com.restApp.religiousIndia.data.entities.cart.UserWishList;

public interface UserWishListRepositry extends CrudRepository<UserWishList, Integer> {
	UserWishList findByUserId(Integer userId);
}
