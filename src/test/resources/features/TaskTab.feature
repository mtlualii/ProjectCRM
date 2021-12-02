Feature: User clicks on the High Priority Check Box

	#User Story: As a user, I should be able to assign tasks under the Quick Navigate Menu
	#Acceptance Criteria: User should be able to click on the "High Priority" checkbox to set the current task to a top priority task.

	Background: Login
		Given the user is on login page
		Then the user enters valid credentials
		And Navigate to "Task" by Quick Menu

	@LUE-692
	Scenario:Task Tab_User clicks on the High Priority Check Box
		When the user clicks on the High Priority Check Box  
		Then the High Priority Check Box should be able to selected   