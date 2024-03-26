package com.cust.sb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cust.sb.entity.AuthRequest;
import com.cust.sb.entity.User;
import com.cust.sb.service.JwtService;
import com.cust.sb.service.UserService;

@RestController
@RequestMapping("/auth")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private JwtService jwtService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@GetMapping("/welcome")
	public String welcome() {
		return "welcome all";
	}
	@PostMapping("/saveUser")
	public String saveUser(@RequestBody User user) {
		return userService.saveUser(user);
	}
	
	@GetMapping("/admin")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String admin() {
		return "welcome admin";
	}
	
	@GetMapping("/user")
	@PreAuthorize("hasRole('ROLE_USER')")
	public String user() {
		return "welcome user";
	}
	@GetMapping("/logout")
	public String adminlogout() {
		return "admin loggedout";
	}
	@PostMapping("/generateToken")
	public String authenticateGetToken(@RequestBody AuthRequest authRequest) {
		Authentication authentication=authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
	if(authentication.isAuthenticated())
	{
		return jwtService.generateToken(authRequest.getUsername());
	}
	else
	{
	     throw new UsernameNotFoundException("invalid user");
	}
	
	
	
	}

}
