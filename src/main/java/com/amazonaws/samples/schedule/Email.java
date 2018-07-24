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
		
		// public String scheduleEmail; 
		  // Replace sender@example.com with your "From" address.
		  // This address must be verified with Amazon SES.
		  final String FROM = "james.wang@capgemini.com";

		  // Replace recipient@example.com with a "To" address. If your account
		  // is still in the sandbox, this address must be verified.
		  final String TO = "brandon.sheu@capgemini.com";

		  // The configuration set to use for this email. If you do not want to use a
		  // configuration set, comment the following variable and the 
		  // .withConfigurationSetName(CONFIGSET); argument below.
		  //static final String CONFIGSET = "ConfigSet";
		  
		  //Link the lambdaHandler class to this class below
		  LambdaHandler lambdaHandler = new LambdaHandler();
		  String lastName = lambdaHandler.getLastName();
		  String firstName = lambdaHandler.firstName;
		  String phoneCompany = lambdaHandler.phoneCompany;
		  // The subject line for the email.
		  final String SUBJECT = "Phone Company Change (AWS SDK)";
		  
		  // The HTML body for the email.
		  final String HTMLBODY = "<h1>Porting Update</h1>"
		      + "<p>Hello, customer %s %s has changed their phone company from %s to %s."
		      + "Amazon SES</a> using the <a href='https://aws.amazon.com/sdk-for-java/'>" 
		      + "AWS SDK for Java</a>";
		  //String text = String.format(TEXTBODY, firstName, lastName, phoneCompany)
		  
		  // The email body for recipients with non-HTML email clients.
		  final String TEXTBODY = "Hello, customer %s %s has changed their phone company from %s to %s blank";
		  
		    try {
		      AmazonSimpleEmailService client = 
		          AmazonSimpleEmailServiceClientBuilder.standard()
		          // Replace US_WEST_2 with the AWS Region you're using for
		          // Amazon SES.
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