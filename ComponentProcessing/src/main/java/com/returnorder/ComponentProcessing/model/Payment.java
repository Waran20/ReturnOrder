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
@Table(name = "payment")
public class Payment {
	
	@Id
	private int requestID;
	private long creditCardNumber;
	private double creditLimit;
	private double processingCharge;
	
}
