package com.rad.rduserportal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rad.rduserportal.dao.RDDAOProxy;
import com.rad.rduserportal.dao.entity.RDUser;

@Service
public class RDPortalServiceImpl implements RDPortalService {

	@Autowired
	private RDDAOProxy rDDAOProxy;

	@Override
	public RDUser getUser(long userDid) throws Exception {
		return rDDAOProxy.getDAOFacory().getRDUserDAOAccess().getUser(userDid);
	}
	
	@Override
	public void addUser(RDUser user) throws Exception {
		rDDAOProxy.getDAOFacory().getRDUserDAOAccess().addUser(user);
	}
	
	@Override
	public void updateUser(RDUser user) throws Exception {
		rDDAOProxy.getDAOFacory().getRDUserDAOAccess().updateUser(user);
	}
}
