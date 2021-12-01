Feature: Login Function
   
  Scenario: Login with valid credentials
    Given the user is on login page
    When the user enters valid credentials
    Then the user sees title "Portal"

