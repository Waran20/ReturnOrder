package com.returnorder.PaymentServices;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.returnorder.PaymentServices.dao.CardRepo;
import com.returnorder.PaymentServices.model.CreditCard;
import com.returnorder.PaymentServices.service.CardService;

@ExtendWith(MockitoExtension.class)
public class TestModel {

	@InjectMocks
	CreditCard card;
	
	@Test
	public void testPaymentCredentialConstructor() {
		CreditCard cc = new CreditCard(1234567, 5000);
		assertEquals(cc.getCardNumber(),1234567);

	}
	
	@Test
	public void testCreditCardNumber() {
		card.setCardNumber(52569852);
		assertEquals(card.getCardNumber(),52569852);
	}
	
	@Test
	public void testCreditCardLimit() {
		card.setCardLimit(5000);
		assertEquals(card.getCardLimit(),5000);
	}

}
