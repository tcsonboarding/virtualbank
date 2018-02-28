package com.virtualbank.billpay.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.virtualbank.billpay.feignclient.CustomerFeignClient;


public class getSSN {
	
	@Autowired
	private CustomerFeignClient cusotmerFeign;
	public getSSN() {
		// TODO Auto-generated constructor stub
	}
	
	public String getSsn(String customerId) {
	 return	cusotmerFeign.getCustomerSsn(customerId);
			
	}

}
