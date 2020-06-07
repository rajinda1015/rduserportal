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
@Table(name = "RD_USER")
public class RDUser implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_DID")
	private long Id;
	
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

	@Version
	@Column(name = "version")
	private Integer version;

	@OneToMany(mappedBy = "user")
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

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
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

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}
}
