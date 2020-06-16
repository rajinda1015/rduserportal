package com.rad.rduserportal.service.Impl;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rad.rduserportal.dao.RDDAOProxy;
import com.rad.rduserportal.dao.entity.RDRole;
import com.rad.rduserportal.dao.entity.RDUserRole;
import com.rad.rduserportal.service.RDRoleService;

@Component
public class RDRoleServiceImpl implements RDRoleService {

	@Autowired
	private RDDAOProxy rDDAOProxy;

	@Override
	public RDRole getRole(long roleDid) throws Exception {
		return rDDAOProxy.getDAOFacory().getRDRoleDAOAccess().getRole(roleDid);
	}

	@Transactional(value = TxType.REQUIRED)
	@Override
	public void addUserRole(RDUserRole userRole) throws Exception {
		rDDAOProxy.getDAOFacory().getRDRoleDAOAccess().addUserRole(userRole);
	}

	@Transactional(value = TxType.REQUIRED)
	@Override
	public void revokeUserRole(RDUserRole userRole) throws Exception {
		rDDAOProxy.getDAOFacory().getRDRoleDAOAccess().revokeUserRole(userRole);
	}

}
