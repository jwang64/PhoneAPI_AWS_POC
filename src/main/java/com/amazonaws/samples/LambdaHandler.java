package com.amazonaws.samples;

import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.lambda.runtime.Context; 

public class LambdaHandler implements RequestHandler<Request, Response> {

	
    @Override
    public Response handleRequest(Request input, Context context) {
    	
    	AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
		 		.withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration("dynamodb.us-east-2.amazonaws.com", "us-east-2"))	
				.build();  

	    DynamoDBMapper mapper = new DynamoDBMapper(client);
    	
		String firstName = input.getFirstName();
		String lastName = input.getLastName();
		String phoneNumber = input.getPhoneNumber();
		String phoneCompany = input.getPhoneCompany();
		
		Customer temp = mapper.load(Customer.class, lastName, phoneNumber);
		
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