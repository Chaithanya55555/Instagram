Feature: Login functionality
  Scenario: Successfully login
    Given I on instagram login page
    When Enter username, password relevant input box
    And Click on login button
    Then Navigated to home page