Feature: User Authentication
  As a user
  I want to be able to authenticate myself
  So that I can access my account


  Scenario:Sucessful login
    Given a registered user with userid "Testuser3" and password "Testpassword123"
    When the user enters the credentials and click on submit button
    Then the system should authenticate the user "Testuser3"


  Scenario Outline: Login with different credentials
    Given I am registered user with username "<username>" and with password "<password>"
    Examples:
      |username|password|
      |testuser123|password@123|
      |testuser234|password@234|

    Scenario: Test using dataTable
      Given the user enters the table creds
        | datatableuser1 | password@123 |
        | datatableuser2 | password@234 |

    Scenario: Test using map
      Given the user entered the creds
        |username|password|
        |testuser123|password@123|
        |testuser234|password@234|

    Scenario: Test using JSON
      Given I am using JSON data
      """
      {
  "users": [
    {"name":"john",
      "age":"20"
    },
    {"name":"doe",
      "age":"25"
    },
     {"name":"johnny",
      "age":"30"
    }
  ]
}
      """


