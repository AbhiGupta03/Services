package com.restApp.religiousIndia.services.temple;

import java.util.List;
import java.util.Map;

import com.restApp.religiousIndia.data.entities.Cities;
import com.restApp.religiousIndia.data.entities.Temple;
import com.restApp.religiousIndia.data.entities.TempleTimings;
import com.restApp.religiousIndia.data.entities.temple.Aarti;
import com.restApp.religiousIndia.request.filter.PostRequest;
import com.restApp.religiousIndia.response.Response;

public interface TempleServices {
	public List<Aarti> getAartiTiming(String templeId);

	public TempleTimings getTempleTimings(String templeId);

	public Map<String, Object> templeDetails(String templeId);

	public Map<String, Object> getTempleConnectivityDetails(String templeId, String currentCity);

	public List<Map<String, Object>> getAllActiveTempleList();

	public List<Cities> getNearByCities(String radius, String cityName);

	public List<Map<String, Object>> getTemplesByCityName(List<String> cityList, String shortBy);

	public List<Map<String, Object>> getTemplesByFilters(PostRequest filterRequest);

	public List<String> findTempleIdByServiceName(List<String> serviceName);

	public Map<String, Object> templeOverView(String templeId);

	public List<String> getTempleImageGallery(String templeId);

	// public List<Map<String, Object>> getNearByTemplesFrom(String cityName);

	public List<Map<String, Object>> getNearByTemples(String templeId);

	public boolean saveTempleReview(Map<String, String> requestParam);

	public Response getTempleReviews(String templeId);

	public List<Temple> getTemplesByTempleIdList(List<String> templeIdList);

	public List<Map<String, Object>> getTempleListInDetails(List<Temple> templesList);

	public Temple getTemplesByTempleId(String templeId);

	public Response getPopularTemples();

}
