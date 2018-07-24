package com.amazonaws.samples.Database;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.samples.Random;
import com.amazonaws.samples.model.Customer;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

public class PopulateDB {
	
    static int accountNumberCount = 0;
	
    // This will randomly generate a Customer object with a name, number
    // company, account number, address, zipcode, ssn, email
	public static Customer generateData()
	{
		
	    Customer keySchema = new Customer();
	    Random randGen = new Random();
	    keySchema.setLastName(randGen.randomIdentifier());
	    String randomPhoneNumber = randGen.randomPhone1() + "-" + randGen.randomPhone1() + "-" + randGen.randomPhone2();
	    keySchema.setPhoneNumber(randomPhoneNumber);
	    keySchema.setPhoneCompany(randGen.randomCompany());
	    keySchema.setFirstName(randGen.randomIdentifier());
	    keySchema.setAccountNumber(Integer.toString(accountNumberCount + 1));
	    String randomAddress = randGen.randomAddrNum() + " " + randGen.randomAddrStreet() + " St.";
	    keySchema.setAddress(randomAddress);
	    keySchema.setZipCode(randGen.randomZipCode());
	    String randomSSN  = randGen.randomPhone1() + "-" + randGen.randomPhone3() + "-" + randGen.randomPhone2();
	    keySchema.setSSN(randomSSN);
	    String randomEmail = randGen.randomIdentifier() + randGen.randomEmailDomain();
	    keySchema.setEmail(randomEmail);
	    accountNumberCount++;
	    return keySchema;

	}
	
	public static void main(String args[]) {
		//Connects w/ DynamoDB and then saves the generated data into the database
		AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
		 		.withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration("dynamodb.us-east-1.amazonaws.com", "us-east-1"))	
				.build(); 
		 DynamoDBMapper mapper = new DynamoDBMapper(client);
			for (int n = 0; n <= 999; n++) 
			{
				mapper.save(generateData());
			} 

	}
}
