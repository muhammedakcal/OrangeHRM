# Author: Muhammed Akcal
# Ticket Number: [Assignment -2]
@All
@Assignment_02_Automate_All_The_Listed_Challenges
Feature: Assignment Part 2: Automate All The Listed Challenges

  Background: User is in the Gatekeeper Page
    Given Menu: I navigate to the page: "https://gatekeeper.codeshake.dev/test"

  @VerifyCompanyAddress
  Scenario: Verify Company Address:
    Given Generic: I see the page title with name: "Gatekeeper"
    And GateKeeper: I see the section with name: "Please extract and verify our address to the following:"
    Then GateKeeper: I extract and verify the address with text: "Vefabey Sokak, No:16 D:11, 34349, Gayrettepe/Istanbul/Turkey"

  @DefeatCosts
  Scenario: Open the pop-up, and then defeat it all cost!
    Given Generic: I see the page title with name: "Gatekeeper"
    And GateKeeper: I click on popup: "Let the battle begin"
    When GateKeeper: I see 9 thermal exhaust ports in the main port
    And GateKeeper: I defeat the cost in the thermal exhaust port
    Then GateKeeper: I defeat the cost for 30 times, and print out the ports information

  @VerifyUnicorn
  Scenario: Use the following search unicorn field and assert that it is found
    Given Generic: I see the page title with name: "Gatekeeper"
    When Generic: I scroll page down till the end of page
    Then GateKeeper: I enter the search data: "BOBI", and verify if the unicorn is visible with text: "Bobi Codeshake"
    And GateKeeper: I enter the search data: "bobi", and verify if the unicorn is visible with text: "Bobi Codeshake"
    But GateKeeper: I enter incorrect information with following data, and verify if the unicorn is not visible
      | Invalid_Unicorn_Name |
      | BO                   |
      | bob                  |

  @MathematicalOperation
  Scenario Outline: Fill in the input fields with some values and assert that the result is correct
    Given Generic: I see the page title with name: "Gatekeeper"
    And Generic: I scroll page down
    When GateKeeper: I see the section with name: "<Section Name>"
    And GateKeeper: I see the icon "Plus" on defined section: "<Section Name>"
    When GateKeeper: I see the icon "Equals" on defined section: "<Section Name>"
    Then GateKeeper: I execute a performance test by sending 50 different sorts of random data and verifying the results in less than 100 seconds on defined section: "<Section Name>"
    And GateKeeper: I see the icon "Calculator" on defined section: "<Section Name>"
    Examples:
      | Section Name                                                                                     |
      | Please fill in the following input fields with some values and assert that the result is correct |




