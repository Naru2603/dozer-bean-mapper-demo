package com.infy;

import org.dozer.loader.api.BeanMappingBuilder;

import com.infy.dto.CustomerAccount;
import com.infy.model.Account;

public class CustomAccountDtoBuilder extends BeanMappingBuilder{

	@Override
	protected void configure() {
		
		mapping(Account.class, CustomerAccount.class)
		.fields("accNo", "customerAccountNumber")
		.fields("transferCode", "ifscCode");
		
	}
	
	

}