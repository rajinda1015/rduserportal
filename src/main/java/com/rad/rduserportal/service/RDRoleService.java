package com.rad.rduserportal.service;

import com.rad.rduserportal.dao.entity.RDRole;
import com.rad.rduserportal.dto.RDUserRoleIdDTO;

public interface RDRoleService {

	public RDRole getRole(long roleDid) throws Exception;
	public boolean addUserRole(RDUserRoleIdDTO userRoleDTO) throws Exception;
	public boolean revokeUserRole(RDUserRoleIdDTO userRoleDTO) throws Exception;
}
