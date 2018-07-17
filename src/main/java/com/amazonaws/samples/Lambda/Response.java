package com.amazonaws.samples.Lambda;

/*
 * Formatting for the response that will be given
 */
public class Response {
	String response;
	
    public String getResponse() {

    	return response;
    }
    
    public void setResponse(String response)
    {
    	this.response = response;
    }

    public Response(String response)
    {
    	this.response = response;
    }

    public Response() {
    }
}