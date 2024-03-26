package com.prod.user.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.prod.user.entity.UserInfo;
import com.prod.user.repository.UserInfoRepo;

@Service
public class UserInfoService {
	
	@Autowired
	private UserInfoRepo userInfoRepo;
	
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public UserInfo saveUser(UserInfo userInfo)
	{
		userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
		return userInfoRepo.save(userInfo);
	}

}
