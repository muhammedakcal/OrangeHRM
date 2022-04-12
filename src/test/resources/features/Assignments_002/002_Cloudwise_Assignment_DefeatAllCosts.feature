# Author: Muhammed Akcal [QA Automation Test Engineer]
# Ticket Number: [Assignment -2]

@All
@Assignment_0
@002_Cloudwise_Assignment_DefeatAllCosts

Feature: [Assignment Part 2] - Gatekeeper Challenge Automation E2E Test -Defeat Costs:
  Rule: [Assignment Part 2]: Automate All The Listed Challenges

    Background: User is in the Gatekeeper Page
      Given Menu: I navigate to the page: "https://gatekeeper.codeshake.dev/test"
      Then Generic: I see the page title with name: "Gatekeeper"

    Scenario: Open the pop-up, and then defeat it all cost!
      Given GateKeeperPage: I see the part of the text: "Return of the pop-up" defined on page with title: "Gatekeeper"
#    Even while the first cost can be easily defeated in theory, we may face the same problem in the future!
#    Because the shaft is connected to the reactor system directly.
#    As a result, this scenario should keep track of expenditures such as cost size, location, and rectangle information.
#    It would be useful to print this information, so that it can be accessed in the event of a test failure.
#    Keep in mind that all costs should be the in same size!
      When GateKeeperPage: I click on popup: "Let the battle begin"
      Then GateKeeperPage: I see 9 thermal exhaust ports in the main port
      And GateKeeperPage: I check the cost's size with the following information: Weight: "29", Height: "30"
      And GateKeeperPage: I defeat the cost in the thermal exhaust port
#     We can defeat the cost as much as we want by changing the value(9 times). This function will operate it accordingly![Line:27]
      Then GateKeeperPage: I defeat the cost for 9 times, and print out the ports information
      And Generic: I generate a message with text: "[Assignment Part 2 - Defeat Costs]: Test Passed!"



