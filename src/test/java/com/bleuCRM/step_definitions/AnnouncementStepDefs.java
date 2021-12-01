package com.bleuCRM.step_definitions;

import com.bleuCRM.pages.AnnouncementPage;
import com.bleuCRM.utilities.BrowserUtils;
import com.bleuCRM.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AnnouncementStepDefs {

    AnnouncementPage announcementPage=new AnnouncementPage();

    @Given("user clicks on {string} tab under More")
    public void userClicksOnTabUnderMore(String arg0) {
        announcementPage.announcementtab.click();

    }


    @When("user clicks on Link  button on To line")
    public void user_clicks_on_Link_button_on_To_line() {
        announcementPage.link.click();
    }

    @Then("Link popup is displayed")
    public void link_popup_is_displayed() {
        Assert.assertTrue(announcementPage.linkBox.isEnabled());
    }


    @When("user must click on Save button")
    public void user_must_click_on_Save_button() {
        announcementPage.saveButton.click();
    }

    @Then("Link text which is {string} should be displayed on Announcement box")
    public void link_text_which_is_should_be_displayed_on_Announcement_box(String linkText) {
        WebElement iframeElement = Driver.get().findElement(By.tagName("iframe"));

        Driver.get().switchTo().frame(iframeElement);
        BrowserUtils.waitFor(2);
        Assert.assertEquals(linkText,announcementPage.announcementTextBox.getText());
    }


    @When("user clicks on Quote button on To line")
    public void userClicksOnQuoteButtonOnToLine() {
        announcementPage.quatoButton.click();
    }

    @Then("Quote box  should be  displayed")
    public void quoteBoxShouldBeDisplayed() {
        WebElement iframeElement = Driver.get().findElement(By.tagName("iframe"));

        Driver.get().switchTo().frame(iframeElement);
        Assert.assertTrue(announcementPage.quatoTextBox.isEnabled());
    }

    @And("User should be able to click any user")
    public void userShouldBeAbleToClickAnyUser() {
        
    }

    @Then("user should be able to see choosed user on Announcemet box")
    public void userShouldBeAbleToSeeChoosedUserOnAnnouncemetBox() {
        
    }

    @When("user enters {string} to Announcement box")
    public void userEntersToAnnouncementBox(String arg0) {
        
    }

    @And("User should click send")
    public void userShouldClickSend() {

    }

    @Then("User should check announcement is sended")
    public void userShouldCheckAnnouncementIsSended() {
    }
}
