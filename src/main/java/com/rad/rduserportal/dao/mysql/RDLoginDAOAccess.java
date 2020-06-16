package com.rad.rduserportal.dao.mysql;

import com.rad.rduserportal.dao.entity.RDLogin;

public interface RDLoginDAOAccess {

	public RDLogin getLoginAccountByUsername(String username) throws Exception;
	public void updateLoginAccount(RDLogin loginAccount) throws Exception;
	public void createLoginAccount(RDLogin loginAccount) throws Exception;
}
