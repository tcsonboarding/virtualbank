package com.digid.bfsi.trainings.virtualbank.customers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digid.bfsi.trainings.virtualbank.customers.exceptionhandling.EntityNotFoundException;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepo custRepo;

	public List<Customer> findAll() {
		return (List<Customer>) custRepo.findAll();
	}

	public Customer findById(Long anId) throws EntityNotFoundException {
		Customer c = custRepo.findOne(anId);
		if (c == null) {
			throw new EntityNotFoundException(Customer.class, "id", anId.toString());
		}
		return c;
	}

	public Customer addCustomer(Customer aCustomer) {
		custRepo.save(aCustomer);
		return aCustomer;
	}
}