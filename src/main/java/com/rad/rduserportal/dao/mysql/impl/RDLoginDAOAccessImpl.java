package com.rad.rduserportal.dao.mysql.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rad.rduserportal.dao.entity.RDLogin;
import com.rad.rduserportal.dao.mysql.RDLoginDAOAccess;
import com.rad.rduserportal.dto.RDSearchDTO;

@Repository
public class RDLoginDAOAccessImpl implements RDLoginDAOAccess {

	@Autowired
	private EntityManager entityManager;

	@Override
	public RDLogin getLoginAccount(RDSearchDTO searchDTO) throws Exception {
		StringBuffer sql = new StringBuffer("SELECT login FROM RDLogin login WHERE ");
		StringBuffer where = new StringBuffer();
		
		if (null != searchDTO.getUserDid()) {
			where.append("login.userDid = :userDid");
		}
		
		if (null != searchDTO.getUserName() && !searchDTO.getUserName().trim().isEmpty()) {
			if (where.length() > 0) {
				where.append(" AND ");
			}
			where.append(" login.username = :username ");
		}
		
		Query query = entityManager.createQuery(sql.append(where).toString());
		
		if (null != searchDTO.getUserDid()) { query.setParameter("userDid", searchDTO.getUserDid()); }
		if (null != searchDTO.getUserName()) { query.setParameter("username", searchDTO.getUserName()); }
		
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
