package com.restApp.religiousIndia.services.cart;

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

import com.restApp.religiousIndia.data.entities.Temple;
import com.restApp.religiousIndia.data.entities.cart.CartItemDetails;
import com.restApp.religiousIndia.data.entities.cart.UserCart;
import com.restApp.religiousIndia.data.entities.cart.UserWishList;
import com.restApp.religiousIndia.data.repositry.cart.CartItemDetailsRepositry;
import com.restApp.religiousIndia.data.repositry.cart.CartRepositry;
import com.restApp.religiousIndia.data.repositry.cart.UserWishListRepositry;
import com.restApp.religiousIndia.response.Response;
import com.restApp.religiousIndia.response.status.ResponseStatus;
import com.restApp.religiousIndia.services.imageServices.RetriveImageService;
import com.restApp.religiousIndia.services.temple.TempleServices;
import com.restApp.religiousIndia.services.temple.donation.DonationService;
import com.restApp.religiousIndia.utilities.exception.CartNotSavedException;
import com.restApp.religiousIndia.utilities.exception.ItemNotRemovedException;

@Service
public class CartServices {
	private static Logger logger = Logger.getLogger(CartServices.class);

	@Autowired
	CartRepositry cartRepositry;

	@Autowired
	DonationService donationService;

	@Autowired
	CartItemDetailsRepositry itemDetailsRepositry;

	@Autowired
	TempleServices templeServices;

	@Autowired
	RetriveImageService retriveImageService;

	@Autowired
	UserWishListRepositry userWishListRepositry;

	public List<Map<String, Object>> getUserCart(Integer userId) {
		UserCart userCart = cartRepositry.findByUserId(userId);

		String cartDetails = userCart.getItemsDetails();

		List<Map<String, Object>> cartItems = getItemDetailsList(cartDetails);

		return cartItems;

	}

	@Transactional
	public Response removeCartItem(Integer userId, Integer removeItemId, Boolean isDeleteFromItems) {
		logger.info("Item removed from cart for userId:" + userId + " ItemId:" + removeItemId + " isWishList:"
				+ !isDeleteFromItems);
		Response response = new Response();

		UserCart userCart = cartRepositry.findByUserId(userId);
		try {
			String updatedItemDetalsList = removeItemFromJson(userCart.getItemsDetails(), removeItemId);
			userCart.setItemsDetails(updatedItemDetalsList);
		} catch (Exception e) {
			logger.error("Error in removeCartItem:" + e);
			response.setStatus(ResponseStatus.INVALID);
			response.setResponse("Error in item list Json");
		}

		try {
			if (isDeleteFromItems) {
				itemDetailsRepositry.delete(removeItemId);
			}
		} catch (Exception e) {
			logger.error("Error in removeCartItem:" + e);
			response.setStatus(ResponseStatus.ERROR);
			response.setResponse("Item details not found in DB");
		}

		response.setStatus(ResponseStatus.OK);
		response.setResponse("Item removed successfully");

		return response;
	}

	@Transactional
	public Response addItemInUserCart(Integer userId, Double donationAmount, String donationSubCategoryId,
			String templeDonationCategoryId) {
		Response response = new Response();

		UserCart userCart = findCartByUserId(userId);

		// Saving new item details(check is TempleID is needed or not)
		Integer itemId = null;
		try {
			itemId = saveCartItemDetailsForTemple(donationSubCategoryId, templeDonationCategoryId, "1");
		} catch (CartNotSavedException e) {
			logger.error("Error in addItemInUserCart:" + e);
		}

		return addItemToUserCart(userCart, itemId, donationAmount);
	}

	public UserCart findCartByUserId(Integer userId) {
		return cartRepositry.findByUserId(userId);
	}

	public CartItemDetails findCartItemDetailsByItemId(Integer itemId) {
		return itemDetailsRepositry.findOne(itemId);
	}

	public Integer saveCartItemDetailsForTemple(String donationSubCategoryId, String templeDonationCategoryId,
			String templeId) throws CartNotSavedException {
		CartItemDetails cartItemDetails = new CartItemDetails();

		cartItemDetails.setIsTempleDonation("1");
		// Temple Donation amount is changeable
		cartItemDetails.setIsAmtChangeable("1");
		cartItemDetails.setTempleDonationCategoryId(templeDonationCategoryId);
		cartItemDetails.setDonationSubCategoryId(donationSubCategoryId);
		cartItemDetails.setTempleId(templeId);

		CartItemDetails cartItem = itemDetailsRepositry.save(cartItemDetails);

		if (cartItem != null) {
			return cartItem.getItemId();
		} else {
			throw new CartNotSavedException("Cart Item Not saved");
		}
	}

	private Response addItemToUserCart(UserCart userCart, Integer itemId, Double donationAmount) {
		Response response = new Response();
		if (userCart != null) {
			try {
				JSONArray itemDetailsArray = new JSONArray(userCart.getItemsDetails());

				JSONObject newItemObject = new JSONObject();
				newItemObject.put("Item_Id", itemId);
				newItemObject.put("Price", donationAmount);
				itemDetailsArray.put(newItemObject);

				userCart.setItemsDetails(itemDetailsArray.toString());

				if (cartRepositry.save(userCart) != null) {

					response.setStatus(ResponseStatus.OK);
					response.setResponse("Item saved in cart successfully.");
				} else {
					response.setStatus(ResponseStatus.INTERNAL_SERVER_ERROR);
					response.setResponse("Something went wrong in saving details");
				}

			} catch (Exception e) {
				logger.error("Error in addItemInUserCart:" + e);
				response.setStatus(ResponseStatus.ERROR);
				response.setResponse("Something went wrong");
			}
		} else {
			UserCart cart = new UserCart();

			cart.setAddressId("12");
			cart.setUserId(userCart.getUserId());
			JSONArray itemArray = new JSONArray();
			cart.setItemsDetails(itemArray.toString());
			cartRepositry.save(cart);

			response.setStatus(ResponseStatus.OK);
			response.setResponse("New cart created for userId:" + userCart.getUserId());
		}
		return response;
	}

	public Response changeDonationAmt(Integer userId, Integer itemId, Double newAmt) {
		Response response = new Response();

		UserCart userCart = cartRepositry.findByUserId(userId);
		String itemsDetails = userCart.getItemsDetails();
		if (itemsDetails != null) {
			try {
				JSONArray itemDetailsArray = new JSONArray(itemsDetails);

				int totalItems = itemDetailsArray.length();
				JSONObject itemObject = null;
				for (int i = 0; i < totalItems; i++) {
					itemObject = itemDetailsArray.getJSONObject(i);
					if (itemObject.getInt("Item_Id") == itemId) {

						itemObject.put("Price", newAmt);
						itemDetailsArray.remove(i);
						itemDetailsArray.put(itemObject);

						userCart.setItemsDetails(itemDetailsArray.toString());

						cartRepositry.save(userCart);
						response.setStatus(ResponseStatus.OK);
						response.setResponse("Amount changed successfull");
						break;
					}
				}

			} catch (JSONException e) {
				logger.error("Error in changeDonationAmt:" + e);
				response.setStatus(ResponseStatus.INTERNAL_SERVER_ERROR);
				response.setResponse("Something went wrong");
			}
		}
		return response;

	}

	private String removeItemFromJson(String itemsDetailsList, Integer removeItemId) throws ItemNotRemovedException {
		try {
			JSONArray itemDetailsArray = new JSONArray(itemsDetailsList);

			if (itemDetailsArray != null) {
				int totalArrayLength = itemDetailsArray.length();

				int cartItemId;
				for (int i = 0; i < totalArrayLength; i++) {
					cartItemId = itemDetailsArray.getJSONObject(i).getInt("Item_Id");
					if (cartItemId == removeItemId) {
						itemDetailsArray.remove(i);
						break;
					}
				}
			}
			return itemDetailsArray.toString();
		} catch (Exception e) {
			logger.error("Error in removeCartItem:" + e);
			throw new ItemNotRemovedException("Unable to remove to item Json Array");
		}
	}

	private Map<String, String> removeItemFromJsonAndGetPrice(String itemsDetailsList, Integer removeItemId)
			throws ItemNotRemovedException {
		try {
			Map<String, String> map = new HashMap<>();
			JSONArray itemDetailsArray = new JSONArray(itemsDetailsList);

			if (itemDetailsArray != null) {
				int totalArrayLength = itemDetailsArray.length();

				int cartItemId;
				for (int i = 0; i < totalArrayLength; i++) {
					cartItemId = itemDetailsArray.getJSONObject(i).getInt("Item_Id");
					if (cartItemId == removeItemId) {
						map.put("Item_Price", itemDetailsArray.getJSONObject(i).getDouble("Price")+"");
						itemDetailsArray.remove(i);
						break;
					}
				}
			}
			map.put("New_Array", itemDetailsArray.toString());
			return map;
		} catch (Exception e) {
			logger.error("Error in removeCartItem:" + e);
			throw new ItemNotRemovedException("Unable to remove to item Json Array");
		}
	}

	@Transactional
	public Response moveItemToWishList(Integer itemId, Integer userId, Double price) {
		logger.info("item added in wishList for userId:" + userId + ",itemId:" + itemId);
		Response response = addItemToWishList(itemId, userId, price);

		if (!removeCartItem(userId, itemId, false).getStatus().equals(ResponseStatus.OK)) {
			response.setStatus(ResponseStatus.INTERNAL_SERVER_ERROR);
			response.setResponse("Something went wrong.Please try later.");
		}
		return response;
	}

	private Response addItemToWishList(Integer itemId, Integer userId, Double price) {
		logger.info("addItemToWishList");
		Response response = new Response();
		UserWishList userWishList = userWishListRepositry.findByUserId(userId);
		int wishlistId;
		if (userWishList != null) {

			try {
				JSONArray wishListArray = new JSONArray(userWishList.getItem());
				JSONObject listObect = new JSONObject();
				listObect.put("Price", price);
				listObect.put("Item_Id", itemId);
				wishListArray.put(listObect);
				userWishList.setItem(wishListArray.toString());
				wishlistId = userWishListRepositry.save(userWishList).getWishlistId();
				response.setStatus(ResponseStatus.OK);
				response.setResponse("Item Moved to wishlist successfully");
			} catch (Exception e) {
				logger.error("Error in addItemToWishList:" + e);
				response.setStatus(ResponseStatus.INTERNAL_SERVER_ERROR);
				response.setResponse("Something went wrong.Please try later");
			}
		} else {
			userWishList = new UserWishList();
			userWishList.setUserId(userId);
			JSONArray wishListArray = new JSONArray();
			JSONObject listObect = new JSONObject();

			try {
				listObect.put("Price", price);
				listObect.put("Item_Id", itemId);
				wishListArray.put(listObect);
			} catch (JSONException e) {
				logger.error("Error in addItemToWishList:" + e);
				response.setStatus(ResponseStatus.INTERNAL_SERVER_ERROR);
				response.setResponse("Something went wrong.Please try later");
			}
			userWishList.setItem(wishListArray.toString());
			wishlistId = userWishListRepositry.save(userWishList).getWishlistId();
			response.setStatus(ResponseStatus.OK);
			response.setResponse("New wishList created:" + wishlistId);
		}
		return response;
	}

	public Response getUserWishList(Integer userId) {
		logger.info("getUserWishList for userId:" + userId);

		Response response = new Response();

		UserWishList userWishList = userWishListRepositry.findByUserId(userId);
		if (userWishList != null) {
			String itemDetails = userWishList.getItem();
			List<Map<String, Object>> detailsList = getItemDetailsList(itemDetails);
			response.setStatus(ResponseStatus.OK);
			response.setResponse(detailsList);
		} else {
			logger.info("No Items in user wishList");
			response.setStatus(ResponseStatus.NO_DATA_FOUND);
			response.setResponse("No item in wishlist.");
		}
		return response;
	}

	private List<Map<String, Object>> getItemDetailsList(String cartDetails) {
		List<Map<String, Object>> cartItems = new ArrayList<>();

		try {
			JSONArray cartDetailsArray = new JSONArray(cartDetails);

			int totalCartItems = cartDetailsArray.length();

			JSONObject itemObject = null;

			for (int i = 0; i < totalCartItems; i++) {
				itemObject = (JSONObject) cartDetailsArray.get(i);

				Integer itemId = itemObject.getInt("Item_Id");

				CartItemDetails cartItemDetails = itemDetailsRepositry.findOne(itemId);
				Map<String, Object> itemDetails = new HashMap<>();
				if (cartItemDetails != null) {

					Boolean isTempleDonation = false;

					Boolean isPanditBooking = false;

					Boolean isPoojaBooking = false;

					isTempleDonation = cartItemDetails.getIsTempleDonation().equals("1");

					isPanditBooking = cartItemDetails.getIsPanditBooking().equals("1");

					isPoojaBooking = cartItemDetails.getIsPoojaBooking().equals("1");

					if (isTempleDonation) {
						String donationSubCategoryId = cartItemDetails.getDonationSubCategoryId();

						Map<String, String> map = donationService.getTempleIdByDonationSubCategory(
								cartItemDetails.getTempleDonationCategoryId(), donationSubCategoryId);
						Temple temple = templeServices.getTemplesByTempleId(map.get("Temple_Id"));

						String imagePath = retriveImageService.getImagePath(temple.getMainImageID());
						itemDetails.put("Image_Id", imagePath);
						itemDetails.put("Category", map.get("Donation_Sub_Cat_Name"));
						itemDetails.put("Name", temple.getTempleName());
						itemDetails.put("templeId", temple.getTempleId());
						itemDetails.put("IsEditable", cartItemDetails.getIsAmtChangeable().equals("1"));

					} else if (isPanditBooking) {

					} else if (isPoojaBooking) {

					}
					itemDetails.put("IsTemple", isTempleDonation);
					itemDetails.put("IsPandit", isPanditBooking);
					itemDetails.put("IsPooja", isPoojaBooking);

					Double price = itemObject.getDouble("Price");

					itemDetails.put("Item_Id", itemId);

					itemDetails.put("Price", price);

					cartItems.add(itemDetails);
				}

			}
		} catch (Exception e) {
			logger.error("Error in getItemDetailsList:" + e);
		}
		return cartItems;
	}

	private Response removeItemFromWishList(Integer userId, Integer itemId) {
		logger.info("removeItemFromWishList");
		Response response = new Response();
		UserWishList userWishList = userWishListRepositry.findByUserId(userId);
		String itemsList = userWishList.getItem();

		if (itemsList != null) {
			try {
				Map<String, String> map = removeItemFromJsonAndGetPrice(itemsList, itemId);
				itemsList = map.get("New_Array");
				Double price = Double.parseDouble(map.get("Item_Price"));
				userWishList.setItem(itemsList);

				userWishListRepositry.save(userWishList);

				response.setResponse(price);
				response.setStatus(ResponseStatus.OK);
				logger.info("WishList itemId:" + itemId + " removed from wishList for user:" + userId);
			} catch (Exception e) {
				logger.error("Eroor in moveItemToCart:" + e);
				response.setStatus(ResponseStatus.INTERNAL_SERVER_ERROR);
				response.setResponse("Something went wrong.Please try later.");
			}
		} else {
			response.setStatus(ResponseStatus.NO_DATA_FOUND);
			response.setResponse("WishList is empty");
		}
		return response;
	}

	@Transactional
	public Response moveItemToCart(Integer userId, Integer itemId) {
		Response responseFromRemoval = removeItemFromWishList(userId, itemId);
		if (responseFromRemoval.getStatus().equals(ResponseStatus.OK)) {
			Double price = (Double) responseFromRemoval.getResponse();
			return addItemIdToUserCart(userId, itemId, price);
		} else {
			return responseFromRemoval;
		}
	}

	private Response addItemIdToUserCart(Integer userId, Integer itemId, Double price) {
		UserCart userCart = cartRepositry.findByUserId(userId);
		return addItemToUserCart(userCart,itemId,price);

	}

}
