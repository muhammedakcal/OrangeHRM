# Author: Muhammed Akcal [QA Automation Test Engineer]
# Ticket Number: [Assignment -2]

@All
@Assignment_02
@003_Cloudwise_Assignment_SearchUnicorn

Feature: [Assignment Part 2] [Assignment Part 2] - Gatekeeper Challenge Automation E2E Test - Search Unicorn:
  Rule: [Assignment Part 2]: Automate All The Listed Challenges

    Background: User is in the Gatekeeper Page
      Given Menu: I navigate to the page: "https://gatekeeper.codeshake.dev/test"
      Then Generic: I see the page title with name: "Gatekeeper"

    Scenario: Use the following search unicorn field and assert that it is found
      # (The name of our unicorn is "bobi")
      Given GateKeeperPage: I see the part of the text: "In search of the unicorn.." defined on page with title: "Gatekeeper"
      When Generic: I scroll page down
      # This step will refresh the page automatically [Line: 21,22 and 23]
      And Generic: I scroll page down
      Then GateKeeperPage: I enter the search data: "BOBI", and verify if the unicorn is visible with text: "Bobi Codeshake"
      And GateKeeperPage: I enter the search data: "bobi", and verify if the unicorn is visible with text: " Bobi Codeshake"
      But GateKeeperPage: I enter incorrect information with following data, and verify if the unicorn is not visible
        |Unicorn_Name   |
        |BO             |
        |BOB!           |
        |BOB"           |
        |BOB^           |
        |BOB&           |
        |BOB(i          |
        |BOB(bi         |
        |BOBIs          |
        |BOBISI         |
        |BOB_i          |
        |BOB1_i         |
        |bob1_i         |
        |bob            |
        |bob_i          |
        |bob$i          |
        |bobis          |
        |.bobi          |
        |bobi.          |
        |bobi,          |
        |,bobi          |
