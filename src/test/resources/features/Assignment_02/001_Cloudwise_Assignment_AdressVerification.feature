# Author: Muhammed Akcal [QA Automation Test Engineer]
# Ticket Number: [Assignment -2]

@All
@Performance
@Assignment_02
@001_Cloudwise_Assignment_AdressVerification


Feature: [Assignment Part 2] - Gatekeeper Challenge Automation E2E Test - Verify Company Address:
  Rule: [Assignment Part 2]: Automate All The Listed Challenges

    Background: User is in the Gatekeeper Page
      Given Menu: I navigate to the page: "https://gatekeeper.codeshake.dev/test"
      Then Generic: I see the page title with name: "Gatekeeper"

    Scenario: Check the company's address on the page and in the frame
      Given GateKeeperPage: I see the text: "Vefabey Sokak, No:16 D:11, 34349, Gayrettepe/Istanbul/Turkey" defined on page with title: "Gatekeeper"
       When GateKeeperPage: I switch to frame: "iframe"
       And GateKeeperPage: I see the section: "About Us" defined on frame
       When Generic: I scroll page down till the end of page
       Then GateKeeperPage: I see the text: "Vefabey Sokak, No:16 D:11, 34349, Gayrettepe/Istanbul/Turkey" defined on frame
       And Generic: I generate a message with text: "[Assignment Part 2 - Verify Company Address]: Test Passed!"

