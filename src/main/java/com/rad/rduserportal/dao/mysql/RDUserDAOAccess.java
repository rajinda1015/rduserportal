package com.rad.rduserportal.dao.mysql;

import com.rad.rduserportal.dao.entity.RDUser;

public interface RDUserDAOAccess {

	public RDUser getUser(long userDid) throws Exception;
	public void addUser(RDUser user) throws Exception;
	public void updateUser(RDUser user) throws Exception;
}
