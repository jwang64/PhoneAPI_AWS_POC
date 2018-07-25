package com.amazonaws.samples.login;

import java.util.Iterator;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.ItemCollection;
import com.amazonaws.services.dynamodbv2.document.ScanOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.spec.ScanSpec;
import com.amazonaws.services.dynamodbv2.document.utils.NameMap;
import com.amazonaws.services.dynamodbv2.document.utils.ValueMap;

public class login {

    public static void main(String[] args) throws Exception{

        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
            .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration("dynamodb.us-east-1.amazonaws.com", "us-east-1"))
            .build();

        DynamoDB dynamoDB = new DynamoDB(client);

        Table table = dynamoDB.getTable("PhoneCustomer");
        String variable = "AT&T";
     /*   ScanSpec scanSpec = new ScanSpec().withProjectionExpression("phoneCompany, phoneNumber")
            .withFilterExpression("phoneCompany = :v_phoneCompany")
            .withValueMap(new ValueMap().withString(":v_phoneCompany", "AT&T"));
 */
        ScanSpec scanSpec = new ScanSpec().withProjectionExpression("PhoneCompany, PhoneNumber, FirstName, LastName")
        		.withFilterExpression("PhoneCompany = :v_phoneCompany")
        		.withValueMap(new ValueMap().withString(":v_phoneCompany", variable));
        try {
            ItemCollection<ScanOutcome> items = table.scan(scanSpec);
            
            Iterator<Item> iter = items.iterator();
            
            while (iter.hasNext()) {
                Item item = iter.next();
                System.out.println(item);
            }

        }
        catch (Exception e) {
            System.err.println("Unable to scan the table:");
            System.err.println(e.getMessage());
        }
    }
}