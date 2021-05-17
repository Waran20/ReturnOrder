package com.returnorder.webPortal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.returnorder.webPortal.model.UserDetails;

public interface UserAuthenticationRepository extends JpaRepository<UserDetails, Integer>{

	 UserDetails findByUserName(String name);
}
