package com.amazonaws.samples;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.amazonaws.client.builder.AwsClientBuilder;

public class PopulateDB {
	public static void main(String args[]) {
		
		int n = 1;
		
		while (n <= 100) //Exit when n is greater than 100 
		{
			AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
	        		.withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration("http://localhost:8000", "us-west-2"))
	        		.build();

	        DynamoDBMapper mapper = new DynamoDBMapper(client);
	        //CreateTableRequest req = mapper.generateCreateTableRequest(Customer.class);
	        //req.setProvisionedThroughput(new ProvisionedThroughput(5L, 5L));
	        //client.createTable(req);
	        
	        Customer keySchema = new Customer();
	        keySchema.setLastName("James Wong");
	        keySchema.setPhoneNumber("111-111-1111");
	        keySchema.setPhoneCompany("ATT");
	        keySchema.setFirstName("James");
	        keySchema.setAccountNumber("12345879");
	        keySchema.setAddress("Marietta, GA");
	        keySchema.setZipCode("30693");
	        keySchema.setSSN("123-45-6789");
	        keySchema.setEmail("james.wong@gmail.com");
	        mapper.save(keySchema);
			
			n++; //increment for next iteration
		
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
		


}
