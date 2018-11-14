package com.restApp.religiousIndia.data.repositry.pandit;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.restApp.religiousIndia.data.entities.pandit.CmsPanditDetails;

public interface CMSPanditDetailsRepositry extends CrudRepository<CmsPanditDetails, String> {
	
	/*PanditDetails findByPanditId(String panditId);

	List<PanditDetails> findByisActiveAndPanditIdIn(String isActive, List<String> panditIdList);

	List<PanditDetails> findByisActiveAndPanditIdInOrderByPanditRatingDesc(String isActive, List<String> panditIdList);

	List<PanditDetails> findByisActiveEquals(String isActive);

	List<PanditDetails> findByisActiveAndUserIdIn(String isActive, List<Integer> userId);

	List<PanditDetails> findByisActiveAndUserIdInOrderByPanditRatingDesc(String isActive, List<Integer> userId);

	List<PanditDetails> findByPanditRatingGreaterThanEqualOrderByPanditRatingDesc(Double rating);

	List<PanditDetails> findByPanditRatingGreaterThanEqual(Double rating);*/

	public static final String Get_Cms_Pandits = "select * from ri_pandit_details_temp order by CREATED_ON desc";

	@Query(value = Get_Cms_Pandits, nativeQuery = true)
	List<CmsPanditDetails> getCmsPandits();
}
