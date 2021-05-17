package com.returnorder.ComponentProcessing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.returnorder.ComponentProcessing.model.Payment;

@Repository
public interface PaymentRepository extends CrudRepository<Payment,Integer>{

}