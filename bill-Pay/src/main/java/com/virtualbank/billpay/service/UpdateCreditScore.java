package com.virtualbank.billpay.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.virtualbank.billpay.feignclient.UpdateCreditScoreFeignClient;


public class UpdateCreditScore {

	@Autowired
	private UpdateCreditScoreFeignClient creditFeignClient;
	public UpdateCreditScore()
	{
		
	}
	public void updateCredit(String ssn, int score)
	{
		creditFeignClient.updateCreditScore(ssn, score);
		
	}
}
