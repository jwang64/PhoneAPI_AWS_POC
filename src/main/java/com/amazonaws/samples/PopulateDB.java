package com.amazonaws.samples;

import javax.xml.transform.Result;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.amazonaws.client.builder.AwsClientBuilder;

public class PopulateDB {
	public static void main(String args[]) {
		
		AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
        		.withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration("http://localhost:8000", "us-west-2"))
        		.build();
		 DynamoDBMapper mapper = new DynamoDBMapper(client);
	      
	        //CreateTableRequest req = mapper.generateCreateTableRequest(Customer.class);
	        //req.setProvisionedThroughput(new ProvisionedThroughput(5L, 5L));
	        //client.createTable(req);
	        
		
		
		for (int n = 0; n <= 999; n++) 
		{
		
	        Customer keySchema = new Customer();
	        Random randGen = new Random();
	        
	        keySchema.setLastName(randGen.randomIdentifier());
	        String randomPhoneNumber = randGen.randomPhone1() + "-" + randGen.randomPhone1() + "-" + randGen.randomPhone2();
	        keySchema.setPhoneNumber(randomPhoneNumber);
	        keySchema.setPhoneCompany(randGen.randomCompany());
	        keySchema.setFirstName(randGen.randomIdentifier());
	        keySchema.setAccountNumber(Integer.toString(n + 1));
	        String randomAddress = randGen.randomAddrNum() + " " + randGen.randomAddrStreet() + " St.";
	        keySchema.setAddress(randomAddress);
	        keySchema.setZipCode(randGen.randomZipCode());
	        String randomSSN  = randGen.randomPhone1() + "-" + randGen.randomPhone3() + "-" + randGen.randomPhone2();
	        keySchema.setSSN(randomSSN);
	        String randomEmail = randGen.randomIdentifier() + randGen.randomEmailDomain();
	        keySchema.setEmail(randomEmail);
	        mapper.save(keySchema);
			
			
	      /*try {
	            Customer result = mapper.load(keySchema);
	            if (result != null) {
	                System.out.println(
	                "The customer's name is: " + result.getFirstName() +
	                "\nThe customer's phone number is: " + result.getPhoneNumber() +
	                "\nThe customer's phone company is: " + result.getPhoneCompany() +
	                "\nThe customer's account number is: " + result.getAccountNumber() +
	                "\nThe customer's address  is: " + result.getAddress() +
	                "\nThe customer's address  is: " + result.getZipCode() +
	                "\nThe customer's SSN  is: " + result.getSSN() +
	                "\nThe customer's email  is: " + result.getEmail()+
	                "\n "
	                		);
	            } else {
	                System.out.println("Empty Database");
	            }
	        } catch (Exception e) {
	            System.err.println("Unable to retrieve data: ");
	            System.err.println(e.getMessage());
	        }
		}*/
	} 
		


}
}
