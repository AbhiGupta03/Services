package com.restApp.religiousIndia.services.pooja;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restApp.religiousIndia.data.entities.pooja.Pooja;
import com.restApp.religiousIndia.data.entities.pooja.PoojaServicesPricing;
import com.restApp.religiousIndia.data.entities.users.CustomerReview.CustomerReview;
import com.restApp.religiousIndia.data.repositry.poojeServices.PoojaServicePricingRepositry;
import com.restApp.religiousIndia.data.repositry.poojeServices.PoojaServiceRepositry;
import com.restApp.religiousIndia.data.repositry.users.customerReview.CustomerReviewRepositry;
import com.restApp.religiousIndia.response.Response;
import com.restApp.religiousIndia.response.status.ResponseStatus;
import com.restApp.religiousIndia.services.imageServices.RetriveImageService;
import com.restApp.religiousIndia.utilities.compositePrimary.PoojaServicePricingPrimaryKey;

@Service
public class PoojaServices {
	private static Logger logger = Logger.getLogger(PoojaServices.class);

	@Autowired
	PoojaServiceRepositry poojaServiceRepositry;

	@Autowired
	RetriveImageService retriveImageService;

	@Autowired
	PoojaServicePricingRepositry poojaServicePricingRepositry;

	@Autowired
	CustomerReviewRepositry customerReviewRepositry;

	public Response getTemplePoojaServices(String templeId) {
		Response response = new Response();
		List<Pooja> listPooja = poojaServiceRepositry.findByisActiveAndTempleId("1", templeId);

		List<Map<String, Object>> list = new ArrayList<>();
		// Choosing pooja category premium
		String poojaPackageCategoryId = "3";

		if (listPooja.size() != 0) {
			try {
				for (Pooja pooja : listPooja) {
					Map<String, Object> map = new HashMap<>();
					pooja.setImageId(retriveImageService.getImagePath(pooja.getImageId()));
					// getting prices for Preminum pooja services
					PoojaServicesPricing servicesPricing = poojaServicePricingRepositry
							.findOne(new PoojaServicePricingPrimaryKey(pooja.getServiceId(), poojaPackageCategoryId));

					map.put("ImageId", pooja.getImageId());
					map.put("ServiceId", pooja.getServiceId());
					map.put("ServiceName", pooja.getServiceName());
					map.put("ServiceDesc", pooja.getServiceDesc());
					map.put("PackageId",
							servicesPricing.getPoojaServicePricingPrimaryKey().getPoojaPackageCategoryId());
					map.put("Price", servicesPricing.getPrice());
					map.put("Discount", servicesPricing.getDiscount());

					list.add(map);
				}
				response.setStatus(ResponseStatus.OK);
				response.setResponse(list);
				return response;
			} catch (Exception e) {
				logger.error("Error:" + e);
				response.setStatus(ResponseStatus.INTERNAL_SERVER_ERROR);
				response.setResponse("Something went wrong.Please try after some time");
				return response;
			}
		} else {
			response.setStatus(ResponseStatus.NO_DATA_FOUND);
			response.setResponse("No pooja Services found. Corresponding to templeId:" + templeId);
			return response;
		}
	}

	public List<Pooja> getTemplePoojaServices() {
		List<Pooja> listPooja = poojaServiceRepositry.findByisActive("1");
		// TO-DO enable after enter all images
		/*
		 * for (Pooja pooja : listPooja) {
		 * pooja.setImageId(retriveImageService.getImagePath(pooja.getImageId())
		 * ); }
		 */
		return listPooja;
	}

	public List<Pooja> getPanditPoojaServices(String panditId) {
		List<Pooja> list = poojaServiceRepositry.findByisActiveAndPanditId("1", panditId);
		return list;
	}

	public boolean savePoojaReview(Map<String, String> requestParam) {

		try {
			CustomerReview poojaReview = new CustomerReview();
			poojaReview.setIsActive("1");

			poojaReview.setRating(requestParam.get("rating"));
			poojaReview.setReviewDesc(requestParam.get("reviewDesc"));
			poojaReview.setPoojaId(requestParam.get("poojaId"));
			poojaReview.setBookingId("1");

			poojaReview.setUserReview(requestParam.get("userReview"));
			poojaReview.setUserId(requestParam.get("userId"));
			CustomerReview isSave = customerReviewRepositry.save(poojaReview);
			if (isSave == null) {
				return false;
			}
			logger.info("Review saved successfully..");
			return true;
		} catch (Exception e) {
			logger.error("Error:" + e);
			return false;

		}

	}
}
