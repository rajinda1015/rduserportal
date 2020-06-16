package com.rad.rduserportal.dto;

import java.io.Serializable;

public class RDLoginDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long userDid;
	private String username;
	private String password;
	private String confimPwd;

	public Long getUserDid() {
		return userDid;
	}

	public void setUserDid(Long userDid) {
		this.userDid = userDid;
	}

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
