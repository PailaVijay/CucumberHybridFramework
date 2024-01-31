Feature: Login Functionality

Scenario: Logging into the application with valid credentials
Given User has navigate to login page
When  User has to enter the valid emailId <username>
And   User has to enter the valid password <password>
And   User has to click on login button
Then  User should get logged in and taken to the My Account page

Examples:

|username        | password   |
|ladu@gmail.com  | ladu123    |
|ladu@gmail.com  | ladu123    |
|ladu@gmail.com  | ladu123    |

Scenario: Logging into the application with invalid credential
Given User has navigate to login page
When  User has to enter invalid emailId
And   User has to enter invalid password "vijay@123"
And   User has to click on login button
Then  User should get the warning message

Scenario: Logging into the application with invalid emailId and valid password
Given User has navigate to login page
When  User has to enter invalid emailId
And   User has to enter valid password "ladu123"
And   User has to click on login button
Then  User should get the warning message

Scenario: Logging into the application with valid emailId and invalid password
Given User has navigate to login page
When  User has to enter valid emailId "ladu@gmail.com"
And   User has to enter invalid password "vijay@123"
And   User has to click on login button
Then  User should get the warning message

Scenario: Logging into the application without providing any credentials
Given User has navigate to login page
When  User dont enter emailId into the email field
And   User dont enter password into the password field
And   User has to click on login button
Then  User should get the warning message


