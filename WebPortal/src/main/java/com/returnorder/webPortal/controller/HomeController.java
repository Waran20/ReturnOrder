package com.returnorder.webPortal.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.returnorder.webPortal.client.AuthenticationFeignClient;
import com.returnorder.webPortal.model.AuthenticationRequest;
import com.returnorder.webPortal.model.AuthenticationResponse;
import com.returnorder.webPortal.service.loginService;

@Controller
public class HomeController {

	@Autowired
	private AuthenticationRequest authenticationRequest;

	@Autowired
	private AuthenticationResponse authenticationResponse;

	@Autowired
	private AuthenticationFeignClient  authenticationFeignClient;
	
	@Autowired
	loginService loginService;
	@RequestMapping("/")
	public String view() {
		
		return "login";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam("username") String username, @RequestParam("password") String password) throws IOException {
		
		authenticationRequest.setUsername(username);
		authenticationRequest.setPassword(password);
		 authenticationResponse = authenticationFeignClient.createAuthenticationToken(authenticationRequest);
		
		 
		 String jwtToken = authenticationResponse.getJwt();
			boolean isValid = authenticationResponse.getValid();
			int userID = 101;
			
					//authenticationResponse.getUserID();

			
			loginService.createUser(userID, username, password, jwtToken, isValid);
			
			
			if (authenticationResponse.getValid())
				 return "home";
				
		 
//		 	
//		 HttpServletResponse response = null;
//		 response.sendRedirect("/myURL");
			return "login";
		
		
	}
		
}
