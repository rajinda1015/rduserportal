package com.rad.rduserportal.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/userportal")
public class RDUserController {

	private static final Logger LOGGER = LogManager.getLogger(RDUserController.class);

	@Autowired
	private ResourceServerTokenServices tokenService;
	
	@RequestMapping(value = "/findUsers", method = RequestMethod.GET)
	public List<String> findUsers(
			@RequestParam Map<String, String> paramMap) throws Exception {
		LOGGER.info("USERPORTAL : Find users by " + paramMap.get("username"));
		
		List<String> list = new ArrayList<String>();
		list.add("User 01");
		list.add("User 02");
		list.add("User 03");
		list.add("User 04");
		list.add("User 05");
		
		return list;
	}
}
