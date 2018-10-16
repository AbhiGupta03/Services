package com.restApp.religiousIndia.data.repositry;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.restApp.religiousIndia.data.entities.Address;

@Scope("prototype")
public interface AddresssRepositry extends CrudRepository<Address, Integer> {
	Address findByIsActiveAndAddressID(String isActive, Integer addressId);

	List<Address> findByCityIdIn(List<String> cityIdList);

	List<Address> findByCityIn(List<String> cityList);

	List<Address> findByisTempleAddressAndCityIn(String isTempleAddress, List<String> cityList);

	public static final String Get_City_For_Pincode = "SELECT distinct city FROM ri_address where pincode = ?1";

	@Query(value = Get_City_For_Pincode, nativeQuery = true)
	public String getcityForPincode(String pincode);

}
