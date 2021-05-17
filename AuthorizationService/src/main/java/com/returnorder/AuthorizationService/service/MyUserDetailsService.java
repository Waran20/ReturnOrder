package com.returnorder.AuthorizationService.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.returnorder.AuthorizationService.model.MyUser;
import com.returnorder.AuthorizationService.repository.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		MyUser myUser = userRepository.findByUsername(username);
		return new User(myUser.getUsername(), myUser.getPassword(), new ArrayList<>());
	}

	
	//Impl password validation
}

