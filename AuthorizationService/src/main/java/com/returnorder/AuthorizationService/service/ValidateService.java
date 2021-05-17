package com.returnorder.AuthorizationService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.returnorder.AuthorizationService.model.AuthenticationResponse;
import com.returnorder.AuthorizationService.repository.UserRepository;



@Component
public class ValidateService {
	@Autowired
	private JwtUtil jwtutil;
	@Autowired
	private UserRepository userRepo;

	public AuthenticationResponse validate(String token) {
		AuthenticationResponse authenticationResponse = new AuthenticationResponse();

		String jwt = token.substring(7);
		authenticationResponse.setJwt(jwt);

		if (jwtutil.validateToken(jwt)) {
			System.out.println("Valid");
			authenticationResponse.setValid(true);
		} else {
			authenticationResponse.setValid(false);
		}
		return authenticationResponse;
	}
}
