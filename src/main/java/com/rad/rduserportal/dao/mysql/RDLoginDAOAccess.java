package com.rad.rduserportal.dao.mysql;

import com.rad.rduserportal.dao.entity.RDLogin;
import com.rad.rduserportal.dto.RDSearchDTO;

public interface RDLoginDAOAccess {

	public RDLogin getLoginAccount(RDSearchDTO searchDTO) throws Exception;
	public void updateLoginAccount(RDLogin loginAccount) throws Exception;
	public void createLoginAccount(RDLogin loginAccount) throws Exception;
}
