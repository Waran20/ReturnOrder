package com.returnorder.AuthorizationService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.returnorder.AuthorizationService.model.MyUser;

public interface UserRepository extends  JpaRepository<MyUser, String> {

	public MyUser findByUsername(String username);
}
