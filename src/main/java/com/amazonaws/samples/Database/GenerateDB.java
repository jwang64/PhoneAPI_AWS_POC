package com.amazonaws.samples.Database;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.samples.model.Customer;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;

public class GenerateDB {
	public static void main(String[] args)
	{
		//Initial setup for the database. Connects with AWS and sends a table creation request
		AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
		 		.withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration("dynamodb.us-east-2.amazonaws.com", "us-east-2"))	
				.build(); 
		 DynamoDBMapper mapper = new DynamoDBMapper(client);
		 
	     CreateTableRequest req = mapper.generateCreateTableRequest(Customer.class);
	     req.setProvisionedThroughput(new ProvisionedThroughput(5L, 5L));
	     client.createTable(req);
	}
}
