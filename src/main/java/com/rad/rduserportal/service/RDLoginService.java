package com.rad.rduserportal.service;

import com.rad.rduserportal.dao.entity.RDLogin;
import com.rad.rduserportal.dto.RDLoginDTO;
import com.rad.rduserportal.dto.RDSearchDTO;

public interface RDLoginService {

	public RDLogin getLoginAccount(RDSearchDTO searchDTO) throws Exception;
	public boolean updateLastLoginDatetoCurrentDate(RDLoginDTO loginDTO) throws Exception;
	public boolean updateLoginAccountStatus(RDLoginDTO loginDTO) throws Exception;
	public boolean createLoginAccount(RDLoginDTO loginDTO) throws Exception;
	public boolean registerUser(RDLoginDTO loginDTO) throws Exception;
}
