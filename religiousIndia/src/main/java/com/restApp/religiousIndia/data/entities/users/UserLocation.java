package com.restApp.religiousIndia.data.entities.users;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;

@Entity
@NamedStoredProcedureQueries({
		@NamedStoredProcedureQuery(name = "get_user_location", procedureName = "get_user_location", parameters = {
				@StoredProcedureParameter(name = "userId", type = Integer.class, mode = ParameterMode.IN),
				@StoredProcedureParameter(name = "address", type = String.class, mode = ParameterMode.OUT) }) })

public class UserLocation {
	@Id
	private String addressId;

	public String getAddressId() {
		return addressId;
	}

	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	private String address;

}
