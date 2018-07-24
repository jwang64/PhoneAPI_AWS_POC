package com.amazonaws.samples.Lambda;

import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.serverless.exceptions.ContainerInitializationException;
import com.amazonaws.serverless.proxy.model.AwsProxyRequest;
import com.amazonaws.serverless.proxy.model.AwsProxyResponse;
import com.amazonaws.serverless.proxy.spring.SpringBootLambdaContainerHandler;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.regions.Regions;
import com.amazonaws.samples.Lambda.LambdaHandler;
import com.amazonaws.samples.model.Customer;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.model.Body;
import com.amazonaws.services.simpleemail.model.Content;
import com.amazonaws.services.simpleemail.model.Destination;
import com.amazonaws.services.simpleemail.model.Message;
import com.amazonaws.services.simpleemail.model.SendEmailRequest; 

public class LambdaHandler implements RequestHandler<Request, Response> {

	
    @Override
    public Response handleRequest(Request input, Context context) {
    	// Connects with AWS
    	AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
		 		.withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration("dynamodb.us-east-1.amazonaws.com", "us-east-1"))	
				.build();  

	    DynamoDBMapper mapper = new DynamoDBMapper(client);
    	// Assigns the request components to variables that will be manipulated
		String firstName = input.getFirstName();	
		String lastName = input.getLastName();
		String phoneNumber = input.getPhoneNumber();
		String phoneCompany = input.getPhoneCompany();
		//Checks the last name and phone number to see whether customer exists in the current system
		Customer temp = mapper.load(Customer.class, phoneNumber);
		//Response being sent to user
    	String output = "Hello, " + firstName + " " + lastName
  			  +" Your phone number is : " + phoneNumber;
    	if(!phoneCompany.equals(temp.getPhoneCompany()))
    	{
    		output += " Your old company was :" + temp.getPhoneCompany();
    		String oldCompany = temp.getPhoneCompany();
    		temp.setPhoneCompany(phoneCompany);
    		mapper.save(temp);
    		output += " Your new phone company is : " + temp.getPhoneCompany();
    	  
    		
  		  final String FROM = "james.wang@capgemini.com";
  		  final String TO = "brandon.sheu@capgemini.com";
		  final String SUBJECT = "Phone Company Change (AWS SDK)";
		  
		  // The HTML body for the email.
		  final String HTMLBODY = "<h1>Porting Update</h1>"
		      + String.format("<p>Hello, customer %s %s has changed their phone company from %s to %s.", temp.getFirstName(), temp.getLastName(), oldCompany, temp.getPhoneCompany())
		      + "Amazon SES</a> using the <a href='https://aws.amazon.com/sdk-for-java/'>" 
		      + "AWS SDK for Java</a>";
		  
		  // Text Body for email 
		  final String TEXTBODY = "Hello, customer S S has changed their phone company from S to S blank";
		  
		  try {
		      AmazonSimpleEmailService client1 = 
		          AmazonSimpleEmailServiceClientBuilder.standard()
		          // Pick region US_EAST_1 for SES
		            .withRegion(Regions.US_EAST_1).build();
		      SendEmailRequest request = new SendEmailRequest()
		          .withDestination(
		              new Destination().withToAddresses(TO))
		          .withMessage(new Message()
		              .withBody(new Body()
		                  .withHtml(new Content()// HTMLBODY defined earlier
		                      .withCharset("UTF-8").withData(HTMLBODY))
		                  .withText(new Content()
		                      .withCharset("UTF-8").withData(TEXTBODY)))
		              .withSubject(new Content()
		                  .withCharset("UTF-8").withData(SUBJECT)))
		          .withSource(FROM); // Email sender
		      client1.sendEmail(request);
		      System.out.println("Email sent!");
		    } catch (Exception ex) {
		      System.out.println("The email was not sent. Error message: " 
		          + ex.getMessage());
    	}
    	} 
    	else
    	{
    		output += " Your current phone company is still : " + temp.getPhoneCompany();
    	}
  			  Response a = new Response(output);

  	  return a;
    }

}