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

import com.rad.rduserportal.dao.entity.RDRole;
import com.rad.rduserportal.dao.entity.RDUser;
import com.rad.rduserportal.dao.entity.RDUserRole;
import com.rad.rduserportal.dto.RDUserDTO;
import com.rad.rduserportal.dto.RDUserRoleIdDTO;
import com.rad.rduserportal.service.RDPortalService;
import com.rad.rduserportal.service.RDRoleService;

@RestController
@RefreshScope
@RequestMapping("/userportal/admin")
public class RDAdminControl {

	private static final Logger LOGGER = LogManager.getLogger(RDAdminControl.class);
	
	@Autowired
	private RDPortalService rdPortalService;
	
	@Autowired
	private RDRoleService rDRoleService;
	
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public List<String> addUser(
			@RequestParam Map<String, String> paramMap,
			@RequestBody RDUserDTO userDTO) {
		
		LOGGER.info("USERPORTAL : Add new user instance by " + paramMap.get("username"));
		List<String> messages = new ArrayList<String>();

		try {
			RDUser user = mapUserByDTO(userDTO, new RDUser());
			rdPortalService.addUser(user);
			messages.add("User instance was successfully added");
			
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
			messages.add("User instance was successfully updated");

		} catch (Exception e) {
			messages.add("Cannot updateuser instance. Error : " + e.getLocalizedMessage());
		}
		
		return messages;
	}
	
	@RequestMapping(value = "/addRolesToUser", method = RequestMethod.POST)
	public List<String> addRolesToUser(
			@RequestParam Map<String, String> paramMap,
			@RequestBody RDUserRoleIdDTO userRoleDTO) {
		
		LOGGER.info("USERPORTAL : Add role to user : " + userRoleDTO.getUserDid() + " by " + paramMap.get("username"));
		List<String> messages = new ArrayList<String>();
		
		try {
			RDRole role = rDRoleService.getRole(userRoleDTO.getRoleDid());
			RDUser user = rdPortalService.getUser(userRoleDTO.getUserDid());
			RDUserRole userRole = new RDUserRole(user, role, new Date());
			rDRoleService.addUserRole(userRole);
			messages.add("User roles were successfully added");
			
		} catch (Exception e) {
			messages.add("Cannot insert roles to user. Error : " + e.getLocalizedMessage());
		}
		
		return messages;
	}
	
	@RequestMapping(value = "/revokeRolesFromUser")
	public List<String> revokeRolesFromUser(
			@RequestParam Map<String, String> paramMap,
			@RequestBody RDUserRoleIdDTO userRoleDTO) {
		
		LOGGER.info("USERPORTAL : Revoke role from user : " + userRoleDTO.getUserDid() + " by " + paramMap.get("username"));
		List<String> messages = new ArrayList<String>();
		
		try {
			RDUser user = rdPortalService.getUser(userRoleDTO.getUserDid());
			RDRole role = rDRoleService.getRole(userRoleDTO.getRoleDid());
			user.removeRole(role);
			rdPortalService.updateUser(user);
			messages.add("User role was successfully deleted");

		} catch (Exception e) {
			messages.add("Cannot revoke roles from user. Error : " + e.getLocalizedMessage());
		}
		
		return messages;
	}
	
	private RDUser mapUserByDTO(RDUserDTO userDTO, RDUser persistUser) throws Exception {
		
		if (userDTO.getUserDid() > 0) { 
			persistUser.setId(userDTO.getUserDid());
			persistUser.setUpdateDate(new Date());			
		} else {
			persistUser.setCreateDate(new Date());
			persistUser.setStatus(1);
		}
		persistUser.setFirstName(userDTO.getFirstName());
		persistUser.setMiddleName(userDTO.getMiddleName());
		persistUser.setLastName(userDTO.getLastName());
		persistUser.setGender(userDTO.getGender());
		persistUser.setStatus(userDTO.getStatus());
		
		return persistUser;
	}
}
