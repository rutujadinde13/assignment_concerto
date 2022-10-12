package com.boot.suvidhabank.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.suvidhabank.entity.Collateral;
import com.boot.suvidhabank.entity.Customer;
import com.boot.suvidhabank.entity.Employee;
import com.boot.suvidhabank.entity.Loan;
import com.boot.suvidhabank.repository.CustomerRepo;
import com.boot.suvidhabank.repository.EmployeeRepo;
import com.boot.suvidhabank.repository.LoanRepo;

@Service
public class LoanService {
	
	@Autowired
	private LoanRepo loanRepo;

	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private EmployeeRepo employeeRepo;
	
	@Autowired
	private CustomerRepo customerRepo;
	
	
	public Loan findLoanById(String loanId)
	{
		Optional<Loan> opt=this.loanRepo.findById(loanId);
		return opt.orElseThrow(()-> new EntityNotFoundException("Loan Not Found"));
	}
	
	public List<Loan> getLoanByEmployeeId(String empId) {
		return this.loanRepo.searchEmployee(empId);
	}
	
	
	public Employee getEmployeeById(String empId) {
		return this.employeeRepo.findById(empId).get();
	}
	
	
	public static int generate(int min, int max) {
		return min + (int) (Math.random() * ((max - min) + 1));
	}
	
	public Loan applyForLoan(String loanType,double loanAmount,double period,String customerIdentity) throws Exception
	{
		Loan applyLoan=new Loan();
		applyLoan.setLoanAmount(loanAmount);
		int randomId=generate(10,300);
		applyLoan.setLoanId(randomId+" ");
		applyLoan.setLoanType(loanType);
		applyLoan.setPeriod(period);
		String s=Integer.valueOf(generate(111, 119)).toString();
		applyLoan.setInterestRate(Loan.calculateInterest(period));
		
		
		applyLoan.setEmployee(getEmployeeById(s));
		applyLoan.setLoanType(loanType);
		applyLoan.setLoanAmount(loanAmount);
		applyLoan.setPeriod(period);
		applyLoan.setCustomer(this.customerRepo.findById(customerIdentity).get());
		
		
		this.loanRepo.save(applyLoan);
		System.out.println(s);
		this.employeeService.approveLoan(s);
		
		return applyLoan;
		
	}
	
	public boolean updateLoan(String customerId)
	{
		
		Customer c=this.customerRepo.findById(customerId).get();			
		String loanid=c.getLoan().getLoanId();
		Loan loanRemark=this.loanRepo.findById(loanid).get();
		loanRemark.setRemarks("Approved");
		this.loanRepo.save(loanRemark);
		return true;
	
      }
	
	public boolean uploadCollateral(String loanId,List<Collateral> collateral)
	{
		if (collateral.size() > 0)
		{
		  return true;
		}
		return false;
	}
}
