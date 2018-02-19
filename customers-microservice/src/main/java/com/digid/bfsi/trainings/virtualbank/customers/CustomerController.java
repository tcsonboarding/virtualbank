package com.digid.bfsi.trainings.virtualbank.customers;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

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

import com.digid.bfsi.trainings.virtualbank.customers.exceptionhandling.EntityNotFoundException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;

@RestController
@RequestMapping("/virtualbank/")
@Api(tags = { "Virtual Bank" })
@SwaggerDefinition(tags = { @Tag(name = "Virtual Bank", description = "API exposing the Customer resource") })
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@ApiOperation(value = "Get all customers", response = Customer.class, responseContainer = "List")
	@RequestMapping(method = RequestMethod.GET, value = "/customers")
	ResponseEntity<?> getCustomers() {
		List<Customer> customers = new ArrayList<>();
		for (Customer c : customerService.findAll()) {
			customers.add(c);

		}
		return new ResponseEntity<>(customers, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/customer/{customerId}")
	@ApiOperation(value = "Get a customer passing an id", response = Customer.class)
	ResponseEntity<?> getCustomer(@PathVariable Long customerId) throws EntityNotFoundException {
		Customer c = customerService.findById(customerId);
		return new ResponseEntity<>(c, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/customers/", produces = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value = "Add a customer")
	ResponseEntity<?> addCustomer(@RequestBody Customer aCustomer) {
		Customer c = customerService.addCustomer(aCustomer);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(c.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
}