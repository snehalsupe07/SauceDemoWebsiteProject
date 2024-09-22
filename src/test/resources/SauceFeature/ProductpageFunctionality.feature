Feature: To verify product page functionality

Scenario: Verify product visibility
Given User is logged in to the application
Then User should see the products list
And User should see the following products
|Sauce Labs Backpack|
|Sauce Labs Bike Light|

Scenario: Verify product details
Given User is logged in to the application
When User click on the product "Sauce Labs Backpack"
Then Verify that the product details page displays the productname as "Sauce Labs Backpack"
And Verify that the product details page displays the description as "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection."
And Verify that the product details page displays the price as "$29.99"

Scenario: Verify add to cart
Given User is logged in to the application
When User clicks the "Add to Cart" button for "Sauce Labs Backpack"
Then the cart count should increase
And the product "Sauce Labs Backpack" should be in the cart