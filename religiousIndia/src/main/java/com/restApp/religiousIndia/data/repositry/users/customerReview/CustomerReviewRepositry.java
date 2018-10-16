package com.restApp.religiousIndia.data.repositry.users.customerReview;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.restApp.religiousIndia.data.entities.users.CustomerReview.CustomerReview;

public interface CustomerReviewRepositry extends CrudRepository<CustomerReview, String> {

	List<CustomerReview> findByisActiveAndPanditId(String isActive, String panditId);

	public static final String Review = "SELECT * from RI_CUSTOMER_REVIEWS review HAVING review.PANDIT_ID = ?1 AND review.IS_ACTIVE='1' ORDER BY UPDATED_ON DESC";

	@Query(value = Review, nativeQuery = true)
	public List<CustomerReview> findReview(String panditId);

	public static final String ReviewUpdatedDate = "SELECT Updated_On from RI_CUSTOMER_REVIEWS review WHERE review.REVIEW_ID = ?1 AND review.IS_ACTIVE='1'";

	@Query(value = ReviewUpdatedDate, nativeQuery = true)
	public Date findReviewUpdatedDate(Long reviewId);

	public static final String ReviewCreatedDate = "SELECT Created_On from RI_CUSTOMER_REVIEWS review WHERE review.REVIEW_ID = ?1 AND review.IS_ACTIVE='1'";

	@Query(value = ReviewCreatedDate, nativeQuery = true)
	public Date findReviewCreatedDate(Long reviewId);
}
