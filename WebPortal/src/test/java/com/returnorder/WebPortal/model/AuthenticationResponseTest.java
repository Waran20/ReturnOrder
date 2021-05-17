package com.returnorder.WebPortal.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.returnorder.webPortal.model.AuthenticationResponse;


public class AuthenticationResponseTest {
	AuthenticationResponse authenticationResponse = new AuthenticationResponse();

	@Test
	void testSetJwtToken() {
		authenticationResponse.setJwt(
				"eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyMSIsImV4cCI6MTYxNTIyNTc5NywiaWF0IjoxNjE1MjIzOTk3fQ.IRD8qCvu6neU1Atkic1qcNnJd_YZEnzFa1F3oaBusiU");
		assertEquals("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyMSIsImV4cCI6MTYxNTIyNTc5NywiaWF0IjoxNjE1MjIzOTk3fQ.IRD8qCvu6neU1Atkic1qcNnJd_YZEnzFa1F3oaBusiU", authenticationResponse.getJwt());
	}
	
	@Test
	void testSetValid() {
		authenticationResponse.setValid(true);
		assertEquals(true, authenticationResponse.getValid());
	}
	
	@Test
	void testGetJwtToken() {
		authenticationResponse.setJwt(
				"eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyMSIsImV4cCI6MTYxNTIyNTc5NywiaWF0IjoxNjE1MjIzOTk3fQ.IRD8qCvu6neU1Atkic1qcNnJd_YZEnzFa1F3oaBusiU");
		assertEquals("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyMSIsImV4cCI6MTYxNTIyNTc5NywiaWF0IjoxNjE1MjIzOTk3fQ.IRD8qCvu6neU1Atkic1qcNnJd_YZEnzFa1F3oaBusiU", authenticationResponse.getJwt());
	}
	
	@Test
	void testGetValid() {
		authenticationResponse.setValid(true);
		assertEquals(true, authenticationResponse.getValid());
	}
	
	@Test
	void testAllArgsConstructor() {
		AuthenticationResponse authenticationResponse = new AuthenticationResponse(0, "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyMSIsImV4cCI6MTYxNTIyNTc5NywiaWF0IjoxNjE1MjIzOTk3fQ.IRD8qCvu6neU1Atkic1qcNnJd_YZEnzFa1F3oaBusiU",true);
		assertEquals(true, authenticationResponse.getValid());
	}
	
}
