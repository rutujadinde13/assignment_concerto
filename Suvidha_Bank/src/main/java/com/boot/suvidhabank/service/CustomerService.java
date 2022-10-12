package com.boot.suvidhabank.service;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.suvidhabank.entity.Customer;
import com.boot.suvidhabank.repository.CustomerRepo;


@Service
public class CustomerService {

	@Autowired
	private CustomerRepo customerRepo;
	
	public Customer findCustomerById(String customerIdentity)
	{
		Optional<Customer> opt=this.customerRepo.findById(customerIdentity);
		return opt.orElseThrow(()-> new EntityNotFoundException("Customer Not Found"));
	}
	
	public boolean addCustomer(Customer customer)
	{
		if(!this.customerRepo.existsById(customer.getCustomerIdentity()))
		{
			this.customerRepo.save(customer);
			return true;
		}
		return false;
	}
}
