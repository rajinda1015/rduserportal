package com.rad.rduserportal.dao.mysql;

import com.rad.rduserportal.dao.entity.RDRole;
import com.rad.rduserportal.dao.entity.RDUserRole;

public interface RDRoleDAOAccess {

	public RDRole getRole(long roleDid) throws Exception;
	public void addUserRole(RDUserRole userRole) throws Exception;
}
