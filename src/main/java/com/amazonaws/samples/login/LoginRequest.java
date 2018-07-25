package com.amazonaws.samples.login;

public class LoginRequest {
	String phoneCompany;
	
	public String getPhoneCompany()
	{
		return phoneCompany;
	}
	
	public void setPhoneCompany(String phoneCompany)
	{
		this.phoneCompany = phoneCompany;
	}
	
	public LoginRequest()
	{
		
	}
	
	public LoginRequest(String phoneCompany)
	{
		this.phoneCompany = phoneCompany;
	}
	
}
