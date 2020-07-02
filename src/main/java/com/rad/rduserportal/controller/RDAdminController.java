package com.rad.rduserportal.controller;

import java.util.ArrayList;
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

import com.rad.rduserportal.dto.RDLoginDTO;
import com.rad.rduserportal.dto.RDUserDTO;
import com.rad.rduserportal.dto.RDUserRoleIdDTO;
import com.rad.rduserportal.service.RDLoginService;
import com.rad.rduserportal.service.RDPortalService;
import com.rad.rduserportal.service.RDRoleService;

@RestController
@RefreshScope
@RequestMapping("/userportal/admin")
public class RDAdminController {

	private static final Logger LOGGER = LogManager.getLogger(RDAdminController.class);
	
	@Autowired
	private RDPortalService rdPortalService;
	
	@Autowired
	private RDRoleService rDRoleService;
	
	@Autowired
	private RDLoginService rDLoginService;
	
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public List<String> addUser(
			@RequestParam Map<String, String> paramMap,
			@RequestBody RDUserDTO userDTO) {
		
		LOGGER.info("USERPORTAL : Add new user instance by " + paramMap.get("username"));
		List<String> messages = new ArrayList<String>();

		try {
			boolean result = rdPortalService.addUser(userDTO);
			
			if (result) {
				messages.add("User instance was successfully added");
			} else {
				messages.add("Cannot create user instance");
			}
			
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
			boolean result = rdPortalService.updateUser(userDTO);;
			if (result) {
				messages.add("User instance was successfully updated");
			} else {
				messages.add("Cannot update user instance");
			}

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
			boolean result = rDRoleService.addUserRole(userRoleDTO);
			if (result) {
				messages.add("User roles were successfully added");
			} else {
				messages.add("Cannot add user roles");
			}
			
		} catch (Exception e) {
			messages.add("Cannot insert roles to user. Error : " + e.getLocalizedMessage());
		}
		
		return messages;
	}
	
	@RequestMapping(value = "/revokeRolesFromUser", method = RequestMethod.DELETE)
	public List<String> revokeRolesFromUser(
			@RequestParam Map<String, String> paramMap,
			@RequestBody RDUserRoleIdDTO userRoleDTO) {
		
		LOGGER.info("USERPORTAL : Revoke role from user : " + userRoleDTO.getUserDid() + " by " + paramMap.get("username"));
		List<String> messages = new ArrayList<String>();
		
		try {
			boolean result = rDRoleService.revokeUserRole(userRoleDTO);;
			if (result) {
				messages.add("User role was successfully deleted");
			} else {
				messages.add("Cannot revoke user role");
			}

		} catch (Exception e) {
			messages.add("Cannot revoke roles from user. Error : " + e.getLocalizedMessage());
		}
		
		return messages;
	}
	
	@RequestMapping(value = "/loginAccountUpdateStatusByAdmin", method = RequestMethod.PUT)
	public List<String> loginAccountUpdateStatusByAdmin(
			@RequestParam Map<String, String> paramMap,
			@RequestBody RDLoginDTO loginDTO) {
		
		LOGGER.info("USERPORTAL : Update status of login account of: " + loginDTO.getDid() + " by " + paramMap.get("username"));
		List<String> messages = new ArrayList<String>();
		
		try {
			boolean result = rDLoginService.updateLoginAccountStatus(loginDTO);
			if (result) {
				messages.add("Login account was successfully updated");
			} else {
				messages.add("Canot update the status of Login account");
			}

		} catch (Exception e) {
			messages.add("Cannot update user account. Error : " + e.getLocalizedMessage());
		}
		
		return messages;
	}
}
