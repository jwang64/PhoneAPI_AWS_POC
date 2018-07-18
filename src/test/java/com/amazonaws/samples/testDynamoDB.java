package com.amazonaws.samples;

import static org.junit.Assert.*;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.samples.model.Customer;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.AttributeDefinition;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.CreateTableResult;
import com.amazonaws.services.dynamodbv2.model.KeySchemaElement;
import com.amazonaws.services.dynamodbv2.model.KeyType;
import com.amazonaws.services.dynamodbv2.model.ListTablesResult;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.amazonaws.services.dynamodbv2.model.ScalarAttributeType;
import com.amazonaws.services.dynamodbv2.model.TableDescription;

public class testDynamoDB {
 	AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
	 		.withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration("dynamodb.us-east-2.amazonaws.com", "us-east-2"))	
			.build();  

        DynamoDBMapper mapper = new DynamoDBMapper(client);
	@Test
	public void createTableTest() {
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
	        Customer testing = mapper.load(Customer.class, "Sheuuu" , "123-456-7890");
	        boolean isNotNull = testing != null; 
	        assertEquals( true, isNotNull);
			
	
	}
	}