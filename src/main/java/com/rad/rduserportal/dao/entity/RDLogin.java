package com.rad.rduserportal.dao.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "RD_LOGIN")
public class RDLogin {

	@Id
	@Column(name = "USER_DID")
	private Long userDid;
	
	@Column(name = "LAST_LOGIN")
	private Date lastLogin;
	
	@Column(name = "PASSWORD")
	private String password;
	
	@Column(name = "STATUS")
	private byte status;
	
	@Column(name = "USERNAME")
	private String username;
	
	@Column(name = "CREATE_DATE")
	private Date createDate;
	
	@Version
	@Column(name = "VERSION")
	private Integer version;
	
	@Column(name = "UPDATE_DATE")
	private Date updateDate;

	public Long getUserDid() {
		return userDid;
	}

	public void setUserDid(Long userDid) {
		this.userDid = userDid;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public byte getStatus() {
		return status;
	}

	public void setStatus(byte status) {
		this.status = status;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

}
