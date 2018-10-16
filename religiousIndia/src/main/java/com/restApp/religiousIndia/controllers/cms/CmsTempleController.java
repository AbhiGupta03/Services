package com.restApp.religiousIndia.controllers.cms;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.restApp.religiousIndia.data.entities.users.UserRoles;
import com.restApp.religiousIndia.request.filter.PostRequest;
import com.restApp.religiousIndia.request.filter.PostRequestWithObject;
import com.restApp.religiousIndia.request.filter.PostRequestWithOutArray;
import com.restApp.religiousIndia.response.Response;
import com.restApp.religiousIndia.response.status.ResponseStatus;
import com.restApp.religiousIndia.services.cmsServices.CmsTempleService;

@RestController
@CrossOrigin
public class CmsTempleController {
	@Autowired
	private CmsTempleService cmsTempleService;

	@Value("${folderToUploadImages}")
	private final String folderToUploadImages = null;

	private Path write;

	@GetMapping("/getAllRoles")
	public ResponseEntity<Response> getAllRoles() {
		Response response = new Response();
		Iterable<UserRoles> allRoles = cmsTempleService.getAllRoles();

		response.setResponse(allRoles);
		response.setStatus(ResponseStatus.OK);
		return ResponseEntity.ok(response);
	}

	@PostMapping("/saveTempleDetails")
	// @PreAuthorize("hasRole('ROLE_SUPER_ADMIN') or hasRole('ROLE_ADMIN') or
	// hasRole('ROLE_TEMPLE')")
	public ResponseEntity<Response> saveTempleDetails(@RequestBody PostRequestWithObject request) {
		Response saveTempleDataResponse = new Response();
		if (request != null) {
			if (request.getRequestType().equals("saveTempleDetails")) {
				if (request.getRequestParam() != null) {
					saveTempleDataResponse = cmsTempleService.saveTempleData(request.getRequestParam());

					if (saveTempleDataResponse.getStatus().equals(ResponseStatus.OK)) {
						/*
						 * if (!file.isEmpty()) { // Get the image and save it try { byte[] bytes =
						 * file.getBytes();
						 * 
						 * Path path = Paths.get(folderToUploadImages + file.getOriginalFilename());
						 * 
						 * write = Files.write(path, bytes); System.out.println(write); } catch
						 * (Exception e) { System.out.println("Error in:" + e); } }
						 */
						// mailService.sendEmail(to, messageBody, subject, isHtml);
					}
				}
			}
		} else {
			saveTempleDataResponse.setStatus(ResponseStatus.INVALID);
			saveTempleDataResponse.setResponse("request can't be blank ");
		}
		return ResponseEntity.ok(saveTempleDataResponse);
	}

	@GetMapping("/getUnVerifiedTemplesList")
	// @PreAuthorize("hasRole('ROLE_SUPER_ADMIN') or hasRole('ROLE_ADMIN')")
	public ResponseEntity<Response> getUnVerfiedTemplesList() {
		Response response = cmsTempleService.getUnVerfiedTemplesList();
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/getUnVerifiedTemple/{templeId}")
	public ResponseEntity<Response> getUnVerifiedTemple(@PathVariable("templeId") String templeId) {
		Response response = new Response();

		if (templeId != null && !templeId.isEmpty() && !templeId.equals("")) {
			response = cmsTempleService.getUnVerifiedTemple(templeId);
		} else {
			response.setStatus(ResponseStatus.BAD_REQUEST);
			response.setResponse("templeId is missing in request");
		}

		return ResponseEntity.ok(response);
	}

	@GetMapping("/saveTempleAsVerified/{templeId}")
	// @PreAuthorize("hasRole('ROLE_SUPER_ADMIN') or hasRole('ROLE_ADMIN')")
	public ResponseEntity<Response> saveTempleAsVerfied(@PathVariable("templeId") String templeId) {
		Response response = new Response();

		if (templeId != null && !templeId.isEmpty() && !templeId.equals("")) {
			response = cmsTempleService.saveTempleAsVerfied(templeId);
		} else {
			response.setStatus(ResponseStatus.BAD_REQUEST);
			response.setResponse("templeId is missing in request");
		}

		return ResponseEntity.ok(response);
	}

	@PostMapping("/saveTempleAsVerified")
	// @PreAuthorize("hasRole('ROLE_SUPER_ADMIN') or hasRole('ROLE_ADMIN')")
	public ResponseEntity<Response> editAndSaveTempleAsVerfied(@RequestBody PostRequest request) {
		Response saveTempleDataResponse = new Response();
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
	}

	@PostMapping("/saveImage")
	public ResponseEntity<Response> saveImage(@RequestParam("file") MultipartFile file) {
		Response response = new Response();
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

				String imageId = cmsTempleService.saveImage(".jpg", file.getOriginalFilename());

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
	}

	@GetMapping("/getUserDetail")
	public ResponseEntity<Response> getUserDetail(@RequestParam("id") String id) {
		Response response = cmsTempleService.getUserDetail(id);
		return ResponseEntity.ok(response);
	}

	@PostMapping("/updateUserRole")
	public ResponseEntity<Response> updateUserRole(@RequestBody PostRequestWithOutArray request) {

		Response response = cmsTempleService.updateUserRole(request);
		return ResponseEntity.ok(response);
	}
}
