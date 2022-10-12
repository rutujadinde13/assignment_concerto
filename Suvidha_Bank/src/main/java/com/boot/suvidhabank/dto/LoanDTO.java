package com.boot.suvidhabank.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class LoanDTO {

	private String identity;
	private String type;
	private Double amount;
	private Double period;
	
	
}
