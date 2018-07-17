package com.amazonaws.samples;

import static org.junit.Assert.*;

import org.junit.Test;

import com.amazonaws.samples.Customer.Customer;

public class testCustomer {

	@Test
	//**LAST NAME TEST**//
		public final void testSetLastName () {
			Customer test = new Customer();
			test.setLastName("SHEU");
			String result = test.getLastName();
			assertEquals("SHEU", result);
		}
	
	
	//**FIRST NAME TEST**//
		public final void testSetFirstName () {
			Customer test = new Customer();
			test.setLastName("BRANDON");
			String result = test.getFirstName();
			assertEquals("BRANDON", result);
		}

	//**PHONE NUMBER TEST**//
		public final void testSetPhoneNumber () {
			Customer test = new Customer();
			test.setPhoneNumber("678-602-3301");
			String result = test.getPhoneNumber();
			assertEquals("678-602-3301", result);
		}

	//**PHONE COMPANY TEST**//
		public final void testSetPhoneCompany () {
			Customer test = new Customer();
			test.setPhoneCompany("AT&T");
			String result = test.getPhoneNumber();
			assertEquals("AT&T", result);
	}
	
	//**ACCOUNT NUMBER TEST**//
		public final void testSetAccountNumber () {
			Customer test = new Customer();
			test.setAccountNumber("125");
			String result = test.getAccountNumber();
			assertEquals("125", result);
		}
		
	//**ADDRESS TEST**//
		public final void testAddress () {
			Customer test = new Customer();
			test.setAddress("1234 Peachtree Rd");
			String result = test.getAddress();
			assertEquals("1234 Peachtree Rd", result);
		}
		
	//**ZIP CODE TEST**//
		public final void testZipCode () {
			Customer test = new Customer();
			test.setZipCode("30308");
			String result = test.getZipCode();
			assertEquals("30308", result);
		}
	//**SSN TEST**//
		public final void testSSN () {
			Customer test = new Customer();
			test.setSSN("123-45-5678");
			String result = test.getSSN();
			assertEquals("123-45-5678", result);
		}
		
	//**EMAIL TEST**//
		public final void testEMAIL () {
			Customer test = new Customer();
			test.setEmail("brandon.sheu@capgemini.com");
			String result = test.getEmail();
			assertEquals("brandon.sheu@capgemini.com", result);
		}

}