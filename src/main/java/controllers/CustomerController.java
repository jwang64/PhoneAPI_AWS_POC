package controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amazonaws.samples.*;

@RequestMapping("/addCustomer")
@RestController
public class CustomerController {
	public String createNewCustomer()
	{
		return "addCustomer";
	}
	/*
	public Customer getCustomer()
	{
		
	}*/
}
