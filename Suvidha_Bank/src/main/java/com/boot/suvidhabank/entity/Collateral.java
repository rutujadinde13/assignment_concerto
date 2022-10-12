package com.boot.suvidhabank.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString


@Entity
@Table(name="rutuja_bank_collateral")
public class Collateral {

	@Id
	private String collateralId;
	private String collateralType;
	private String loanId;
}
