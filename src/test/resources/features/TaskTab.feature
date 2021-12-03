Feature: Task Tab

#User Story: As a user, I should be able to assign tasks under the Quick Navigate Menu

	Background: Login
		Given the user is on login page
		Then the user enters valid credentials
		And Navigate to "Task" by Quick Menu


	@LUE-692 @LUE-697
	Scenario:Task Tab_User clicks on the High Priority Check Box
		When the user clicks on the High Priority Check Box  
		Then the High Priority Check Box should be able to selected


	@LUE-694 @LUE-697
	Scenario:Task Tab_User adds a checklist item by clicking on the add button
		When the user clicks on the checklist item
		And the user enters some text in the checklist line
		And the user clicks on the add item
		Then the entered text should be able to displayed


	@LUE-695 @LUE-697
	Scenario: Task Tab_User deletes a checklist item
		When the user clicks on the checklist item
		And the user enters some text in the checklist line
		And the user clicks on the add item
		And the user deletes the entered text
		Then the deleted text should be disappeared


	@LUE-696 @LUE-697
	Scenario: Task Tab_User sends tasks
		When the user enters some text in the things to do line
		And the user clicks on the send button
		And the user clicks on the view task button
		Then the entered text should be displayed







