package com.restApp.religiousIndia.services.cmsServices;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restApp.religiousIndia.data.entities.Address;
import com.restApp.religiousIndia.data.entities.Image;
import com.restApp.religiousIndia.data.entities.Temple;
import com.restApp.religiousIndia.data.entities.cmsEntities.CmsTemple;
import com.restApp.religiousIndia.data.entities.users.UserDetailsImpl;
import com.restApp.religiousIndia.data.entities.users.UserRoles;
import com.restApp.religiousIndia.data.repositry.AddresssRepositry;
import com.restApp.religiousIndia.data.repositry.TempleRepositry;
import com.restApp.religiousIndia.data.repositry.cmsDataRepo.CmsTempleDataRepositry;
import com.restApp.religiousIndia.data.repositry.users.UserRolesRepositry;
import com.restApp.religiousIndia.request.filter.PostRequestWithOutArray;
import com.restApp.religiousIndia.response.Response;
import com.restApp.religiousIndia.response.status.ResponseStatus;
import com.restApp.religiousIndia.services.imageServices.RetriveImageService;
import com.restApp.religiousIndia.services.mail.MailService;
import com.restApp.religiousIndia.services.users.UserServices;
import com.restApp.religiousIndia.utilities.EmailValidator;
import com.restApp.religiousIndia.utilities.PhoneNoVaildator;

@Service
public class CmsTempleService {

	private static Logger logger = Logger.getLogger(CmsTempleService.class);

	@Autowired
	private CmsTempleDataRepositry cmsTempleDataRepositry;

	@Autowired
	private TempleRepositry templeRepositry;

	@Autowired
	private RetriveImageService imageService;

	@Autowired
	private MailService mailService;

	@Autowired
	private AddresssRepositry addressRepo;

	@Autowired
	private UserServices userService;

	@Autowired
	private UserRolesRepositry userRolesRepositry;

	public Response saveTempleData(Map<String, Object> map) {
		logger.info("Method:saveTempleData");
		Response response = new Response();

		CmsTemple temple = new CmsTemple();

		try {
			String contactNoList = (String) map.get("contactNo");
			String templeName = (String) map.get("templeName");
			Map<String, String> templeAddress = (Map<String, String>) map.get("address");
			String templeDesc = (String) map.get("templeDesc");
			List<String> templeTimings = (List<String>) map.get("templeTiming");
			List<String> aartiTimings = (List<String>) map.get("aartiTiming");
			String mainImageId = (String) map.get("image");
			List<String> templeGalleryImages = (List<String>) map.get("templeGalleryImages");

			if (contactNoList != null) {
				String contactNo = contactNoList;
				if (PhoneNoVaildator.validatePhone(contactNo)) {
					temple.setContactNo(contactNo);
				}
			} else {
				logger.error("contactNo blank");
				response.setStatus(ResponseStatus.BAD_REQUEST);
				response.setResponse("contactNo is mandatory");
				return response;
			}

			if (templeName != null) {
				String name = templeName;
				boolean isTempleNameExists = cmsTempleDataRepositry.findByTempleName(name).isPresent();
				if (isTempleNameExists) {
					response.setStatus(ResponseStatus.INVALID);
					response.setResponse("Temple Name already exists");
					return response;
				}

				temple.setTempleName(name);
				/*
				 * String imageData = saveTempleImage(name);
				 * 
				 * if (imageData != null) { temple.setMainImageData(imageData); } else {
				 * response.setStatus(ResponseStatus.BAD_REQUEST);
				 * response.setResponse("Temple Name is mandatory"); return response; }
				 */

			} else {
				logger.error("Temple Name");
				response.setStatus(ResponseStatus.BAD_REQUEST);
				response.setResponse("Temple Name is mandatory");
				return response;
			}

			if (mainImageId != null) {
				if (!mainImageId.isEmpty()) {
					temple.setMainImageData(mainImageId);
				} else {
					response.setStatus(ResponseStatus.BAD_REQUEST);
					response.setResponse("Temple main image Id can not be blank.");
					return response;
				}
			} else {
				response.setStatus(ResponseStatus.BAD_REQUEST);
				response.setResponse("Temple main image Id is mandatory");
				return response;
			}

			if (templeAddress != null) {

				if (!templeAddress.isEmpty()) {
					String addressData = saveAddressDataForTemple(templeAddress).toString();

					if (addressData != null) {
						temple.setTempleAddressData(addressData);
					} else {
						response.setStatus(ResponseStatus.BAD_REQUEST);
						response.setResponse("Address details are not correct");
						return response;
					}
				}
			} else {
				logger.error("Temple Address blank");
				response.setStatus(ResponseStatus.BAD_REQUEST);
				response.setResponse("Temple Address is mandatory");
				return response;
			}

			if (templeDesc != null) {
				if (!templeDesc.isEmpty()) {
					temple.setTempleDesc(templeDesc);
				} else {
					logger.error("Temple Desc blank");
					response.setStatus(ResponseStatus.BAD_REQUEST);
					response.setResponse("Temple Desc is mandatory");
					return response;
				}

			} else {
				logger.error("Temple Desc blank");
				response.setStatus(ResponseStatus.BAD_REQUEST);
				response.setResponse("Temple Desc is mandatory");
				return response;
			}

			if (templeTimings != null) {
				
				String timing = String.join(",", templeTimings);

				if (timing != null) {
					temple.setTempleTiming(timing);
				}

			} else {
				response.setStatus(ResponseStatus.INVALID);
				response.setResponse("Please provide temple open and close timing");
				return response;
			}

			if (aartiTimings != null) {
				
				String aarti = String.join(",", aartiTimings);

				if (aarti != null) {
					temple.setAartiTiming(aarti);
				}
			}

			if (templeGalleryImages != null) {
				if (templeGalleryImages.size() != 0) {
					String templeImageList = String.join(",", templeGalleryImages);
					temple.setImageGallery(templeImageList);
				}
			}

			temple.setIsVerified("0");
			temple.setAuthChannelPartner("0");

			// validateTempleUser();

			CmsTemple isTempleSaved = cmsTempleDataRepositry.save(temple);

			if (isTempleSaved != null) {
				response.setStatus(ResponseStatus.OK);
				response.setResponse("Temple Details Saved in temp");
				return response;
			}

		} catch (Exception e) {
			response.setStatus(ResponseStatus.INTERNAL_SERVER_ERROR);
			response.setResponse("Something went wrong.");
		}
		return response;

	}

	/*
	 * private void validateTempleUser() { String otp = OTPGenrator.generateOTP(6);
	 * 
	 * // mailService.sendEmail(to, messageBody, subject, isHtml);
	 * 
	 * }
	 */

	private Address saveAddressDataForTemple(String addressObject) {
		try {
			JSONObject addressJsonObject = new JSONObject(addressObject);
			Address address = new Address();

			address.setState((String) addressJsonObject.get("state"));

			address.setCity((String) addressJsonObject.get("city"));

			address.setDist(((String) addressJsonObject.get("dist")));

			address.setAddressDetail((String) addressJsonObject.get("addressDetail"));

			address.setIsActive("0");

			address.setIsTempleAddress("1");

			address.setContactNo((String) addressJsonObject.get("addressContactNo"));

			return address;

		} catch (JSONException e) {
			logger.error("Error in saveAddressDataForTemple:" + e);
			return null;
		}
	}

	private Address saveAddressDataForTemple(Map<String, String> addressObject) {
		try {
			Address address = new Address();

			String state = addressObject.get("state");
			String city = addressObject.get("city");
			String dist = addressObject.get("dist");
			String addressDetails = addressObject.get("address");
			String addressContactNo = addressObject.get("addressContactNo");

			address.setState(state);
			address.setCity(city);
			address.setDist(dist);
			address.setAddressDetail(addressDetails);
			address.setContactNo(addressContactNo);

			address.setIsActive("0");

			address.setIsTempleAddress("1");

			return address;
		} catch (Exception e) {
			logger.error("Error in saveAddressDataForTemple:" + e);
			return null;
		}
	}

	private String saveTempleImage(String templeName) {
		Image image = new Image();

		// TO_DO change default image type
		image.setImageType("jpg");

		String[] split = templeName.split(" ");
		templeName = "";
		for (String string : split) {
			templeName += String.join("", string);
		}

		image.setCategory("temple");
		image.setImagePath("images/" + templeName);

		return image.toString();
	}

	private String saveImageDetail(String imageDetail) {

		try {
			JSONObject imageJsonObject = new JSONObject(imageDetail);

			String imageType = (String) imageJsonObject.get("imageType");
			String imagePath = (String) imageJsonObject.get("imagePath");

			Image image = new Image();

			image.setCategory("Temple");
			image.setImagePath(imagePath);
			image.setImageType(imageType);

			String savedTempleId = imageService.saveImageToDb(image);

			if (savedTempleId != null) {
				return savedTempleId;
			}

		} catch (Exception e) {
			logger.error("Error in saveImageDetail:" + e);
			return null;
		}
		return null;
	}

	public Response getUnVerfiedTemplesList() {
		Response response = new Response();
		List<CmsTemple> templesToVerify = cmsTempleDataRepositry.findByIsVerified("0").orElse(null);
		response.setResponse(templesToVerify);

		if (templesToVerify != null) {
			response.setResponse(getUnVerfiedTemplesDetails(templesToVerify));
			response.setStatus(ResponseStatus.OK);
		} else {
			response.setStatus(ResponseStatus.NO_DATA_FOUND);
		}

		return response;
	}

	private List<Map<String, Object>> getUnVerfiedTemplesDetails(List<CmsTemple> templesToVerify) {
		List<Map<String, Object>> list = new ArrayList();

		for (CmsTemple temple : templesToVerify) {

			list.add(unVerfiedTempleDetail(temple));

		}
		return list;
	}

	private Address getTempleAddressToVerify(String addressData) {
		try {
			JSONObject addessJsonObject = new JSONObject(addressData);

			Address address = new Address();

			address.setAddressDetail((String) addessJsonObject.get("addressDetail"));

			address.setCity((String) addessJsonObject.get("city"));

			address.setState((String) addessJsonObject.get("state"));

			address.setDist((String) addessJsonObject.get("dist"));

			address.setContactNo((String) addessJsonObject.get("addressContactNo"));

			return address;
		} catch (Exception e) {
			logger.error("Error in getTempleAddressToVerify:" + e);
			return null;
		}
	}

	private Map<String, Object> unVerfiedTempleDetail(CmsTemple temple) {
		Map<String, Object> map = new HashMap<String, Object>();

		map.put("templeId", temple.getTempleId());
		map.put("templeName", temple.getTempleName());
		map.put("templeDesc", temple.getTempleDesc());

		map.put("contactNo", temple.getContactNo());
		map.put("templeTiming", temple.getTempleTiming());
		map.put("aartiTiming", temple.getAartiTiming());

		String imagePath = imageService.getImagePath(temple.getMainImageData());
		String imageType = imageService.getImageType(temple.getMainImageData());

		map.put("image", "images/" + imagePath);
		Address templeAddressToVerify = getTempleAddressToVerify(temple.getTempleAddressData());

		Map<String, String> addressMap = new HashMap<>();
		addressMap.put("city", templeAddressToVerify.getCity());
		addressMap.put("state", templeAddressToVerify.getState());
		addressMap.put("dist", templeAddressToVerify.getDist());
		addressMap.put("addressContactNo", templeAddressToVerify.getContactNo());
		addressMap.put("address", templeAddressToVerify.getAddressDetail());

		map.put("address", addressMap);

		return map;
	}

	private String getImagePath(String imageObject) {
		try {
			JSONObject imageJsonObject = new JSONObject(imageObject);

			return ((String) imageJsonObject.get("imagePath")) + "." + ((String) imageJsonObject.get("imageType"));

		} catch (JSONException e) {
			logger.error("Error in getImagePath:" + e);
			return null;
		}
	}

	@Transactional
	public Response saveTempleAsVerfied(String templeId) {
		logger.info("Verifying temple details for TempleId:" + templeId);
		Response response = new Response();
		CmsTemple cmsTemple = cmsTempleDataRepositry.findOne(templeId);

		if (cmsTemple != null) {
			Temple temple = new Temple();

			temple.setContactNo(cmsTemple.getContactNo());
			temple.setIsActive("1");
			temple.setTempleDesc(cmsTemple.getTempleDesc());

			temple.setTempleName(cmsTemple.getTempleName());

			String galleryObject = createImageGalleryObject(cmsTemple.getImageGallery());

			temple.setImageGallery(galleryObject);
			if (cmsTemple.getMainImageData() != null) {
				Boolean isImageDetailUpdated = updateImageDetail(cmsTemple.getMainImageData());

				if (isImageDetailUpdated) {

					temple.setMainImageID(cmsTemple.getMainImageData());

				} else {
					logger.error("Error while updating image to DB");
					response.setStatus(ResponseStatus.INTERNAL_SERVER_ERROR);
					response.setResponse("Something went wrong.Please Try Later");
					return response;
				}
			} else {
				response.setStatus(ResponseStatus.ERROR);
				response.setResponse("Main image id not found");
				return response;
			}

			Address templeAddress = saveAddressDataForTemple(cmsTemple.getTempleAddressData());

			Address addressSaved = addressRepo.save(templeAddress);

			if (addressSaved != null) {
				temple.setTempleAddressId(addressSaved.getId() + "");
			} else {
				logger.error("Error while saving address to DB");
				response.setStatus(ResponseStatus.INTERNAL_SERVER_ERROR);
				response.setResponse("Something went wrong.Please Try Later");
				return response;
			}

			Temple isSaved = templeRepositry.save(temple);

			if (isSaved != null) {
				logger.info("Temple details verfied for TempleId:" + templeId);
				cmsTempleDataRepositry.delete(templeId);
				response.setStatus(ResponseStatus.OK);
				response.setResponse("Temple Saved successFully");
			} else {
				logger.error("Error in saving temple details in Temple table");
				response.setStatus(ResponseStatus.INTERNAL_SERVER_ERROR);
				response.setResponse("Something went wrong whlie saving details");
			}
		} else {
			logger.error("Temple ID:" + templeId + " not found in temple_temp table");
			response.setStatus(ResponseStatus.NO_DATA_FOUND);
			response.setResponse("Temple detail not found");
		}

		return response;
	}

	private String createImageGalleryObject(String imageGallery) {
		try {
			JSONArray jsonArray = new JSONArray();

			String[] galleryImages = imageGallery.split(",");

			for (String galleryImage : galleryImages) {
				JSONObject jsonObject = new JSONObject();

				jsonObject.put("imageId", galleryImage);

				jsonArray.put(jsonObject);
			}

			return jsonArray.toString();
		} catch (Exception e) {
			return null;
		}
	}

	@Transactional
	public Response editAndSaveTempleAsVerfied(Map<String, List<String>> request) {
		logger.info("Method:editAndSaveTempleAsVerfied");
		Response response = new Response();

		Temple temple = new Temple();

		try {
			List<String> contactNoList = request.get("contactNo");
			List<String> templeName = request.get("templeName");
			List<String> templeAddress = request.get("templeAddress");
			List<String> templeDesc = request.get("templeDesc");
			List<String> templeTimings = request.get("templeTiming");
			List<String> aartiTimings = request.get("aartiTiming");
			List<String> mainImageId = request.get("mainImageId");

			if (templeName != null) {
				String name = templeName.get(0);
				boolean isTempleNameExists = templeRepositry.findByTempleName(name).isPresent();
				if (isTempleNameExists) {
					response.setStatus(ResponseStatus.INVALID);
					response.setResponse("Temple Name already exists");
					return response;
				}
				temple.setIsActive("1");
				temple.setTempleName(name);
				String imageData = saveTempleImage(name);

				if (imageData != null) {

				} else {
					response.setStatus(ResponseStatus.BAD_REQUEST);
					response.setResponse("Temple Name is mandatory");
					return response;
				}

			} else {
				logger.error("Temple Name is blank.");
				response.setStatus(ResponseStatus.BAD_REQUEST);
				response.setResponse("Temple Name is mandatory");
				return response;
			}

			if (templeAddress != null) {

				Address templeAddressData = saveAddressDataForTemple(templeAddress.get(0));

				if (templeAddressData != null) {
					Address isAddressSaved = addressRepo.save(templeAddressData);

					if (isAddressSaved != null) {
						temple.setTempleAddressId(isAddressSaved.getId() + "");
					} else {
						logger.error("Error while trying to save temple address data.");
						response.setStatus(ResponseStatus.INTERNAL_SERVER_ERROR);
						response.setResponse("Something went wrong while saving data.Please try later");
						return response;
					}
				} else {
					response.setStatus(ResponseStatus.BAD_REQUEST);
					response.setResponse("Address details are mandatory");
					return response;
				}
			} else {
				logger.error("Temple Address blank");
				response.setStatus(ResponseStatus.BAD_REQUEST);
				response.setResponse("Temple Address is mandatory");
				return response;
			}

			if (templeDesc != null) {
				if (!templeDesc.get(0).isEmpty()) {
					temple.setTempleDesc(templeDesc.get(0));
				} else {
					response.setStatus(ResponseStatus.BAD_REQUEST);
					response.setResponse("Temple Desc can not be blank.");
					return response;
				}

			} else {
				response.setStatus(ResponseStatus.BAD_REQUEST);
				response.setResponse("Temple Desc is mandatory");
				return response;
			}

			if (mainImageId != null) {
				String mainImage = mainImageId.get(0);
				if (!mainImage.isEmpty()) {
					Image image = imageService.getImage(mainImage);
					image.setImagePath("images/" + image.getImagePath() + "." + image.getImageType());
					image.setCategory("Temple");
					String savedImageId = imageService.saveImageToDb(image);
					if (savedImageId != null && !savedImageId.isEmpty()) {
						temple.setMainImageID(savedImageId);
					} else {
						logger.error("Something went wrong while updating the image details.");
						response.setStatus(ResponseStatus.INTERNAL_SERVER_ERROR);
						response.setResponse("Something went wrong");
						return response;
					}

				} else {
					response.setStatus(ResponseStatus.BAD_REQUEST);
					response.setResponse("Temple main image cant not be blank");
					return response;
				}
			} else {
				response.setStatus(ResponseStatus.BAD_REQUEST);
				response.setResponse("Temple main image is mandatory");
				return response;
			}

			if (templeTimings != null) {
				if (!templeTimings.get(0).isEmpty()) {

				}
			}

			if (aartiTimings != null) {
				if (!aartiTimings.get(0).isEmpty()) {

				}
			}

			if (contactNoList != null) {

				String contactNo = contactNoList.get(0);
				if (PhoneNoVaildator.validatePhone(contactNo)) {
					temple.setContactNo(contactNo);
				}
			} else {
				logger.error("contactNo blank");
				response.setStatus(ResponseStatus.BAD_REQUEST);
				response.setResponse("contactNo is mandatory");
				return response;
			}

			Temple isTempleSaved = templeRepositry.save(temple);

			if (isTempleSaved != null) {
				logger.info("temple saved successfully with templeId:" + isTempleSaved.getTempleId());
				response.setStatus(ResponseStatus.OK);
				response.setResponse("Temple saved successfully");
				return response;
			} else {
				logger.error("Error while saving temple data");
				response.setStatus(ResponseStatus.INTERNAL_SERVER_ERROR);
				response.setResponse("Something went wrong while saving temple data.Please try later.");
				return response;
			}

		} catch (Exception e) {
			logger.error("Error in:" + e);
			return null;
		}
	}

	public Response getUserDetail(String id) {
		Response response = new Response();
		if (id == null) {
			if (id.isEmpty()) {
				response.setResponse("No search param found");
				response.setStatus(ResponseStatus.BAD_REQUEST);
			}

		} else {
			boolean isEmail = EmailValidator.validateEmail(id);
			List<Map<String, String>> listOfMatchedUsers = new ArrayList<Map<String, String>>();

			if (isEmail) {
				Map<String, String> userDataMap = new HashMap<>();
				UserDetailsImpl userDetails = userService.getUserDetails(id);
				if (userDetails != null) {
					userDataMap.put("userId", userDetails.getUserId().toString());
					userDataMap.put("userName", userDetails.getFirstName() + " " + userDetails.getMiddleName() + " "
							+ userDetails.getLastName());
					userDataMap.put("userRole", userService.getUserRoles(userDetails.getUserRoleDetails()).toString());

					listOfMatchedUsers.add(userDataMap);
					response.setResponse(listOfMatchedUsers);
					response.setStatus(ResponseStatus.OK);
				} else {
					response.setResponse("No record found for mailId:" + id);
					response.setStatus(ResponseStatus.NO_DATA_FOUND);
				}

			} else {
				List<Integer> userByName = userService.getUserByNameLike(id);

				if (userByName != null && !userByName.isEmpty()) {
					List<UserDetailsImpl> userDetailsList = userService.getUserDetailsList(userByName);
					listOfMatchedUsers.clear();
					if (userDetailsList != null) {
						for (UserDetailsImpl userDetails : userDetailsList) {
							Map<String, String> userDataMap = new HashMap<>();
							userDataMap.put("userId", userDetails.getUserId().toString());
							userDataMap.put("userName", userDetails.getFirstName() + " " + userDetails.getMiddleName()
									+ " " + userDetails.getLastName());
							userDataMap.put("userRole",
									userService.getUserRoles(userDetails.getUserRoleDetails()).toString());

							listOfMatchedUsers.add(userDataMap);
						}

						response.setResponse(listOfMatchedUsers);
						response.setStatus(ResponseStatus.OK);
					} else {
						response.setResponse("No record found for name:" + id);
						response.setStatus(ResponseStatus.NO_DATA_FOUND);
					}
				}
			}
		}
		return response;
	}

	public Iterable<UserRoles> getAllRoles() {
		return userRolesRepositry.findAll();
	}

	public Response updateUserRole(PostRequestWithOutArray request) {
		Response response = new Response();

		if (request != null) {
			if (request.getRequestType() != null && request.getRequestType().equals("updateUserRole")) {
				Map<String, String> requestParam = request.getRequestParam();

				if (requestParam != null) {
					String userId = requestParam.get("userId");
					String newRoleId = requestParam.get("newRoleId");

					if (userId != null && newRoleId != null && !userId.isEmpty() && !newRoleId.isEmpty()) {
						response = userService.updateUserRole(userId, newRoleId);
					} else {
						response.setStatus(ResponseStatus.BAD_REQUEST);
						response.setResponse("reuired attributes are missing");
					}

				} else {
					response.setStatus(ResponseStatus.BAD_REQUEST);
					response.setResponse("Request attributes expected");
				}
			} else {
				response.setStatus(ResponseStatus.BAD_REQUEST);
				response.setResponse("Bad request");
			}
		} else {
			response.setStatus(ResponseStatus.BAD_REQUEST);
			response.setResponse("Blank reuest");
		}

		return response;
	}

	public String saveImage(String imageType, String originalFilename,String type) {
		Image image = new Image();
		if (type.equalsIgnoreCase("image")) {
			image.setCategory("");
			image.setImagePath(originalFilename);
			image.setImageType(imageType);

			String saveImageId = imageService.saveImageToDb(image);

			if (saveImageId != null) {
				return saveImageId;
			} else {
				return null;
			}
		} else {
			image.setCategory("");
			image.setImagePath(originalFilename);
			image.setImageType(imageType);

			String saveImageId = imageService.saveImageToDb(image);

			if (saveImageId != null) {
				return saveImageId;
			} else {
				return null;
			}
		}
	}

	public Response getUnVerifiedTemple(String templeId) {
		Response response = new Response();
		CmsTemple cmsTemple = cmsTempleDataRepositry.findOne(templeId);

		if (cmsTemple != null) {
			Map<String, Object> unVerfiedTempleDetail = unVerfiedTempleDetail(cmsTemple);
			response.setStatus(ResponseStatus.OK);
			response.setResponse(unVerfiedTempleDetail);
		} else {
			response.setStatus(ResponseStatus.NO_DATA_FOUND);
			response.setResponse("No temple details found with Id:" + templeId);
		}

		return response;
	}

	private Boolean updateImageDetail(String imageId) {
		Image image = imageService.getImage(imageId);

		image.setCategory("Temple");
		image.setImagePath("images/" + image.getImagePath());

		String saveImageToDb = imageService.saveImageToDb(image);

		if (saveImageToDb != null) {
			return true;
		} else {
			return false;
		}
	}
}
