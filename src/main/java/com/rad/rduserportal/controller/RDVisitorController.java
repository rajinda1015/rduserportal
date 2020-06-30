package com.rad.rduserportal.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rad.rduserportal.dto.RDLoginDTO;
import com.rad.rduserportal.service.RDLoginService;

@RestController
@RefreshScope
@RequestMapping(value = "/userportal/visitor")
public class RDVisitorController {
	
	@Autowired
	private RDLoginService rDLoginService;

	@RequestMapping(value = "/registerUser", method = RequestMethod.POST)
	public List<String> registerUser(@RequestBody RDLoginDTO loginDTO) {
		List<String> messages = new ArrayList<String>();
		
		try {
			boolean result = rDLoginService.registerUser(loginDTO);
			
			if (result) {
				messages.add("User is successfully registered");
			} else {
				messages.add("User cannot be registered");
			}

		} catch (Exception e) {
			messages.add("User cannot be registered. Error : " + e.getLocalizedMessage());
		}
		
		return messages;
	}
}
