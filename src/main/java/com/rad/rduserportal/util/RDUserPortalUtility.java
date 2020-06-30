package com.rad.rduserportal.util;

import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rad.rduserportal.dao.entity.RDXContactType;
import com.rad.rduserportal.service.RDContactService;

@Component
public class RDUserPortalUtility {

	ConcurrentHashMap<Integer, RDXContactType> contactTypesMasterDetails = null;
	
	@Autowired
	private RDContactService rDContactService;
	
	public ConcurrentHashMap<Integer, RDXContactType> loadContactMasterDetails() throws Exception {
		if (null == contactTypesMasterDetails) {
			contactTypesMasterDetails = rDContactService.loadContactMasterDetails();
		}
		return contactTypesMasterDetails;
	}
}
