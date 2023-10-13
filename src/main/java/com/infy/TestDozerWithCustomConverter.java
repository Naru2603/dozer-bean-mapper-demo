package com.infy;

import java.util.Arrays;

import org.dozer.DozerBeanMapper;

import com.infy.dto.CustomerAccount;
import com.infy.dto.Destination;
import com.infy.model.Account;
import com.infy.model.Source;

public class TestDozerWithCustomConverter {
	
	public static void main(String[] args) {

		Account account = new Account();
		account.setAccNo("abc123");
		account.setName("Ram");
		account.setTransferCode(9999);
		account.setAccountOpeningDate(new Long("1696659549"));
		account.setCountryCode(80);
		
		
		DozerBeanMapper mapper = new DozerBeanMapper();

		mapper.setMappingFiles(Arrays.asList("dozer_mapping2.xml"));
		
//		mapper.addMapping(new CustomAccountDtoBuilder());
		
		CustomerAccount customerAccount = mapper.map(account, CustomerAccount.class);
		
		System.out.println(account);
		System.out.println("=================");
		System.out.println(customerAccount);
		
	}

}