package com.amazonaws.samples;

/*
 * Request object format that is sent in from Lambda
 */
public class Request {
    String firstName;
    String lastName;
    String phoneNumber;
    String phoneCompany;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    public String getPhoneCompany(){
    	return phoneCompany;
    }
    
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    public void setPhoneCompany(String phoneCompany){
    	this.phoneCompany = phoneCompany;
    }
    
    public Request(String firstName, String lastName, String phoneNumber, String phoneCompany) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.phoneCompany = phoneCompany;
    }

    public Request() {
    }
}