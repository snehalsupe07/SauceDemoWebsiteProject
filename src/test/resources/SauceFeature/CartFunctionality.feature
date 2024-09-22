Feature: To verify cart functionality

Scenario: Verify view cart
Given User already has item in the cart
When User clicks cart icon
Then User should see the products added in the cart are displyed correctly

Scenario: Verify remove item from cart
Given User already has item in the cart
When User removes an item from cart
Then Item is removed
And Cart count is updated accordingly

Scenario: Verify checkout process
Given User already has item in the cart
When User clicks on "Checkout" button
And User enters valid checkout information
| First Name | Last Name | Postal Code |
| Stuart | Patrick | 76786 |
And Complete checkout process
Then User should see order confirmation process