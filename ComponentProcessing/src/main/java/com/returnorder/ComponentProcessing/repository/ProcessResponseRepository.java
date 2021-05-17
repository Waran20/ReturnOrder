package com.returnorder.ComponentProcessing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.returnorder.ComponentProcessing.model.ProcessResponse;

@Repository
public interface ProcessResponseRepository extends CrudRepository<ProcessResponse, Integer> {
	
}
