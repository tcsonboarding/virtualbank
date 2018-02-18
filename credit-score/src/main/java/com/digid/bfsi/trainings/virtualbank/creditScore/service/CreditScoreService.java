package com.digid.bfsi.trainings.virtualbank.creditScore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digid.bfsi.trainings.virtualbank.creditScore.domain.CreditScore;
import com.digid.bfsi.trainings.virtualbank.creditScore.repository.CreditStoreRepository;

@Service
public class CreditScoreService {
	@Autowired
	private CreditStoreRepository repository;

	public CreditScore findBySsn(String ssn) {
		return repository.findBySsn(ssn);
	}
}
