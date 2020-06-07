package com.rad.rduserportal.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rad.rduserportal.dao.entity.RDUser;
import com.rad.rduserportal.dto.RDUserDTO;
import com.rad.rduserportal.service.RDPortalService;

@RestController
@RefreshScope
@RequestMapping("/userportal/admin")
public class RDAdminControl {

	private static final Logger LOGGER = LogManager.getLogger(RDAdminControl.class);
	
	@Autowired
	private RDPortalService rdPortalService;
	
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public List<String> addUser(
			@RequestParam Map<String, String> paramMap,
			@RequestBody RDUserDTO userDTO) {
		
		LOGGER.info("USERPORTAL : Add new user instance by " + paramMap.get("username"));
		List<String> messages = new ArrayList<String>();

		try {
			RDUser user = mapUserByDTO(userDTO, new RDUser());
			rdPortalService.addUser(user);
			messages.add("User instance is successfully added");
			
		} catch (Exception e) {
			messages.add("Cannot add user instance. Error : " + e.getLocalizedMessage());
		}
		
		return messages;
	}
	
	@RequestMapping(value = "/updateUser", method = RequestMethod.PUT)
	public List<String> updateUser(
			@RequestParam Map<String, String> paramMap,
			@RequestBody RDUserDTO userDTO) {
		
		LOGGER.info("USERPORTAL : Update userinstance by " + paramMap.get("username"));
		List<String> messages = new ArrayList<String>();
		
		try {
			RDUser persistUser = rdPortalService.getUser(userDTO.getUserDid());
			mapUserByDTO(userDTO, persistUser);
			rdPortalService.updateUser(persistUser);
			messages.add("User instance is successfully updated");

		} catch (Exception e) {
			messages.add("Cannot updateuser instance. Error : " + e.getLocalizedMessage());
		}
		
		return messages;
	}
	
	private RDUser mapUserByDTO(RDUserDTO userDTO, RDUser persistUser) throws Exception {
		
		if (userDTO.getUserDid() > 0) { persistUser.setId(userDTO.getUserDid()); }
		persistUser.setFirstName(userDTO.getFirstName());
		persistUser.setMiddleName(userDTO.getMiddleName());
		persistUser.setLastName(userDTO.getLastName());
		persistUser.setGender(userDTO.getGender());
		persistUser.setCreateDate(new Date());
		
		return persistUser;
	}
}
