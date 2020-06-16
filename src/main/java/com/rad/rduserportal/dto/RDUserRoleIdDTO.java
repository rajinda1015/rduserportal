package com.rad.rduserportal.dto;

import java.io.Serializable;

public class RDUserRoleIdDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private long userDid;
	private long roleDid;

	public long getUserDid() {
		return userDid;
	}

	public void setUserDid(long userDid) {
		this.userDid = userDid;
	}

	public long getRoleDid() {
		return roleDid;
	}

	public void setRoleDid(long roleDid) {
		this.roleDid = roleDid;
	}
	
}
