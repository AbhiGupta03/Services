package com.restApp.religiousIndia.data.repositry.pandit;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.restApp.religiousIndia.data.entities.pandit.PanditDetails;

public interface PanditDetailsRepositry extends CrudRepository<PanditDetails, String> {
	PanditDetails findByPanditId(String panditId);

	List<PanditDetails> findByisActiveAndPanditIdIn(String isActive, List<String> panditIdList);
	
	List<PanditDetails> findByisActiveAndPanditIdInOrderByPanditRatingDesc(String isActive, List<String> panditIdList);

	List<PanditDetails> findByisActiveEquals(String isActive);

	List<PanditDetails> findByisActiveAndUserIdIn(String isActive, List<Integer> userId);
	
	List<PanditDetails> findByisActiveAndUserIdInOrderByPanditRatingDesc(String isActive, List<Integer> userId);

	List<PanditDetails> findByPanditRatingGreaterThanEqualOrderByPanditRatingDesc(Double rating);
	
	List<PanditDetails> findByPanditRatingGreaterThanEqual(Double rating);
	
	public static final String Get_Five_Top_Rated_Pandit = "select * from ri_pandit_details order by RI_PANDIT_RATING desc LIMIT 5";

	@Query(value = Get_Five_Top_Rated_Pandit, nativeQuery = true)
	List<PanditDetails> getFiveTopRatedPandits();
	
	//List<PanditDetails> findBy
}
