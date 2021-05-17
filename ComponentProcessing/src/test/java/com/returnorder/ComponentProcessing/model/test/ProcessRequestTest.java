package com.returnorder.ComponentProcessing.model.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.returnorder.ComponentProcessing.model.ProcessRequest;

public class ProcessRequestTest {
	ProcessRequest processRequest = new ProcessRequest();
	
	@Test
	void testGetUserID() {
		processRequest.setUserID(1);
		assertEquals(1, processRequest.getUserID());
	}
	
	@Test
	void testSetUserID() {
		processRequest.setUserID(1);
		assertEquals(1, processRequest.getUserID());
	}
	
	@Test
	void testGetUserName() {
		processRequest.setUserName("Sarvesh");
		assertEquals("Sarvesh", processRequest.getUserName());
	}
	
	@Test
	void testSetUserName() {
		processRequest.setUserName("Mani");
		assertEquals("Mani", processRequest.getUserName());
	}
	
	@Test
	void testGetContactNumber() {
		processRequest.setContactNumber(779921204);
		assertEquals(779921204, processRequest.getContactNumber());
	}
	
	@Test
	void testSetContactNumber() {
		processRequest.setContactNumber(987456123);
		assertEquals(987456123, processRequest.getContactNumber());
	}
	
	@Test
	void testGetCreditCardNumber() {
		processRequest.setCreditCardNumber(1234567890);
		assertEquals(1234567890, processRequest.getCreditCardNumber());
	}

	@Test
	void testSetCreditCardNumber() {
		processRequest.setCreditCardNumber(1234567890);
		assertEquals(1234567890, processRequest.getCreditCardNumber());
	}
	
	@Test
	void testGetComponentType() {
		processRequest.setComponentType("integral");
		assertEquals("integral", processRequest.getComponentType());
	}
	
	@Test
	void testSetComponentType() {
		processRequest.setComponentType("integral");
		assertEquals("integral", processRequest.getComponentType());
	}
	
	@Test
	void testGetComponentName() {
		processRequest.setComponentName("Laptop");
		assertEquals("Laptop", processRequest.getComponentName());
	}
	
	@Test
	void testSetComponentName() {
		processRequest.setComponentName("Laptop");
		assertEquals("Laptop", processRequest.getComponentName());
	}
	
	@Test
	void testGetQuantityOfDefective() {
		processRequest.setQuantityOfDefective(1);
		assertEquals(1, processRequest.getQuantityOfDefective());
	}
	
	@Test
	void testSetQuantityOfDefective() {
		processRequest.setQuantityOfDefective(1);
		assertEquals(1, processRequest.getQuantityOfDefective());
	}
	
	@Test
	void testGetPriorityRequest() {
		processRequest.setPriorityRequest(true);
		assertEquals(true, processRequest.isPriorityRequest());
	}
	
	@Test
	void testSetPriorityRequest() {
		processRequest.setPriorityRequest(true);
		assertEquals(true, processRequest.isPriorityRequest());
	}
	
	@Test
	void testAllargsConstructor() {
		ProcessRequest processRequest = new ProcessRequest(1,"Mani",7799212041L,1234567,"Integral","Earphone",3,true);
		assertEquals(true,processRequest.isPriorityRequest());
	}
}
