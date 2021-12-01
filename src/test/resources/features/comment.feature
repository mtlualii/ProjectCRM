Feature: Comment Function

  Background:
    Given the user is on login page
    When the user enters valid credentials
    Then the user sees title "Portal"

  Scenario:User should be able to make a comment on other employees' posts
    When Click on Comment button on any employees' post
    And Enter text "This is a test comment" into comment box
    Then Click Send button and verify the comment