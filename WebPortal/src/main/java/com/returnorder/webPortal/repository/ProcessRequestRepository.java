package com.returnorder.webPortal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.returnorder.webPortal.model.ProcessRequest;

@Repository
public interface ProcessRequestRepository extends JpaRepository<ProcessRequest, Integer> {

}
