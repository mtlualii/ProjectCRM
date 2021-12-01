@LUE-593
Feature: User should be able to send message

  Agile Story: As a user, I should be able to send messages by clicking on Message

  Background:
    Given user on the login page
    And user logs in with valid credential
    And user clicks on "Message" tab under Activity Stream

    #"//*[@id='diskuf-selectdialog-3UhAWHv']//td//span[text()='Upload files and images']" text
    #"//*[@id='diskuf-selectdialog-3UhAWHv']//td//span[@class='wd-fa-add-file-light']" upload files click

  @LUE-627
  Scenario: Local disk upload function
    Given  user should be able to click on "Upload files" icon
    When user clicks on "Upload files" icon
    Then upload files and images table should be displayed
    And upload files and images table should be interactable

    #"bx-destination-tag" add more button id
  #"popup-window-content-BXSocNetLogDestination" add more popup window
  #"destDepartmentTab_destination4444720" Employees and Departments box in Add more
  #"//div[@class='bx-finder-company-department-employee-name']" employee list
  #"feed-add-post-destination-item" selected contact on To list
  @LUE-628
  Scenario: Adding multiple contacts to message function
    Given user should be able to click on "Add more" button on To line
    When user clicks on "Add more" button on To line
    Then Add more pop up is displayed
    When user clicks on "Employees and Departments" box on the table
    Then contacts should be listed
    And user should be able to select contacts from the list
    And selected contacts should be listed on To line


    # "#bx-b-quote-blogPostForm>span" quote icon
  # iframe var message box


@LUE-629
  Scenario: Creating quote function
    Given user should be able to click on "Quote text" icon
    When user clicks on "Quote text" icon
    Then a yellow area should be displayed on message area

    #"bx-finder-groupbox-content" recent contact lsit box
  #"destDepartmentTab_mention58449878" Employees and Departments box in Add mention
  #"popup-window-content-BXSocNetLogDestination" Add mention popup windows (it's same with add more)
#"//div[@class='bx-finder-company-department-employee-name']" employee list
  @LUE-630
  Scenario: Add mention function
    Given user should be able to click on "Add mention" icon
    When user clicks on "Add mention" icon
    Then Add more pop up is displayed
    When user clicks on "Employees and Departments" box on the table
    Then contacts should be listed
    And user should be able to select a contact from the list
    And selected contacts should be listed on Message area box

#"blog-submit-button-save"
  @LUE-631
  Scenario: Sending message function
    When user write message to Message area box
    Then message should be displayed
    When user clicks on Send button
    Then message should be listed on Activity Stream


