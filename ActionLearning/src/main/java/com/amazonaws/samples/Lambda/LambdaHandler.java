package com.amazonaws.samples.Lambda;

import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.samples.Application;
import com.amazonaws.samples.Customer.Customer;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.serverless.exceptions.ContainerInitializationException;
import com.amazonaws.serverless.proxy.model.AwsProxyRequest;
import com.amazonaws.serverless.proxy.model.AwsProxyResponse;
import com.amazonaws.serverless.proxy.spring.SpringBootLambdaContainerHandler;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.lambda.runtime.Context;

public class LambdaHandler implements RequestHandler<Request, Response> {

	
    @Override
    public Response handleRequest(Request input, Context context) {
    	// Connects with AWS
    	AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
		 		.withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration("dynamodb.us-east-2.amazonaws.com", "us-east-2"))	
				.build();  

	    DynamoDBMapper mapper = new DynamoDBMapper(client);
    	// Assigns the request components to variables that will be manipulated
		String firstName = input.getFirstName();	
		String lastName = input.getLastName();
		String phoneNumber = input.getPhoneNumber();
		String phoneCompany = input.getPhoneCompany();
		//Checks the last name and phone number to see whether customer exists in the current system
		Customer temp = mapper.load(Customer.class, lastName, phoneNumber);
		//Response being sent to user
    	String output = "Hello, " + firstName + " " + temp.getLastName()
  			  +" Your phone number is : " + temp.getPhoneNumber();
    	if(!phoneCompany.equals(temp.getPhoneCompany()))
    	{
    		output += " Your old company was :" + temp.getPhoneCompany();
    		temp.setPhoneCompany(phoneCompany);
    		mapper.save(temp);
    		output += " Your new phone company is : " + temp.getPhoneCompany();
    	}
    	else
    	{
    		output += " Your current phone company is still : " + temp.getPhoneCompany();
    	}
  			  Response a = new Response(output);
        // TODO: implement your handler
  	  return a;
    }

}