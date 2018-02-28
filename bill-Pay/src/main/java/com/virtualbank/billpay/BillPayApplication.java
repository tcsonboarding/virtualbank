package com.virtualbank.billpay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
@EnableFeignClients(basePackages= {"com.virtualbank.billpay"})
@SpringBootApplication
public class BillPayApplication {

	public static void main(String[] args) {
		SpringApplication.run(BillPayApplication.class, args);
	}
}
