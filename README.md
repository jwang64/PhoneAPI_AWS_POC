# AL_Project

## Generate Database
Go to src/main/java/amazonaws/samples/model/Customer.java and there will be a DynamoDB table generator
```
@DynamoDBTable(tableName="tableName")
public class Customer {
```
Change the name to whatever you want the table to be.

Go to src/main/java/amazonaws/samples/Database/GenerateDB.java
Run as java function
Your DynamoDB will have a table on the US-East-1 endpoint

## Populate Database
Go to src/main/java/amazonaws/samples/Database/PopulateDB.java
Run as java function

## Lambdas

### Port Lambda
Go to src/main/java/amazonaws/samples/Lambda/LambdaHandler.java
Right click and upload on AWS Lambda
Create a new Lambda Function / Upload to an existing Lambda Function
Right click and run as a lambda function

Sample JSON Input
```
{ "firstName":  "EOHBNSLBP",
  "lastName":  "XGJSN",
  "phoneNumber": "001-053-6672",
  "phoneCompany": "T-Mobile"
}  
```
Sample JSON Output
```
{
  "response": "Hi FIRST_NAME, your phone company has been changed from AT&T to T-Mobile
}
```

*NOTE Must be a customer generated in your database. Check your DynamoDB to get a customer


### Phone Number to Phone Company Lambda
Go to src/main/java/amazonaws/samples/phoneNumberLambda/LambdaHandler.java
Right click and upload on AWS Lambda
Create a new Lambda Function / Upload to an existing Lambda Function
Right click and run as a lambda function

Sample JSON Input
```
{ 
  "phoneNumber": "001-053-6672",
}  
```
Sample JSON Output
```
{
  "response": "Your phone company is T-mobile"
}
```
