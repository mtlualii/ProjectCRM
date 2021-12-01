
Feature: Poll

  Agile Story: As a user, I should be able to create a poll by clicking on Poll tab under Active Stream

  Background: Login
    Given the user is on login page
    When the user enters valid credentials
    Then the user sees title "Portal"

#  Acceptance Criteria:
#
#  +User should be able to add users by selecting multiple contacts from Employees and Departments contact lists.
#  +User should be able to attach a link by clicking on the link icon.
#  +User should be able to add mention by clicking on the add mention icon.
#  +User should be able to add questions and multiple answers.
#  +User should be able to delete questions and multiple answers.
#  +User should be able to provide multiple choice to attendees by selecting the Allow multiple choice checkbox.
#  +User should be able to send a poll

  Scenario: Adding multiple contacts to message function
    And user clicks on "Poll" tab under Activity Stream
    Given user should be able to see Add more button on To line
    When user clicks on Add more button on To line
    Then Add more pop up is displayed
    When user clicks on Employees and Departments link on the table
    Then contacts should be listed
    And user should be able to select multiple contact from the list
    And selected contact should be listed on To line


  Scenario: Attach Link function
    And user clicks on "Poll" tab under Activity Stream
    When user clicks on "Link" icon
    Then Link pop up is displayed
    When user enters "testLink" to "Link text" box
    When user enters "www.duckduckgo.com" to "Link URL" box
    And user clicks on Save button
    Then Link text which is "testLink" should be displayed on message box


  Scenario: Add mention function
    And user clicks on "Poll" tab under Activity Stream
    Given user should be able to see "Add mention" icon
    When user clicks on "Add mention" icon
    Then Add more pop up is displayed
    When user clicks on Employees and Departments link on the table
    Then contacts should be listed
    And user should be able to select a contact from the list
    And selected contact should be listed on Message area box


  Scenario: Add multiple questions and answers function
    And user clicks on "Poll" tab under Activity Stream
    When user enters clicks on Add question link
    Then one more question area should be displayed
    When user clicks on latest answer
    Then a new answer box should be displayed

  Scenario: Deleting multiple questions and answers function
    And user clicks on "Poll" tab under Activity Stream
    When user clicks on Add question link
    And user clicks on Delete question mark
    Then the question area should be deleted
    When user clicks on Delete answer mark
    Then the question should be deleted

  Scenario: Giving multiple choice opportunity to user function
    And user clicks on "Poll" tab under Activity Stream
    Given Allow multiple choice box should be displayed
    When user selects Allow multiple choice
    Then Allow multiple choice box should be selected

  Scenario: Sending poll function
    And user clicks on "Poll" tab under Activity Stream
    When user write message to Message area box
    And user enters "question" to question box
    And User enters "answer" to answers box
    And user clicks on Send button
    Then poll should be listed on Activity Stream