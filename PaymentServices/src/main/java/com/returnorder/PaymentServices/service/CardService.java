package com.returnorder.PaymentServices.service;

import java.util.NoSuchElementException;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.returnorder.PaymentServices.dao.CardRepo;
import com.returnorder.PaymentServices.exception.CardNotFoundException;
import com.returnorder.PaymentServices.model.CreditCard;


@Service
public class CardService {

	@Autowired
	CardRepo cardRepo;
	
	@Transactional
	public double processPayment(long cardNumber,double charge) throws NoSuchElementException {
		//Optional<CreditCard> result = cardRepo.findByCardNumber(cardNumber);
		//CreditCard card=result.get();
		CreditCard card=cardRepo.findByCardNumber(cardNumber);
		if(card==null) {
			throw new CardNotFoundException();
		}
		else {
		double balance= card.getCardLimit()-charge;
		if(balance>0)
		{
			card.setCardLimit(balance);
			cardRepo.save(card);
			return balance;
			
		}
		else {
			return -1;
		}}
	}
}
