package com.returnorder.PaymentServices.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.returnorder.PaymentServices.exception.CardNotFoundException;
import com.returnorder.PaymentServices.model.CreditCard;

public interface CardRepo extends JpaRepository<CreditCard, String>{

	CreditCard findByCardNumber(long cardNumber)throws CardNotFoundException;

}
