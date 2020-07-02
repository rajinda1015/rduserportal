package com.rad.rduserportal.dto;

import java.util.List;

public class RDUserDTO extends RDAbstractDTO {

	private String firstName;
	private char gender;
	private String lastName;
	private String middleName;
	private List<RDRoleDTO> userRoles;

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

	public List<RDRoleDTO> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(List<RDRoleDTO> userRoles) {
		this.userRoles = userRoles;
	}

}
