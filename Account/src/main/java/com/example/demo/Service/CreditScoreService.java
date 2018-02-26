package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Service.FeignClients.CreditScoreFeignClient;
@Service
public class CreditScoreService {

	@Autowired
	private CustomerService customerService;
	private CreditScoreFeignClient creditScoreFeign;
	
	public String getCreditScore(String ssn) {
	
		String creditScore = creditScoreFeign.getCreditScore(ssn);
		return creditScore;
	}

}
