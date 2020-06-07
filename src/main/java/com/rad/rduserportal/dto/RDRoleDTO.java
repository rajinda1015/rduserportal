package com.rad.rduserportal.dto;

import java.io.Serializable;
import java.util.Date;

public class RDRoleDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private long roleDid;
	private String roleName;
	private String description;
	private int status;
	private Date createDate;

	public long getRoleDid() {
		return roleDid;
	}

	public void setRoleDid(long roleDid) {
		this.roleDid = roleDid;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

}
