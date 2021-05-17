package com.returnorder.ComponentProcessing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.returnorder.ComponentProcessing.client.AuthenticationFeignClient;
import com.returnorder.ComponentProcessing.model.AuthenticationResponse;
import com.returnorder.ComponentProcessing.model.ProcessRequest;
import com.returnorder.ComponentProcessing.model.ProcessResponse;
import com.returnorder.ComponentProcessing.repository.ProcessRequestRepository;
import com.returnorder.ComponentProcessing.service.AccessoryPartService;
import com.returnorder.ComponentProcessing.service.IntegralPartService;
import com.returnorder.ComponentProcessing.service.PaymentService;

@RestController
public class ComponentProcessingController {
	
	@Autowired
	IntegralPartService integralPartService;
	
	@Autowired
	AccessoryPartService accessoryPartService;
	
	@Autowired
	PaymentService paymentService;
	
	@Autowired
	ProcessRequestRepository processRequestRepository;
	
	@Autowired
	AuthenticationFeignClient authenticationFeignClient;
	
	@PostMapping("/service")
	public ProcessResponse getProcessingDetails(@RequestHeader("Authorization") String token,@RequestBody ProcessRequest processRequest) throws Exception {
		
		AuthenticationResponse authenticationResponse = null;
		try {
			authenticationResponse = authenticationFeignClient.getValidity(token);
			if(authenticationResponse.getValid() == false)
				return null;
		} 
		catch(Exception e) {
			e.printStackTrace();
			throw new Exception("Authorization Failed. Please try again");
		}
		
		processRequestRepository.save(processRequest);
		ProcessResponse response = null;//new ProcessResponse(3,5,50.0,40.0,"25");
		int userID = processRequest.getUserID();
		String componentType = processRequest.getComponentType();
		if (componentType.equals("integral"))
		response = (integralPartService.processDetail(userID));
		else if (componentType.equals("accessory"))
		response = (accessoryPartService.processDetail(userID));
	
		return response;
	}
	
	
	@PostMapping("/payment/{requestID}/{creditCardNumber}/{creditLimit}/{processingCharge}")
	public String paymentProcessing(@RequestHeader("Authorization") String token, @PathVariable("requestID") int requestID, @PathVariable("creditCardNumber") long creditCardNumber,
			@PathVariable("creditLimit") double creditLimit,
			@PathVariable("processingCharge") double processingCharge) throws Exception{
		
		AuthenticationResponse authenticationResponse = null;
		try {
			authenticationResponse = authenticationFeignClient.getValidity(token);
			if(authenticationResponse.getValid() == false)
				return null;
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new Exception("Authorization Failed. Please try again");
		}
		
		
		return paymentService.completeProcessing(requestID, creditCardNumber, creditLimit, processingCharge);
	}
	
	
}
