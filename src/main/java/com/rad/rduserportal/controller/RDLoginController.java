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

import com.rad.rduserportal.dao.entity.RDLogin;
import com.rad.rduserportal.dto.RDLoginDTO;
import com.rad.rduserportal.service.RDLoginService;
import com.rad.rduserportal.util.RDUserPortalConstants;

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
			@RequestBody RDLoginDTO loginAccount) {
		
		LOGGER.info("USERPORTAL : Update last login of " + loginAccount.getUsername() + " by " + paramMap.get("username"));
		List<String> messages = new ArrayList<String>();
		
		try {
			RDLogin logAccount = rDLoginService.getLoginAccountByUsername(loginAccount.getUsername());
			if (null != logAccount) {
				logAccount.setLastLogin(new Date());
				rDLoginService.updateLoginAccount(logAccount);
				messages.add("Last login time is updated for : " + logAccount.getUserDid());

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
			@RequestBody RDLoginDTO loginAccount) {
		
		LOGGER.info("USERPORTAL : Create login account to " + loginAccount.getUsername() + " by " + paramMap.get("username"));
		List<String> messages = new ArrayList<String>();
		
		try {
			RDLogin logAccount = rDLoginService.getLoginAccountByUsername(loginAccount.getUsername());
			if (null != logAccount) {
				messages.add("You are not allowed to proceed with this credentials. Please try with different username and password");

			} else {
				logAccount = new RDLogin();
				logAccount.setUserDid(loginAccount.getUserDid());
				logAccount.setUsername(loginAccount.getUsername());
				logAccount.setPassword(loginAccount.getPassword());
				logAccount.setCreateDate(new Date());
				logAccount.setStatus(RDUserPortalConstants.ACTIVE);
				
				rDLoginService.createLoginAccount(logAccount);
				messages.add("Login account was successfully created");
			}
			
			return messages;

		} catch (Exception e) {
			messages.add("Cannot create login account. Error : " + e.getLocalizedMessage());
		}
		
		return messages;
	}
	
}
