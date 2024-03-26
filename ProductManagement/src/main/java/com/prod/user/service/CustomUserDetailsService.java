package com.prod.user.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.prod.user.dto.UserInfoDetails;
import com.prod.user.entity.UserInfo;
import com.prod.user.repository.UserInfoRepo;
@Component
public class CustomUserDetailsService implements UserDetailsService{
	
	
	@Autowired
	private UserInfoRepo userInfoRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UserInfo> userInfo=userInfoRepo.findByUsername(username);
		
		
		return userInfo.map(UserInfoDetails::new)
				.orElseThrow(()->new UsernameNotFoundException("user not found"));
	}

}
