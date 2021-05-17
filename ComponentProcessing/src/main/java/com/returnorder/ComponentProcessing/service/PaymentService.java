package com.returnorder.ComponentProcessing.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.returnorder.ComponentProcessing.client.PaymentFeignClient;
import com.returnorder.ComponentProcessing.model.Payment;
import com.returnorder.ComponentProcessing.repository.PaymentRepository;

@Service
public class PaymentService {
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	@Autowired
	private PaymentFeignClient paymentClient;
	
	
	public String completeProcessing(int requestID, long creditCardNumber, double creditLimit,
			double processingCharge) {
		
		double currentBalance = -1;
		String finalResponse = "Unable to connect to Payment Microservice";
		
		Payment payment = new Payment();
		payment.setRequestID(requestID);
		payment.setCreditCardNumber(creditCardNumber);
		payment.setCreditLimit(creditLimit);
		payment.setProcessingCharge(processingCharge);
		paymentRepository.save(payment);
		
		currentBalance = paymentClient.ProcessPayment(creditCardNumber, processingCharge);
		
		if (currentBalance  <= -1)
			finalResponse = "We are sorry. Your payment could not be processed due to insufficient limit.";
		else
			finalResponse = "Your Payment is successful. Thank you for using our service";
		
		return finalResponse;
	}

}
