package com.boot.suvidhabank.repository;

import org.springframework.data.repository.CrudRepository;

import com.boot.suvidhabank.entity.Customer;

public interface CustomerRepo extends CrudRepository<Customer, String>{

}
