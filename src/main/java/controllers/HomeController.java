package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amazonaws.samples.Customer.Customer;

@Controller
public class HomeController {
 @RequestMapping("/")
 public String home() {
  return "index";
 }
 
 @RequestMapping(path="/addCustomer")
 public String addCustomer()
 {
	 return "addCustomer";
 }
 
 @GetMapping(path="/login")
 public String loginForm(Model model)
 {
	 Customer temp = new Customer();
	 model.addAttribute("login", temp);
	 return "login";
 }
 
 @RequestMapping(path="/port")
 public String port()
 {
	 return "port";
 }

}