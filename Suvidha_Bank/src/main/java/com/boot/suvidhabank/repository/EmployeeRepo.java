package com.boot.suvidhabank.repository;

import org.springframework.data.repository.CrudRepository;

import com.boot.suvidhabank.entity.Employee;

public interface EmployeeRepo extends CrudRepository<Employee, String> {

}
