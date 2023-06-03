# Author: Murat Dunger
# Ticket Number: Assignment 1

@RegressionTests
@CartOperations
Feature: Cart Operations 

  @Regression_CartOperationsPositiveTest
  Scenario: Cart Operations Positive Test
    Given Generic: I see the page title with name: "Swag Labs"
    When Login Page: I enter the username/password: "username" with: "standard_user"
    And Login Page: I enter the username/password: "password" with: "secret_sauce"
    Then Login Page: I click on the Login button
    And Login Page: I verify if the app logo appears on the home page
    When HomePage: I select: "Name (Z to A)" from the filter dropdown
    Then HomePage: I add to cart/remove: "add to cart" the product with name: "Sauce Labs Fleece Jacket" on the home page
    And HomePage: I add to cart/remove: "add to cart" the product with name: "Sauce Labs Bolt T-Shirt" on the home page
    And HomePage: I add to cart/remove: "add to cart" the product with name: "Sauce Labs Backpack" on the home page
    Then HomePage: I verify that 3 number of products added to the cart
    When HomePage: I click on the shopping cart button
    And HomePage: I select the operation Continue Shopping/Checkout: "Checkout" on the checkout section
    Then Home Page: I verify the page title with: "Checkout: Your Information" on the checkout section
    When HomePage: I enter the fields on the checkout section
      | Field Name      | Value   |
      | First Name      | Murat   |
      | Last Name       | Dulger  |
      | Zip/Postal Code | 0211    |
    And Home Page: I click on the button Continue/Cancel: "Continue" on the checkout section
    Then Home Page: I verify the page title with: "Checkout: Overview" on the checkout section
    # Update the total amount in the case of the price change
    And Home Page: I verify total amount: "Total: $103.65" on the checkout section
    And Home Page: I click on the button Finish/Cancel: "Finish" on the checkout overview section
    Then Home Page: I verify the page title with: "Checkout: Complete!" on the checkout section
    And Home Page: I verify the message: "Thank you for your order!" on the checkout complete section
    And Home Page: I verify the message: "Your order has been dispatched, and will arrive just as fast as the pony can get there!" on the checkout complete section
    When Login Page: I logout from the application
    And Generic: I see the page title with name: "Swag Labs"
