package com.example.demo.Service.FeignClients;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.Config.FeignConfiguration;
import com.example.demo.Service.FeignClients.CustomerFeignClient.HystrixClientFallbackFacrory;

import feign.hystrix.FallbackFactory;
//name of the application
@FeignClient(name="CustomerService", configuration = FeignConfiguration.class, fallbackFactory = HystrixClientFallbackFacrory.class)
public interface CustomerFeignClient {
	@RequestMapping(value = "customer/{customerId}/ssn", method=RequestMethod.GET)
	public String getCustomerSsn(String customerId);
	
	@Component
	static class HystrixClientFallbackFacrory implements FallbackFactory<CustomerFeignClient>{

		@Override
		public CustomerFeignClient create(Throwable arg0) {
			return new CustomerFeignClient() {

				@Override
				public String getCustomerSsn(String customerId) {
					return "error occured while returning ssn";
				}
				
			};
		}
	
	}
	
}
