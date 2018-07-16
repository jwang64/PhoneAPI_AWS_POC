package com.amazonaws.samples;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

/*
 * Customer class. Holds information about the customer: name, phone number, company, account number, zipcode, ssn, email
 */
@DynamoDBTable(tableName="TestTable")
public class Customer {
	private String phoneCompany;
	private String phoneNumber;
	private String firstName;
	public String lastName;
	private String accountNumber;
	private String address;
	private String zipCode;
	private String SSN;
	private String email;
	
	
	@DynamoDBHashKey(attributeName="LastName")
	public String getLastName() { return lastName; }
	public void setLastName(String lastName) { this.lastName = lastName; }
	
	@DynamoDBRangeKey(attributeName="PhoneNumber")
	public String getPhoneNumber() { return phoneNumber; }
	public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

	@DynamoDBAttribute(attributeName="PhoneCompany")
	public String getPhoneCompany() { return phoneCompany; }
	public void setPhoneCompany(String phoneCompany) { this.phoneCompany = phoneCompany; }
	
	@DynamoDBAttribute(attributeName="FirstName")
	public String getFirstName() { return firstName; }
	public void setFirstName(String firstName) { this.firstName = firstName; }
	
	@DynamoDBAttribute(attributeName="AccountNumber")
	public String getAccountNumber() { return accountNumber; }
	public void setAccountNumber(String accountNumber) { this.accountNumber = accountNumber; }
	
	@DynamoDBAttribute(attributeName="Address")
	public String getAddress() { return address; }
	public void setAddress(String address) { this.address = address; }
	
	@DynamoDBAttribute(attributeName="ZipCode")
	public String getZipCode() { return zipCode; }
	public void setZipCode(String zipCode) { this.zipCode = zipCode; }
	
	@DynamoDBAttribute(attributeName="SSN")
	public String getSSN() { return SSN; }
	public void setSSN(String SSN) { this.SSN = SSN; }
	
	@DynamoDBAttribute(attributeName="Email")
	public String getEmail() { return email; }
	public void setEmail(String email) { this.email = email; }
}
