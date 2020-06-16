package com.rad.rduserportal.service;

import com.rad.rduserportal.dao.entity.RDRole;
import com.rad.rduserportal.dao.entity.RDUserRole;

public interface RDRoleService {

	public RDRole getRole(long roleDid) throws Exception;
	public void addUserRole(RDUserRole userRole) throws Exception;
	public void revokeUserRole(RDUserRole userRole) throws Exception;
}
