package com.returnorder.WebPortal.service;

import static org.hamcrest.CoreMatchers.anything;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.returnorder.webPortal.model.UserDetails;
import com.returnorder.webPortal.repository.UserAuthenticationRepository;
import com.returnorder.webPortal.service.loginService;

@SpringBootTest
class loginServiceTest {

	
	@Captor
	ArgumentCaptor<UserDetails> captor;
	
	@Mock
	UserDetails userDetails;
	
	@Mock
	UserAuthenticationRepository userRepo;
	
	@InjectMocks
	loginService loginservice;
	
	@Test
	void createValidUsertest() {
		
		 loginservice.createUser(101, "user1", "pwd", "sdfak2", true);
		 then(userRepo).should(times(1)).save(captor.capture());
		
	}
	
	
}
