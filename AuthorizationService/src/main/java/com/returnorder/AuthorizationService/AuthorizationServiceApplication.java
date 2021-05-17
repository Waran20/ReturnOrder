package com.returnorder.AuthorizationService;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.returnorder.AuthorizationService.model.MyUser;
import com.returnorder.AuthorizationService.repository.UserRepository;


@SpringBootApplication
public class AuthorizationServiceApplication {

	@Autowired
    private UserRepository repository;

    @PostConstruct
    public void initUsers() {
        List<MyUser> users = Stream.of(
               new MyUser("101","user1","pwd1"),
               new MyUser("102","user2","pwd2"),
               new MyUser("103","user3","pwd3")
        ).collect(Collectors.toList());
        repository.saveAll(users);
    }
    
	public static void main(String[] args) {
		SpringApplication.run(AuthorizationServiceApplication.class, args);
	}

}
