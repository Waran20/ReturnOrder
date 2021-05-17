package com.returnorder.webPortal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.returnorder.webPortal.client.ComponentProcessingFeignClient;
import com.returnorder.webPortal.model.ProcessRequest;
import com.returnorder.webPortal.model.ProcessResponse;
import com.returnorder.webPortal.model.UserDetails;
import com.returnorder.webPortal.repository.ProcessRequestRepository;
import com.returnorder.webPortal.repository.ProcessResponseRepository;
import com.returnorder.webPortal.repository.UserAuthenticationRepository;

@Controller
public class ProcessController {

	@Autowired
	private ProcessRequest processRequest;
	
	@Autowired
	private ProcessResponse processResponse;
	
	@Autowired
	private UserAuthenticationRepository userAuthenticationRepository;
	
	@Autowired
	private ProcessRequestRepository processRequestRepository;
	
	@Autowired
	private	ProcessResponseRepository processResponseRepository;
	
	@Autowired
	private ComponentProcessingFeignClient componentProcessingFeignClient;

	
	@RequestMapping("/addprocessRequest")      //To be invoked when user enters component details
	public String displayProcessingDetails(@RequestParam("username") String username,
			@RequestParam("contactNumber") long contactNumber, @RequestParam("creditCardNumber") long creditCardNumber,
			@RequestParam("componentType") String componentType, @RequestParam("componentName") String componentName,
			@RequestParam("quantityOfDefective") int quantityOfDefective,
			@RequestParam(value="isPriorityRequest", required = false) boolean isPriorityRequest,  Model model) {
				
	
			UserDetails user=userAuthenticationRepository.findByUserName(username);
			
			int userId=user.getUserID();
			
			processRequest=  new ProcessRequest(userId, username, contactNumber, creditCardNumber,
					componentType, componentName, quantityOfDefective, isPriorityRequest);
			processRequestRepository.save(processRequest);
			String jwtToken = "Bearer "+ userAuthenticationRepository.findById(processRequest.getUserID()).get().getJwtToken();
			processResponse = componentProcessingFeignClient.getProcessingDetails(jwtToken, processRequest);
			processResponseRepository.save(processResponse);
			int requestId = processResponse.getRequestID();
			int userID = processResponse.getUserID();
			double processingCharge = processResponse.getProcessingCharge();
			double packagingAndDeliveryCharge = processResponse.getPackagingAndDeliveryCharge();
			String dateOfDelivery = processResponse.getDateOfDelivery();

			model.addAttribute("requestId", requestId);
			model.addAttribute("userID", userID);
			model.addAttribute("processingCharge", processingCharge);
			model.addAttribute("packagingAndDeliveryCharge", packagingAndDeliveryCharge);
			model.addAttribute("dateOfDelivery", dateOfDelivery);
			
		return "process";
		
		
	}
	
	
	@RequestMapping("/payment")
	public String confirmationMessage(  Model Map) {
		
		boolean confirmation = true;
		String response = "Unable to process";
		String jwtToken = "Bearer "+ userAuthenticationRepository.findById(processRequest.getUserID()).get().getJwtToken();
		int requestID = processResponse.getRequestID();
		
		long creditCardNumber = processRequest.getCreditCardNumber();
		double totalCharge = processResponse.getProcessingCharge() + processResponse.getPackagingAndDeliveryCharge();
		
		if(confirmation) {
			response=componentProcessingFeignClient.paymentProcessing(jwtToken, requestID, creditCardNumber, 3000.0, totalCharge);
		}
		
		Map.addAttribute("response",response);
		return "confirmation";
		
	}
	
	

}
