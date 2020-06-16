package com.rad.rduserportal.dao.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class RDUserRoleId implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long userDid;
	private Long roleDid;
	
	public RDUserRoleId() {}
	
	public RDUserRoleId(Long userDid, Long roleDid) {
		this.userDid = userDid;
		this.roleDid = roleDid;
	}

	public Long getUserDid() {
		return userDid;
	}

	public void setUserDid(Long userDid) {
		this.userDid = userDid;
	}

	public Long getRoleDid() {
		return roleDid;
	}

	public void setRoleDid(Long roleDid) {
		this.roleDid = roleDid;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (null == obj) { return false; }
		if (!(obj instanceof RDUserRoleId)) { return false; }
		
		if (this == obj) { return true; }
		
		RDUserRoleId urId = (RDUserRoleId) obj;
		return Objects.equals(userDid, urId.userDid) && Objects.equals(roleDid, urId.roleDid);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(userDid, roleDid);
	}
}
