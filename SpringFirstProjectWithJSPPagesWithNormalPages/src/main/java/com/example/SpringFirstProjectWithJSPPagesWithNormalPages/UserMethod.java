package com.example.SpringFirstProjectWithJSPPagesWithNormalPages;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserMethod {

	
	Logger logger = LoggerFactory.getLogger(UserMethod.class);
	
	public String getName(String name) {
		System.out.println("Calling the getName method Okay");
		logger.info("Calling the getName method Okay");
		return name;
	}
}
