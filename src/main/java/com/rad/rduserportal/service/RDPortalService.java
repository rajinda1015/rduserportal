package com.rad.rduserportal.service;

import com.rad.rduserportal.dao.entity.RDUser;
import com.rad.rduserportal.dto.RDUserDTO;

public interface RDPortalService {

	public RDUser getUser(long userDid) throws Exception;
	public boolean addUser(RDUserDTO RDUserDTO) throws Exception;
	public boolean updateUser(RDUserDTO RDUserDTO) throws Exception;
}
