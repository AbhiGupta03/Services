package com.restApp.religiousIndia.data.repositry.temple.review;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.restApp.religiousIndia.data.entities.temple.reviews.TempleReview;

public interface TempleReviewRepositry extends CrudRepository<TempleReview, String> {

	List<TempleReview> findByisActiveAndTempleIdOrderByReviewIdDesc(String isActive, String templeId);

}
