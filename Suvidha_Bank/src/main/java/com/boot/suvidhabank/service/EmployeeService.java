package com.boot.suvidhabank.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.suvidhabank.entity.Customer;
import com.boot.suvidhabank.entity.Employee;
import com.boot.suvidhabank.entity.Loan;
import com.boot.suvidhabank.repository.EmployeeRepo;
import com.boot.suvidhabank.repository.LoanRepo;

@Service
public class EmployeeService
{

	@Autowired
	private EmployeeRepo employeeRepo;
	
	@Autowired
	private LoanRepo loanRepo;
	
	public boolean searchEmployeeById(String employeeId)
	{
		if(this.employeeRepo.existsById(employeeId))
			return true;
		
		return false;
	}
	
	
	public boolean addEmployee(Employee employee)
	{
		if(!this.employeeRepo.existsById(employee.getEmployeeId()))
		{
			this.employeeRepo.save(employee);
			return true;
		}
		return false;
	}
	
	
	public void approveLoan(String empId) throws Exception
	{
		if(this.searchEmployeeById(empId))
		{
			List<Loan> loans =null;
			loans=this.loanRepo.searchEmployee(empId);
			System.out.println(loans);
			if(loans.size()>0)
			{
				for(Loan loan:loans)
				{
					Customer customer=loan.getCustomer();
					
					if(loan.getLoanAmount()>(10*customer.getAnnualIncome()))
					{
						loan.setRemarks("Loan amount cannot be 10 times of annual income");
						loan.setApproved(false);
						this.loanRepo.save(loan);
					}
					else if(!customer.isIncomeTaxReturnAttached())
					{
						loan.setRemarks( "Income proof not attached");
						loan.setApproved(false);
						this.loanRepo.save(loan);
					}
					else if(customer.getCustomerIdentity() == null) 
					{
						loan.setRemarks( "Identity document not submitted");
						loan.setApproved(false);
						this.loanRepo.save(loan);	
					}
					else if(loan.getCollateral() == null || loan.getCollateral().size() == 0)
					{
						loan.setRemarks( "No collateral submitted");
				   	    loan.setApproved(false);
						this.loanRepo.save(loan);		
					}
					else
					{
						loan.setRemarks( "Approved");
						loan.setApproved(true);
						this.loanRepo.save(loan);
					}
				}
			}
			else
			{
				throw new Exception("No loan proposals against this employee id");
			}
		/*
		 * if(customer.getAnnualIncome()*10<loan.getLoanAmount()&&
		 * loan.getCollateral().size()>0 && customer.isIncomeTaxReturnAttached()==true
		 * && customer.getCustomerIdentity()!=null) { loan.setApproved(true); }
		 * loan.setApproved(false);
		 */
		}
		else
		{
			throw new EntityNotFoundException("Employee does not exist");
		}
	}
}
