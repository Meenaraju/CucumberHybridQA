Feature: Login Functionality Of PetStore

@de
Scenario Outline: Login with valid credentials
Given User navigates to sig-in page
When User enters username <username> into the field
And User enters password <password> into the field
And Clicks on Login
Then User landed on home page with welcome message
Examples:
|username								|password	|
|amotooricap9@gmail.com	|1234567	|

@de
Scenario Outline: Login with invalid credentials
Given User navigates to sig-in page
When User enters username <username> into the field
And User enters password <password> into the field
And Clicks on Login
Then User get a warning message about credentials mismatch
Examples:
|username								|password	|
|amotooricap9123@gmail.com	|123456756	|