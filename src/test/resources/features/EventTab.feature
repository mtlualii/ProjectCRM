@wip
Feature: Event Menu

  Background:
    Given the user is on login page
    Then the user enters valid credentials
    And Navigate to "Event" by Quick Menu
    And Enters "xyz" on Event Name Box

  Scenario: Setting Reminder
    When Clicks set reminder checkmark
    Then Should be able to see two boxes to set a reminder


  Scenario: Selecting Meeting Room
    When Clicks Event Location Box and pick "West Meeting Room"
    And Clicks send
    Then Should be able to see selected meeting room "West Meeting Room" as location


  Scenario: Adding Attendees
    When Clicks Member Box
    And Clicks Employees and Departments
    And Clicks the arrow left side of department name "New Department" which would like to be added
    And Selects "marketing2@cybertekschool.com"
    And Clicks send
    Then Should be able to see followings
      | marketing2@cybertekschool.com |
      | New Department                |


  Scenario: Clicking More
    When Clicks more button
    Then Should be able to see followings as parameters
      | Availability |
      | Repeat       |
      | Calendar     |
      | Importance   |

  @smoke
  Scenario: Sending Message
    When Clicks send
    Then Should be able to see an event with the name of "xyz"





















