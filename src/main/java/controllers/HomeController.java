package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amazonaws.samples.Customer.Customer;

@Controller
public class HomeController {
 @RequestMapping("/")
 public String home() {
  return "index";
 }
 
 @RequestMapping("/test")
 public String test()
 {
	 return "test";
 }
 
 public Customer customerDetails()
 {
	 //temp, going to add the load DB for customer after getting some parameters
	 Customer tempCustomer = new Customer();
	 return tempCustomer;
 }
}