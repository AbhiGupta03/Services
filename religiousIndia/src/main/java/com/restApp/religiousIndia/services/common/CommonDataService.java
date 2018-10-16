package com.restApp.religiousIndia.services.common;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.restApp.religiousIndia.data.entities.Cities;
import com.restApp.religiousIndia.data.repositry.CityRepositry;
import com.restApp.religiousIndia.data.repositry.login.LoginTypesRepositry;

@Service
@Scope("prototype")
public class CommonDataService {

	@Autowired
	CityRepositry cityRepositry;

	@Autowired
	LoginTypesRepositry loginTypesRepositry;

	public List<Cities> getAllCities() {
		Iterable<Cities> allCitiesData = cityRepositry.findBypopularIsNotNullOrderByCityNameAsc();

		Collections.sort((List<Cities>) allCitiesData);

		return (List<Cities>) allCitiesData;
	}

	public String getLoginType(String loginId) {
		return loginTypesRepositry.findOne(loginId).getLoginType();
	}

	public List<String> getAllStates() {
		List<String> statesList = getAllCities().stream().map(data->data.getState()).collect(Collectors.toList()).stream().distinct().sorted().collect(Collectors.toList());
		return statesList;
	}
}
