# Author: Muhammed Akcal [QA Automation Test Engineer]
# Ticket Number: [Assignment -2]

@All @Performance
@Assignment_02
@Cloud-Wise_Assignment_002_GateKeeper

Feature: [Assignment Part 2] - Gatekeeper Challenge Automation E2E Test: Verify Company Address, Mathematical Operation, Defeat Costs and Search Unicorn
  Rule: [Assignment Part 2]: Automate All The Listed Challenges

    Background: User is in the Gatekeeper Page
      Given Menu: I navigate to the page: "https://gatekeeper.codeshake.dev/test"
      Then Generic: I see the page title with name: "Gatekeeper"

   # @Cloud-Wise_Assignment_002_GateKeeper_VerifyAddressInPageAndInFrame
    Scenario: Check the company's address on the page and in the frame
      Given GateKeeperPage: I see the text: "Vefabey Sokak, No:16 D:11, 34349, Gayrettepe/Istanbul/Turkey" defined on page with title: "Gatekeeper"
      When GateKeeperPage: I switch to frame: "iframe"
      And GateKeeperPage: I see the section: "About Us" defined on frame
      When Generic: I scroll page down till the end of page
      Then GateKeeperPage: I see the text: "Vefabey Sokak, No:16 D:11, 34349, Gayrettepe/Istanbul/Turkey" defined on frame


    @Cloud-Wise_Assignment_002_GateKeeper_OpenThePopUp_Then_Defeat_It_All_Cost
    Scenario: Open the pop-up, and then defeat it all cost!
      Given GateKeeperPage: I see the part of the text: "Return of the pop-up" defined on page with title: "Gatekeeper"
#    Even while the first cost can be easily defeated in theory, we may face the same problem in the future!
#    Because the shaft is connected to the reactor system directly.
#    As a result, this scenario should keep track of expenditures such as cost size, location, and rectangle information's.
#    It would be useful to print this information, so that it can be accessed in the event of a test failure.
#    Keep in mind that all costs should be the in same size!
      When GateKeeperPage: I click on popup: "Let the battle begin"
      Then GateKeeperPage: I see 9 thermal exhaust ports in the main port
      And GateKeeperPage: I check the cost's size with the following information: Weight: "29", Height: "30"
      And GateKeeperPage: I defeat the cost in the thermal exhaust port
      Then GateKeeperPage: I defeat the cost for 9 times, and print out the ports information


    @Cloud-Wise_Assignment_002_SearchUnicorn
    Scenario: Use the following search unicorn field and assert that it is found
  #   (The name of our unicorn is "bobi")
      Given GateKeeperPage: I see the part of the text: "In search of the unicorn.." defined on page with title: "Gatekeeper"
      When Generic: I scroll page down
      # This step refresh the page automatically [Line: 46,47 and 48]
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


    @Cloud-Wise_Assignment_002_FillInTheInputFieldsWithSomeValuesAndAssert
    Scenario Outline: [<Test Type>]: Fill in the input fields with some values and assert that the result is correct
      Given GateKeeperPage: I see the part of the text: "A little bit of math." defined on page with title: "Gatekeeper"
      When Generic: I scroll page down
      And GateKeeperPage: I see the section with name: "Please fill in the following input fields with some values and assert that the result is correct."
      And GateKeeperPage: I see the icon "Plus" on defined section: "Please fill in the following input fields with some values"
      And GateKeeperPage: I see the icon "Equals" on defined section: "Please fill in the following input fields with some values"
      And GateKeeperPage: I see the icon "Calculator" on defined section: "Please fill in the following input fields with some values"
      Then GateKeeperPage: I fill the input fields and assert number to verify if the results are correct;
        |<FIELD -1:[FIRST OPERATOR]>      |<FIELD -2:[SECOND OPERATOR]>    |<FIELD -3:[VERIFICATION]> |
        |1                                |2                               |3                         |
        |100                              |-2                              |98                        |
        |-100                             |6                               |-94                       |
        |0                                |2                               |2                         |
        |167                              |-167                            |0                         |
        |-2340                            |-2340                           |-4680                     |
        |1076854                          |2565565                         |3642419                   |
        |-19999999999999999999            |0                               |-20000000000000000000     |
        |-1999999999999999999999          |0                               |-2e+21                    |
        |0                                |-1999999999999999999999         |-2e+21                    |
        |-1999999999999999999999999998888 |0                               |-2e+30                    |
        |1999999999999999999999999998888  |0                               |2e+30                    |
        |0                                |1999999999999999999999999998888 |2e+30                    |
        |199999999999999999999            |0                               |200000000000000000000     |
        |199999999999999999999            |11                              |200000000000000000000     |

      # Calculation process is stopped in the process of Functional Test! [Line:89]
      And Menu: I refresh the page
      And GateKeeperPage: I see the icon "Calculator" on defined section: "Please fill in the following input fields with some values"
      Examples:
        | Test Type         | FIELD -1:[FIRST OPERATOR]  |FIELD -2:[SECOND OPERATOR]  |FIELD -3:[VERIFICATION]   |
        | Functional Test:  | First_Input                |Second_Input                | Third_Input              |



