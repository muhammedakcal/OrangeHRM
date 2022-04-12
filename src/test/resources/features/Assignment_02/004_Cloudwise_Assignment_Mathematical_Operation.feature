# Author: Muhammed Akcal [QA Automation Test Engineer]
# Ticket Number: [Assignment -2]

@All
@Performance
@Assignment_02
@004_Cloudwise_Assignment_Mathematical_Operation

Feature: [Assignment Part 2] - Mathematical Operation
  Rule: [Assignment Part 2]: Automate All The Listed Challenges

    Background: User is in the Gatekeeper Page
      Given Menu: I navigate to the page: "https://gatekeeper.codeshake.dev/test"
      Then Generic: I see the page title with name: "Gatekeeper"

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
        |1999999999999999999999999998888  |0                               |2e+30                     |
        |0                                |1999999999999999999999999998888 |2e+30                     |
        |199999999999999999999            |0                               |200000000000000000000     |
        |199999999999999999999            |11                              |200000000000000000000     |

      # Calculation process is stopped in the process of Functional Test! [Line:32]
      And Menu: I refresh the page
      # Make a Performance Test
      And GateKeeperPage: I run a performance test by sending 50 different types of data, and verify the results in less than 4 minutes on defined section: "Please fill in the following input fields with some values"
      And GateKeeperPage: I see the icon "Calculator" on defined section: "Please fill in the following input fields with some values"
      And Generic: I generate a message with text: "[Assignment Part 2 - Mathematical Operation]: Test Passed!"
      Examples:
        | Test Type                        | FIELD -1:[FIRST OPERATOR] | FIELD -2:[SECOND OPERATOR] | FIELD -3:[VERIFICATION] |
        | Performance and Functional Test: | First_Input               | Second_Input               | Third_Input             |





