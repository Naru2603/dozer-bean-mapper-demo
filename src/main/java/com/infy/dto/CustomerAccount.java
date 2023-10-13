package com.infy.dto;

import org.dozer.Mapping;

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
public class CustomerAccount {

	

//	@Mapping("accNo")
	String customerAccountNumber;
	String name;
	
//	@Mapping("transferCode")
	int ifscCode;


	String accountOpeningDate;
	
	String countryCode;
}
