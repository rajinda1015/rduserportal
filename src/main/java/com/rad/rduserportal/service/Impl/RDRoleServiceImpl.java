package com.rad.rduserportal.service.Impl;

import java.util.Date;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rad.rduserportal.dao.RDDAOProxy;
import com.rad.rduserportal.dao.entity.RDRole;
import com.rad.rduserportal.dao.entity.RDUser;
import com.rad.rduserportal.dao.entity.RDUserRole;
import com.rad.rduserportal.dto.RDUserRoleIdDTO;
import com.rad.rduserportal.service.RDPortalService;
import com.rad.rduserportal.service.RDRoleService;

@Service
public class RDRoleServiceImpl implements RDRoleService {

	@Autowired
	private RDPortalService rdPortalService;
	
	@Autowired
	private RDRoleService rDRoleService;
	
	@Autowired
	private RDDAOProxy rDDAOProxy;

	@Override
	public RDRole getRole(long roleDid) throws Exception {
		return rDDAOProxy.getDAOFacory().getRDRoleDAOAccess().getRole(roleDid);
	}

	@Transactional(value = TxType.REQUIRED)
	@Override
	public boolean addUserRole(RDUserRoleIdDTO userRoleDTO) throws Exception {
		RDRole role = rDRoleService.getRole(userRoleDTO.getRoleDid());
		RDUser user = rdPortalService.getUser(userRoleDTO.getUserDid());
		RDUserRole userRole = new RDUserRole(user, role, new Date());
		rDDAOProxy.getDAOFacory().getRDRoleDAOAccess().addUserRole(userRole);
		return true;
	}

	@Transactional(value = TxType.REQUIRED)
	@Override
	public boolean revokeUserRole(RDUserRoleIdDTO userRoleDTO) throws Exception {
		RDUser user = rdPortalService.getUser(userRoleDTO.getUserDid());
		RDRole role = rDRoleService.getRole(userRoleDTO.getRoleDid());
		user.removeRole(role);
		rDDAOProxy.getDAOFacory().getRDUserDAOAccess().updateUser(user);
		return true;
	}

}
