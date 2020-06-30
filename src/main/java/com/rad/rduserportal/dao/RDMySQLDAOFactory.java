package com.rad.rduserportal.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rad.rduserportal.dao.RDDAOFactory;
import com.rad.rduserportal.dao.mysql.RDCompanyDAOAccess;
import com.rad.rduserportal.dao.mysql.RDContactDAOAccess;
import com.rad.rduserportal.dao.mysql.RDLoginDAOAccess;
import com.rad.rduserportal.dao.mysql.RDRoleDAOAccess;
import com.rad.rduserportal.dao.mysql.RDUserDAOAccess;

@Component
public class RDMySQLDAOFactory extends RDDAOFactory {

	@Autowired
	private RDUserDAOAccess rDUserDAOAccess;
	
	@Autowired
	private RDCompanyDAOAccess rDCompanyDAOAccess;
	
	@Autowired
	private RDRoleDAOAccess rDRoleDAOAccess;
	
	@Autowired
	private RDLoginDAOAccess rDLoginDAOAccess;
	
	@Autowired
	private RDContactDAOAccess rDContactDAOAccess;
	
	@Override
	public RDUserDAOAccess getRDUserDAOAccess() {
		return rDUserDAOAccess;
	}
	
	@Override
	public RDCompanyDAOAccess getRDCompanyDAOAccess() {
		return rDCompanyDAOAccess;
	}
	
	@Override
	public RDRoleDAOAccess getRDRoleDAOAccess() {
		return rDRoleDAOAccess;
	}

	@Override
	public RDLoginDAOAccess getRDLoginDAOAccess() {
		return rDLoginDAOAccess;
	}

	@Override
	public RDContactDAOAccess getRDContactDAOAccess() {
		return rDContactDAOAccess;
	}
}
