package com.bleuCRM.step_definitions;

import com.bleuCRM.pages.TaskPage;
import com.bleuCRM.utilities.BrowserUtils;
import com.bleuCRM.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TaskTabStepDefs {

    TaskPage taskPage = new TaskPage();

    ////////////////////////////////////////////////LUE-692
    @When("the user clicks on the High Priority Check Box")
    public void the_user_clicks_on_the_High_Priority_Check_Box() {
        BrowserUtils.waitFor(3);
        taskPage.highPriorityCheckBox.click();
    }

    @Then("the High Priority Check Box should be able to selected")
    public void the_High_Priority_Check_Box_should_be_able_to_selected() {

        Assert.assertTrue("verify check box is selected", taskPage.highPriorityCheckBox.isSelected());
    }
    ////////////////////////////////////////////////LUE-694

    @When("the user clicks on the checklist item")
    public void the_user_clicks_on_the_checklist_item() {
        BrowserUtils.waitFor(2);
        taskPage.checklistItem.click();
    }

    String checkListMessage = "test19";

    @When("the user enters some text in the checklist line")
    public void the_user_enters_some_text_in_the_checklist_line() {
        taskPage.checklistLine.sendKeys(checkListMessage);
    }

    @When("the user clicks on the add item")
    public void the_user_clicks_on_the_add_item() {
        taskPage.checklistAddItem.click();
    }

    @Then("the entered text should be able to displayed")
    public void the_entered_text_should_be_able_to_displayed() {
        Assert.assertTrue("verify test message is present", taskPage.checklistMessageLocated.getText().contains(checkListMessage));
        }

    ////////////////////////////////////////////////LUE-695

    @And("the user deletes the entered text")
    public void theUserDeletesTheEnteredText() {
        taskPage.checklistDeleteButton.click();
    }

    @Then("the deleted text should be disappeared")
    public void theDeletedTextShouldBeDisappeared() {
        BrowserUtils.waitFor(2);
        Object driver;
        Boolean isMessagePresent = Driver.get().findElements(By.xpath("//span[@class='js-id-checklist-is-i-title ']")).size() > 0 ;
        Assert.assertFalse("verify test message is still present", isMessagePresent);
    }

    ////////////////////////////////////////////////LUE-696
    @When("the user enters some text in the things to do line")
    public void the_user_enters_some_text_in_the_things_to_do_line() {
        BrowserUtils.waitFor(3);
        taskPage.thingsToDoLine.sendKeys(checkListMessage);
    }

    @When("the user clicks on the send button")
    public void the_user_clicks_on_the_send_button() {
        taskPage.thingsToDoSendButton.click();
    }

    @When("the user clicks on the view task button")
    public void the_user_clicks_on_the_view_task_button() {
        taskPage.thingsToDoViewTaskPopUp.click();
    }

    @Then("the entered text should be displayed")
    public void the_entered_text_should_be_displayed() {
        Driver.get().switchTo().frame(taskPage.iframeElement);
        System.out.println("taskPage.thingsToDoPageTitle.getText() = " + taskPage.thingsToDoPageTitle.getText());
        Assert.assertEquals("verify task message is displayed", checkListMessage, taskPage.thingsToDoPageTitle.getText());
    }





}





