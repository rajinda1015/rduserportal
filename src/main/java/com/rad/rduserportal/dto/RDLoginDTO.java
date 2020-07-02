package com.rad.rduserportal.dto;


public class RDLoginDTO extends RDUserDTO {

	private String username;
	private String password;
	private String confimPwd;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfimPwd() {
		return confimPwd;
	}

	public void setConfimPwd(String confimPwd) {
		this.confimPwd = confimPwd;
	}
	
}
