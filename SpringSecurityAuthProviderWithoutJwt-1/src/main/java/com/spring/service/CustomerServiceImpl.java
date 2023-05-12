package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.spring.exception.CustomerException;
import com.spring.model.Customer;
import com.spring.repository.CustomerRepository;

public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerRepository customerRepo;

	@Override
	public Customer registerCustomer(Customer customer) {
		
		return customerRepo.save(customer);

	}

	@Override
	public Customer getCustomerDetailsByEmail(String email) throws CustomerException {
		
		return customerRepo.findByEmail(email)
				.orElseThrow(() -> new CustomerException("Customer Not found with Email: "+email));	

	}

	@Override
	public List<Customer> getAllCustomerDetails() throws CustomerException {

			List<Customer> customers= customerRepo.findAll();
			
			if(customers.isEmpty())
				throw new CustomerException("No Customer find");
			
			return customers;
	}
	

}
