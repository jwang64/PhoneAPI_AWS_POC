package com.amazonaws.samples.login;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.samples.Lambda.Request;
import com.amazonaws.samples.Lambda.Response;
import com.amazonaws.samples.model.Customer;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.ItemCollection;
import com.amazonaws.services.dynamodbv2.document.ScanOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.spec.ScanSpec;
import com.amazonaws.services.dynamodbv2.document.utils.ValueMap;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class LoginHandler implements RequestHandler<LoginRequest, LoginResponse> {

	
    @Override
    public LoginResponse handleRequest(LoginRequest input, Context context) {
    	// Connects with AWS
    	AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
		 		.withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration("dynamodb.us-east-1.amazonaws.com", "us-east-1"))	
				.build();  
        DynamoDB dynamoDB = new DynamoDB(client);

        Table table = dynamoDB.getTable("TestTable2");
    	// Assigns the request components to variables that will be manipulated
		String phoneCompany = input.getPhoneCompany();
        ScanSpec scanSpec = new ScanSpec().withProjectionExpression("PhoneCompany, PhoneNumber, FirstName, LastName")
        		.withFilterExpression("PhoneCompany = :v_phoneCompany")
        		.withValueMap(new ValueMap().withString(":v_phoneCompany", phoneCompany));
            ItemCollection<ScanOutcome> items = table.scan(scanSpec);
     
            Iterator<Item> iter = items.iterator();
            List<Item> list = new ArrayList<>();
            iter.forEachRemaining(list::add);
            LoginResponse data = new LoginResponse((ArrayList<Item>) list);

            while (iter.hasNext()) {
            	int i = 0;
            	
               // Item item = iter.next();
               // System.out.println("Database");
               // LoginResponse data = new LoginResponse(item);
               // return data;
            	System.out.println(list.get(i));
            	i++;
            	System.out.println("Hello");
            	
            }
            return data;
		/*
    	String output = "Your phone number is : " + temp.getPhoneNumber() + "\nYour phone company is" + temp.getPhoneCompany();
  			  Response a = new Response(output);
        // TODO: implement your handler
  	  return a;*/
    }
}