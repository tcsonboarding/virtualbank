package com.virtualbank.billpay.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.virtualbank.billpay.feignclient.AccountFeignClient;

public class UpdateAccount {
	@Autowired
	AccountFeignClient accountClient;
	private UpdateAccount()
	{
		
	}

	public void updateAccount(float debit)
	{
		accountClient.updateAccount(debit);
	}
}
