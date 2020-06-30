package com.rad.rduserportal.service.Impl;

import java.util.Date;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rad.rduserportal.dao.RDDAOProxy;
import com.rad.rduserportal.dao.entity.RDLogin;
import com.rad.rduserportal.dto.RDLoginDTO;
import com.rad.rduserportal.dto.RDSearchDTO;
import com.rad.rduserportal.service.RDLoginService;
import com.rad.rduserportal.service.RDPortalService;
import com.rad.rduserportal.util.RDUserPortalConstants;

@Service
public class RDLoginServiceImpl implements RDLoginService {

	@Autowired
	private RDDAOProxy rDDAOProxy;
	
	@Autowired
	private RDPortalService rDPortalService;

	@Override
	public RDLogin getLoginAccount(RDSearchDTO searchDTO) throws Exception {
		return rDDAOProxy.getDAOFacory().getRDLoginDAOAccess().getLoginAccount(searchDTO);
	}

	@Transactional(value = TxType.REQUIRED)
	public boolean updateLastLoginDatetoCurrentDate(RDLoginDTO loginDTO) throws Exception {
		RDSearchDTO searchDTO = new RDSearchDTO();
		searchDTO.setUserName(loginDTO.getUsername());
		RDLogin loginAccount = rDDAOProxy.getDAOFacory().getRDLoginDAOAccess().getLoginAccount(searchDTO);
		
		if (null != loginAccount) {
			loginAccount.setLastLogin(new Date());
			rDDAOProxy.getDAOFacory().getRDLoginDAOAccess().updateLoginAccount(loginAccount);
			return true;
		}
		return false;
	}

	@Transactional(value = TxType.REQUIRED)
	@Override
	public boolean updateLoginAccountStatus(RDLoginDTO loginDTO) throws Exception {
		RDSearchDTO searchDTO = new RDSearchDTO();
		searchDTO.setUserDid(loginDTO.getUserDid());
		
		RDLogin loginAccount = rDDAOProxy.getDAOFacory().getRDLoginDAOAccess().getLoginAccount(searchDTO);
		if (null != loginAccount) {
			loginAccount.setStatus(loginDTO.getStatus());
			loginAccount.setUpdateDate(new Date());
			rDDAOProxy.getDAOFacory().getRDLoginDAOAccess().updateLoginAccount(loginAccount);
			return true;
		}
		return false;
	}

	@Transactional(value = TxType.REQUIRED)
	@Override
	public boolean createLoginAccount(RDLoginDTO loginDTO) throws Exception {
		RDSearchDTO searchDTO = new RDSearchDTO();
		if (null != loginDTO.getUserDid() && loginDTO.getUserDid() > 0) {
			searchDTO.setUserDid(loginDTO.getUserDid());
		} else if (null != loginDTO.getUsername() && !loginDTO.getUsername().trim().isEmpty()) {
			searchDTO.setUserName(loginDTO.getUsername());
		} else {
			return false;
		}
		RDLogin logAccount = rDDAOProxy.getDAOFacory().getRDLoginDAOAccess().getLoginAccount(searchDTO);
		
		if (null != logAccount) {
			return false;
		}
		
		logAccount = new RDLogin();
		logAccount.setUserDid(loginDTO.getUserDid());
		logAccount.setUsername(loginDTO.getUsername());
		logAccount.setPassword(loginDTO.getPassword());
		logAccount.setCreateDate(new Date());
		logAccount.setStatus(RDUserPortalConstants.ACTIVE);
		
		rDDAOProxy.getDAOFacory().getRDLoginDAOAccess().createLoginAccount(logAccount);
		return true;
	}

	@Transactional(value = TxType.REQUIRED)
	public boolean registerUser(RDLoginDTO loginDTO) throws Exception {
		
		rDPortalService.addUser(loginDTO);
		
		RDLogin loginAccount = new RDLogin();
		loginAccount.setUserDid(loginDTO.getUserDid());
		loginAccount.setUsername(loginDTO.getUsername());
		loginAccount.setPassword(loginDTO.getPassword());
		loginAccount.setCreateDate(new Date());
		loginAccount.setStatus(RDUserPortalConstants.ACTIVE);
		
		rDDAOProxy.getDAOFacory().getRDLoginDAOAccess().createLoginAccount(loginAccount);
		return true;
	}
}
