Feature: Register Functionality

@register
Scenario: User creates an account only with mandatory fields
Given user navigates to register account page
When user enters the details below into the fields
|firstname	|Meena										|
|lastname		|Raju											|
|email			|mailtominumeena@gmail.com|
|telephone	|2289764523								|
|password		|12345@25									|
And user selects privacy policy
And user clicks on continue button
Then user account should get created successfully
@register
Scenario: User creates an account with all fields
Given user navigates to register account page
When user enters the details below into the fields
|firstname	|Minu										|
|lastname		|meena											|
|email			|mailtominumeena23@gmail.com|
|telephone	|228976452323								|
|password		|1234545@25									|
And user selects Yes for newsletter
And user selects privacy policy
And user clicks on continue button
Then user account should get created successfully
@mek
Scenario: User creates duplicate account
Given user navigates to register account page
When user enters the duplicate details into the fields
|firstname	|Meena										|
|lastname		|Raju											|
|email			|mailtominumeena@gmail.com|
|telephone	|2289764523								|
|password		|12345@25									|
And user selects Yes for newsletter
And user selects privacy policy
And user clicks on continue button
Then user should get proper warning about duplicate email

Scenario: user creates an account without filling any details
Given user navigates to register account page
When user dont enter any details into the fields
And user clicks on continue button
Then user should get proper warning for every mandatory fields