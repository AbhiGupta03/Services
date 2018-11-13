package com.restApp.religiousIndia.services.cmsServices;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restApp.religiousIndia.common.PanditCategoryId;
import com.restApp.religiousIndia.data.entities.pandit.CmsPanditDetails;
import com.restApp.religiousIndia.data.entities.pandit.PanditDetails;
import com.restApp.religiousIndia.data.entities.pandit.availability.PanditDailyAvailibility;
import com.restApp.religiousIndia.data.entities.users.UserDetailsImpl;
import com.restApp.religiousIndia.data.repositry.pandit.CMSPanditDetailsRepositry;
import com.restApp.religiousIndia.data.repositry.pandit.PanditDetailsRepositry;
import com.restApp.religiousIndia.data.repositry.pandit.availability.PanditDailyAvailibilityRepositry;
import com.restApp.religiousIndia.data.repositry.poojeServices.PoojaServicesListRepositry;
import com.restApp.religiousIndia.data.repositry.users.UserDetailsRepositry;
import com.restApp.religiousIndia.request.filter.PostRequestWithObject;
import com.restApp.religiousIndia.response.Response;
import com.restApp.religiousIndia.response.status.ResponseStatus;
import com.restApp.religiousIndia.services.users.LoginService;

@Service
public class CmsPanditServices {
	private static Logger logger = Logger.getLogger(CmsPanditServices.class);

	@Autowired
	CMSPanditDetailsRepositry cmsPanditDetailsRepositry;

	@Autowired
	private LoginService loginService;

	@Autowired
	PanditDetailsRepositry panditDetailsRepositry;

	@Autowired
	PanditDailyAvailibilityRepositry panditDailyAvailibilityRepositry;

	@Autowired
	PoojaServicesListRepositry poojaServicesListRepositry;

	@Autowired
	UserDetailsRepositry userDetailsRepositry;

	@Transactional
	public Response saveNewPanditDetails(PostRequestWithObject request) {
		logger.info("/saveNewPanditDetails method");
		Response response = new Response();

		if (request != null) {
			if (request.getRequestType() != null) {
				if (request.getRequestType().equalsIgnoreCase("saveNewPanditDetails")) {
					Map<String, Object> requestMap = request.getRequestParam();
					if (requestMap != null) {
						try {
							if (requestMap.size() != 0) {
								String isNewUser = (String) requestMap.get("isNewUser");

								if (isNewUser != null) {
									CmsPanditDetails cmsPanditDetails = new CmsPanditDetails();
									if (isNewUser.equals("1")) {
										cmsPanditDetails.setIsNewUser("1");
										Map<String, String> signUpDetails = (Map<String, String>) requestMap
												.get("signUpDetails");

										Integer isSignedUp = userSignUp(signUpDetails);

										if (isSignedUp != null) {
											cmsPanditDetails.setUserId(isSignedUp);
											response = createCmsPanditDetail(requestMap, cmsPanditDetails);
										} else {
											response.setStatus(ResponseStatus.INTERNAL_SERVER_ERROR);
											response.setResponse("Error while crating user");
											return response;
										}

									} else {
										cmsPanditDetails.setIsNewUser("0");
										String userId = (String) requestMap.get("userId");
										if (userId != null) {
											cmsPanditDetails.setUserId(new Integer(userId));
											response = createCmsPanditDetail(requestMap, cmsPanditDetails);
											return response;
										} else {
											response.setStatus(ResponseStatus.INVALID);
											response.setResponse("Please provide pandit userId");
											return response;
										}

									}
								} else {
									response.setStatus(ResponseStatus.BAD_REQUEST);
									response.setResponse(
											"please provide detail that is user is new one or already has an account as normal user");
								}

							} else {
								response.setStatus(ResponseStatus.BAD_REQUEST);
								response.setResponse("Request param required.");
								return response;
							}
						} catch (Exception e) {
							response.setStatus(ResponseStatus.INTERNAL_SERVER_ERROR);
							response.setResponse("Something went wrong");
							return response;
						}
					} else {
						response.setStatus(ResponseStatus.BAD_REQUEST);
						response.setResponse("Request param cant't be blank");
					}
				} else {
					response.setStatus(ResponseStatus.BAD_REQUEST);
					response.setResponse("Request type not matched");
				}
			} else {
				response.setStatus(ResponseStatus.BAD_REQUEST);
				response.setResponse("Request type cant't be blank");
			}
		} else {
			response.setStatus(ResponseStatus.BAD_REQUEST);
			response.setResponse("Request can't be blank.");
		}
		return response;
	}

	@Transactional
	public Response saveNewPanditDetailsAsVerified(PostRequestWithObject request) {
		logger.info("/saveNewPanditDetailsAsVerified method");
		Response response = new Response();

		if (request != null) {
			if (request.getRequestType() != null) {
				if (request.getRequestType().equalsIgnoreCase("saveNewPanditDetailsAsVerified")) {
					Map<String, Object> requestMap = request.getRequestParam();
					if (requestMap != null) {
						try {
							if (requestMap.size() != 0) {
								String isNewUser = (String) requestMap.get("isNewUser");

								if (isNewUser != null) {
									CmsPanditDetails cmsPanditDetails = new CmsPanditDetails();
									if (isNewUser.equals("1")) {
										cmsPanditDetails.setIsNewUser("1");
										Map<String, String> signUpDetails = (Map<String, String>) requestMap
												.get("signUpDetails");

										Integer isSignedUp = userSignUp(signUpDetails);

										if (isSignedUp != null) {
											cmsPanditDetails.setUserId(isSignedUp);
											response = createCmsPanditDetailForVerified(requestMap, cmsPanditDetails);

											if (response.getStatus().equals(ResponseStatus.OK)) {
												String cmsPanditId = (String) response.getResponse();

												response = savePanditAsVerfied(cmsPanditId);
											} else {
												response.setStatus(ResponseStatus.INTERNAL_SERVER_ERROR);
												response.setResponse("Something went wrong");
												return response;
											}
										} else {
											response.setStatus(ResponseStatus.INTERNAL_SERVER_ERROR);
											response.setResponse("Error while crating user");
											return response;
										}

									} else {
										cmsPanditDetails.setIsNewUser("0");
										String userId = (String) requestMap.get("userId");
										if (userId != null) {
											cmsPanditDetails.setUserId(new Integer(userId));
											response = createCmsPanditDetailForVerified(requestMap, cmsPanditDetails);
											if (response.getStatus().equals(ResponseStatus.OK)) {
												String cmsPanditId = (String) response.getResponse();

												response = savePanditAsVerfied(cmsPanditId);
											} else {
												response.setStatus(ResponseStatus.INTERNAL_SERVER_ERROR);
												response.setResponse("Something went wrong");
												return response;
											}

										} else {
											response.setStatus(ResponseStatus.INVALID);
											response.setResponse("Please provide pandit userId");
											return response;
										}

									}
								} else {
									response.setStatus(ResponseStatus.BAD_REQUEST);
									response.setResponse(
											"please provide detail that is user is new one or already has an account as normal user");
								}

							} else {
								response.setStatus(ResponseStatus.BAD_REQUEST);
								response.setResponse("Request param required.");
								return response;
							}
						} catch (Exception e) {
							response.setStatus(ResponseStatus.INTERNAL_SERVER_ERROR);
							response.setResponse("Something went wrong");
							return response;
						}
					} else {
						response.setStatus(ResponseStatus.BAD_REQUEST);
						response.setResponse("Request param cant't be blank");
					}
				} else {
					response.setStatus(ResponseStatus.BAD_REQUEST);
					response.setResponse("Request type not matched");
				}
			} else {
				response.setStatus(ResponseStatus.BAD_REQUEST);
				response.setResponse("Request type cant't be blank");
			}
		} else {
			response.setStatus(ResponseStatus.BAD_REQUEST);
			response.setResponse("Request can't be blank.");
		}
		return response;
	}

	private Integer userSignUp(Map<String, String> details) {

		details.put("roleId", "2");
		details.put("email", "");

		Response signUpResponse = loginService.createUserDetails(details);

		if (signUpResponse.getStatus().equals(ResponseStatus.OK)) {
			UserDetailsImpl userDetails = (UserDetailsImpl) signUpResponse.getResponse();

			Integer userId = userDetails.getUserId();

			return userId;
		} else {
			logger.error("User signUp failed during adding new pandit details");
			return null;
		}
	}

	private String createTimingJsonObject(Map<String, String> dailyTiming) {
		JSONArray jsonArray = new JSONArray();
		JSONObject jsonObject = new JSONObject(dailyTiming);
		jsonArray.put(jsonObject);
		return jsonArray.toString();
	}

	private String createJsonObject(List<Map<String, String>> awardsDetails) {
		JSONArray jsonArray = new JSONArray();
		for (Map<String, String> map : awardsDetails) {
			JSONObject jsonObject = new JSONObject(map);
			jsonArray.put(jsonObject);
		}
		return jsonArray.toString();
	}

	private Response createCmsPanditDetail(Map<String, Object> requestMap, CmsPanditDetails cmsPanditDetails) {
		Response response = new Response();
		String aboutPandit = (String) requestMap.get("aboutPandit");

		if (aboutPandit != null) {
			List<String> qualificationList = (List<String>) requestMap.get("qualification");
			String qualification = String.join(",", qualificationList);

			if (qualificationList != null) {
				if (qualificationList.size() != 0) {

					List<String> specilaizationList = (List<String>) requestMap.get("specilaization");
					String specilaization = String.join(",", specilaizationList);

					if (specilaizationList != null) {
						if (specilaizationList.size() != 0) {
							cmsPanditDetails.setSpecilaization(specilaization);
						}
					}

					List<String> specilaizationPoojaList = (List<String>) requestMap.get("specilaizationPooja");
					String specilaizationPooja = String.join(",", specilaizationPoojaList);

					if (specilaizationPoojaList != null) {
						if (specilaizationPoojaList.size() != 0) {
							cmsPanditDetails.setSpecilaizationPooja(specilaizationPooja);
						}
					}

					/*
					 * List<TypeOfAvailability> typeOfAvailabilityList = (List<TypeOfAvailability>)
					 * requestMap .get("typeOfAvailability");
					 */
					String isFreeLancer = (String) requestMap.get("isFreeLancer");
					String isAssociatedWithTemple = (String) requestMap.get("isAssociatedWithTemple");
					if (isFreeLancer != null) {
						if (isFreeLancer.equals("1")) {
							cmsPanditDetails.setIsFreeLancer(isFreeLancer);
						} else {

							if (isAssociatedWithTemple != null) {
								cmsPanditDetails.setIsAssociatedWithTemple(isAssociatedWithTemple);

								List<String> templeIdList = (List<String>) requestMap.get("templeIdList");
								String templeId = String.join(",", templeIdList);

								if (templeIdList != null) {
									if (templeIdList.size() != 0) {
										cmsPanditDetails.setTempleIdList(templeId);
									} else {
										response.setStatus(ResponseStatus.INVALID);
										response.setResponse("List of associated temple id is blank");
										return response;
									}
								} else {
									response.setStatus(ResponseStatus.INVALID);
									response.setResponse("List of associated temple id is missing");
									return response;
								}
							} else {
								response.setStatus(ResponseStatus.INVALID);
								response.setResponse(
										"Pandit ji association with temple is compulsory because he is not a freelancer");
								return response;
							}

						}
					} else {
						if (isAssociatedWithTemple != null) {
							cmsPanditDetails.setIsAssociatedWithTemple(isAssociatedWithTemple);

							List<String> templeIdList = (List<String>) requestMap.get("templeIdList");
							String templeId = String.join(",", templeIdList);

							if (templeIdList != null) {
								if (templeIdList.size() != 0) {
									cmsPanditDetails.setTempleIdList(templeId);
								} else {
									response.setStatus(ResponseStatus.INVALID);
									response.setResponse("List of associated temple id is blank");
									return response;
								}
							} else {
								response.setStatus(ResponseStatus.INVALID);
								response.setResponse("List of associated temple id is missing");
								return response;
							}
						} else {
							response.setStatus(ResponseStatus.INVALID);
							response.setResponse(
									"Pandit ji Either be a freelancer or his association with temple is compulsory");
							return response;
						}
					}

					String isAvailableOnALlDays = (String) requestMap.get("isAvailableOnALlDays");

					if (isAvailableOnALlDays != null) {
						if (isAvailableOnALlDays.equals("1")) {
							cmsPanditDetails.setIsAvailableOnALlDays(isAvailableOnALlDays);

							String generalAvailablityTiming = (String) requestMap.get("generalAvailablityTiming");
							cmsPanditDetails.setGeneralAvailablityTiming(generalAvailablityTiming);
						}
					} else {
						cmsPanditDetails.setIsAvailableOnALlDays("0");
					}

					String imageId = (String) requestMap.get("imageId");

					if (imageId != null) {
						if (!imageId.isEmpty()) {
							cmsPanditDetails.setImageId(imageId);
						}
					}

					Map<String, String> dailyTiming = (Map<String, String>) requestMap.get("dailyTiming");

					List<Map<String, String>> awardsDetails = (List<Map<String, String>>) requestMap
							.get("awardsDetails");

					List<Map<String, String>> articlesDetails = (List<Map<String, String>>) requestMap
							.get("articlesDetails");

					cmsPanditDetails.setPanditDesc(aboutPandit);
					cmsPanditDetails.setQualification(qualification);

					// cmsPanditDetails.setTypeOfAvailbility(typeOfAvailabilityList);

					cmsPanditDetails.setPanditDailyAvailablityTiming(createTimingJsonObject(dailyTiming));

					cmsPanditDetails.setAwardsDetails(createJsonObject(awardsDetails));

					cmsPanditDetails.setArticlesDetails(createJsonObject(articlesDetails));

					CmsPanditDetails isSaved = cmsPanditDetailsRepositry.save(cmsPanditDetails);

					if (isSaved != null) {
						response.setStatus(ResponseStatus.OK);
						response.setResponse("Pandit details saved successfully");
						return response;
					}
				} else {
					response.setStatus(ResponseStatus.INVALID);
					response.setResponse("Qualification list can'nt be blank");
					return response;
				}
			} else {
				response.setStatus(ResponseStatus.INVALID);
				response.setResponse("Please provide qualification of pandit ji");
				return response;
			}
		} else {
			response.setStatus(ResponseStatus.INVALID);
			response.setResponse("Please provide desc of pandit ji");
			return response;
		}
		return response;

	}

	private Response createCmsPanditDetailForVerified(Map<String, Object> requestMap,
			CmsPanditDetails cmsPanditDetails) {

		Response response = new Response();
		String aboutPandit = (String) requestMap.get("aboutPandit");

		if (aboutPandit != null) {
			List<String> qualificationList = (List<String>) requestMap.get("qualification");
			String qualification = String.join(",", qualificationList);

			if (qualificationList != null) {
				if (qualificationList.size() != 0) {

					List<String> specilaizationList = (List<String>) requestMap.get("specilaization");
					String specilaization = String.join(",", specilaizationList);

					if (specilaizationList != null) {
						if (specilaizationList.size() != 0) {
							cmsPanditDetails.setSpecilaization(specilaization);
						}
					}

					List<String> specilaizationPoojaList = (List<String>) requestMap.get("specilaizationPooja");
					String specilaizationPooja = String.join(",", specilaizationPoojaList);

					if (specilaizationPoojaList != null) {
						if (specilaizationPoojaList.size() != 0) {
							cmsPanditDetails.setSpecilaizationPooja(specilaizationPooja);
						}
					}

					/*
					 * List<TypeOfAvailability> typeOfAvailabilityList = (List<TypeOfAvailability>)
					 * requestMap .get("typeOfAvailability");
					 */
					String isFreeLancer = (String) requestMap.get("isFreeLancer");
					String isAssociatedWithTemple = (String) requestMap.get("isAssociatedWithTemple");
					if (isFreeLancer != null) {
						if (isFreeLancer.equals("1")) {
							cmsPanditDetails.setIsFreeLancer(isFreeLancer);
						} else {

							if (isAssociatedWithTemple != null) {
								cmsPanditDetails.setIsAssociatedWithTemple(isAssociatedWithTemple);

								List<String> templeIdList = (List<String>) requestMap.get("templeIdList");
								String templeId = String.join(",", templeIdList);

								if (templeIdList != null) {
									if (templeIdList.size() != 0) {
										cmsPanditDetails.setTempleIdList(templeId);
									} else {
										response.setStatus(ResponseStatus.INVALID);
										response.setResponse("List of associated temple id is blank");
										return response;
									}
								} else {
									response.setStatus(ResponseStatus.INVALID);
									response.setResponse("List of associated temple id is missing");
									return response;
								}
							} else {
								response.setStatus(ResponseStatus.INVALID);
								response.setResponse(
										"Pandit ji association with temple is compulsory because he is not a freelancer");
								return response;
							}

						}
					} else {
						if (isAssociatedWithTemple != null) {
							cmsPanditDetails.setIsAssociatedWithTemple(isAssociatedWithTemple);

							List<String> templeIdList = (List<String>) requestMap.get("templeIdList");
							String templeId = String.join(",", templeIdList);

							if (templeIdList != null) {
								if (templeIdList.size() != 0) {
									cmsPanditDetails.setTempleIdList(templeId);
								} else {
									response.setStatus(ResponseStatus.INVALID);
									response.setResponse("List of associated temple id is blank");
									return response;
								}
							} else {
								response.setStatus(ResponseStatus.INVALID);
								response.setResponse("List of associated temple id is missing");
								return response;
							}
						} else {
							response.setStatus(ResponseStatus.INVALID);
							response.setResponse(
									"Pandit ji Either be a freelancer or his association with temple is compulsory");
							return response;
						}
					}

					String isAvailableOnALlDays = (String) requestMap.get("isAvailableOnALlDays");

					if (isAvailableOnALlDays != null) {
						if (isAvailableOnALlDays.equals("1")) {
							cmsPanditDetails.setIsAvailableOnALlDays(isAvailableOnALlDays);

							String generalAvailablityTiming = (String) requestMap.get("generalAvailablityTiming");
							cmsPanditDetails.setGeneralAvailablityTiming(generalAvailablityTiming);
						}
					} else {
						cmsPanditDetails.setIsAvailableOnALlDays("0");
					}

					String imageId = (String) requestMap.get("imageId");

					if (imageId != null) {
						if (!imageId.isEmpty()) {
							cmsPanditDetails.setImageId(imageId);
						}
					}

					Map<String, String> dailyTiming = (Map<String, String>) requestMap.get("dailyTiming");

					List<Map<String, String>> awardsDetails = (List<Map<String, String>>) requestMap
							.get("awardsDetails");

					List<Map<String, String>> articlesDetails = (List<Map<String, String>>) requestMap
							.get("articlesDetails");

					cmsPanditDetails.setPanditDesc(aboutPandit);
					cmsPanditDetails.setQualification(qualification);

					// cmsPanditDetails.setTypeOfAvailbility(typeOfAvailabilityList);

					cmsPanditDetails.setPanditDailyAvailablityTiming(createTimingJsonObject(dailyTiming));

					cmsPanditDetails.setAwardsDetails(createJsonObject(awardsDetails));

					cmsPanditDetails.setArticlesDetails(createJsonObject(articlesDetails));

					CmsPanditDetails isSaved = cmsPanditDetailsRepositry.save(cmsPanditDetails);

					if (isSaved != null) {
						response.setStatus(ResponseStatus.OK);
						response.setResponse(isSaved.getPanditId());
						return response;
					}
				} else {
					response.setStatus(ResponseStatus.INVALID);
					response.setResponse("Qualification list can'nt be blank");
					return response;
				}
			} else {
				response.setStatus(ResponseStatus.INVALID);
				response.setResponse("Please provide qualification of pandit ji");
				return response;
			}
		} else {
			response.setStatus(ResponseStatus.INVALID);
			response.setResponse("Please provide desc of pandit ji");
			return response;
		}
		return response;

	}

	public Response getUnverifiedPanditsList() {
		Response response = new Response();
		List<CmsPanditDetails> cmsPandits = cmsPanditDetailsRepositry.getCmsPandits();

		List<Map<String, Object>> detailsList = createPanditDetails(cmsPandits);

		if (cmsPandits != null) {
			if (cmsPandits.size() != 0) {
				if (detailsList != null) {
					response.setStatus(ResponseStatus.OK);
					response.setResponse(detailsList);
					return response;
				} else {
					response.setStatus(ResponseStatus.INTERNAL_SERVER_ERROR);
					response.setResponse("Something went wrong.Please try later.");
					return response;
				}

			} else {
				response.setStatus(ResponseStatus.NO_DATA_FOUND);
				response.setResponse("No pandit entry found in CMS");
				return response;
			}
		} else {
			response.setStatus(ResponseStatus.NO_DATA_FOUND);
			response.setResponse("No record");
			return response;
		}
	}

	private List<Map<String, Object>> createPanditDetails(List<CmsPanditDetails> cmsPandits) {
		List<Map<String, Object>> list = new ArrayList<>();

		for (CmsPanditDetails cmsPanditDetails : cmsPandits) {
			Map<String, Object> map = new HashMap<>();
			map.put("isFreeLancer", cmsPanditDetails.getIsFreeLancer());
			map.put("panditId", cmsPanditDetails.getPanditId());
			map.put("isAssociatedWithTemple", cmsPanditDetails.getIsAssociatedWithTemple());
			map.put("panditDesc", cmsPanditDetails.getPanditDesc());

			map.put("specilaization", cmsPanditDetails.getSpecilaization().split(","));
			map.put("specilaizationPooja", cmsPanditDetails.getSpecilaizationPooja().split(","));
			map.put("templeIdList", cmsPanditDetails.getTempleIdList().split(","));
			map.put("qualification", cmsPanditDetails.getQualification().split(","));

			map.put("isAvailableOnALlDays", cmsPanditDetails.getIsAvailableOnALlDays());
			map.put("generalAvailablityTiming", cmsPanditDetails.getGeneralAvailablityTiming());
			map.put("panditDailyAvailablityTiming", cmsPanditDetails.getPanditDailyAvailablityTiming());

			map.put("awardsDetails", cmsPanditDetails.getAwardsDetails());
			map.put("articlesDetails", cmsPanditDetails.getArticlesDetails());

			Integer userId = cmsPanditDetails.getUserId();
			UserDetailsImpl userDetails = userDetailsRepositry.findByUserId(userId);

			String name = userDetails.getFirstName() + " " + userDetails.getMiddleName() + " "
					+ userDetails.getLastName();

			map.put("panditName", name);

			String gender = userDetails.getGender();

			map.put("gender", gender);

			String contact = (userDetails.getPrimaryPhone() != null) ? userDetails.getPrimaryPhone() : "";

			map.put("contact", contact);

			list.add(map);
		}
		return list;
	}

	@Transactional
	public Response savePanditAsVerfied(String cmsPanditId) {
		Response response = new Response();
		CmsPanditDetails cmsPanditDetails = cmsPanditDetailsRepositry.findOne(cmsPanditId);

		if (cmsPanditDetails != null) {
			PanditDetails pandit = new PanditDetails();

			pandit.setIsActive("1");

			pandit.setImageId(cmsPanditDetails.getImageId());

			pandit.setPanditDesc(cmsPanditDetails.getPanditDesc());

			pandit.setIsAssociatedWithTemple(cmsPanditDetails.getIsAssociatedWithTemple());

			pandit.setIsFreeLancer(cmsPanditDetails.getIsFreeLancer());

			pandit.setPanditRating(0.0);

			pandit.setPanditCategoryId(PanditCategoryId.NEW);

			pandit.setAwardsDetails(cmsPanditDetails.getAwardsDetails());

			pandit.setArticlesDetails(cmsPanditDetails.getArticlesDetails());

			pandit.setQualification(cmsPanditDetails.getQualification());

			pandit.setReviewers(0);

			pandit.setSpecilaization(cmsPanditDetails.getSpecilaization());

			pandit.setSpecilaizationPooja(cmsPanditDetails.getSpecilaizationPooja());

			pandit.setTempleIdList(cmsPanditDetails.getTempleIdList());

			pandit.setPanditJoinDate(new Date());

			pandit.setUserId(cmsPanditDetails.getUserId());

			PanditDailyAvailibility dailyTiming = saveDailyTiming(cmsPanditDetails.getGeneralAvailablityTiming(),
					cmsPanditDetails.getIsAvailableOnALlDays(), cmsPanditDetails.getPanditDailyAvailablityTiming());

			if (dailyTiming != null) {
				pandit.setPanditDailyAvailablityTiming(dailyTiming);
			}

			PanditDetails isSaved = panditDetailsRepositry.save(pandit);

			if (isSaved != null) {
				cmsPanditDetailsRepositry.delete(cmsPanditId);
				response.setStatus(ResponseStatus.OK);
				response.setResponse("Record verfied successfully");
				return response;

			} else {
				response.setStatus(ResponseStatus.INTERNAL_SERVER_ERROR);
				response.setResponse("Record not verfied successfully");
				return response;
			}
		} else {
			response.setStatus(ResponseStatus.NO_DATA_FOUND);
			response.setResponse("No record found");
			return response;
		}

	}

	private PanditDailyAvailibility saveDailyTiming(String generalAvailablityTiming, String isAvailableOnALlDays,
			String panditDailyAvailablityTiming) {
		PanditDailyAvailibility dailyTiming = new PanditDailyAvailibility();

		if (isAvailableOnALlDays != null) {
			if (isAvailableOnALlDays.equals("1")) {
				dailyTiming.setIsAvailableOnALlDays("1");

				dailyTiming.setGeneralAvailablityTiming(generalAvailablityTiming);

				PanditDailyAvailibility isSaved = panditDailyAvailibilityRepositry.save(dailyTiming);

				if (isSaved != null) {
					return isSaved;
				}
			} else {
				dailyTiming.setIsAvailableOnALlDays("0");

				Boolean isSet = setDailyTiming(panditDailyAvailablityTiming, dailyTiming);

				if (isSet) {
					PanditDailyAvailibility isSaved = panditDailyAvailibilityRepositry.save(dailyTiming);

					if (isSaved != null) {
						return isSaved;
					}

				}
			}
		} else {
			dailyTiming.setIsAvailableOnALlDays("0");

			Boolean isSet = setDailyTiming(panditDailyAvailablityTiming, dailyTiming);

			if (isSet) {
				PanditDailyAvailibility isSaved = panditDailyAvailibilityRepositry.save(dailyTiming);

				if (isSaved != null) {
					return isSaved;
				}

			}
		}
		return null;
	}

	private Boolean setDailyTiming(String panditDailyAvailablityTiming, PanditDailyAvailibility dailyTiming) {
		try {
			if (panditDailyAvailablityTiming != null) {
				JSONArray jsonArray = new JSONArray(panditDailyAvailablityTiming);

				JSONObject jsonObject = (JSONObject) jsonArray.get(0);

				dailyTiming.setFridayTiming(jsonObject.getString("FRI"));
				dailyTiming.setThursdayTiming(jsonObject.getString("THU"));
				dailyTiming.setThuesdayTiming(jsonObject.getString("TUE"));
				dailyTiming.setWednesdayTiming(jsonObject.getString("WED"));
				dailyTiming.setSaturdayTiming(jsonObject.getString("SAT"));
				dailyTiming.setMondayTiming(jsonObject.getString("Mon"));
				dailyTiming.setSundayTiming(jsonObject.getString("SUN"));

				dailyTiming = panditDailyAvailibilityRepositry.save(dailyTiming);

				if (dailyTiming != null) {
					return true;
				} else {
					return false;
				}

			} else {
				return false;
			}
		} catch (Exception e) {
			logger.error("Error in setDailyTiming:" + e);
			return false;
		}

	}

	public Response getAllPoojaServicesList() {
		Response response = new Response();
		List<String> allServicesName = poojaServicesListRepositry.getAllServicesName();

		if (allServicesName != null) {
			response.setStatus(ResponseStatus.OK);
			response.setResponse(allServicesName);
			return response;
		} else {
			response.setStatus(ResponseStatus.NO_DATA_FOUND);
			response.setResponse("No record found");
			return response;
		}
	}
}
