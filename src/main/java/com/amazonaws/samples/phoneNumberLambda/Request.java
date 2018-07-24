package com.amazonaws.samples.phoneNumberLambda;

public class Request {
	String phoneNumber;
	
	  public String getPhoneNumber() {
	        return phoneNumber;
	    }
	  
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
  
    
    public Request(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Request() {
    }
} 