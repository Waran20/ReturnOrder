package com.returnorder.ComponentProcessing.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.returnorder.ComponentProcessing.client.PackagingAndDeliveryFeignClient;
import com.returnorder.ComponentProcessing.model.ProcessRequest;
import com.returnorder.ComponentProcessing.model.ProcessResponse;
import com.returnorder.ComponentProcessing.repository.ProcessRequestRepository;
import com.returnorder.ComponentProcessing.repository.ProcessResponseRepository;

@Service
public class AccessoryPartService implements ProcessService {
	
	@Autowired
	private ProcessRequestRepository processRequestRepository;
	@Autowired
	private ProcessResponseRepository processResponseRepository;
	
	@Autowired
	private PackagingAndDeliveryFeignClient packagingAndDeliveryFeignClient;
	
	public ProcessResponse processDetail(int userID) {
		
		double packagingAndDeliveryCharge = 0.0;
		int processingDays = 5;
		double processingCharge = 300;
		
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Calendar c = Calendar.getInstance();
		
		ProcessResponse processResponse = new ProcessResponse();
		
		Optional<ProcessRequest> result = processRequestRepository.findById(userID);
		ProcessRequest processRequest = result.get();
		
		//Calculating the expected date of delivery
		c.add(Calendar.DATE, processingDays);
		
		processResponse.setUserID(userID);
		processResponse.setProcessingCharge(processingCharge);
		
		/*
		 * 
		 * Call Packaging and Delivery Microservice to get packaging cost Input to give
		 * - Component Type, Count Charge Output to receive - Packaging and Delivery
		 * charge
		 * 
		 */
		
		packagingAndDeliveryCharge = packagingAndDeliveryFeignClient.PackagingAndDeliveryCost(
				processRequest.getComponentType(), processRequest.getQuantityOfDefective());//300;
		
		processResponse.setPackagingAndDeliveryCharge(packagingAndDeliveryCharge);
		processResponse.setDateOfDelivery(dateFormat.format(c.getTime()));
		processResponseRepository.save(processResponse);
		return processResponse;
		
		
	}

}
