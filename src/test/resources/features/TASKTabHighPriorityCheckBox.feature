Feature : Click On the "High Priority" Checkbox in the Task Tab

  Agile Story : User should be able to click on the "High Priority" checkbox to set the current task to a top priority task.

  Background:
    Given the user is on login page
    Then the user enters valid credentials
    And the user navigate to "Task" by Quick Menu

    Scenario: the user clicks on the High Priority check box
      When the user clicks on High Priority check box
      Then High Priority check box should be selected