package com.restApp.religiousIndia.data.repositry;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.restApp.religiousIndia.data.entities.Temple;
import com.restApp.religiousIndia.data.entities.cmsEntities.CmsTemple;

public interface TempleRepositry extends CrudRepository<Temple, String> {
	List<Temple> findByisActiveEquals(String isActive);

	Temple findByisActiveAndTempleId(String isActive, String templeId);

	List<Temple> findByTempleAddressIdIn(List<String> addressIdList);

	List<Temple> findByTempleAddressIdInOrderByHitsCount(List<String> addressIdList);

	List<Temple> findByisActiveAndTempleIdInOrderByHitsCount(String isActive, List<String> templeIdList);

	List<Temple> findByisActiveAndTempleIdIn(String isActive, List<String> templeIdList);

	public static final String Image_Galley = "SELECT Image_Gallery FROM ri_temple img where img.temple_id = ?1";

	@Query(value = Image_Galley, nativeQuery = true)
	public String findImageGallery(String templeId);

	List<Temple> findByTempleIdIn(List<String> templesIdList);

	static final String Most_Hits = "SELECT * FROM religious_india.ri_temple Order by Hits_Count desc LIMIT 5";

	@Query(value = Most_Hits, nativeQuery = true)
	public List<Temple> findByMostHits();

	Optional<CmsTemple> findByTempleName(String name);
}
