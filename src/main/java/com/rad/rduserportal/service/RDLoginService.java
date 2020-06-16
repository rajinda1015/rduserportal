package com.rad.rduserportal.service;

import com.rad.rduserportal.dao.entity.RDLogin;

public interface RDLoginService {

	public RDLogin getLoginAccountByUsername(String username) throws Exception;
	public void updateLoginAccount(RDLogin loginAccount) throws Exception;
	public void createLoginAccount(RDLogin loginAccount) throws Exception;
}
