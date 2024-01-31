Feature: Registration functionality

Scenario: User create an account by providing only mandatory fields
Given User navigates to Register Account page
When  User enters the details into below fields
|FirstName|Vijay          |
|LastName |Kumar          |
|Email    |Vijayhq@gmail.com|
|Telephone|123456622334   |
|Password |12345          |
|ConfirmPassowrd|12345   |

And  User select yes for Newsletter
And  User Click on Privacy Policy checkbox
And  User Click on continue 
Then User should get create successfull

Scenario: User create an account by providing all fields
Given User navigates to Register Account page
When  User enters the details into below fields
|FirstName|Vijay          |
|LastName |Kumar          |
|Email    |Vijaykqp@gmail.com|
|Telephone|123456622334   |
|Password |12345          |
|ConfirmPassowrd|12345   |

And  User select yes for Newsletter
And  User Click on Privacy Policy checkbox
And  User Click on continue 
Then User should get create successfull

Scenario: User create an account by providing existing email
Given User navigates to Register Account page
When  User enters the details into below fields with existing email
|FirstName|Vijayreddy     |
|LastName |Kumar          |
|Email    |Vijay@gmail.com|
|Telephone|123456622334   |
|Password |12345          |
|ConfirmPassowrd|12345   |

And  User select yes for Newsletter
And  User Click on Privacy Policy checkbox
And  User Click on continue 
Then User should get warning message about duplicate email

Scenario: User create an account without providing details
Given User navigates to Register Account page
When  User do not enter any details
And   User Click on continue
Then  User should get warning messages for every mandatory fields





