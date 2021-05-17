package com.retrunorder.ComponentProcessing.controller.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//
//import com.returnorder.ComponentProcessing.client.AuthenticationFeignClient;
//import com.returnorder.ComponentProcessing.controller.ComponentProcessingController;
//import com.returnorder.ComponentProcessing.model.AuthenticationResponse;
//
//@WebMvcTest(ComponentProcessingController.class)
//@ExtendWith(MockitoExtension.class)
//public class ComponentProcessingControllerTest {
//	
//	@Mock
//	AuthenticationFeignClient authenticationFeignClient;
//	
//	@Test
//	public void test_validateToken() {
//		when(authenticationFeignClient.getValidity("token")).thenReturn(new AuthenticationResponse("jwtToken",true));
//		assertEquals(true, authenticationFeignClient.getValidity("token").getValid());
//	}
//	
//}
