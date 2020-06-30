package com.rad.rduserportal.dao.mysql.impl;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rad.rduserportal.dao.entity.RDRole;
import com.rad.rduserportal.dao.entity.RDUserRole;
import com.rad.rduserportal.dao.mysql.RDRoleDAOAccess;

@Repository
public class RDRoleDAOAccessImpl implements RDRoleDAOAccess {

	@Autowired
	private EntityManager entityManager;

	@Override
	public RDRole getRole(long roleDid) throws Exception {
		return entityManager.find(RDRole.class, roleDid);
	}

	@Override
	public void addUserRole(RDUserRole userRole) throws Exception {
		entityManager.persist(userRole);
	}
	
}
