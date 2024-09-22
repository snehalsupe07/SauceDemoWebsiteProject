Feature: To verify the login functionality

Scenario: Verify valid login
Given User should be at login page
When User enters valid username as "standard_user"
And User enters valid password as "secret_sauce"
And Click on login button
Then User is redirected to products page
Then Verify username is displayed

Scenario: Verify invalid login
Given User should be at login page
When User enters invalid username as ": wrong_user"
And User enters invalid password as "wrong_password"
And Click on login button
Then User should see an error message for invalid credntials

Scenario: Verify empty fields
Given User should be at login page
When User Leaves both username and password fields empty
And Click on login button
Then Verify that an error message is displayed for empty credentials