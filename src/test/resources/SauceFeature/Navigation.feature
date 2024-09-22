Feature: To verify navigation between the pages and logout functionality

Scenario: Verify navigation between pages
Given User logged in to the application
When user navigates to the product page
Then the product page should be displayed
When User navigates to the cart page
Then the cart page should be displayed
When User navigates to the checkout page
Then the checkout page should be displayed

Scenario: Verify logout functionality
Given User logged in to the application
When User clicks the "Logout" button
Then User should be redirected to the login page
And User should be logged out