package com.returnorder.webPortal.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor	
@Component
@Entity
public class ProcessRequest {

	@Id
	private int userID;
	private String username;
	private long contactNumber;
	private long creditCardNumber;
	private String componentType;
	private String componentName;
	private int quantityOfDefective;
	private boolean isPriorityRequest;
	

	
}
