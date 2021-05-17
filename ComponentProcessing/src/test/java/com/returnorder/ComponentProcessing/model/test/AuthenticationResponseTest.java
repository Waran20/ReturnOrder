package com.returnorder.ComponentProcessing.model.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.returnorder.ComponentProcessing.model.AuthenticationResponse;

public class AuthenticationResponseTest {
	AuthenticationResponse authenticationResponse = new AuthenticationResponse();

	@Test
	void testSetJwtToken() {
		authenticationResponse.setJwtToken(
				"eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyMSIsImV4cCI6MTYxNTIyNTc5NywiaWF0IjoxNjE1MjIzOTk3fQ.IRD8qCvu6neU1Atkic1qcNnJd_YZEnzFa1F3oaBusiU");
		assertEquals("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyMSIsImV4cCI6MTYxNTIyNTc5NywiaWF0IjoxNjE1MjIzOTk3fQ.IRD8qCvu6neU1Atkic1qcNnJd_YZEnzFa1F3oaBusiU", authenticationResponse.getJwtToken());
	}
	
	@Test
	void testSetValid() {
		authenticationResponse.setValid(true);
		assertEquals(true, authenticationResponse.getValid());
	}
	
	@Test
	void testGetJwtToken() {
		authenticationResponse.setJwtToken(
				"eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyMSIsImV4cCI6MTYxNTIyNTc5NywiaWF0IjoxNjE1MjIzOTk3fQ.IRD8qCvu6neU1Atkic1qcNnJd_YZEnzFa1F3oaBusiU");
		assertEquals("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyMSIsImV4cCI6MTYxNTIyNTc5NywiaWF0IjoxNjE1MjIzOTk3fQ.IRD8qCvu6neU1Atkic1qcNnJd_YZEnzFa1F3oaBusiU", authenticationResponse.getJwtToken());
	}
	
	@Test
	void testGetValid() {
		authenticationResponse.setValid(true);
		assertEquals(true, authenticationResponse.getValid());
	}
	
	@Test
	void testAllArgsConstructor() {
		AuthenticationResponse authenticationResponse = new AuthenticationResponse("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyMSIsImV4cCI6MTYxNTIyNTc5NywiaWF0IjoxNjE1MjIzOTk3fQ.IRD8qCvu6neU1Atkic1qcNnJd_YZEnzFa1F3oaBusiU",true);
		assertEquals(true, authenticationResponse.getValid());
	}
	
}
