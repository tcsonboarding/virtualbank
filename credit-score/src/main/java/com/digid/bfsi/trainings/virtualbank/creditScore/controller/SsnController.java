package com.digid.bfsi.trainings.virtualbank.creditScore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.digid.bfsi.trainings.virtualbank.creditScore.domain.CreditScore;
import com.digid.bfsi.trainings.virtualbank.creditScore.exceptionhandling.EntityNotFoundException;
import com.digid.bfsi.trainings.virtualbank.creditScore.service.CreditScoreService;

@RestController
@RequestMapping("/virtualbank/ssn/")
public class SsnController {

	@Autowired
	CreditScoreService creditScoreService;

	@RequestMapping(method = RequestMethod.GET, value = "/{ssn}/creditscore")
	ResponseEntity<?> getSSN(@PathVariable String ssn) throws EntityNotFoundException {
		CreditScore score = creditScoreService.findBySsn(ssn);
		return new ResponseEntity<>(score, HttpStatus.OK);
	}
}
