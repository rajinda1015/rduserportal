package com.rad.rduserportal.dao.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
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
@Table(name = "RD_USER")
public class RDUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_DID")
	private Long id;
	
	@Column(name = "FIRST_NAME")
	private String firstName;
	
	@Column(name = "GENDER")
	private char gender;
	
	@Column(name = "LAST_NAME")
	private String lastName;
	
	@Column(name = "MIDDLE_NAME")
	private String middleName;
	
	@Column(name = "CREATE_DATE")
	private Date createDate;
	
	@Column(name = "UPDATE_DATE")
	private Date updateDate;
	
	@Column(name = "STATUS")
	private Integer status;

	@Version
	@Column(name = "version")
	private Integer version;

	@OneToMany(
			mappedBy = "user",
			cascade = CascadeType.ALL,
			orphanRemoval = true)
	private List<RDUserRole> userRoles = new ArrayList<RDUserRole>();
	
	public RDUser() {}
	
	public RDUser(Long userDid, String firstName, String middleName,
			String lastName, char gender, Date createDate, Date updateDate,
			Integer status, Integer version) {
		this.id = userDid;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.gender = gender;
		this.createDate = createDate;
		this.status = status;
		this.updateDate = updateDate;
		this.version = version;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}
	
	public void addRole(RDRole role) {
		RDUserRole userRole = new RDUserRole(this, role, new Date());
		userRoles.add(userRole);
		role.getUserRoles().add(userRole);
	}
	
	public void removeRole(RDRole role) {
		Iterator<RDUserRole> itrUserRoles = userRoles.iterator();
		while (itrUserRoles.hasNext()) {
			RDUserRole userRole = itrUserRoles.next();
			if (userRole.getUser().equals(this) && userRole.getRole().equals(role)) {
				itrUserRoles.remove();
				userRole.getRole().getUserRoles().remove(userRole);
				userRole.setUser(null);
				userRole.setRole(null);
			}
		}
	}
	
	@Override
	public boolean equals(Object obj) {
		if (null == obj) { return false; }
		if (!(obj instanceof RDUser)) { return false; }
		
		if (this == obj) { return true; }
		
		RDUser ru = (RDUser) obj;
		return Objects.equals(id, ru.id);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}
