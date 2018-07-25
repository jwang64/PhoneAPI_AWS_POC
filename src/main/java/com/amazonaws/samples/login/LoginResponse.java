package com.amazonaws.samples.login;

import java.util.ArrayList;

import com.amazonaws.services.dynamodbv2.document.Item;

public class LoginResponse {
	ArrayList<Item> response;
	
    public ArrayList<Item> getResponse() {

    	return response;
    }
    
    public void setResponse(ArrayList<Item> response)
    {
    	this.response = response;
    }

    public LoginResponse(ArrayList<Item> item)
    {
    	this.response = item;
    }

    public LoginResponse() {
    }
}
