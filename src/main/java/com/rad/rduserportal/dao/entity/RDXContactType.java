package com.rad.rduserportal.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RDX_CONTACT_TYPE")
public class RDXContactType {

	@Id
	@Column(name = "TYPE_DID")
	private Integer typeDid;
	
	@Column(name = "TYPE")
	private String value;
	
	@Column(name = "STATUS")
	private byte status;

	public Integer getTypeDid() {
		return typeDid;
	}

	public void setTypeDid(Integer typeDid) {
		this.typeDid = typeDid;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public byte getStatus() {
		return status;
	}

	public void setStatus(byte status) {
		this.status = status;
	}

}
