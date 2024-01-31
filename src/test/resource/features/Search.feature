Feature: Search Functionality

Scenario: User search for valid product
Given  User opens the application
When   User enters valid product "HP" into search field
And    User clicks on search button
Then   User should get the valid product displayed in search results

Scenario: User search for non existing product
Given  User opens the application
When   User enters invalid product "HONDA" into search field
And    User clicks on search button
Then   User should get a message about no product matching

Scenario: User search wihtout prviding data in search field
Given  User opens the application
When   User do not enter any product
And    User clicks on search button
Then   User should get a message about no product matching


  	