package com.boot.suvidhabank.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.boot.suvidhabank.dto.LoanDTO;
import com.boot.suvidhabank.entity.Loan;
import com.boot.suvidhabank.service.LoanService;

@RestController
public class LoanController {

	@Autowired
	private LoanService loanService;
	
	@PostMapping("/loan")
	public Loan applyForLoan(@RequestBody LoanDTO loandto) throws Exception 
	{	
		System.out.println("Calling loan method from controller");
		return this.loanService.applyForLoan(loandto.getType(), loandto.getAmount(),loandto.getPeriod(), loandto.getIdentity());

	}
}
