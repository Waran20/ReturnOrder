package com.returnorder.ComponentProcessing.service;

import org.springframework.stereotype.Service;

import com.returnorder.ComponentProcessing.model.ProcessResponse;

@Service
public interface ProcessService {
	ProcessResponse processDetail(int userID);
}

