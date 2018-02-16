package com.digid.bfsi.trainings.virtualbank.customers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CustomerApplication {

	private static final Logger log = LoggerFactory.getLogger(CustomerApplication.class);

	@Autowired
	CustomerRepo repository;

	public static void main(String[] args) {
		log.info("Started Customer MicroService");
		SpringApplication.run(CustomerApplication.class, args);
	}
}
