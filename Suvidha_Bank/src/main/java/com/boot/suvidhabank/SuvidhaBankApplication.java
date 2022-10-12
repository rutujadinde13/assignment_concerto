package com.boot.suvidhabank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.boot.suvidhabank.entity.Collateral;
import com.boot.suvidhabank.entity.Customer;
import com.boot.suvidhabank.entity.Employee;
import com.boot.suvidhabank.entity.Loan;
import com.boot.suvidhabank.repository.LoanRepo;
import com.boot.suvidhabank.service.EmployeeService;

@SpringBootApplication
public class SuvidhaBankApplication 
{

	@Autowired
	private LoanRepo loanRepo;
	
	@Autowired
	private EmployeeService employeeService;
	
	
	public static void main(String[] args)
	{
		SpringApplication.run(SuvidhaBankApplication.class, args);
	}

	//@Bean
	public void startup()
	{
		
		//Customer Data
		Customer customerdata=new Customer();
		customerdata.setCustomerIdentity("1234");
		customerdata.setCustomerAddress("Parel");
		customerdata.setEmailId("rutuja@123");
		customerdata.setAnnualIncome(400000.0);
		customerdata.setIncomeTaxReturnAttached(true);
		
		
		//Loan Data
		Loan loandata=new Loan();
		loandata.setLoanId("101");
		loandata.setLoanType("Buying car");
		loandata.setLoanAmount(20000.0);
		loandata.setInterestRate(400.0);
		loandata.setPeriod(3.0);
		loandata.setRemarks("Well Cooperated");
		loandata.setCustomer(customerdata);
		
		//Collateral Data
		Collateral collateraldata=new Collateral();
		collateraldata.setCollateralId("2001");
		collateraldata.setCollateralType("Vehicle");
		
		Collateral collateraldata1=new Collateral();
		collateraldata1.setCollateralId("2002");
		collateraldata1.setCollateralType("Fixed Deposit");

		//Employee Data
		for(int i=11;i<30;i++) 
		{
			Employee employeedata=new Employee();
			employeedata.setEmployeeId(""+i);
			employeedata.setEmployeeName("Employee"+i);
			this.employeeService.addEmployee(employeedata);
		}
		
//		List<Collateral> list=Arrays.asList(collateraldata,collateraldata1);
		
		
     	this.loanRepo.save(loandata);
		
	}
}
