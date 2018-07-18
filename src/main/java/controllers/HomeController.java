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
 
 @RequestMapping("/addCustomer")
 public String addCustomer()
 {
	 return "addCustomer";
 }
 
 @RequestMapping("/login")
 public String login()
 {
	 return "login";
 }
 
 @RequestMapping("/port")
 public String port()
 {
	 return "port";
 }

}