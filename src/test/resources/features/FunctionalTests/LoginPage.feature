# Author: Muhammed Akcal
# Ticket Number: Assignment 1

@FunctionalTests
@LoginPage
@FunctionalTest_LoginPage  
Feature: Login Test

  Scenario: Login Positive Test
    Given Generic: I see the page title with name: "OrangeHRM"
    When Login Page: I enter the username/password: "username" with: "Admin"
    And Login Page: I enter the username/password: "password" with: "admin123"
    Then Login Page: I click on the Login button
    And Login Page: I verify if the logo is present


  Scenario: Login Negative Test
    Given Generic: I see the page title with name: "OrangeHRM"
    When Login Page: I enter the username/password: "username" with: "Admin"
    And Login Page: I enter the username/password: "password" with: "admin12"
    Then Login Page: I click on the Login button
    And Login Page: I verify the error message with: "Invalid credentials"