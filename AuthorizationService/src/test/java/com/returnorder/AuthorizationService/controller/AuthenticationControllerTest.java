package com.returnorder.AuthorizationService.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.json.JSONException;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.returnorder.AuthorizationService.AuthorizationServiceApplication;
import com.returnorder.AuthorizationService.exception.BadCredentialException;
import com.returnorder.AuthorizationService.model.AuthenticationRequest;
import com.returnorder.AuthorizationService.model.AuthenticationResponse;


@SpringBootTest(classes = AuthorizationServiceApplication.class,
webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AuthenticationControllerTest {

	@LocalServerPort
	private int port;
	
	@Autowired
	AuthenticationController authenticationController;

	TestRestTemplate restTemplate =new TestRestTemplate();
	HttpHeaders headers=new HttpHeaders();
	
	@Before
	public void before() {
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	}
	
	@Test
	public void loginTest() throws JSONException {
		
			AuthenticationRequest authenticationRequest=new AuthenticationRequest("user1","pwd1");
			HttpEntity<AuthenticationRequest> entity =new HttpEntity<AuthenticationRequest>(authenticationRequest,headers);
			ResponseEntity<String> response = restTemplate.exchange(createURL("/login"), HttpMethod.POST, entity, String.class);
			String body = response.getBody();
			String expected= "{valid:true}";
			JSONAssert.assertEquals(expected, response.getBody(), false);			
	}
	
	//GET
	@Test
	public void validTest() throws BadCredentialException {
		
		AuthenticationRequest authenticationRequest=new AuthenticationRequest("user1","pwd1");
		HttpEntity<AuthenticationRequest> entity =new HttpEntity<AuthenticationRequest>(authenticationRequest,headers);
		ResponseEntity<AuthenticationResponse> response = restTemplate.exchange(createURL("/login"), HttpMethod.POST, entity, AuthenticationResponse.class);
		AuthenticationResponse authenticationResponse = response.getBody();
		
		headers.add("Authorization",authenticationResponse.getJwt() );
		HttpEntity entity2 =new HttpEntity(headers);
		ResponseEntity<AuthenticationResponse> response2  = restTemplate.exchange(createURL("/validate"), HttpMethod.GET, entity2, AuthenticationResponse.class);
		AuthenticationResponse body = response.getBody();
		String expected= "{valid:true}";
		
		assertEquals(authenticationResponse, body);
		
		
	}
	
	private String createURL(String retriURL) {
		return "http://localhost:"+port+retriURL;
	}

}

