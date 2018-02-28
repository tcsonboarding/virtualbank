package com.virtualbank.billpay.feignclient;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.virtualbank.billpay.config.FeignConfiguration;
import com.virtualbank.billpay.feignclient.UpdateCreditScoreFeignClient.HystrixClientFallbackFacrory;

import feign.hystrix.FallbackFactory;

@FeignClient(name = "CreditScoreService", configuration = FeignConfiguration.class, fallbackFactory = HystrixClientFallbackFacrory.class)
public interface UpdateCreditScoreFeignClient {
	@RequestMapping(value = "ssn/{ssn}/creditScore", method = RequestMethod.PUT)
	public String updateCreditScore(String ssn, int score);

	@Component
	static class HystrixClientFallbackFacrory implements FallbackFactory<UpdateCreditScoreFeignClient> {

		@Override
		public UpdateCreditScoreFeignClient create(Throwable arg0) {
			// TODO Auto-generated method stub
			return new UpdateCreditScoreFeignClient() {

				@Override
				public String updateCreditScore(String ssn, int score) {
					// TODO Auto-generated method stub
					return "error getting ssn from";
				}
				
			};
		}
	}
}

