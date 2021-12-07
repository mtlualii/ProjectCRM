package com.bleuCRM.step_definitions;

import com.bleuCRM.pages.PollPage;
import com.bleuCRM.utilities.BrowserUtils;
import com.bleuCRM.utilities.Driver;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

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
        Assert.assertTrue("To box has two mail", new PollPage().toListBox.size() > 2);
    }


    @Then("Link pop up is displayed")
    public void link_pop_up_is_displayed() {
        Assert.assertTrue(new PollPage().linkAddPopup.isDisplayed());
    }

    @When("user enters {string} to {string} box")
    public void user_enters_to_box(String text, String boxName) {
        Driver.get().findElement(By.xpath("//input[@placeholder='" + boxName + "']")).sendKeys(text);
    }


    @When("user clicks on Save button")
    public void user_clicks_on_Save_button() {
        new PollPage().saveLinkButton.click();
    }


    @Then("Link text which is {string} should be displayed on message box")
    public void linkTextWhichIsShouldBeDisplayedOnMessageBox(String linkText) {
        new PollPage().swapToMessageIframe();
        Assert.assertEquals(linkText, new PollPage().pollMessageBox.getText());
    }

    @When("user clicks on {string} icon")
    public void in_message_tab_user_clicks_on_icon(String iconName) {
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

    @When("user clicks on Add question link")
    public void user_clicks_on_Add_question_link() {
        new PollPage().addQuestionLink.click();
    }

    @Then("one more question area should be displayed")
    public void one_more_question_area_should_be_displayed() {
        Assert.assertTrue(new PollPage().questionOptionsBlocks.size() > 1);
    }


    @When("user clicks on latest answer")
    public void user_clicks_on_latest_answer() {
        PollPage pollPage = new PollPage();
        PollPage.countsOfAnswers = pollPage.firstQuestionBlockAnswerList.size();
        pollPage.firstQuestionBlockAnswerList.get(PollPage.countsOfAnswers - 1).click();
    }

    @Then("a new answer box should be displayed")
    public void a_new_answer_box_should_be_displayed() {
        Assert.assertTrue((PollPage.countsOfAnswers+1) == new PollPage().firstQuestionBlockAnswerList.size());
    }



    @When("user clicks on Delete question mark")
    public void user_clicks_on_Delete_question_mark() {
        Actions actions = new Actions(Driver.get());
        PollPage p = new PollPage();
        actions.moveToElement(p.firstQuestionInputBox).perform();
        p.deleteQuestionMark.click();
    }

    @Then("the question area should be deleted")
    public void the_question_area_should_be_deleted() {
        Assert.assertTrue(new PollPage().questionOptionsBlocks.size()==1);
    }

    @When("user clicks on Delete answer mark")
    public void user_clicks_on_Delete_answer_mark() {
        PollPage pollPage = new PollPage();
        PollPage.countsOfAnswers = pollPage.firstQuestionBlockAnswerList.size();
        new Actions(Driver.get()).moveToElement(pollPage.firstQuestionBlockAnswerList.get(0)).perform();
        pollPage.deleteAnswerMark.click();
    }

    @Then("the question should be deleted")
    public void the_question_should_be_deleted() {
        Assert.assertTrue(PollPage.countsOfAnswers == (new PollPage().firstQuestionBlockAnswerList.size()+1));
    }

    @Given("Allow multiple choice box should be displayed")
    public void allow_multiple_choice_box_should_be_displayed() {
       Assert.assertTrue(new PollPage().allowMultipleChoiceCheckBox.isDisplayed());
    }

    @When("user selects Allow multiple choice")
    public void user_selects_Allow_multiple_choice() {
        new PollPage().allowMultipleChoiceCheckBox.click();
    }

    @Then("Allow multiple choice box should be selected")
    public void allow_multiple_choice_box_should_be_selected() {
        Assert.assertTrue(new PollPage().allowMultipleChoiceCheckBox.isSelected());
    }

    @When("user writes message to Message area box")
    public void user_writes_message_to_Message_area_box() {
       PollPage p = new PollPage();
       p.swapToMessageIframe();
       p.pollMessageBox.sendKeys("It's Always Sunny in Philadelphia");
       Driver.get().switchTo().defaultContent();
    }

    @When("user enters {string} to question box")
    public void user_enters_to_question_box(String question) {
       new PollPage().firstQuestionInputBox.sendKeys(question);
    }

    @When("User enters {string} to answers box")
    public void user_enters_to_answers_box(String answer) {
        PollPage p = new PollPage();
        for (WebElement a: p.firstQuestionBlockAnswerList ) {
            BrowserUtils.waitFor(1);
            a.sendKeys(answer);
        }
    }

    @When("user clicks on the Send button")
    public void user_clicks_on_Send_the_button() {
       new PollPage().sendButton.click();
    }

    @Then("poll should be listed on Activity Stream")
    public void poll_should_be_listed_on_Activity_Stream() {
       BrowserUtils.waitFor(3);
       PollPage p = new PollPage();
       Assert.assertTrue(p.lastPostBodyVoteElement.getAttribute("id").contains("vote"));

    }


}
