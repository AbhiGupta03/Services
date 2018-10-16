package com.restApp.religiousIndia.services.users;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.restApp.religiousIndia.data.entities.Address;
import com.restApp.religiousIndia.data.entities.pandit.PanditDetails;
import com.restApp.religiousIndia.data.entities.users.UserDetailsImpl;
import com.restApp.religiousIndia.data.entities.users.UserRoles;
import com.restApp.religiousIndia.data.repositry.AddresssRepositry;
import com.restApp.religiousIndia.data.repositry.CityRepositry;
import com.restApp.religiousIndia.data.repositry.users.UserDetailsRepositry;
import com.restApp.religiousIndia.data.repositry.users.UserRolesRepositry;
import com.restApp.religiousIndia.model.roleName.RoleName;
import com.restApp.religiousIndia.request.filter.PostRequestWithOutArray;
import com.restApp.religiousIndia.response.Response;
import com.restApp.religiousIndia.response.status.ResponseStatus;
import com.restApp.religiousIndia.services.imageServices.RetriveImageService;
import com.restApp.religiousIndia.services.temple.nearBy.NearByDetails;
import com.restApp.religiousIndia.utilities.exception.UserNotSavedException;

@Service
public class UserServices {

	@Autowired
	private NearByDetails nearByDetails;

	@Autowired
	private CityRepositry cityRepositry;

	@Autowired
	RetriveImageService retriveImageService;

	@Autowired
	UserRolesRepositry userRolesRepositry;

	@Autowired
	UserDetailsRepositry userDetailsRepositry;

	@Autowired
	AddresssRepositry addressRepositry;

	public RoleName getUserRoles(String userRoleID) {
		UserRoles userRoles = userRolesRepositry.findOne(userRoleID);
		if (userRoles != null) {
			return userRoles.getName();
		}
		return RoleName.ROLE_USER;
	}

	public UserDetailsImpl getUserDetails(String userId) {
		UserDetailsImpl userDetails = userDetailsRepositry.findByEmail(userId)
				.orElseThrow(() -> new UsernameNotFoundException("User Name not found"));

		return userDetails;
	}

	public Integer saveUserPrimaryDetails(UserDetailsImpl userDetails) throws UserNotSavedException {
		try {
			return userDetailsRepositry.save(userDetails).getUserId();

		} catch (Exception e) {
			throw new UserNotSavedException("User Not Saved dew to: " + e);
		}

	}

	public Response userProfileDetails(String userName) {
		Map<String, String> map = new HashMap<>();
		Response response = new Response();

		try {
			UserDetailsImpl userDetails = getUserDetails(userName);
			if (userDetails != null) {

				map.put("userId", userDetails.getUserId() + "");
				map.put("firstName", userDetails.getFirstName());
				map.put("middleName", userDetails.getMiddleName());
				map.put("lastName", userDetails.getLastName());
				map.put("email", userDetails.getEmail());
				map.put("gender", userDetails.getGender());
				map.put("addressId", userDetails.getAddressId());
				map.put("primaryPhone", userDetails.getPrimaryPhone());

				map.put("role", getUserRoles(userDetails.getUserRoleDetails()).toString());
				response.setStatus(ResponseStatus.OK);
				response.setResponse(map);
			}
		} catch (Exception e) {
			response.setStatus(ResponseStatus.NO_DATA_FOUND);
			response.setResponse("User Name not found");
		}

		return response;
	}

	public Map<String, Object> getUserDeliveryDetails(Integer userId) {
		Map<String, Object> map = new HashMap<>();
		UserDetailsImpl userDetails = userDetailsRepositry.findByUserId(userId);

		Integer addressId = new Integer(userDetails.getAddressId());

		Address address = null;

		address = addressRepositry.findOne(addressId);

		if (address != null) {
			map.put("Address", address);
			if (address.getPincode() == null || address.getPincode().equals("")) {
				String pinCodeForAddress = nearByDetails
						.getPinCodeForAddress(address.getAddressDetail() + address.getState());

				address.setPincode(pinCodeForAddress);

				addressRepositry.save(address);
			}
			map.put("PinCode", address.getPincode());
			map.put("Contact", userDetails.getPrimaryPhone());
		}

		return map;
	}

	public List<Map<String, Object>> getUserOtherAddresses(Integer userId) {
		List<Map<String, Object>> list = new ArrayList<>();

		UserDetailsImpl userDetails = userDetailsRepositry.findByUserId(userId);

		String otherAddresses = userDetails.getOtherAddresses();

		String[] otherAddressesList = otherAddresses.split(",");

		Address address = null;

		for (String addressId : otherAddressesList) {
			Map<String, Object> map = new HashMap<>();
			address = addressRepositry.findOne(new Integer(addressId));

			if (address != null) {
				map.put("Address", address);
				if (address.getPincode() == null || address.getPincode().equals("")) {
					String pinCodeForAddress = nearByDetails
							.getPinCodeForAddress(address.getAddressDetail() + address.getState());

					address.setPincode(pinCodeForAddress);

					addressRepositry.save(address);
				}

				map.put("Contact", userDetails.getPrimaryPhone());
			}
			list.add(map);
		}

		return list;
	}

	public Response updateUserRole(String userId, String roleId) {
		Response response = new Response();
		UserDetailsImpl userDetails = userDetailsRepositry.findByUserId(new Integer(userId));

		if (userDetails != null) {
			userDetails.setUserRoleDetails(roleId);

			UserDetailsImpl save = userDetailsRepositry.save(userDetails);
			if (save != null) {
				response.setStatus(ResponseStatus.OK);
				response.setResponse("user role updated successfully");
			} else {
				response.setStatus(ResponseStatus.INTERNAL_SERVER_ERROR);
				response.setResponse("Something went wrong.Please try later");
			}
		} else {
			response.setStatus(ResponseStatus.NO_DATA_FOUND);
			response.setResponse("user Id not found in records");
		}
		return response;
	}

	public Response addNewAddress(PostRequestWithOutArray addressDetails, Integer userId) {
		Response response = new Response();
		if (addressDetails.getRequestType().equalsIgnoreCase("addNewAddress")) {
			Map<String, String> requestParam = addressDetails.getRequestParam();
			String city = requestParam.get("city");
			String state = requestParam.get("state");
			String addressDesc = requestParam.get("addressDesc");
			String pincode = requestParam.get("pincode");
			String contactNo = requestParam.get("contactNo");

			if (pincode == null || pincode.isEmpty()) {
				pincode = nearByDetails.getPinCodeForAddress(addressDesc + "," + city + "," + state);
			}
			UserDetailsImpl userDetails = userDetailsRepositry.findByUserId(userId);

			if (userDetails != null) {
				Address address = new Address();

				address.setCity(city);
				address.setState(state);
				address.setAddressDetail(addressDesc);
				address.setIsActive("1");
				address.setIsTempleAddress("0");
				address.setCityId(cityRepositry.findCityId(city));
				address.setPincode(pincode);
				address.setContactNo(contactNo);

				int addressId = addressRepositry.save(address).getId();

				String otherAddresses = userDetails.getOtherAddresses();
				if (otherAddresses != null && !otherAddresses.isEmpty()) {
					otherAddresses += "," + addressId;
					userDetails.setOtherAddresses(otherAddresses);
				} else {
					userDetails.setOtherAddresses(addressId + "");
				}

				userDetailsRepositry.save(userDetails);
				response.setStatus(ResponseStatus.OK);
				response.setResponse("New address saved successfully");
			} else {
				response.setStatus(ResponseStatus.NO_DATA_FOUND);
				response.setResponse("No record found for user");
			}
		} else {
			response.setStatus(ResponseStatus.BAD_REQUEST);
			response.setResponse("Bad Request");
		}
		return response;
	}

	public String getCitiesForPinCode(String pincode) {
		return addressRepositry.getcityForPincode(pincode);
	}

	public Response deleteAddressFromList(Integer userId, String addressId) {
		Response response = new Response();
		UserDetailsImpl userDetails = userDetailsRepositry.findByUserId(userId);

		if (userDetails != null) {
			if (userDetails.getAddressId().equals(addressId)) {
				String[] otherAddresses = userDetails.getOtherAddresses().split(",");

				String newDefaultAddress = otherAddresses[0];

				new LinkedList<String>(Arrays.asList(otherAddresses)).remove(0);

				String updatedOtherAddresses = String.join(",", otherAddresses);

				userDetails.setOtherAddresses(updatedOtherAddresses);
				userDetails.setAddressId(newDefaultAddress);

				userDetailsRepositry.save(userDetails);

				response.setStatus(ResponseStatus.OK);
				response.setResponse("address List Updated and default address changed");
			} else {
				String addresses = userDetails.getOtherAddresses();
				String[] otherAddresses = addresses.split(",");
				List<String> otherAddressList = new LinkedList<String>(Arrays.asList(otherAddresses));

				Predicate<String> predicate = p -> p.equals(addressId);

				otherAddressList.removeIf(predicate);

				addresses = String.join(",", otherAddressList);

				userDetails.setOtherAddresses(addresses);

				userDetailsRepositry.save(userDetails);

				response.setStatus(ResponseStatus.OK);
				response.setResponse("address List Updated");
			}

			addressRepositry.delete(new Integer(addressId));
		} else {
			response.setStatus(ResponseStatus.NO_DATA_FOUND);
			response.setResponse("User Id not Found");
		}
		return response;
	}

	public List<Integer> getUserByNameLike(String userName) {
		List<Integer> userIdList = new ArrayList<>();

		String firstName;
		String middleName = " ";
		String lastName = " ";

		String[] name = userName.split(" ");
		firstName = name[0];
		switch (name.length) {
		case 1:
			middleName = name[0];
			lastName = name[0];
			break;

		case 2:
			middleName = name[1];
			break;

		case 3:
			lastName = name[2];
			break;
		}

		userDetailsRepositry
				.findByisActiveAndFirstNameContainingOrIsActiveAndMiddleNameContainingOrIsActiveAndLastNameContaining(
						"1", firstName, "1", middleName, "1", lastName)
				.forEach(user -> userIdList.add(user.getUserId()));

		return userIdList;
	}

	public List<UserDetailsImpl> getUserDetailsList(List<Integer> usersId) {
		return userDetailsRepositry.findByUserIdIn(usersId);
	}
}
