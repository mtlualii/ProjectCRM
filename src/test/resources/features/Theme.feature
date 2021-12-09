@Theme
Feature: User should be able to change theme and notification settings.

#  As a user, I should be able to change theme and notification settings;
#  so that I can experience more personal application

  Background:Login with valid credentials
    Given the user is on login page
    When the user enters valid credentials
    Then the user sees title "Portal"

  @LUE-700
  Scenario: User should be able to select an image from the options.
    Given The User is on the Mainpage
    When The User clicks own username at the right top of page
    And The User selects Theme on the opened list
    And The User selects any image in new window that opens
    And The User should click Save button
    Then Selected image should be visible in the background

  @LUE-701
  Scenario: User should be able to create custom theme.
    Given The User is on the Mainpage
    When The User clicks own username at the right top of page
    And The User selects Theme on the opened list
    And The User clicks Custom Theme button in new window that opens
    And Create Custom Theme window should appear
    And The User should be able to upload an image
    And The User should click Create button
    And The User should click save button
    Then Uploaded image should be visible in the background

  @LUE-702
  Scenario: User should be able to use animated background
    Given The User is on the Mainpage
    When The User clicks own username at the right top of page
    And The User selects Theme on the opened list
    And The User selects any animated image in new window that opens
    And The User should click Save Button
    Then Selected animated image should be visible in the background

  @LUE-703
  Scenario: User should be able to display Simple Mode and Advance Mode under Configure Notifications
    Given The User is on the Mainpage
    When The User clicks own username at the right top of page
    And The User selects Configure Notifications on the opened list
    And The User should be able to select Simple Mode or Advance Mode
    Then Only Simple Mode or Advance Mode should be selected
