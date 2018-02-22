package com.digid.bfsi.trainings.virtualbank.creditScore.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.digid.bfsi.trainings.virtualbank.creditScore.domain.CreditEvent;
import com.digid.bfsi.trainings.virtualbank.creditScore.exceptionhandling.EntityNotFoundException;
import com.digid.bfsi.trainings.virtualbank.creditScore.service.CreditScoreService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;

@RestController
@RequestMapping("/virtualbank/ssn/")
@Api(tags = { "Virtual Bank" })
@SwaggerDefinition(tags = { @Tag(name = "Virtual Bank", description = "API exposing the CreditScore resource") })
public class SsnController {
	// We're using Swagger-UI to test RestAPI functionality. To access Swagger
	// Dashboard go to:
	// http://localhost:8080/swagger-ui.html

	@Autowired
	CreditScoreService creditScoreService;

	@RequestMapping(method = RequestMethod.GET, value = "/{ssn}/creditscore")
	ResponseEntity<?> getSSN(@PathVariable String ssn) throws EntityNotFoundException {
		Integer score = creditScoreService.getScore(ssn);
		return new ResponseEntity<>(score, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/{ssn}/creditscore", produces = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value = "Add a credit event")
	ResponseEntity<?> addCreditEvent(@PathVariable String ssn, @RequestBody CreditEvent creditEvent) {
		creditEvent.setSsn(ssn);
		creditScoreService.addCreditEvent(creditEvent);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{ssn}/creditscore")
				.buildAndExpand(ssn).toUri();
		return ResponseEntity.created(location).build();
	}

}
