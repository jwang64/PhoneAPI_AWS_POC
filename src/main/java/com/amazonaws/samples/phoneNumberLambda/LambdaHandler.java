package com.amazonaws.samples.phoneNumberLambda;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.samples.Lambda.Request;
import com.amazonaws.samples.Lambda.Response;
import com.amazonaws.samples.model.Customer;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class LambdaHandler implements RequestHandler<Request, Response> {

	
    @Override
    public Response handleRequest(Request input, Context context) {
    	// Connects with AWS
    	AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
		 		.withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration("dynamodb.us-east-2.amazonaws.com", "us-east-2"))	
				.build();  

	    DynamoDBMapper mapper = new DynamoDBMapper(client);
    	// Assigns the request components to variables that will be manipulated
		String phoneNumber = input.getPhoneNumber();
		//Checks the last name and phone number to see whether customer exists in the current system
		Customer temp = mapper.load(Customer.class, phoneNumber);
		//Response being sent to user
    	String output = "Your phone number is : " + temp.getPhoneNumber() + "\nYour phone company is" + temp.getPhoneCompany();
  			  Response a = new Response(output);
        // TODO: implement your handler
  	  return a;
    }

}