package com.boot.suvidhabank.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.boot.suvidhabank.entity.Collateral;
import com.boot.suvidhabank.repository.CollateralRepo;
import com.boot.suvidhabank.service.LoanService;

@RestController
public class CollateralController
{

	@Autowired
	private LoanService loanService;
	
	@Autowired
	private CollateralRepo collateralRepo;
	
	
	@PostMapping("/collat/{customerId}")
	public boolean addCollat(@RequestBody Collateral collateral,@PathVariable String customerId) {
		this.collateralRepo.save(collateral);
		return this.loanService.updateLoan(customerId);
		
	}
}
