package com.example.demo.Service.FeignClients;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.Config.FeignConfiguration;
import com.example.demo.Service.FeignClients.CustomerFeignClient.HystrixClientFallbackFacrory;
//the name of their microservice

import feign.hystrix.FallbackFactory;

@FeignClient(name="CreditScoreService", configuration = FeignConfiguration.class, fallbackFactory = HystrixClientFallbackFacrory.class)
public interface CreditScoreFeignClient {
	@RequestMapping(value = "ssn/{ssn}/creditScore", method=RequestMethod.GET)
	public String getCreditScore(String ssn);
	
	@Component
	static class HystrixClientFallbackFacrory implements FallbackFactory<CreditScoreFeignClient>{

		@Override
		public CreditScoreFeignClient create(Throwable arg0) {
			// TODO Auto-generated method stub
			return new CreditScoreFeignClient() {

				@Override
				public String getCreditScore(String creditScore) {
					// TODO Auto-generated method stub
					return "error getting ssn from";
				}
				
			};
		}
		
	}
}
