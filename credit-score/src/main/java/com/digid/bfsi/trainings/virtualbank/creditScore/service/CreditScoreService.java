package com.digid.bfsi.trainings.virtualbank.creditScore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digid.bfsi.trainings.virtualbank.creditScore.domain.CreditEvent;
import com.digid.bfsi.trainings.virtualbank.creditScore.repository.CreditEventRepository;

@Service
public class CreditScoreService {
	@Autowired
	private CreditEventRepository repository;

	public void addCreditEvent(CreditEvent creditEvent) {
		repository.save(creditEvent);
	}

	public Integer getScore(String ssn) {
		Integer sum = 0;
		List<CreditEvent> events = repository.findBySsn(ssn);
		for (CreditEvent event : events) {
			sum += event.getScoreChange();
		}
		return sum;
	}
}
