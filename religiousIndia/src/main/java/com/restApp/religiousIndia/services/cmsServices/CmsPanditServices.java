package com.restApp.religiousIndia.services.cmsServices;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restApp.religiousIndia.data.entities.pandit.CmsPanditDetails;
import com.restApp.religiousIndia.data.repositry.pandit.CMSPanditDetailsRepositry;
import com.restApp.religiousIndia.request.filter.PostRequestWithObject;
import com.restApp.religiousIndia.response.Response;
import com.restApp.religiousIndia.response.status.ResponseStatus;

@Service
public class CmsPanditServices {
	private static Logger logger = Logger.getLogger(CmsPanditServices.class);

	@Autowired
	CMSPanditDetailsRepositry cmsPanditDetailsRepositry;

	@Transactional
	public Response saveNewPanditDetails(PostRequestWithObject request) {
		logger.info("/saveNewPanditDetails request");
		Response response = new Response();

		if (request != null) {
			if (request.getRequestType() != null) {
				if (request.getRequestType().equalsIgnoreCase("saveNewPanditDetails")) {
					Map<String, Object> requestMap = request.getRequestParam();
					if (requestMap != null) {
						try {
							if (requestMap.size() != 0) {
								String userId = (String) requestMap.get("userId");

								if (userId != null) {
									String aboutPandit = (String) requestMap.get("aboutPandit");

									if (aboutPandit != null) {
										List<String> qualificationList = (List<String>) requestMap.get("qualification");
										String qualification = String.join(",", qualificationList);

										if (qualificationList != null) {
											if (qualificationList.size() != 0) {
												CmsPanditDetails cmsPanditDetails = new CmsPanditDetails();

												List<String> specilaizationList = (List<String>) requestMap
														.get("specilaization");
												String specilaization = String.join(",", specilaizationList);

												if (specilaizationList != null) {
													if (specilaizationList.size() != 0) {
														cmsPanditDetails.setSpecilaization(specilaization);
													}
												}

												List<String> specilaizationPoojaList = (List<String>) requestMap
														.get("specilaizationPooja");
												String specilaizationPooja = String.join(",", specilaizationPoojaList);

												if (specilaizationPoojaList != null) {
													if (specilaizationPoojaList.size() != 0) {
														cmsPanditDetails.setSpecilaizationPooja(specilaizationPooja);
													}
												}

												/*
												 * List<TypeOfAvailability> typeOfAvailabilityList =
												 * (List<TypeOfAvailability>) requestMap .get("typeOfAvailability");
												 */
												String isFreeLancer = (String) requestMap.get("isFreeLancer");
												String isAssociatedWithTemple = (String) requestMap
														.get("isAssociatedWithTemple");
												if (isFreeLancer != null) {
													if (isFreeLancer.equals("1")) {
														cmsPanditDetails.setIsFreeLancer(isFreeLancer);
													} else {

														if (isAssociatedWithTemple != null) {
															cmsPanditDetails
																	.setIsAssociatedWithTemple(isAssociatedWithTemple);

															List<String> templeIdList = (List<String>) requestMap
																	.get("templeIdList");
															String templeId = String.join(",", templeIdList);

															if (templeIdList != null) {
																if (templeIdList.size() != 0) {
																	cmsPanditDetails.setTempleIdList(templeId);
																} else {
																	response.setStatus(ResponseStatus.INVALID);
																	response.setResponse(
																			"List of associated temple id is blank");
																	return response;
																}
															} else {
																response.setStatus(ResponseStatus.INVALID);
																response.setResponse(
																		"List of associated temple id is missing");
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
														cmsPanditDetails
																.setIsAssociatedWithTemple(isAssociatedWithTemple);

														List<String> templeIdList = (List<String>) requestMap
																.get("templeIdList");
														String templeId = String.join(",", templeIdList);

														if (templeIdList != null) {
															if (templeIdList.size() != 0) {
																cmsPanditDetails.setTempleIdList(templeId);
															} else {
																response.setStatus(ResponseStatus.INVALID);
																response.setResponse(
																		"List of associated temple id is blank");
																return response;
															}
														} else {
															response.setStatus(ResponseStatus.INVALID);
															response.setResponse(
																	"List of associated temple id is missing");
															return response;
														}
													} else {
														response.setStatus(ResponseStatus.INVALID);
														response.setResponse(
																"Pandit ji Either be a freelancer or his association with temple is compulsory");
														return response;
													}
												}

												String isAvailableOnALlDays = (String) requestMap
														.get("isAvailableOnALlDays");

												if (isAvailableOnALlDays != null) {
													if (isAvailableOnALlDays.equals("1")) {
														cmsPanditDetails.setIsAvailableOnALlDays(isAvailableOnALlDays);

														String generalAvailablityTiming = (String) requestMap
																.get("generalAvailablityTiming");
														cmsPanditDetails
																.setGeneralAvailablityTiming(generalAvailablityTiming);
													}
												} else {
													cmsPanditDetails.setIsAvailableOnALlDays("0");
												}

												Map<String, String> dailyTiming = (Map<String, String>) requestMap
														.get("dailyTiming");

												List<Map<String, String>> awardsDetails = (List<Map<String, String>>) requestMap
														.get("awardsDetails");

												List<Map<String, String>> articlesDetails = (List<Map<String, String>>) requestMap
														.get("articlesDetails");

												cmsPanditDetails.setUserId(new Integer(userId));

												cmsPanditDetails.setPanditDesc(aboutPandit);
												cmsPanditDetails.setQualification(qualification);

												// cmsPanditDetails.setTypeOfAvailbility(typeOfAvailabilityList);

												cmsPanditDetails.setPanditDailyAvailablityTiming(
														createTimingJsonObject(dailyTiming));

												cmsPanditDetails.setAwardsDetails(createJsonObject(awardsDetails));

												cmsPanditDetails.setArticlesDetails(createJsonObject(articlesDetails));

												CmsPanditDetails isSaved = cmsPanditDetailsRepositry
														.save(cmsPanditDetails);

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
								} else {
									response.setStatus(ResponseStatus.INVALID);
									response.setResponse("Please provide pandit userId");
									return response;
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
}
