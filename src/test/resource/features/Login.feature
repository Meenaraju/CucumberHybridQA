Feature: Login Functionality

@ch
Scenario Outline: Login with valid credentials
Given user navigates to login page
When user enters valid email address <username> into email field
And user enters the vaild password <password> into password field
And user clicks on login button
Then user should get successfully logged in
Examples:
|username								|password	|
|amotooricap9@gmail.com	|12345		|
|amotooricap1@gmail.com	|12345		|


Scenario: Login with invalid credentials
Given user navigates to login page
When user enters invalid email address into email field
And user enters the invalid password "12345432" into password field
And user clicks on login button
Then user should get a warning message about credentials mismatch


Scenario: Login with valid email and invalid password
Given user navigates to login page
When user enters valid email address "amotooricap9@gmail.com" into email field
And user enters the invalid password "12345432" into password field
And user clicks on login button
Then user should get a warning message about credentials mismatch

@me
Scenario: Login with invalid email and valid password
Given user navigates to login page
When user enters invalid email address into email field
And user enters the vaild password "12345" into password field
And user clicks on login button
Then user should get a warning message about credentials mismatch

Scenario: Login without providing any credentials
Given user navigates to login page
When user donot enter email address into email field
And user donot enter password into password field
And user clicks on login button
Then user should get a warning message about credentials mismatch