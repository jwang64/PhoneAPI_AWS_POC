package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.samples.model.Customer;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

//Index Page Controller
@Controller
public class HomeController {
 @RequestMapping("/")
 public String home() {
  return "index";
 }
 
 //Connects to AWS and DynamoDB
 AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
	 		.withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration("dynamodb.us-east-2.amazonaws.com", "us-east-2"))	
			.build(); 
	 DynamoDBMapper mapper = new DynamoDBMapper(client);
 
 /*
 @RequestMapping("/newCustomer")
 public String newCustomer(Model model)
 {
	 AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
		 		.withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration("dynamodb.us-east-2.amazonaws.com", "us-east-2"))	
				.build(); 
		 DynamoDBMapper mapper = new DynamoDBMapper(client);
	 Customer login = new Customer();
	 login.setFirstName("firstName");
	 login.setLastName("lastName");
	 login.setPhoneNumber("phoneNumber");
	 login.setEmail("email");
	 login.setAddress("address");
	 login.setZipCode("zipCode");
	 login.setPhoneCompany("phoneCompany");
	 model.addAttribute("login", login);
	 mapper.save(login);
	 return "home";
 }*/
 
//sets up a new customer
 @RequestMapping("/newCustomer")
 @ResponseBody
 public String newCustomer(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName, @RequestParam("phoneNumber") String phoneNumber
		 , @RequestParam("email") String email, @RequestParam("address") String address, @RequestParam("zipCode") String zipCode
		 , @RequestParam("phoneCompany") String phoneCompany)
 {
	 
	 Customer newCustomer = new Customer();
	 newCustomer.setFirstName(firstName);
	 newCustomer.setLastName(lastName);
	 newCustomer.setPhoneNumber(phoneNumber);
	 newCustomer.setEmail(email);
	 newCustomer.setAddress(address);
	 newCustomer.setZipCode(zipCode);
	 newCustomer.setPhoneCompany(phoneCompany);
	 //model.addAttribute("login", login);
	 mapper.save(newCustomer);
	 return "index";
 }
 
 //Port customer phone number into new company
 @RequestMapping(path="/port")
 public String port(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName, @RequestParam("phoneNumber") String phoneNumber, @RequestParam("phoneCompany") String phoneCompany)
 {
	 
	 Customer temp = mapper.load(Customer.class, lastName, phoneNumber);
	 temp.setPhoneCompany(phoneCompany);
	 mapper.save(temp);
	 return "port";
 }

}