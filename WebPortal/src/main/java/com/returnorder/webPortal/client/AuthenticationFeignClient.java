package com.returnorder.webPortal.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.returnorder.webPortal.model.AuthenticationRequest;
import com.returnorder.webPortal.model.AuthenticationResponse;



@FeignClient(name = "authenticationFeignClient",url = "http://localhost:8084/")
public interface AuthenticationFeignClient {

	@PostMapping("/login")
	public AuthenticationResponse createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest);
	
}
