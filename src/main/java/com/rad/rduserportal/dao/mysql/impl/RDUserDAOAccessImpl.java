package com.rad.rduserportal.dao.mysql.impl;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rad.rduserportal.dao.entity.RDUser;
import com.rad.rduserportal.dao.mysql.RDUserDAOAccess;

@Repository
public class RDUserDAOAccessImpl implements RDUserDAOAccess {

	@Autowired
	private EntityManager entityManager;

	@Override
	public RDUser getUser(long userDid) throws Exception {
		return entityManager.find(RDUser.class, userDid);
	}

	@Override
	public void addUser(RDUser user) throws Exception {
		entityManager.persist(user);
	}

	@Override
	public void updateUser(RDUser user) throws Exception {
		entityManager.merge(user);
	}

}
