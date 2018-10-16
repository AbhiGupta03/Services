package com.restApp.religiousIndia.data.entities.login;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.restApp.religiousIndia.utilities.audits.AuditFields;

@Entity
@Table(name = "ri_login_types")
public class LoginTypes extends AuditFields<String> {

	@Id
	@Column(name = "LOGIN_TYPE_ID")
	private String loginTypeId;

	private String loginType;

	private String typeDesc;

	public String getLoginTypeId() {
		return loginTypeId;
	}

	public void setLoginTypeId(String loginTypeId) {
		this.loginTypeId = loginTypeId;
	}

	public String getLoginType() {
		return loginType;
	}

	public void setLoginType(String loginType) {
		this.loginType = loginType;
	}

	public String getTypeDesc() {
		return typeDesc;
	}

	public void setTypeDesc(String typeDesc) {
		this.typeDesc = typeDesc;
	}
}
