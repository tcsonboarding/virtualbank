package com.digid.bfsi.trainings.virtualbank.customers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.digid.bfsi.trainings.virtualbank.customers.exceptionhandling.EntityNotFoundException;

@RestController
@RequestMapping("/virtualbank/")
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@RequestMapping(method = RequestMethod.GET, value = "/customers")
	ResponseEntity<?> getCustomers() {
		List<Customer> customers = new ArrayList<>();
		for (Customer c : customerService.findAll()) {
			customers.add(c);

		}
		return new ResponseEntity<>(customers, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/customer/{customerId}")
	ResponseEntity<?> getCustomer(@PathVariable Long customerId) throws EntityNotFoundException {
		Customer c = customerService.findById(customerId);
		return new ResponseEntity<>(c, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/customers/")
	ResponseEntity<?> addCustomer(@RequestBody Customer aCustomer) {
		customerService.addCustomer(aCustomer);
		return null;
	}
}