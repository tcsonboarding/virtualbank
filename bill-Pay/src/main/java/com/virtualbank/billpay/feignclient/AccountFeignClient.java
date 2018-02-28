package com.virtualbank.billpay.feignclient;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.virtualbank.billpay.config.FeignConfiguration;
import com.virtualbank.billpay.feignclient.CustomerFeignClient.HystrixClientFallbackFacrory;

import feign.hystrix.FallbackFactory;

@FeignClient(name="AccountService", configuration = FeignConfiguration.class, fallbackFactory = HystrixClientFallbackFacrory.class)
public interface AccountFeignClient {
	@RequestMapping(value = "accounts/{account}", method=RequestMethod.PATCH)
	public String updateAccount(float debit);
	
	@Component
	static class HystrixClientFallbackFacrory implements FallbackFactory<AccountFeignClient>{

		@Override
		public AccountFeignClient create(Throwable arg0) {
			return new AccountFeignClient() {

				@Override
				public String updateAccount(float debit) {
					return "error occured while returning ssn";
				}
				
			};
		}
	
	}
}
