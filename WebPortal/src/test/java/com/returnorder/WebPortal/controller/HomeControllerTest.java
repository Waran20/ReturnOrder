package com.returnorder.WebPortal.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.returnorder.webPortal.client.AuthenticationFeignClient;
import com.returnorder.webPortal.controller.HomeController;
import com.returnorder.webPortal.model.AuthenticationRequest;
import com.returnorder.webPortal.model.AuthenticationResponse;
import com.returnorder.webPortal.service.loginService;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Arrays;

@WebMvcTest(HomeController.class)
class HomeControllerTest {

	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	private AuthenticationRequest authenticationRequest;

	@MockBean
	private AuthenticationResponse authenticationResponse;

	@MockBean
	private AuthenticationFeignClient  authenticationFeignClient;
	
	@MockBean
	loginService loginService;
	
	@Captor
	ArgumentCaptor<AuthenticationRequest> captor;
	
	
	@Test
	void loginTest() throws Exception {
		
		RequestBuilder requestBuilder=MockMvcRequestBuilders.get("/").accept(MediaType.TEXT_HTML);
		MvcResult mvcResult = (MvcResult) mockMvc.perform(requestBuilder).andExpect(status().isOk()).andReturn();
	}
	
	
	@Test
	void HomeTest() throws Exception {
		
		AuthenticationResponse response=new AuthenticationResponse(0, "jwt", true);
		when(authenticationFeignClient.createAuthenticationToken(authenticationRequest)).thenReturn(response);
		//when(authenticationResponse.getJwt()).thenReturn("jwt");
		//when(authenticationResponse.getValid()).thenReturn(true);
		
		RequestBuilder requestBuilder=MockMvcRequestBuilders.post("/login").accept(MediaType.TEXT_HTML).param("username", "user1").param("password", "pwd");
		MvcResult mvcResult = (MvcResult) mockMvc.perform(requestBuilder).andExpect(status().isOk()).andReturn();
	
	}

}
