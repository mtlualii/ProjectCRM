Feature: Announcement

  Agile Story: As a user, I should be able to send announcements from Announcement subheading from "More" under Activity Stream

  Background: Login
    Given the user is on login page
    When the user enters valid credentials
    Then the user sees title "Portal"
    And user clicks on "More" tab under Activity Stream
    Given user clicks on "Announcement" tab under More



  Scenario:User should be able to attach a link
    When user clicks on Link  button on To line
    Then Link popup is displayed
    When user enters "www.duckduckgo.com" to "Link URL" box
    And user must click on Save button
    Then Link text which is "www.duckduckgo.com" should be displayed on Announcement box

  Scenario:User should be able to create a quote
    When user clicks on Quote button on To line
    Then Quote box  should be  displayed
  @wip

  Scenario:User should be able to send an announcement.
    When user enters "That is first commit1" to Announcement box
    And User should click send
    Then User should check announcement is sended "That is first commit1"