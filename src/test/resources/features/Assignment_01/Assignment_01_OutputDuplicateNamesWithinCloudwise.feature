# Author: Muhammed Akcal
# Ticket Number: Assignment -1

@Assignment_01_OutputDuplicateNames

Feature: Assignment Part 1: Output The Duplicate Names Within Cloudwise

  @OutputDuplicateNamesInDepartments
    Scenario: Output The Duplicate Names Within Cloudwise
      Given I open the environment and see the home page
      When Menu: I select the language: "Nederlands"
      And Menu: I select the menu option: "Dit is Cloudwise->Alle Cloudwisers"
      And Workflow: I see the section with label: "Alle Cloudwisers"
      When Generic: I scroll page down
      Then Workflow: I go to departments and print out the employee names that have been duplicated

