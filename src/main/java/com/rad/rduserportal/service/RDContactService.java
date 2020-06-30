package com.rad.rduserportal.service;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import com.rad.rduserportal.dao.entity.RDXContactType;
import com.rad.rduserportal.dto.RDContactDTO;

public interface RDContactService {

	public ConcurrentHashMap<Integer, RDXContactType> loadContactMasterDetails() throws Exception;
	public boolean addContactDetails(List<RDContactDTO> contacts) throws Exception;
	public boolean updateContactDetails(List<RDContactDTO> contacts) throws Exception;
}
