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
public class ProcessResponse {

	
	@Id
	private int requestID;
	private int userID;
	private double processingCharge;
	private double packagingAndDeliveryCharge;
	private String dateOfDelivery;


}
