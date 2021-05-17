package com.returnorder.ComponentProcessing.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="paymentFeignClient",url="http://localhost:8082")
public interface PaymentFeignClient {

	@GetMapping("/card/{cardNumber}/{charge}")
	double ProcessPayment(@PathVariable long cardNumber,@PathVariable double charge);
}
