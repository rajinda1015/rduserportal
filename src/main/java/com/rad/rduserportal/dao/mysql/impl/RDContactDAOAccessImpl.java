package com.rad.rduserportal.dao.mysql.impl;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.rad.rduserportal.dao.entity.RDContact;
import com.rad.rduserportal.dao.entity.RDXContactType;
import com.rad.rduserportal.dao.mysql.RDContactDAOAccess;

@Repository
public class RDContactDAOAccessImpl implements RDContactDAOAccess {

	@Value("${spring.jpa.properties.hibernate.jdbc.batch_size}")
	private int BATCH_SIZE;
	
	@Autowired
	private EntityManager entityManager;

	@Override
	public ConcurrentHashMap<Integer, RDXContactType> loadContactMasterDetails() throws Exception {
		ConcurrentHashMap<Integer, RDXContactType> masterDetails = new ConcurrentHashMap<Integer, RDXContactType>();
		
		StringBuffer sql = new StringBuffer("SELECT conTypes FROM RDXContactType conTypes");
		Query query = entityManager.createQuery(sql.toString());
		List<RDXContactType> contactTypes = query.getResultList();
		for (RDXContactType rdxContactType : contactTypes) {
			masterDetails.put(rdxContactType.getTypeDid(), rdxContactType);
		}
		
		return masterDetails;
	}

	@Override
	public List<RDContact> getContactDetails(List<Long> contactDids) throws Exception {
		Query query = entityManager
						.createQuery("SELECT contact FROM RDContact contact WHERE contact.contactDid IN (:did)", RDContact.class)
						.setParameter("did",contactDids);
		List<RDContact> contacts = query.getResultList();
		return contacts;
		
	}
	@Override
	public void addContactDetails(List<RDContact> contacts) throws Exception {
		contacts.forEach(contact -> {
			/*
			if (i > 0 && i % BATCH_SIZE == 0) {
				entityManager.flush();
				entityManager.clear();
			}
			++i;
			*/
			entityManager.persist(contact);
		});
	}
	
	@Override
	public void updateContactDetails(List<RDContact> contacts) throws Exception {
		contacts.forEach(persistUnit -> {
			entityManager.merge(persistUnit);
		});
	}

}
