package com.rad.rduserportal.dao.mysql.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rad.rduserportal.dao.entity.RDLogin;
import com.rad.rduserportal.dao.mysql.RDLoginDAOAccess;

@Repository
public class RDLoginDAOAccessImpl implements RDLoginDAOAccess {

	@Autowired
	private EntityManager entityManager;

	@Override
	public RDLogin getLoginAccountByUsername(String username) throws Exception {
		Query query = entityManager.createQuery("SELECT login FROM RDLogin login WHERE login.username = :username");
		query.setParameter("username", username);
		List<RDLogin> results = query.getResultList();
		if (null != results && !results.isEmpty()) {
			return (RDLogin) results.get(0);
		} else {
			return null;
		}
	}

	@Override
	public void updateLoginAccount(RDLogin loginAccount) throws Exception {
		entityManager.merge(loginAccount);
	}

	@Override
	public void createLoginAccount(RDLogin loginAccount) throws Exception {
		entityManager.persist(loginAccount);
	}

}
