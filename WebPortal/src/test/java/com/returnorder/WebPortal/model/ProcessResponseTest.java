package com.returnorder.WebPortal.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.returnorder.webPortal.model.ProcessResponse;


public class ProcessResponseTest {
	ProcessResponse processResponse = new ProcessResponse();
	
	@Test
	void testGetRequestID() {
		processResponse.setRequestID(11);
		assertEquals(11, processResponse.getRequestID());
	}

	@Test
	void testSetRequestID() {
		processResponse.setRequestID(11);
		assertEquals(11, processResponse.getRequestID());
	}
	
	@Test
	void testGetUserID() {
		processResponse.setUserID(1);
		assertEquals(1, processResponse.getUserID());
	}
	
	@Test
	void testSetUserID() {
		processResponse.setUserID(1);
		assertEquals(1, processResponse.getUserID());
	}
	
	@Test
	void testGetProcessingCharge() {
		processResponse.setProcessingCharge(500.0);
		assertEquals(500.0, processResponse.getProcessingCharge());
	}
	
	@Test
	void testSetProcessingCharge() {
		processResponse.setProcessingCharge(500.0);
		assertEquals(500.0, processResponse.getProcessingCharge());
	}
	
	@Test
	void testGetPackagingAndDeliveryCharge() {
		processResponse.setPackagingAndDeliveryCharge(500.0);
		assertEquals(500.0, processResponse.getPackagingAndDeliveryCharge());
	}
	
	@Test
	void testSetPackagingAndDeliveryCharge() {
		processResponse.setPackagingAndDeliveryCharge(500.0);
		assertEquals(500.0, processResponse.getPackagingAndDeliveryCharge());
	}
	
	@Test
	void testGetDateOfDelivery() {
		processResponse.setDateOfDelivery("23/03/2021");
		assertEquals("23/03/2021", processResponse.getDateOfDelivery());
	}
	
	@Test
	void testSetDateOfDelivery() {
		processResponse.setDateOfDelivery("23/03/2021");
		assertEquals("23/03/2021", processResponse.getDateOfDelivery());
	}
	
	@Test
	void testAllArgsConstructor() {
		ProcessResponse processResponse = new ProcessResponse(1,101,500.0,200.0,"23/03/2021");
		assertEquals("23/03/2021", processResponse.getDateOfDelivery());
	}
	
}
