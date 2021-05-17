package com.returnorder.ComponentProcessing.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="packagingAndDeliveryFeignClient",url="http://localhost:8083")
public interface PackagingAndDeliveryFeignClient {
	
	@GetMapping("/PackagingAndDeliveryCharge/{componentType}/{count}")
	public int PackagingAndDeliveryCost(@PathVariable String componentType, @PathVariable int count);
	
}
