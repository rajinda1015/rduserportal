package com.rad.rduserportal.dao.mysql;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import com.rad.rduserportal.dao.entity.RDContact;
import com.rad.rduserportal.dao.entity.RDXContactType;

public interface RDContactDAOAccess {

	public ConcurrentHashMap<Integer, RDXContactType> loadContactMasterDetails() throws Exception;
	public List<RDContact> getContactDetails(List<Long> contactDids) throws Exception;
	public void addContactDetails(List<RDContact> contacts) throws Exception;
	public void updateContactDetails(List<RDContact> contacts) throws Exception;
	public void deleteContactDetails(List<Long> dids) throws Exception;
}
