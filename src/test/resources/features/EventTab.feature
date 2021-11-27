Feature: Event Menu

  Background:
    Given the user is on login page
    Then the user enters valid credentials
    And the user navigate to "Event" by Quick Menu
    And the user enters "input" on Event Name Box;

  Scenario: Adding Time
    When the user enters
