package com.rad.rduserportal.dao.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "RD_ROLE")
public class RDRole implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "ROLE_DID")
	private long roleDid;
	
	@Column(name = "ROLE_NAME")
	private String roleName;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	@Column(name = "STATUS")
	private int status;
	
	@Column(name = "CREATE_DATE")
	private Date createDate;

	@Version
	@Column(name = "version")
	private Integer version;

	@OneToMany(mappedBy = "role")
	private Set<RDUserRole> userRoles = new HashSet<RDUserRole>();

	public Set<RDUserRole> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(Set<RDUserRole> userRoles) {
		this.userRoles = userRoles;
	}
	
	public void addUserRole(RDUserRole userRole) {
		this.userRoles.add(userRole);
	}

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

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

}
