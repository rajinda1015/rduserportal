package com.rad.rduserportal.dao.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "RD_USER_ROLE")
@IdClass(RDUserRoleId.class)
public class RDUserRole implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "USER_DID", referencedColumnName = "userDid")
	private RDUser user;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "ROLE_DID", referencedColumnName = "roleDid")
	private RDRole role;

	@Column(name = "CREATE_DATE")
	private Date createDate;

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

}
