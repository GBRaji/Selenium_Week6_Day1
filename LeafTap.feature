Feature: LeafTaps Testcase Integration 

Background: Login to Application 

Given Enter the Username as 'DemoSalesManager'
And Enter password as 'crmsfa'
When Click on Login Button
Then Homepage should display
When Click on Leads


Scenario Outline: Create Lead

When Create Lead
When Enter Company Name <companyname>
When Enter First Name <fname>
When Enter Last Name <lname>
When Click Submit Button
Then Verify Lead creation

Examples:
|companyname|fname|lname|
|'Wipro'|'GB'|'B'|
|'TCS'|'Venba'|'GR'|


Scenario: Edit Lead

Given Find Lead to Edit
When Click PhoneNumber and Enter Number '99'
When Click Find Lead
When  Edit Lead Company Name 'TCSA'
When Click Submit Button for edit


Scenario: Merge Contact
Given Find Lead to Merge
When Click Merge
When Enter Firstname to Merge 'GB'
When Click submit to Merge

Scenario: Duplicate Lead
Given Select Lead to Find Duplicate
When Enter Phonenumber '99'
When Find Lead for Duplicate
When Click Submit to know Duplicate

Scenario: Delete Lead
Given Select Lead to Delete
When Enter PhoneNumber '9'
When Click Lead to Delete
When Verify Lead Deleted




 
