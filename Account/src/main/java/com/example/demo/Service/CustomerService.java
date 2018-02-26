package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Service.FeignClients.CustomerFeignClient;

@Service
public class CustomerService {

	@Autowired
	private CustomerFeignClient cusotmerFeign;
	public CustomerService() {
		// TODO Auto-generated constructor stub
	}
	
	public String getSsn(String customerId) {
	 return	cusotmerFeign.getCustomerSsn(customerId);
			
	}

}
