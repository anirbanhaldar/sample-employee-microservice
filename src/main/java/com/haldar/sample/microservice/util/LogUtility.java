package com.haldar.sample.microservice.util;

public class LogUtility {
	  
	 private LogUtility(){
		 
	 }
	public static String getCurrentMethodName() {
       return Thread.currentThread().getStackTrace()[2].getClassName() + "." + Thread.currentThread().getStackTrace()[2].getMethodName();
   }
	
}
