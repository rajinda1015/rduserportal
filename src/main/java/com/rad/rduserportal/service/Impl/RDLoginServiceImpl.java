package com.rad.rduserportal.service.Impl;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rad.rduserportal.dao.RDDAOProxy;
import com.rad.rduserportal.dao.entity.RDLogin;
import com.rad.rduserportal.service.RDLoginService;

@Component
public class RDLoginServiceImpl implements RDLoginService {

	@Autowired
	private RDDAOProxy rDDAOProxy;

	@Override
	public RDLogin getLoginAccountByUsername(String username) throws Exception {
		return rDDAOProxy.getDAOFacory().getRDLoginDAOAccess().getLoginAccountByUsername(username);
	}

	@Transactional(value = TxType.REQUIRED)
	@Override
	public void updateLoginAccount(RDLogin loginAccount) throws Exception {
		rDDAOProxy.getDAOFacory().getRDLoginDAOAccess().updateLoginAccount(loginAccount);
	}

	@Transactional(value = TxType.REQUIRED)
	@Override
	public void createLoginAccount(RDLogin loginAccount) throws Exception {
		rDDAOProxy.getDAOFacory().getRDLoginDAOAccess().createLoginAccount(loginAccount);
	}

}
