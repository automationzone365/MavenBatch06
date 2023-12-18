@Regression
Feature: User registration
  As a new user
  I want to register to the application
  So that I can access my account to shop

  Scenario: Successful Registration
    Given I am on the AutomationZone shopping page
    And I am a new user registered
      | username          | email                       | password       |
      | testuser18Dec2023 | Testuser18Dec2023@gmail.com | Password@123#$ |
    And I log out from the application
