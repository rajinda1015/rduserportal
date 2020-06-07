package com.rad.rduserportal.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RDDAOProxy {

	@Value("${db.type}")
	private String dbType;

	@Autowired
	private RDMySQLDAOFactory rDMySQLDAOFactory;

	public RDDAOFactory getDAOFacory() {
		
		if ("mysql".equals(dbType)) {
			return rDMySQLDAOFactory;
		}
		
		return rDMySQLDAOFactory;
	}
}
