package com.returnorder.webPortal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.returnorder.webPortal.model.UserDetails;
import com.returnorder.webPortal.repository.UserAuthenticationRepository;

@Component
public class loginService {

	@Autowired
	private UserDetails userDetails;

	@Autowired
	private UserAuthenticationRepository userAuthenticationRepository;

	public void createUser(int userID, String userName, String password, String jwtToken, boolean isValid) {
		
		userDetails = new UserDetails(userID, userName, password, jwtToken, isValid);
		userAuthenticationRepository.save(userDetails);
	
	}
	
}
