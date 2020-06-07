package com.rad.rduserportal.service;

import com.rad.rduserportal.dao.entity.RDUser;

public interface RDPortalService {

	public RDUser getUser(long userDid) throws Exception;
	public void addUser(RDUser user) throws Exception;
	public void updateUser(RDUser user) throws Exception;
}
