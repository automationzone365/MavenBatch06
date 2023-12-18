@Regression @smoke
Feature: Login to the application
  Scenario Outline: Login with user credentials
    Given I am on the AutomationZone shopping page
    When I enter my username "<username>" and password "<password>"
    Then the users "<username>" logged in successfully
    Examples:
      |username|password|
      |Test12user|Password@123#$|