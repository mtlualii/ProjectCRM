Feature: Event Menu

  Background:
    Given the user is on login page
    Then the user enters valid credentials
    And Navigate to "Event" by Quick Menu
    And Enters "input" on Event Name Box

  Scenario: Adding Time and specify Time zone
    When Clicks event start date box
    And Enters start "12/27/2021"
    And Clicks start time box, clicks start hour box and enters "3", clicks minutes box and enters "10" and close it
    When Clicks specify time zone
    Then Two dropdown menu appears and select start zone "Asia/Bishkek"
    When Clicks send
    Then Should be able to see entered "input" as event name, "12/26/2021", "3", "10" as event date and time depends on time zone "Asia/Bishkek"

  Scenario: Setting Reminder
    When Clicks set reminder checkmark
    Then Should be able to see two boxes to set a reminder


  Scenario: Selecting Meeting Room
    When Clicks Event Location Box and pick "East Meeting Room"
    And Clicks send
    Then Should be able to see selected meeting room "East Meeting Room" as location


  Scenario: Adding Attendees
    When Clicks Member Box
    And Clicks Employees and Departments
    And Clicks the arrow left side of department name "New Department" which would like to be added
    And Selects "marketing2@cybertekschool.com"
    And Clicks send
    Then Should be able to see followings
      | marketing2@cybertekschool.com |
      | New Department                |

  @wip
  Scenario: Clicking More
    When Clicks more button
    Then Should be able to see followings as parameters
      | Availability |
      | Repeat       |
      |           |
      | Calendar     |
      | Importance   |

  Scenario: Sending Message
    When Clicks send
    Then Should be able to see an event with the name of "input"





















