package com.returnorder.PaymentServices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.returnorder.PaymentServices.exception.CardNotFoundException;
import com.returnorder.PaymentServices.service.CardService;

@RestController
public class CardController {
	@Autowired
	private CardService cardService;
	
	@GetMapping("/card/{cardNumber}/{charge}")
	@ResponseStatus(code=HttpStatus.OK)
	public double getBalance(@PathVariable long cardNumber,@PathVariable double charge) throws CardNotFoundException {
		try {
			return cardService.processPayment(cardNumber,charge);
		}
		catch(CardNotFoundException ex){
			throw new CardNotFoundException();
		}
		
	}
}
