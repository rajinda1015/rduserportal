package com.rad.rduserportal.dao.mysql;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Transactional
@Repository
public class RDCompanyDAOAccessImpl implements RDCompanyDAOAccess {

	@Override
	public String getCompany(long companyDid) throws Exception {
		return "Test company";
	}

}
