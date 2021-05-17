package com.returnorder.webPortal.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor	
@Component
@Entity
@Table(name = "user_details")
public class UserDetails {
	
	@Id
	private int userID;
	private String password;
	private String jwtToken;
	private boolean isValid;
	private String userName;
	
	
	
	public UserDetails(int userID, String userName, String password, String jwtToken, boolean isValid) {
		super();
		this.userID = userID;
		this.userName = userName;
		this.password = password;
		this.jwtToken = jwtToken;
		this.isValid = isValid;
	}



}