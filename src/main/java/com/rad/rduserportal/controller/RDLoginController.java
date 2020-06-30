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
import com.rad.rduserportal.service.RDLoginService;

@RestController
@RefreshScope
@RequestMapping("/userportal/user")
public class RDLoginController {

	private static final Logger LOGGER = LogManager.getLogger(RDLoginController.class);

	@Autowired
	private RDLoginService rDLoginService;

	@RequestMapping(value = "/updateLastLogin", method = RequestMethod.PUT)
	public List<String> updateLastLogin(
			@RequestParam Map<String, String> paramMap,
			@RequestBody RDLoginDTO loginDTO) {
		
		LOGGER.info("USERPORTAL : Update last login of " + loginDTO.getUsername() + " by " + paramMap.get("username"));
		List<String> messages = new ArrayList<String>();
		
		try {
			boolean result = rDLoginService.updateLastLoginDatetoCurrentDate(loginDTO);
			if (result) {
				messages.add("Last login time is updated for : " + loginDTO.getUsername());

			} else {
				messages.add("Account does not exist");
			}

		} catch (Exception e) {
			messages.add("Cannot update last login time. Error : " + e.getLocalizedMessage());
		}
		
		return messages;
	}

	@RequestMapping(value = "/createLoginAccountByAdmin", method = RequestMethod.POST)
	public List<String> createLoginAccountByAdmin(
			@RequestParam Map<String, String> paramMap,
			@RequestBody RDLoginDTO loginDTO) {
		
		LOGGER.info("USERPORTAL : Create login account to " + loginDTO.getUsername() + " by " + paramMap.get("username"));
		List<String> messages = new ArrayList<String>();
		
		try {
			boolean result = rDLoginService.createLoginAccount(loginDTO);;
			if (result) {
				messages.add("Login account was successfully created");

			} else {
				messages.add("You are not allowed to proceed with this credentials. Please try with different username and password");				
			}
			
			return messages;

		} catch (Exception e) {
			messages.add("Cannot create login account. Error : " + e.getLocalizedMessage());
		}
		
		return messages;
	}
	
}
