package com.amazonaws.samples.schedule;

import com.amazonaws.regions.Regions;
import com.amazonaws.samples.Lambda.LambdaHandler;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder;
import com.amazonaws.services.simpleemail.model.Body;
import com.amazonaws.services.simpleemail.model.Content;
import com.amazonaws.services.simpleemail.model.Destination;
import com.amazonaws.services.simpleemail.model.Message;
import com.amazonaws.services.simpleemail.model.SendEmailRequest; 

public class Email implements RequestHandler<EmailRequest, EmailResponse>  {

	@Override
	public EmailResponse handleRequest(EmailRequest input, Context context) {
		
		  final String FROM = "james.wang@capgemini.com";
		  final String TO = "brandon.sheu@capgemini.com";
		  
		  final String SUBJECT = "Phone Company Change (AWS SDK)";
		  
		  // The HTML body for the email.
		  final String HTMLBODY = "<h1>Health Check</h1>"
		      + "<p>Hello, system is still running.</p>";
		  // The email body for recipients with non-HTML email clients.
		  final String TEXTBODY = "Hello, customer %s %s has changed their phone company from %s to %s blank";
		  
		    try {
		      AmazonSimpleEmailService client = 
		          AmazonSimpleEmailServiceClientBuilder.standard()
		          // Select region US_EAST_1 for SES
		            .withRegion(Regions.US_EAST_1).build();
		      SendEmailRequest request = new SendEmailRequest()
		          .withDestination(
		              new Destination().withToAddresses(TO))
		          .withMessage(new Message()
		              .withBody(new Body()
		                  .withHtml(new Content()
		                      .withCharset("UTF-8").withData(HTMLBODY))
		                  .withText(new Content()
		                      .withCharset("UTF-8").withData(TEXTBODY)))
		              .withSubject(new Content()
		                  .withCharset("UTF-8").withData(SUBJECT)))
		          .withSource(FROM);
		          // Comment or remove the next line if you are not using a
		          // configuration set
		          //.withConfigurationSetName(CONFIGSET);
		      client.sendEmail(request);
		      System.out.println("Email sent!");
		    } catch (Exception ex) {
		      System.out.println("The email was not sent. Error message: " 
		          + ex.getMessage());
		    }
			return null;
		  
	
	}

}