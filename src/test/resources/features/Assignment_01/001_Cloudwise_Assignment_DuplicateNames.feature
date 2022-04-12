# Author: Muhammed Akcal [QA Automation Test Engineer]
# Ticket Number: Assignment -1

@All
@Performance
@001_Cloudwise_Assignment_DuplicateNames
@Assignment_01

Feature: [Assignment Par 1]: Output The Duplicate Names Within Cloudwise for 9 Departments

  Rule: [Assignment Part 1]:  There can be more than one duplicate names. The test should be able to find duplicate names and print it


    Scenario: Output The Duplicate Names Within Cloudwise in Departments

      Given I open the environment and see the home page
      When Menu: I select the language: "Nederlands"
      Then Waiting: I wait for 5 seconds
      And Menu: I select the menu option: "Dit is Cloudwise"
      And Workflow: I see the section with label: "Dit is Cloudwise"

       # Go to 'Alle Cloudwisers'! Note: Menu selection can be also done like this: ["Dit is Cloudwise->Alle Cloudwisers"] Arraw configuration is available to go to "Alle Cloudwisers Section" directly
      When Waiting: I wait for 5 seconds
      Then Workflow: I click on the flip-box button with name: "Ontmoet het team" inside the department: "Alle Cloudwisers" placed on section having label: "Dit is Cloudwise"
      And Workflow: I see the section with label: "Alle Cloudwisers"

      # Go to one department and create a list to save names
      When Generic: I scroll page down
      Then Workflow: I click on the flip-box button with name: "Wie zijn wij?" inside the department: "Projecten & Support" placed on section having label: "Alle Cloudwisers"
      And Workflow: I create/use: "create" a list to store the names placed on section having label: "Projecten en support"

       # Go back and visit each departments to save names in the list, which was created for this purpose
      When Menu: I go back to previous page

      # ['Wie zijn wij'] In the 'Direction' department, there is no "?" at the end. In order to check it, I needed to create a customize x-path! [Line:36]
      Then Workflow: I click on the flip-box button with name: "Wie zijn wij" inside the department: "Directie" placed on section having label: "Alle Cloudwisers"
      # Expected: [Wie zijn wij?] <---> Found: [Wie zijn wij]: [Line:36]
      And Workflow: I create/use: "use" a list to store the names placed on section having label: "Directie"

      When Menu: I go back to previous page
      And Generic: I scroll page down
      Then Workflow: I click on the flip-box button with name: "Wie zijn wij?" inside the department: "Support" placed on section having label: "Alle Cloudwisers"
      And Workflow: I create/use: "use" a list to store the names placed on section having label: "Support"

      When Menu: I go back to previous page
      Then Workflow: I click on the flip-box button with name: "Wie zijn wij?" inside the department: "Sales" placed on section having label: "Alle Cloudwisers"
      And Workflow: I create/use: "use" a list to store the names placed on section having label: "Sales"

      When Menu: I go back to previous page
      Then Workflow: I click on the flip-box button with name: "Wie zijn wij?" inside the department: "Marketing" placed on section having label: "Alle Cloudwisers"
      And Workflow: I create/use: "use" a list to store the names placed on section having label: "Marketing"

      When Menu: I go back to previous page
      Then Workflow: I click on the flip-box button with name: "Wie zijn wij?" inside the department: "Academy" placed on section having label: "Alle Cloudwisers"
      And Workflow: I create/use: "use" a list to store the names placed on section having label: "Academy"

      Then Menu: I go back to previous page
      When Generic: I scroll page down
      And Workflow: I click on the flip-box button with name: "Wie zijn wij?" inside the department: "Development" placed on section having label: "Alle Cloudwisers"
      And Workflow: I create/use: "use" a list to store the names placed on section having label: "Development"

      When Menu: I go back to previous page
      Then Workflow: I click on the flip-box button with name: "Wie zijn wij?" inside the department: "HR & Administratie" placed on section having label: "Alle Cloudwisers"
      And Workflow: I create/use: "use" a list to store the names placed on section having label: "HR en administratie"

      When Menu: I go back to previous page
      And Workflow: I click on the flip-box button with name: "Wie zijn wij?" inside the department: "Logistiek & Service" placed on section having label: "Alle Cloudwisers"
      And Workflow: I create/use: "use" a list to store the names placed on section having label: "Logistiek & Service"

      # Let the test find all users in the list and output the duplicate names within cloudwise
      And Workflow: I print out the names that were stored in the list that were duplicated
      # I also added such functions to verify whether if it has a duplicate names in the Department. I haven't used it due to the fact that it was not needed!
      Then Generic: I generate a message with text: "[Assignment Part 1 - Output The Duplicate Names Within Cloud-wise]: Test Passed!"