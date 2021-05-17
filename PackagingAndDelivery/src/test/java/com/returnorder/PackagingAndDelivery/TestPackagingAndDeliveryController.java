package com.returnorder.PackagingAndDelivery;


import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.returnorder.PackagingAndDelivery.controller.PackagingAndDeliveryController;


@ExtendWith(MockitoExtension.class)
@WebMvcTest(value = PackagingAndDeliveryController.class)
class TestPackagingAndDeliveryController {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	PackagingAndDeliveryController packagingAndDeliveryController;
	
	@Test
	public void testChargesAccessories() throws Exception{
		when(packagingAndDeliveryController.PackagingAndDeliveryCost(Mockito.anyString(), Mockito.anyInt())).thenReturn(400);
		String componentType="accessory";
		Integer count=2;
		
		mockMvc.perform(get("/PackagingAndDeliveryCharge/{componentType}/{count}",componentType,count)).andExpect(status().isOk());
	}
	
	@Test
	public void testChargesIntegral() throws Exception{
		when(packagingAndDeliveryController.PackagingAndDeliveryCost(Mockito.anyString(), Mockito.anyInt())).thenReturn(700);
		String componentType="integral";
		Integer count=2;
		
		mockMvc.perform(get("/PackagingAndDeliveryCharge/{componentType}/{count}",componentType,count)).andExpect(status().isOk());
	} 
	
	/*@Test
	public void testGetException() throws Exception {
		when(packagingAndDeliveryController.PackagingAndDeliveryCost(Mockito.anyString(), Mockito.anyInt())).thenThrow(new ComponentNotFoundException(null));
		String componentType="integral";
		Integer count=2;
		mockMvc.perform(get("/PackagingAndDeliveryCharge/{componentType}/{count}",componentType,count)).andExpect(status().isNotFound());
	}*/
}
