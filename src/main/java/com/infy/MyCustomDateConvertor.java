package com.infy;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.dozer.CustomConverter;

import com.infy.dto.CustomerAccount;
import com.infy.model.Account;
import com.infy.util.ConverterUtil;

public class MyCustomDateConvertor implements CustomConverter{

    public Object convert(Object dest, Object source, Class<?> arg2, Class<?> arg3) {
        if (source == null) 
            return null;
        
        if (source instanceof Account) {
        	Account acc = (Account) source;
        	//logic toconvert epoch into Java Date - in string format
            Date date = new Date(acc.getAccountOpeningDate() * 1000);
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
            String isoDate = format.format(date);
            
            String countryCode = getCountryCode(acc.getCountryCode());
            return new CustomerAccount(acc.getAccNo(),acc.getName(),acc.getTransferCode(), isoDate, countryCode);

        }else if (source instanceof CustomerAccount) {
        	CustomerAccount custAcc = (CustomerAccount) source;
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
            Date date = null;
			try {
				date = format.parse(custAcc.getAccountOpeningDate());
			} catch (ParseException e) {
				System.out.println("Error while parsing the date!!!");
				e.printStackTrace();
			}
            long timestamp = date.getTime();
            int cc = 0;
            return new Account(custAcc.getCustomerAccountNumber(),custAcc.getName(), custAcc.getIfscCode(), timestamp, cc);
        }else
		return null; 
        
    }

	private String getCountryCode(int countryCode) {
		
		return ConverterUtil.getCountryCode().get(countryCode);
	}
}
