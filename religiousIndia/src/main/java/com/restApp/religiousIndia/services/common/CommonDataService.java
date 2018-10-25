package com.restApp.religiousIndia.services.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.restApp.religiousIndia.data.entities.Cities;
import com.restApp.religiousIndia.data.entities.Image;
import com.restApp.religiousIndia.data.repositry.CityRepositry;
import com.restApp.religiousIndia.data.repositry.login.LoginTypesRepositry;
import com.restApp.religiousIndia.response.Response;
import com.restApp.religiousIndia.response.status.ResponseStatus;
import com.restApp.religiousIndia.services.imageServices.RetriveImageService;

@Service
@Scope("prototype")
public class CommonDataService {

	@Autowired
	CityRepositry cityRepositry;

	@Autowired
	RetriveImageService retriveImageService;

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
		List<String> statesList = getAllCities().stream().map(data -> data.getState()).collect(Collectors.toList())
				.stream().distinct().sorted().collect(Collectors.toList());
		return statesList;
	}

	public Response getLatestUploadedImages() {
		Response response = new Response();
		List<Image> latestUploadedImages = retriveImageService.getLatestUploadedImages();

		if (latestUploadedImages != null) {
			List<String> imagePaths = getImagePaths(latestUploadedImages);
			response.setStatus(ResponseStatus.OK);
			response.setResponse(imagePaths);

		} else {
			response.setStatus(ResponseStatus.NO_DATA_FOUND);
			response.setResponse("No Data Found");
		}
		return response;
	}

	private List<String> getImagePaths(List<Image> latestUploadedImages) {
		List<String> imagePathList = new ArrayList<>(10);
		for (Image image : latestUploadedImages) {
			imagePathList.add(image.getImagePath());
		}
		return imagePathList;
	}
}
