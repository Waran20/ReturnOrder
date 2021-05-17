package com.returnorder.ComponentProcessing.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "process_request")
public class ProcessRequest {
	
	@Id
	private int userID;
	private String userName;
	private long contactNumber;
	private long creditCardNumber;
	private String componentType;
	private String componentName;
	private int quantityOfDefective;
	private boolean isPriorityRequest;
		
}
/*
 * Sample JSON Format
{
    "userID": 5,
    "userName": "XYZ",
    "contactNumber": 9874563210,
    "creditCardNumber": 1234567890,
    "componentType": "integral",
    "componentName": "Motor",
    "quantityOfDefective": 2,
    "isPriorityRequest": true
}

*/
