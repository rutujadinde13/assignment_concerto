package com.boot.suvidhabank.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.boot.suvidhabank.entity.Customer;
import com.boot.suvidhabank.service.CustomerService;


@RestController
public class CustomerController 
{
	
	@Autowired
	private CustomerService customerService;
	
	
	@GetMapping("/suvidha_bank")
	public String home() {
		return "home";
	}
	
	@PostMapping("/customer")
	public boolean addCustomer(@RequestBody Customer customer) {
		return this.customerService.addCustomer(customer);
	}
	
	@GetMapping("/customer/{id}")
	public Customer getCustomerById(@PathVariable String id) {
		System.out.println(id);
	return this.customerService.findCustomerById(id);
	}
}
