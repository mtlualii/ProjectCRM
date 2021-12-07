@appreciation
Feature:Attaching a link

  Scenario: Adding link
    Given the user is on the login page
    And the user enters the hr100 information
    And the user should be able to login
    And the user lands on the appreciation message page
    And the user clicks on the link icon
    When the user enters text and link infos and click on the save button
    Then the user should be able to send and display the appreciation message


  Scenario: Mention adding
    Given the user is on the login page
    And the user enters the hr100 information
    And the user should be able to login
    And the user lands on the appreciation message page
    And the user clicks on the mention icon
    And the user clicks the Employees and departments option
    When the user clicks the marketing2@cybertekschool.com
    Then the user should be able to add mention and send and display the the message


  Scenario: Login as hr100 user
    Given the user is on the login page
    When the user enters the hr100 information
    Then the user should be able to login

  Scenario: Adding quote
    Given the user is on the login page
    And the user enters the hr100 information
    And the user should be able to login
    And the user lands on the appreciation message page
    And the user clicks on the quote icon
    Then the user clicks the send button


  Scenario: Adding video
    Given the user is on the login page
    And the user enters the hr100 information
    And the user should be able to login
    And the user lands on the appreciation message page
    And the user clicks on the video icon
    And the user enters the video URL
    When the user clicks the save button
    Then the user should be able to send the message