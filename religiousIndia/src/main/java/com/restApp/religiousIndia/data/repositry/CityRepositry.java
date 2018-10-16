package com.restApp.religiousIndia.data.repositry;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.restApp.religiousIndia.data.entities.Cities;

@Repository
public interface CityRepositry extends CrudRepository<Cities, Long> {
	List<Cities> findByCityNameIn(List<String> cityName);

	List<Cities> findBypopularIsNotNullOrderByCityNameAsc();

	public static final String Get_City_Id = "select Id from ri_cities where ri_cities.cityname = ?1";

	@Query(value = Get_City_Id, nativeQuery = true)
	public String findCityId(String cityName);
	
}
