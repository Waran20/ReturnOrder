package com.returnorder.AuthorizationService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.returnorder.AuthorizationService.exception.BadCredentialException;
import com.returnorder.AuthorizationService.model.AuthenticationRequest;
import com.returnorder.AuthorizationService.model.AuthenticationResponse;
import com.returnorder.AuthorizationService.service.JwtUtil;
import com.returnorder.AuthorizationService.service.MyUserDetailsService;
import com.returnorder.AuthorizationService.service.ValidateService;

@RestController
public class AuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private MyUserDetailsService userDetailsService;
	
	@Autowired
	private ValidateService validateService;
	
	
	
	@PostMapping("/login")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws BadCredentialException  {
		
		try {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),authenticationRequest.getPassword()));
		}
		catch(BadCredentialsException e) {
			throw new BadCredentialException();
		}
		
		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
		
		String token = jwtUtil.generateToken(userDetails);
	
		return ResponseEntity.ok(new AuthenticationResponse(token,true));
		
	}
	
	  @GetMapping("/validate")
	  public AuthenticationResponse getValidity(@RequestHeader("Authorization") final String token) {
		  return validateService.validate(token); 
	  }
}
