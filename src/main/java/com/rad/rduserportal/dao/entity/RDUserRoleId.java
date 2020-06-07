package com.rad.rduserportal.dao.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class RDUserRoleId implements Serializable {

	private static final long serialVersionUID = 1L;

	private RDUser user;
	private RDRole role;

	@ManyToOne(cascade = CascadeType.ALL)
	public RDUser getUser() {
		return user;
	}

	public void setUser(RDUser user) {
		this.user = user;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	public RDRole getRole() {
		return role;
	}

	public void setRole(RDRole role) {
		this.role = role;
	}
	
}
