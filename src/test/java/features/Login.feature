Feature: Login for Leaftaps 1

Background:
Given Launch for Browser
And Enter the URL

@reg
Scenario Outline: Login Positive

And Enter the username as <username> 
And Enter the password as <password>
When Click on the login button 
Then Verify login is Success


Examples:
	|username|password|
	|DemoSalesManager|crmsfa|


@reg
Scenario: Login Negative
 
And Enter the username as DemoCSR
And Enter the password as crmsfa 

@smoke
Scenario Outline: Create Lead

And Enter the username as DemoCSR
And Enter the password as crmsfa 
When Click on the login button 
Then Verify login is Success
And click CRMSFA link
And click Leads link 
And click Create Lead link
And Enter Company Name as <CompanyName>
And Enter First Name as <FirstName>
And Enter Last Name as <LastName>
When Click Create lead
Then Create Lead Success

Examples:
	|Company Name|First Name|Last Name|
	|Renault|ALagar|S|
