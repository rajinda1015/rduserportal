package com.rad.rduserportal.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class RDUserDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private long userDid;
	private String firstName;
	private char gender;
	private String lastName;
	private String middleName;
	private Date createDate;
	private int status;
	private List<RDRoleDTO> userRoles;

	public long getUserDid() {
		return userDid;
	}

	public void setUserDid(long userDid) {
		this.userDid = userDid;
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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public List<RDRoleDTO> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(List<RDRoleDTO> userRoles) {
		this.userRoles = userRoles;
	}

}
