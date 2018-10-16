package com.restApp.religiousIndia.services.homeDataService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restApp.religiousIndia.data.entities.FamousThoughts;
import com.restApp.religiousIndia.data.entities.HomeBanner;
import com.restApp.religiousIndia.data.entities.MainMenuItem;
import com.restApp.religiousIndia.data.repositry.HomeBannerRepositry;
import com.restApp.religiousIndia.data.repositry.ImagesRepositry;
import com.restApp.religiousIndia.data.repositry.MainMenuRepositry;
import com.restApp.religiousIndia.data.repositry.TempleRepositry;
import com.restApp.religiousIndia.data.repositry.ThoughtRepositry;
import com.restApp.religiousIndia.services.imageServices.RetriveImageService;

@Service
public class HomeDataService {
	@Autowired
	ThoughtRepositry thoughtRepositry;

	@Autowired
	MainMenuRepositry mainMenuRepositry;

	@Autowired
	HomeBannerRepositry homeBannerRepositry;

	@Autowired
	RetriveImageService retriveImageService;

	@Autowired
	TempleRepositry templeRepositry;

	@Autowired
	ImagesRepositry dummyRepositry;

	public Iterable<FamousThoughts> getAllThoughts() {
		try {
			return thoughtRepositry.findAll();
		} catch (Exception e) {
			return null;
		}
	}

	public List<MainMenuItem> getHomeMenuActiveTab() {
		try {
			return mainMenuRepositry.findByisActiveEquals("1");
		} catch (Exception e) {
			return null;
		}

	}

	public List<Map<String, String>> getBannerDetails() {
		try {
			Map<String, String> allBannersDetails = new HashMap<String, String>();
			List<Map<String, String>> listofBanners = new ArrayList<Map<String, String>>();
			List<HomeBanner> allBanners = homeBannerRepositry.findByisActiveEquals("1");
			for (HomeBanner homeBanner : allBanners) {
				String imageId = homeBanner.getImageId();
				allBannersDetails.put("IMAGE_ID", imageId);
				allBannersDetails.put("IMAGE_NAME", homeBanner.getBannerName());
				allBannersDetails.put("ITEM_ID", homeBanner.getItemId());
				allBannersDetails.put("SUB_ITEM_ID", homeBanner.getSubItemId());
				allBannersDetails.put("DATA_ID", homeBanner.getDataId());

				listofBanners.add(allBannersDetails);
			}
			return listofBanners;
		} catch (Exception e) {
			return null;
		}
	}

	public List<Map<String, String>> getHomeBannerDetails() {
		try {

			List<Map<String, String>> listofBanners = new ArrayList<Map<String, String>>();

			List<HomeBanner> allBanners = homeBannerRepositry.findByisActiveEquals("1");
			for (HomeBanner homeBanner : allBanners) {
				Map<String, String> bannersDetails = new HashMap<String, String>();
				String imageId = homeBanner.getImageId();
				bannersDetails.put("IMAGE_ID", imageId);
				bannersDetails.put("BANNER_NAME", homeBanner.getBannerName());
				bannersDetails.put("ITEM_ID", homeBanner.getItemId());
				bannersDetails.put("SUB_ITEM_ID", homeBanner.getSubItemId());
				bannersDetails.put("DATA_ID", homeBanner.getDataId());
				bannersDetails.put("BANNER_DESC", homeBanner.getBannerDesc());
				String imagePath = retriveImageService.getImagePath(imageId);
				bannersDetails.put("Image_Path", imagePath);
				listofBanners.add(bannersDetails);

			}
			return listofBanners;

		} catch (Exception e) {
			return null;
		}
	}
}
