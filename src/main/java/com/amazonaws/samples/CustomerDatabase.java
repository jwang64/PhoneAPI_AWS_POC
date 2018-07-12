package com.amazonaws.samples;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;

public class CustomerDatabase {
	 public static void main(String[] args) {
		 
	        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
	        		.withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration("http://localhost:8000", "us-west-2"))
	        		.build();

	        DynamoDBMapper mapper = new DynamoDBMapper(client);
	        CreateTableRequest req = mapper.generateCreateTableRequest(Customer.class);
	        req.setProvisionedThroughput(new ProvisionedThroughput(5L, 5L));
	        client.createTable(req);
	        
	        Customer keySchema = new Customer();
	        keySchema.setLastName("Sheuuu");
	        keySchema.setPhoneNumber("123-456-7890");
	        keySchema.setPhoneCompany("T-Mobile");
	        keySchema.setFirstName("Brandon");
	        keySchema.setAccountNumber("1");
	        keySchema.setAddress("100 Midtown");
	        keySchema.setZipCode("30603");
	        keySchema.setSSN("123-45-6789");
	        keySchema.setEmail("brandon.Asheu@gmail.com");
	        mapper.save(keySchema);
	        
	        try {
	            Customer result = mapper.load(keySchema);
	            if (result != null) {
	                System.out.println(
	                "The customer's name is: " + result.getLastName() +
	                "\nThe customer's phone number is: " + result.getPhoneNumber() +
	                "\nThe customer's phone company is: " + result.getPhoneCompany()
	                		);
	            } else {
	                System.out.println("Empty Database");
	            }
	        } catch (Exception e) {
	            System.err.println("Unable to retrieve data: ");
	            System.err.println(e.getMessage());
	        }
}
	 
}
