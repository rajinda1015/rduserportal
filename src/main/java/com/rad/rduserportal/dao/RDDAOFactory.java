package com.rad.rduserportal.dao;

import com.rad.rduserportal.dao.mysql.RDCompanyDAOAccess;
import com.rad.rduserportal.dao.mysql.RDUserDAOAccess;

public abstract class RDDAOFactory {
	
	public abstract RDUserDAOAccess getRDUserDAOAccess();
	public abstract RDCompanyDAOAccess getRDCompanyDAOAccess();	
}