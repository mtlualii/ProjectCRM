package com.bleuCRM.step_definitions;

import com.bleuCRM.pages.LoginPage;
import com.bleuCRM.pages.MessagePage;
import com.bleuCRM.utilities.BrowserUtils;
import com.bleuCRM.utilities.ConfigurationReader;
import com.bleuCRM.utilities.Driver;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.List;


public class MessageStepsDefinitions {

    WebDriverWait wait = new WebDriverWait(Driver.get(), 3);
    String demoMsg = new Faker().lordOfTheRings().character();

    @Given("user on the login page")
    public void user_on_the_login_page() {
        Driver.get().get(ConfigurationReader.get("url"));
    }

    @Given("user logs in with valid credential")
    public void user_logs_in_with_valid_credential() {
        LoginPage loginPage = new LoginPage();
        loginPage.usernameBox.sendKeys(ConfigurationReader.get("hr_username"));
        loginPage.passwordBox.sendKeys(ConfigurationReader.get("password"));
        loginPage.logInButton.click();

    }

    @Given("user clicks on {string} tab under Activity Stream")
    public void user_clicks_on_tab_under_Activity_Stream(String activityTab) {
        Driver.get().findElement(By.xpath("//*[.='" + activityTab + "']")).click();
        BrowserUtils.waitFor(2);
    }

    @Given("user should be able to click on {string} icon")
    public void user_should_be_able_to_click_on_icon(String msgBoxFunc) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@title='" + msgBoxFunc + "']")));
        Assert.assertTrue(msgBoxFunc + " is clickable", Driver.get().findElement(By.xpath("//*[@title='" + msgBoxFunc + "']")).isDisplayed());
    }

    @When("user clicks on {string} icon")
    public void user_clicks_on_icon(String msgBoxFunc) {
        Driver.get().findElement(By.xpath("//*[@title='" + msgBoxFunc + "']")).click();
    }

    @Then("upload files and images table should be displayed")
    public void upload_files_and_images_table_should_be_displayed() {
        Assert.assertTrue(new MessagePage().uploadFilesAndImagesText.isDisplayed());
    }

    @Then("upload files and images table should be interactable")
    public void upload_files_and_images_table_should_be_interactable() {
        MessagePage messagePage = new MessagePage();
        Actions actions = new Actions(Driver.get());
        actions.moveToElement(messagePage.uploadFilesAndImagesText).perform();
        //????????????????????????
    }

    @Given("user should be able to click on {string} button on To line")
    public void user_should_be_able_to_click_on_button_on_To_line(String string) {
        Assert.assertTrue(new MessagePage().addMoreButtonOnMessage.isDisplayed());
    }

    @When("user clicks on {string} button on To line")//yesterday
    public void user_clicks_on_button_on_To_line(String string) {
        new MessagePage().addMoreButtonOnMessage.click();
        BrowserUtils.waitFor(2);

    }

    @Then("Add more pop up is displayed")
    public void add_more_pop_up_is_displayed() {
        Assert.assertTrue(new MessagePage().addMorePopupWindow.isDisplayed());
    }

    @When("user clicks on {string} box on the table")
    public void user_clicks_on_box_on_the_table(String string) {
        new MessagePage().employeesAndDepartmentsTabButton.click();
    }

    @Then("contacts should be listed")
    public void contacts_should_be_listed() {
        Assert.assertFalse("Contacts isnt listed", new MessagePage().EmployeesAndDepartmentsContactsList.isEmpty());
    }

    @Then("user should be able to select contacts from the list")
    public String[] user_should_be_able_to_select_contacts_from_the_list() {
        MessagePage n = new MessagePage();
        //int num = new Faker().number().numberBetween(1, n.EmployeesAndDepartmentsContactsList.size());
        String selectedName1 = n.EmployeesAndDepartmentsContactsList.get(0).getText();
        n.EmployeesAndDepartmentsContactsList.get(0).click();
        String selectedName2 = n.EmployeesAndDepartmentsContactsList.get(6).getText();
        n.EmployeesAndDepartmentsContactsList.get(6).click();
        return new String[]{selectedName1, selectedName2};
    }

    @Then("user should be able to select a contact from the list")
    public void user_should_be_able_to_select_a_contact_from_the_list() {
        MessagePage n = new MessagePage();
        int num = new Faker().number().numberBetween(1, n.EmployeesAndDepartmentsContactsList.size());
        String selectedName1 = n.EmployeesAndDepartmentsContactsList.get(num).getText();
        n.EmployeesAndDepartmentsContactsList.get(num).click();
    }

    @Then("selected contacts should be listed on To line")
    public void selected_contacts_should_be_listed_on_To_line() {
        List<String> actualListBox = BrowserUtils.getElementsText(new MessagePage().toListBox);
//        System.out.println(actualListBox);
//        System.out.println(Arrays.asList(user_should_be_able_to_select_contacts_from_the_list()));
        Assert.assertTrue(actualListBox.containsAll(Arrays.asList(user_should_be_able_to_select_contacts_from_the_list())));
    }

    @Then("a yellow area should be displayed on message area")
    public void a_yellow_area_should_be_displayed_on_message_area() {
        MessagePage msgpg = new MessagePage();
        msgpg.swapToMessageIframe();
        Assert.assertTrue(msgpg.quoteYellowArea.isDisplayed());
    }

    @Then("selected contacts should be listed on Message area box")
    public void selected_contacts_should_be_listed_on_Message_area_box() {
        MessagePage msgpg = new MessagePage();
        msgpg.swapToMessageIframe();
        Assert.assertTrue(Driver.get().findElement(By.xpath("/html[1]/body[1]/span[1]")).isDisplayed());
    }

    @When("user write message to Message area box")
    public void user_write_message_to_Message_area_box() {
        MessagePage asd = new MessagePage();
        asd.swapToMessageIframe();
        asd.messageBox.sendKeys(demoMsg);
    }

    @Then("message should be displayed")
    public void message_should_be_displayed() {
        Assert.assertEquals(demoMsg,new MessagePage().messageBox.getText());
    }

    @When("user clicks on Send button")
    public void user_clicks_on_Send_button() {
        Driver.get().switchTo().defaultContent();
        new MessagePage().messageSendButton.click();
    }

    @Then("message should be listed on Activity Stream")
    public void message_should_be_listed_on_Activity_Stream() {
       Assert.assertEquals(demoMsg,Driver.get().findElement(By.xpath("//div[starts-with(@id,'blog_post_body_')]")).getText());



    }



}
