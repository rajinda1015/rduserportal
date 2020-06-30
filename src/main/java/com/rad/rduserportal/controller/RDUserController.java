package com.rad.rduserportal.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rad.rduserportal.dto.RDContactDTO;
import com.rad.rduserportal.service.RDContactService;

@RestController
@RequestMapping(value = "/userportal/user")
public class RDUserController {

	private static final Logger LOGGER = LogManager.getLogger(RDUserController.class);
	
	@Autowired
	private RDContactService rDContactService;
	
	@RequestMapping(value = "/addContactDetails", method = RequestMethod.POST)
	public List<String> addContactDetails(
			@RequestParam Map<String, String> paramMap,
			@RequestBody RDContactDTO[] contacts) throws Exception {
		LOGGER.info("USERPORTAL : Add contact details by " + paramMap.get("username"));
		List<String> messages = new ArrayList<String>();
		
		try {
			List<RDContactDTO> conList = new ArrayList<RDContactDTO>();
			Collections.addAll(conList, contacts);
			boolean result = rDContactService.addContactDetails(conList);
			
			if (result) {
				messages.add("Contacts were successfully added");
			} else {
				messages.add("Cannot insert contacts details");
			}
			
		} catch (Exception e) {
			messages.add("Cannot add contact details. Error : " + e.getLocalizedMessage());
		}
		
		return messages;
	}
	
	@RequestMapping(value = "/updateContactDetails", method = RequestMethod.PUT)
	public List<String> updateContactDetails(
			@RequestParam Map<String, String> paramMap,
			@RequestBody RDContactDTO[] contacts) throws Exception {
		LOGGER.info("USERPORTAL : Update contact details by " + paramMap.get("username"));
		List<String> messages = new ArrayList<String>();
		
		try {
			List<RDContactDTO> conList = new ArrayList<RDContactDTO>();
			Collections.addAll(conList, contacts);
			boolean result = rDContactService.updateContactDetails(conList);
			
			if (result) {
				messages.add("Contacts were successfully updated");
			} else {
				messages.add("Cannot update contacts details");
			}
			
		} catch (Exception e) {
			messages.add("Cannot update contact details. Error : " + e.getLocalizedMessage());
		}
		
		return messages;
	}

	@RequestMapping(value = "/deleteContactDetails", method = RequestMethod.DELETE)
	public List<String> deleteContactDetails(
			@RequestParam Map<String, String> paramMap,
			@RequestBody Long[] dids) throws Exception {
		LOGGER.info("USERPORTAL : Delete contact details by " + paramMap.get("username"));
		List<String> messages = new ArrayList<String>();
		
		try {
			List<Long> didList = new ArrayList<Long>();
			Collections.addAll(didList, dids);
			boolean result = rDContactService.deleteContactDetails(didList);
			
			if (result) {
				messages.add("Contacts were successfully deleted");
			} else {
				messages.add("Cannot delete contacts details");
			}
			
		} catch (Exception e) {
			messages.add("Cannot delete contact details. Error : " + e.getLocalizedMessage());
		}
		
		return messages;
	}
}
