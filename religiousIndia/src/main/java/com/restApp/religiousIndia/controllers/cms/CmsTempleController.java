package com.restApp.religiousIndia.controllers.cms;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.restApp.religiousIndia.data.entities.users.UserDetailsImpl;
import com.restApp.religiousIndia.data.entities.users.UserRoles;
import com.restApp.religiousIndia.request.filter.PostRequest;
import com.restApp.religiousIndia.request.filter.PostRequestWithObject;
import com.restApp.religiousIndia.request.filter.PostRequestWithOutArray;
import com.restApp.religiousIndia.response.Response;
import com.restApp.religiousIndia.response.status.ResponseStatus;
import com.restApp.religiousIndia.services.cmsServices.CmsPanditServices;
import com.restApp.religiousIndia.services.cmsServices.CmsTempleService;
import com.restApp.religiousIndia.services.mail.MailService;
import com.restApp.religiousIndia.services.users.UserServices;
import com.restApp.religiousIndia.utilities.AmazonClient;

@RestController
@CrossOrigin
public class CmsTempleController {
	private static Logger logger = Logger.getLogger(CmsTempleController.class);

	@Autowired
	private CmsTempleService cmsTempleService;

	@Autowired
	private CmsPanditServices cmsPanditServices;

	@Autowired
	private UserServices userServices;

	@Autowired
	MailService mailService;

	@Value("${folderToUploadImages}")
	private final String folderToUploadImages = null;

	@Value("${folderToUploadVideos}")
	private final String folderToUploadVideos = null;

	private Path write;

	private AmazonClient amazonClient;

	@Autowired
	CmsTempleController(AmazonClient amazonClient) {
		this.amazonClient = amazonClient;
	}

	@PostMapping("/uploadFile")
	public String uploadFile(@RequestParam(value = "file") MultipartFile file) {
		return this.amazonClient.uploadFile(file);
	}

	@GetMapping("/getAllRoles")
	@PreAuthorize("hasRole('ROLE_SUPER_ADMIN')")
	public ResponseEntity<Response> getAllRoles() {
		Response response = new Response();
		try {
			Iterable<UserRoles> allRoles = cmsTempleService.getAllRoles();

			response.setResponse(allRoles);
			response.setStatus(ResponseStatus.OK);
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			logger.error("Error in getAllRoles(CMSController):" + e);
			response.setStatus(ResponseStatus.INTERNAL_SERVER_ERROR);
			response.setResponse("");
			return ResponseEntity.ok(response);
		}
	}

	@PostMapping("/saveTempleDetails")
	@PreAuthorize("hasRole('ROLE_SUPER_ADMIN') or hasRole('ROLE_ADMIN') or hasRole('ROLE_TEMPLE')")
	public ResponseEntity<Response> saveTempleDetails(@RequestBody PostRequestWithObject request) {
		Response saveTempleDataResponse = new Response();
		try {
			if (request != null) {
				if (request.getRequestType().equals("saveTempleDetails")) {
					if (request.getRequestParam() != null) {
						saveTempleDataResponse = cmsTempleService.saveTempleData(request.getRequestParam());

						if (saveTempleDataResponse.getStatus().equals(ResponseStatus.OK)) {
							String mailSignature = mailService.getMailSignature();

							String messageBody = "<div>New Temple details saved.Will let you know once its data verified by our support team</div><br>";

							messageBody += mailSignature;

							mailService.sendEmail("", messageBody, "Temple details Saved", true);
						}
					}
				}
			} else {
				saveTempleDataResponse.setStatus(ResponseStatus.INVALID);
				saveTempleDataResponse.setResponse("request can't be blank ");
			}
			return ResponseEntity.ok(saveTempleDataResponse);
		} catch (Exception e) {
			logger.error("Error in saveTempleDetails(CMSController):" + e);
			saveTempleDataResponse.setStatus(ResponseStatus.INTERNAL_SERVER_ERROR);
			saveTempleDataResponse.setResponse("");

			return ResponseEntity.ok(saveTempleDataResponse);
		}
	}

	@GetMapping("/getUnVerifiedTemplesList")
	@PreAuthorize("hasRole('ROLE_SUPER_ADMIN') or hasRole('ROLE_ADMIN')")
	public ResponseEntity<Response> getUnVerfiedTemplesList() {
		Response response = new Response();
		try {
			response = cmsTempleService.getUnVerfiedTemplesList();
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			logger.error("Error in getUnVerifiedTemplesList(CMSController):" + e);
			response.setStatus(ResponseStatus.INTERNAL_SERVER_ERROR);
			response.setResponse("");
			return ResponseEntity.ok(response);
		}
	}

	@GetMapping("/getUnVerifiedTemple/{templeId}")
	public ResponseEntity<Response> getUnVerifiedTemple(@PathVariable("templeId") String templeId) {
		Response response = new Response();

		try {
			if (templeId != null && !templeId.isEmpty() && !templeId.equals("")) {
				response = cmsTempleService.getUnVerifiedTemple(templeId);
			} else {
				response.setStatus(ResponseStatus.BAD_REQUEST);
				response.setResponse("templeId is missing in request");
			}

			return ResponseEntity.ok(response);
		} catch (Exception e) {
			logger.error("Error in getUnVerifiedTemple(CMSController)/" + templeId + ":" + e);
			response.setStatus(ResponseStatus.INTERNAL_SERVER_ERROR);
			response.setResponse("");
			return ResponseEntity.ok(response);
		}
	}

	@GetMapping("/saveTempleAsVerified/{templeId}")
	@PreAuthorize("hasRole('ROLE_SUPER_ADMIN') or hasRole('ROLE_ADMIN')")
	public ResponseEntity<Response> saveTempleAsVerfied(@PathVariable("templeId") String templeId) {
		Response response = new Response();

		try {
			if (templeId != null && !templeId.isEmpty() && !templeId.equals("")) {
				response = cmsTempleService.saveTempleAsVerfied(templeId);
			} else {
				response.setStatus(ResponseStatus.BAD_REQUEST);
				response.setResponse("templeId is missing in request");
			}

			return ResponseEntity.ok(response);
		} catch (Exception e) {
			logger.error("Error in saveTempleAsVerified(CMSController)/" + templeId + ":" + e);
			response.setStatus(ResponseStatus.INTERNAL_SERVER_ERROR);
			response.setResponse("");
			return ResponseEntity.ok(response);
		}
	}

	@PostMapping("/saveTempleAsVerified")
	@PreAuthorize("hasRole('ROLE_SUPER_ADMIN') or hasRole('ROLE_ADMIN')")
	public ResponseEntity<Response> editAndSaveTempleAsVerfied(@RequestBody PostRequest request) {
		Response saveTempleDataResponse = new Response();
		try {
			if (request != null) {
				if (request.getRequestType().equals("editAndSaveTempleDetails")) {
					if (request.getRequestParam() != null) {
						saveTempleDataResponse = cmsTempleService.editAndSaveTempleAsVerfied(request.getRequestParam());
					}
				}
			}

			else {
				saveTempleDataResponse.setStatus(ResponseStatus.BAD_REQUEST);
				saveTempleDataResponse.setResponse("templeId is missing in request");
			}

			return ResponseEntity.ok(saveTempleDataResponse);
		} catch (Exception e) {
			logger.error("Error in saveTempleAsVerified(CMSController):" + e);
			saveTempleDataResponse.setStatus(ResponseStatus.INTERNAL_SERVER_ERROR);
			saveTempleDataResponse.setResponse("");
			return ResponseEntity.ok(saveTempleDataResponse);
		}
	}

	@PostMapping("/saveImage")
	public ResponseEntity<Response> saveImage(@RequestParam("file") MultipartFile file) {
		Response response = new Response();
		try {
			if (!file.isEmpty()) {
				// Get the image and save it
				try {
					byte[] bytes = file.getBytes();

					String originalFilename = file.getOriginalFilename();

					// String contentType = file.getContentType();

					if (folderToUploadImages != null) {

						Path path = Paths.get(folderToUploadImages + "/" + file.getOriginalFilename());

						write = Files.write(path, bytes);

					} else {
						File folder = new File("E:\\temp\\");
						folder.mkdirs();

						Path path = Paths.get(folder + "/" + file.getOriginalFilename());

						write = Files.write(path, bytes);
					}

					String imageId = cmsTempleService.saveImage(".jpg", file.getOriginalFilename(), "image");

					if (imageId != null) {
						Map<String, String> map = new HashMap<>(1);
						map.put("imageId", imageId);

						response.setStatus(ResponseStatus.OK);
						response.setResponse(map);

					} else {
						response.setStatus(ResponseStatus.INTERNAL_SERVER_ERROR);
						response.setResponse("Something went wrong while saving image.");
					}

				} catch (Exception e) {
					response.setStatus(ResponseStatus.INTERNAL_SERVER_ERROR);
					response.setResponse("Something went wrong while saving image.");
				}
			} else {
				response.setStatus(ResponseStatus.BAD_REQUEST);
				response.setResponse("File not found in request");
			}
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			logger.error("Error in saveImage(CMSController):" + e);
			response.setStatus(ResponseStatus.INTERNAL_SERVER_ERROR);
			response.setResponse("");
			return ResponseEntity.ok(response);
		}
	}

	@GetMapping("/getUserDetail")
	public ResponseEntity<Response> getUserDetail(@RequestParam("id") String id) {
		Response response = cmsTempleService.getUserDetail(id);
		return ResponseEntity.ok(response);
	}

	@PostMapping("/updateUserRole")
	@PreAuthorize("hasRole('ROLE_SUPER_ADMIN')")
	public ResponseEntity<Response> updateUserRole(@RequestBody PostRequestWithOutArray request) {

		Response response = cmsTempleService.updateUserRole(request);
		return ResponseEntity.ok(response);
	}

	@PostMapping("/saveMultipleImages")
	public ResponseEntity<Response> saveMultipleImages(@RequestParam("file") MultipartFile[] files) {
		Response response = new Response();
		try {
			List<Map<String, String>> listOfImageIdMaps = new ArrayList<>();
			if (files != null) {
				if (files.length != 0) {
					for (MultipartFile file : files) {
						if (!file.isEmpty()) {
							// Get the image and save it
							try {
								String type = "";
								byte[] bytes = file.getBytes();

								String originalFilename = file.getOriginalFilename();

								String contentType = file.getContentType();
								type = contentType.equalsIgnoreCase("video/mp4") ? "video" : "image";

								if (folderToUploadImages != null) {

									if (type.equalsIgnoreCase("video")) {

										Path path = Paths.get(folderToUploadVideos + "/" + file.getOriginalFilename());

										write = Files.write(path, bytes);
									} else {

										Path path = Paths.get(folderToUploadImages + "/" + file.getOriginalFilename());

										write = Files.write(path, bytes);
									}

								} else {
									File folder = new File("E:\\temp\\");
									folder.mkdirs();

									Path path = Paths.get(folder + "/" + file.getOriginalFilename());

									write = Files.write(path, bytes);
								}

								String imageId = cmsTempleService.saveImage(".jpg", file.getOriginalFilename(), type);

								if (imageId != null) {
									Map<String, String> map = new HashMap<>(1);
									map.put("imageId", imageId);

									listOfImageIdMaps.add(map);

								} else {
									response.setStatus(ResponseStatus.INTERNAL_SERVER_ERROR);
									response.setResponse("Something went wrong while saving image.");
								}

							} catch (Exception e) {
								response.setStatus(ResponseStatus.INTERNAL_SERVER_ERROR);
								response.setResponse("Something went wrong while saving image.");
							}
						} else {
							response.setStatus(ResponseStatus.BAD_REQUEST);
							response.setResponse("No File not found in request");
						}
					}

					if (listOfImageIdMaps.size() != 0) {
						response.setStatus(ResponseStatus.OK);
						response.setResponse(listOfImageIdMaps);
					} else {
						response.setStatus(ResponseStatus.ERROR);
						response.setResponse("Something went wrong");
					}
				} else {
					response.setStatus(ResponseStatus.BAD_REQUEST);
					response.setResponse("No Image found in request params");
				}
			}

			return ResponseEntity.ok(response);
		} catch (Exception e) {
			logger.error("Error in saveMultipleImages(CMSController):" + e);
			response.setStatus(ResponseStatus.INTERNAL_SERVER_ERROR);
			response.setResponse("");
			return ResponseEntity.ok(response);
		}
	}

	@PostMapping("/saveNewPanditDetails")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<Response> saveNewPanditDetails(@RequestBody PostRequestWithObject request) {
		logger.info("/saveNewPanditDetails method");
		Response response = new Response();
		try {
			response = cmsPanditServices.saveNewPanditDetails(request);
			logger.info("/saveNewPanditDetails request completed successfully.");
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			logger.error("Error in saveNewPanditDetails(CMSController):" + e);
			response.setStatus(ResponseStatus.INTERNAL_SERVER_ERROR);
			response.setResponse("");
			logger.info("/saveNewPanditDetails request Failed.");
			return ResponseEntity.ok(response);
		}
	}

	@GetMapping("/getUnverifiedPanditsList")
	@PreAuthorize("hasRole('ROLE_SUPER_ADMIN') or hasRole('ROLE_ADMIN')")
	public ResponseEntity<Response> getUnverifiedPanditsList() {
		Response response = new Response();
		try {
			response = cmsPanditServices.getUnverifiedPanditsList();
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			logger.error("/getUnverifiedPanditsList request Failed.");
			response.setStatus(ResponseStatus.ERROR);
			response.setResponse("");
			return ResponseEntity.ok(response);
		}
	}

	@GetMapping("/getUsersByName")
	public ResponseEntity<Response> getUsersByName(@RequestParam("name") String name) {
		Response response = new Response();
		try {
			List<Integer> userByNameLike = userServices.getUserByNameLike(name);
			if (userByNameLike != null) {
				if (userByNameLike.isEmpty()) {
					response.setStatus(ResponseStatus.NO_DATA_FOUND);
					response.setResponse("No user found by name" + name);
				} else {
					List<UserDetailsImpl> userDetailsList = userServices.getUserDetailsList(userByNameLike);
					response.setStatus(ResponseStatus.OK);
					response.setResponse(userDetailsList);
					return ResponseEntity.ok(response);
				}
			}
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			logger.error("Error in getUsersByName(CMSController):" + e);
			response.setStatus(ResponseStatus.INTERNAL_SERVER_ERROR);
			response.setResponse("");
			return ResponseEntity.ok(response);
		}
	}

	@GetMapping("/savePanditAsVerified/{panditId}")
	@PreAuthorize("hasRole('ROLE_SUPER_ADMIN') or hasRole('ROLE_ADMIN')")
	public ResponseEntity<Response> savePanditAsVerified(@PathVariable("panditId") String panditId) {
		Response response = new Response();
		try {
			logger.info("savePanditAsVerified request");
			response = cmsPanditServices.savePanditAsVerfied(panditId);
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			logger.info("/savePanditAsVerified request failed.");
			response.setStatus(ResponseStatus.INTERNAL_SERVER_ERROR);
			response.setResponse("");
			return ResponseEntity.ok(response);

		}
	}

	@PostMapping("/saveNewPanditDetailsAsVerified")
	@PreAuthorize("hasRole('ROLE_SUPER_ADMIN')")
	public ResponseEntity<Response> saveNewPanditDetailsAsVerified(@RequestBody PostRequestWithObject request) {
		logger.info("/saveNewPanditDetailsAsVerified method");
		Response response = new Response();
		try {
			response = cmsPanditServices.saveNewPanditDetailsAsVerified(request);
			logger.info("/saveNewPanditDetailsAsVerified request completed successfully.");
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			logger.error("Error in saveNewPanditDetails(CMSController):" + e);
			response.setStatus(ResponseStatus.INTERNAL_SERVER_ERROR);
			response.setResponse("");
			logger.info("/saveNewPanditDetailsAsVerified request Failed.");
			return ResponseEntity.ok(response);
		}
	}

	@GetMapping("/getAllPoojaServicesList")
	public ResponseEntity<Response> getAllPoojaServicesList() {
		logger.info("/getAllPoojaServicesList request");
		Response response = new Response();
		try {
			response = cmsPanditServices.getAllPoojaServicesList();
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			response.setStatus(ResponseStatus.INTERNAL_SERVER_ERROR);
			response.setResponse("");
			logger.info("/getAllPoojaServicesList request failed");
			return ResponseEntity.ok(response);
		}
	}
}
