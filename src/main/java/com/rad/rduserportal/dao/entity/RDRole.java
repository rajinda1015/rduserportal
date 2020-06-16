package com.rad.rduserportal.dao.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
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
public class RDRole {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ROLE_DID")
	private Long id;
	
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
	
	@OneToMany(
			mappedBy = "role",
			cascade = CascadeType.ALL,
			orphanRemoval = true)
	private List<RDUserRole> userRoles = new ArrayList<RDUserRole>();

	public RDRole() {}
	
	public RDRole(Long roleDid, String roleName, String description, int status, Date createDate) {
		this.id = roleDid;
		this.roleName = roleName;
		this.description = description;
		this.status = status;
		this.createDate = createDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public List<RDUserRole> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(List<RDUserRole> userRoles) {
		this.userRoles = userRoles;
	}

	@Override
	public boolean equals(Object obj) {
		if (null == obj) { return false; }
		if (!(obj instanceof RDRole)) { return false; }
		
		if (this == obj) { return true; }
		
		RDRole rr = (RDRole) obj;
		return Objects.equals(id, rr.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}
