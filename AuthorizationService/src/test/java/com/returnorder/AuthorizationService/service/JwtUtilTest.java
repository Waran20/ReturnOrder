package com.returnorder.AuthorizationService.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.junit4.SpringRunner;

import com.returnorder.AuthorizationService.repository.UserRepository;

@SpringBootTest
public class JwtUtilTest {

	
	UserDetails userDetails;

	@InjectMocks
	JwtUtil jwtUtil;

	
	@Test
	public void generateTokenTest() {
		userDetails=new User("user1","pwd1",new ArrayList<>());
		String token = jwtUtil.generateToken(userDetails);
		assertNotNull(token);
	}
	
	@Test
	public void validateTokenTest() {
		userDetails=new User("user1","pwd1",new ArrayList<>());
		String token = jwtUtil.generateToken(userDetails);
		Boolean validateToken = jwtUtil.validateToken(token);
		assertEquals(true, validateToken);
	}
	
	@Test
	public void extractUsernameTest() {
		userDetails = new User("admin", "admin", new ArrayList<>());
		String token = jwtUtil.generateToken(userDetails);
		String username = jwtUtil.extractUsername(token);
		assertEquals(username, "admin");
	}
	

}
