package com.boot.suvidhabank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.boot.suvidhabank.entity.Loan;

public interface LoanRepo extends CrudRepository<Loan, String>{

	@Query(value="select * from rutuja_bank_loan where employee_Id=:empId",nativeQuery = true)
	public List<Loan> searchEmployee(String empId);
}
