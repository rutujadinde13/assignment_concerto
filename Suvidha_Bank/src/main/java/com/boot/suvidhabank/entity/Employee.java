package com.boot.suvidhabank.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor



@Entity
@Table(name="rutuja_bank_employee")
public class Employee {

	
	@Id
	private String employeeId;
	private String employeeName;

	@JsonIgnore
	@OneToOne(mappedBy = "employee")
	private Loan loan;
	
	
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + "]";
	}

}
