Feature: Comment Function

  Background:
    Given the user is on login page
    When the user enters valid credentials
    Then the user sees title "Portal"


  Scenario:User should be able to make a comment on other employees' posts
    When Click on Comment button on any employees' post
    And Enter text "This is a test comment" into comment box
    Then Click Send button and verify the comment



  @wip
  Scenario: User should be able to like reviewers' comments
    Given Click on Reply button on other reviewer's comment
    And Enter Reply text "This is a second test comment" into comment box
    Then Click on Send button and verify the comment

  Scenario: User should be able to visit other profiles
    When the user click on any reviewers name on the posts and verify that


