package com.bleuCRM.step_definitions;

import com.bleuCRM.pages.PollPage;
import com.bleuCRM.utilities.BrowserUtils;
import com.bleuCRM.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

public class Poll_Step_Definitions {

    @Given("user clicks on {string} tab under Activity Stream")
    public void user_clicks_on_tab_under_Activity_Stream(String activityTab) {
        Driver.get().findElement(By.xpath("//*[.='" + activityTab + "']")).click();
        BrowserUtils.waitFor(2);
    }

    @Given("user should be able to see Add more button on To line")
    public void user_should_be_able_to_see_button_on_To_line() {
        Assert.assertTrue(new PollPage().addMoreButtonOnToLine.isDisplayed());
    }

    @When("user clicks on Add more button on To line")
    public void user_clicks_on_button_on_To_line() {
        new PollPage().addMoreButtonOnToLine.click();
        BrowserUtils.waitFor(2);
    }

    @Then("Add more pop up is displayed")
    public void add_more_pop_up_is_displayed() {
        BrowserUtils.waitFor(1);
        Assert.assertTrue(new PollPage().addMorePopupWindow.isDisplayed());
    }

    @When("user clicks on Employees and Departments link on the table")
    public void user_clicks_on_box_on_the_table() {
        new PollPage().employeesAndDepartmentsTabOnPopUp.click();
    }

    @Then("contacts should be listed")
    public void contacts_should_be_listed() {
        BrowserUtils.waitFor(2);
        Assert.assertFalse("Contacts isn't listed", new PollPage().EmployeesAndDepartmentsContactsList.isEmpty());
    }

    @Then("user should be able to select multiple contact from the list")
    public void user_should_be_able_to_select_a_contact_from_the_list() {
         new PollPage().EmployeesAndDepartmentsContactsList.get(3).click();
         new PollPage().EmployeesAndDepartmentsContactsList.get(4).click();

    }

    @Then("selected contact should be listed on To line")
    public void selected_contact_should_be_listed_on_To_line() {
        Assert.assertTrue("To box has two mail",new PollPage().toListBox.size()>2);
    }


    @Then("Link pop up is displayed")
    public void link_pop_up_is_displayed() {
        Assert.assertTrue(new PollPage().linkAddPopup.isDisplayed());
    }

    @When("user enters {string} to {string} box")
    public void user_enters_to_box(String text, String boxName) {
        Driver.get().findElement(By.xpath("//input[@placeholder='"+boxName+"']")).sendKeys(text);
    }


    @When("user clicks on Save button")
    public void user_clicks_on_Save_button() {
       new PollPage().saveLinkButton.click();
    }


    @Then("Link text which is {string} should be displayed on message box")
    public void linkTextWhichIsShouldBeDisplayedOnMessageBox(String linkText) {
        new PollPage().swapToMessageIframe();
        Assert.assertEquals(linkText,new PollPage().pollMessageBox.getText());
    }

    @When("user clicks on {string} icon")
    public void user_clicks_on_icon(String iconName) {
        new PollPage().myIcon(iconName).click();
    }

    @Given("user should be able to see {string} icon")
    public void userShouldBeAbleToSeeIcon(String iconName) {
        Assert.assertTrue(new PollPage().myIcon(iconName).isDisplayed());
    }

    @And("user should be able to select a contact from the list")
    public void userShouldBeAbleToSelectAContactFromTheList() {
        new PollPage().EmployeesAndDepartmentsContactsList.get(3).click();
    }

    @And("selected contact should be listed on Message area box")
    public void selectedContactShouldBeListedOnMessageAreaBox() {
        PollPage p = new PollPage();
        p.swapToMessageIframe();
        Assert.assertTrue(p.pollMessageBox.getText().contains("@cybertekschool.com"));
    }
}
