package com.rad.rduserportal.service.Impl;

import java.util.Date;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rad.rduserportal.dao.RDDAOProxy;
import com.rad.rduserportal.dao.entity.RDUser;
import com.rad.rduserportal.dto.RDUserDTO;
import com.rad.rduserportal.service.RDPortalService;
import com.rad.rduserportal.util.RDUserPortalConstants;

@Service
public class RDPortalServiceImpl implements RDPortalService {

	@Autowired
	private RDDAOProxy rDDAOProxy;

	@Override
	public RDUser getUser(long userDid) throws Exception {
		return rDDAOProxy.getDAOFacory().getRDUserDAOAccess().getUser(userDid);
	}
	
	@Transactional(value = TxType.REQUIRED)
	@Override
	public boolean addUser(RDUserDTO userDTO) throws Exception {
		RDUser user = mapUserByDTO(userDTO, new RDUser());
		rDDAOProxy.getDAOFacory().getRDUserDAOAccess().addUser(user);
		userDTO.setDid(user.getId());
		return true;
	}
	
	@Transactional(value = TxType.REQUIRED)
	@Override
	public boolean updateUser(RDUserDTO userDTO) throws Exception {
		RDUser persistUser = rDDAOProxy.getDAOFacory().getRDUserDAOAccess().getUser(userDTO.getDid());
		if (null != persistUser) {
			mapUserByDTO(userDTO, persistUser);
			rDDAOProxy.getDAOFacory().getRDUserDAOAccess().updateUser(persistUser);
			return true;
		}
		return false;
	}
	
	private RDUser mapUserByDTO(RDUserDTO userDTO, RDUser persistUser) throws Exception {
		
		if (null != userDTO.getDid() && userDTO.getDid() > 0) { 
			persistUser.setId(userDTO.getDid());
			persistUser.setUpdateDate(new Date());
			persistUser.setStatus(userDTO.getStatus());
		} else {
			persistUser.setCreateDate(new Date());
			persistUser.setStatus(RDUserPortalConstants.ACTIVE);
		}
		persistUser.setFirstName(userDTO.getFirstName());
		persistUser.setMiddleName(userDTO.getMiddleName());
		persistUser.setLastName(userDTO.getLastName());
		persistUser.setGender(userDTO.getGender());
		
		return persistUser;
	}
}
