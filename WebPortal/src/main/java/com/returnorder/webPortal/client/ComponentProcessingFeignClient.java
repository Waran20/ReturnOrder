package com.returnorder.webPortal.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.returnorder.webPortal.model.ProcessRequest;
import com.returnorder.webPortal.model.ProcessResponse;


@FeignClient(name="componentProcessingFeignClient", url="http://localhost:8081/")
public interface ComponentProcessingFeignClient {

	@PostMapping("/service")
	ProcessResponse getProcessingDetails(@RequestHeader("Authorization") String token, @RequestBody ProcessRequest processRequest);
	
	@PostMapping("/payment/{requestID}/{creditCardNumber}/{creditLimit}/{processingCharge}")
    public String paymentProcessing(@RequestHeader("Authorization") String token,
            @PathVariable("requestID") int requestID, @PathVariable("creditCardNumber") long creditCardNumber,
            @PathVariable("creditLimit") double creditLimit,
            @PathVariable("processingCharge") double processingcharge);
}
