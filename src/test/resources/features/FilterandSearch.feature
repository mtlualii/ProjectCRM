@aa
Feature:User should be able to see default filters as "WORKFLOWS,ANNOUNCEMENTS,MY ACTIVITY,FAVORITES,and WORK"

  Background: Login as a hrUser
    Given the user is on the login page
    Then the user enters valid credentials
    And the user click on filter and search field

  Scenario: Check default filters

    Then the user should see following values
      | WORK          |
      | FAVORITES     |
      | MY ACTIVITY   |
      | ANNOUNCEMENTS |
      | WORKFLOWS     |


  #*User Story:* As a user, I should be able to use "Filter and search" functionality on Active Stream

  #*Acceptance Criteria:*
 # User should be able to see default filters as "my activity, work, favorite, announcements, and workflows" 
 # User should be able to add and remove field.
 # User should be able to search by selecting Date,
 # User should be able to search by selecting one or more Type,
 # User should be able to save filter.
 # User should be able to restore default field,
 # User should be able to reset filters to default.

  Scenario:User should be add and remove field
    When the user click addfield
    And Unselect "Date","Type","Author","To" and Select "Favorites","Tag","Extranet"
    Then the user check last selected fields

  Scenario:select any date
    When the user click date area and select Current day
    And the user click search button
    Then the user should be see only selected date

  @smoke
  Scenario:User should be save filter
    When User click SAVE FILTER button
    Then User wright "TEAM ACTIVITY" and click SAVE button
    And  User check last filters