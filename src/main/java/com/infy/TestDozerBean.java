package com.infy;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import com.infy.dto.Destination;
import com.infy.model.Source;

public class TestDozerBean {

	public static void main(String[] args) {
		
		Source source = new Source();
		
		source.setId("45");
		source.setPoint(20.02);
		
		Destination destination = new Destination();
		
		DozerBeanMapper mapper = new DozerBeanMapper();
		
		destination = mapper.map(source, Destination.class);
		
		System.out.println("Source :"+source);
		
		System.out.println("Source :"+destination);

	}

}
