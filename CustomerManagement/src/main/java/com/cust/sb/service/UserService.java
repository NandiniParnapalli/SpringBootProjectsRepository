package com.cust.sb.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cust.sb.entity.CustomUserDetails;
import com.cust.sb.entity.User;
import com.cust.sb.repository.UserRepository;

@Service
public class UserService implements UserDetailsService{
     @Autowired
	private UserRepository userRepository;
     
     @Autowired
     private PasswordEncoder passwordEncoder;
     
     public String saveUser(User user)
     {
    	 user.setPassword(passwordEncoder.encode(user.getPassword()));
    	 userRepository.save(user);
    	 return "user added";
     }

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user= userRepository.findByUsername(username);
		return user.map(CustomUserDetails::new).orElseThrow(()->new UsernameNotFoundException("user not found"+username));
	}
}
