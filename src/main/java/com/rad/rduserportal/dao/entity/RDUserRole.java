package com.rad.rduserportal.dao.entity;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity(name = "RDUserRole")
@Table(name = "RD_USER_ROLE")
public class RDUserRole {
	
	@EmbeddedId
	private RDUserRoleId id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("userDid")
	@JoinColumn(name = "USER_DID")
	private RDUser user;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("roleDid")
	@JoinColumn(name = "ROLE_DID")
	private RDRole role;
	
	@Column(name = "CREATE_DATE")
	private Date createDate;
	
	public RDUserRole() {}
	
	public RDUserRole(RDUser user, RDRole role, Date createDate) {
		this.user = user;
		this.role = role;
		this.createDate = createDate;
		this.id = new RDUserRoleId(user.getId(), role.getId());
	}

	public RDUserRoleId getId() {
		return id;
	}

	public void setId(RDUserRoleId id) {
		this.id = id;
	}

	public RDUser getUser() {
		return user;
	}

	public void setUser(RDUser user) {
		this.user = user;
	}

	public RDRole getRole() {
		return role;
	}

	public void setRole(RDRole role) {
		this.role = role;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (null == obj) { return false; }
		if (!(obj instanceof RDUserRole)) {return false; }
		
		if (this == obj) { return true; }
		
		RDUserRole rdUR = (RDUserRole) obj;
		return Objects.equals(user, rdUR.getUser()) && Objects.equals(role, rdUR.getRole()); 
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(user, role);
	}
}
