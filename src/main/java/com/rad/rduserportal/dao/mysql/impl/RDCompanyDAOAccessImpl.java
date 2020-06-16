package com.rad.rduserportal.dao.mysql.impl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.rad.rduserportal.dao.mysql.RDCompanyDAOAccess;

@Transactional
@Repository
public class RDCompanyDAOAccessImpl implements RDCompanyDAOAccess {

	@Override
	public String getCompany(long companyDid) throws Exception {
		return "Test company";
	}

}
