package com.prod.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prod.user.entity.UserInfo;
import com.prod.user.service.UserInfoService;

@RestController
@RequestMapping("/user")
public class UserInfoController {
	
	@Autowired
	private UserInfoService userInfoService;
	
	@PostMapping("/saveUser")
	public String saveUser(@RequestBody UserInfo userInfo) {
		userInfoService.saveUser(userInfo);
		return "user saved successfully";
	}
	

}
