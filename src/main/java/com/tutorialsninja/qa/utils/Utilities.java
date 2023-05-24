package com.tutorialsninja.qa.utils;

import java.util.Date;

public class Utilities {

	public static String generateEmailwithTimeStamp () {
		Date date = new Date();
		String timestamp = date.toString().replace(" ","_").replace(":","_");
		return "daminho"+timestamp+"@gmail.com";
				
		
	}

}
