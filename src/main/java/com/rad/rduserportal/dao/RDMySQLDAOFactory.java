package com.rad.rduserportal.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rad.rduserportal.dao.RDDAOFactory;
import com.rad.rduserportal.dao.mysql.RDCompanyDAOAccess;
import com.rad.rduserportal.dao.mysql.RDUserDAOAccess;

@Component
public class RDMySQLDAOFactory extends RDDAOFactory {

	@Autowired
	private RDUserDAOAccess rDUserDAOAccess;
	
	@Autowired
	private RDCompanyDAOAccess rDCompanyDAOAccess;
	
	@Override
	public RDUserDAOAccess getRDUserDAOAccess() {
		return rDUserDAOAccess;
	}
	
	@Override
	public RDCompanyDAOAccess getRDCompanyDAOAccess() {
		return rDCompanyDAOAccess;
	}
}