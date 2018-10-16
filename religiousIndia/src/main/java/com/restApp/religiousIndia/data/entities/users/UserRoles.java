package com.restApp.religiousIndia.data.entities.users;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import com.restApp.religiousIndia.model.roleName.RoleName;
import com.restApp.religiousIndia.utilities.audits.AuditFields;

@Entity
@Table(name = "ri_user_roles")
public class UserRoles extends AuditFields<String> {

	@Id
	@Column(name = "ROLE_ID")
	private String userRoleID;

	@Enumerated(EnumType.STRING)
	@Column(name = "USER_ROLE")
	private RoleName name;

	private String roleDesc;

	public String getUserRoleID() {
		return userRoleID;
	}

	public void setUserRoleID(String userRoleID) {
		this.userRoleID = userRoleID;
	}

	public String getRoleDesc() {
		return roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

	public RoleName getName() {
		return name;
	}

	public void setName(RoleName name) {
		this.name = name;
	}
}
