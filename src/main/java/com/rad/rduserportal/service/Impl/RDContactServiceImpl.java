package com.rad.rduserportal.service.Impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rad.rduserportal.dao.RDDAOProxy;
import com.rad.rduserportal.dao.entity.RDContact;
import com.rad.rduserportal.dao.entity.RDXContactType;
import com.rad.rduserportal.dto.RDContactDTO;
import com.rad.rduserportal.service.RDContactService;
import com.rad.rduserportal.util.RDUserPortalConstants;
import com.rad.rduserportal.util.RDUserPortalUtility;

@Service
public class RDContactServiceImpl implements RDContactService {
	
	@Autowired
	private RDUserPortalUtility rDUserPortalUtility;

	@Autowired
	private RDDAOProxy rDDAOProxy;

	@Override
	public ConcurrentHashMap<Integer, RDXContactType> loadContactMasterDetails() throws Exception {
		return rDDAOProxy.getDAOFacory().getRDContactDAOAccess().loadContactMasterDetails();
	}

	@Transactional(value = TxType.REQUIRED)
	@Override
	public boolean addContactDetails(List<RDContactDTO> contacts) throws Exception {
		List<RDContact> persistList = mapContactDetails(contacts, new ArrayList<RDContact>());
		rDDAOProxy.getDAOFacory().getRDContactDAOAccess().addContactDetails(persistList);
		return true;
	}
	
	@Transactional(value = TxType.REQUIRED)
	public boolean updateContactDetails(List<RDContactDTO> contacts) throws Exception {
		List<Long> dids = new ArrayList<Long>();
		contacts.forEach(contact -> {
			dids.add(contact.getDid());
		});
		List<RDContact> persistList = rDDAOProxy.getDAOFacory().getRDContactDAOAccess().getContactDetails(dids);
		persistList = mapContactDetails(contacts, persistList);
		rDDAOProxy.getDAOFacory().getRDContactDAOAccess().updateContactDetails(persistList);
		return true;
	}

	@Transactional(value = TxType.REQUIRED)
	public boolean deleteContactDetails(List<Long> dids) throws Exception {
		rDDAOProxy.getDAOFacory().getRDContactDAOAccess().deleteContactDetails(dids);
		return true;
	}

	private List<RDContact> mapContactDetails(List<RDContactDTO> contacts, List<RDContact> persistList) throws Exception {
		
		final Map<Long, RDContact> persistMap = new HashMap<Long, RDContact>();
		if (null != persistList && persistList.size() > 0) {
			persistMap.putAll(persistList.stream().collect(Collectors.toMap(RDContact::getContactDid, contact -> contact)));
		}

		contacts.forEach(cont -> {
			RDContact persistContact = null;
			
			if (!persistMap.isEmpty()) {
				persistContact = persistMap.get(cont.getDid());
				persistContact.setStatus(cont.getStatus());
				persistContact.setUpdateDate(new Date());
			} else {
				persistContact = new RDContact();
				persistContact.setUserDid(cont.getUserDid());
				persistContact.setStatus(RDUserPortalConstants.ACTIVE);
				persistContact.setCreateDate(new Date());
			}

			persistContact.setContactValue(cont.getValue());
			persistContact.setIsDefault(cont.getDefaultValue());
			
			if (null == persistContact.getContactType() ||
					(null != persistContact.getContactType() && !persistContact.getContactType().getTypeDid().equals(cont.getType()))) {
				RDXContactType conType;
				try {
					conType = rDUserPortalUtility.loadContactMasterDetails().get(cont.getType());
					persistContact.setContactType(conType);
				} catch (Exception e) {
					persistContact.setContactType(null);
				}
			}
			persistList.add(persistContact);
		});
		
		return persistList;
	}

}
