package com.rad.rduserportal.dao.entity;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "RD_CONTACT")
public class RDContact {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CONTACT_DID")
	private Long contactDid;
	
	@Column(name = "USER_DID")
	private Long userDid;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "TYPE_DID", referencedColumnName = "TYPE_DID")
	private RDXContactType contactType;
	
	@Column(name="CONTACT_VALUE")
	private String contactValue;
	
	@Column(name="IS_DEFAILT")
	private byte isDefault;
	
	@Column(name="STATUS")
	private byte status;
	
	@Column(name="CREATE_DATE")
	private Date createDate;
	
	@Column(name="UPDATE_DATE")
	private Date updateDate;
	
	@Version
	@Column(name="VERSION")
	private Integer version;

	public Long getContactDid() {
		return contactDid;
	}

	public void setContactDid(Long contactDid) {
		this.contactDid = contactDid;
	}

	public Long getUserDid() {
		return userDid;
	}

	public void setUserDid(Long userDid) {
		this.userDid = userDid;
	}
	
	public RDXContactType getContactType() {
		return contactType;
	}

	public void setContactType(RDXContactType contactType) {
		this.contactType = contactType;
	}

	public String getContactValue() {
		return contactValue;
	}

	public void setContactValue(String contactValue) {
		this.contactValue = contactValue;
	}

	public byte getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(byte isDefault) {
		this.isDefault = isDefault;
	}

	public byte getStatus() {
		return status;
	}

	public void setStatus(byte status) {
		this.status = status;
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

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	@Override
	public int hashCode() {
		return Objects.hash(contactDid);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (null == obj) { return false; }
		if (!(obj instanceof RDContact)) { return false; }
		
		if (this == obj) { return true; }
		
		RDContact objCon = (RDContact) obj;
		return Objects.equals(contactDid, objCon.getContactDid());
	}
}
