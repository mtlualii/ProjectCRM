package com.bleuCRM.step_definitions;

import com.bleuCRM.pages.BasePage;
import com.bleuCRM.pages.ThemePage;
import com.bleuCRM.utilities.BrowserUtils;
import com.bleuCRM.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Wait;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class ThemeStepDefinitions {

    ThemePage themePage = new ThemePage();
    BasePage basePage = new BasePage();

    @Given("The User is on the Mainpage")
    public void the_User_is_on_the_Mainpage() {
        System.out.println("The User is on the Mainpage");
    }

    @When("The User clicks own username at the right top of page")
    public void the_User_clicks_own_username_at_the_right_top_of_page() {
        basePage.rightTopUsername.click();
    }

    @When("The User selects Theme on the opened list")
    public void the_User_selects_Theme_on_the_opened_list() {
        themePage.theme.click();
    }

    @When("The User selects any image in new window that opens")
    public void the_User_selects_any_image_in_new_window_that_opens() {
        BrowserUtils.waitFor(2);
        themePage.sunsetImage.click();
        BrowserUtils.waitFor(3);

    }

    @When("The User should click Save button")
    public void the_User_should_click_Save_button() {
        themePage.saveButton.click();
        BrowserUtils.waitFor(2);
        (Driver.get()).navigate().refresh();

    }

    @Then("Selected image should be visible in the background")
    public void selected_image_should_be_visible_in_the_background() {
        BrowserUtils.waitFor(2);
        String ba = themePage.backgroundImage.getAttribute("innerHTML");
        System.out.println(ba);
        Assert.assertTrue(ba.contains("light:sunset"));

        BrowserUtils.waitFor(2);
        basePage.rightTopUsername.click();
        themePage.theme.click();
        BrowserUtils.waitFor(2);
        themePage.defaultImage.click();
        BrowserUtils.waitFor(1);
        themePage.saveButton.click();
    }

    @When("The User clicks Custom Theme button in new window that opens")
    public void the_User_clicks_Custom_Theme_button_in_new_window_that_opens() {
        themePage.createButton.click();
    }

    @When("Create Custom Theme window should appear")
    public void create_Custom_Theme_window_should_appear() {
        String expectedText = "Create Custom Theme";
        String actualText = themePage.createCustomTheme.getText();
        System.out.println(themePage.createCustomTheme.getText());
        Assert.assertTrue(actualText.contains(expectedText));

    }

    @When("The User should be able to upload an image")
    public void the_User_should_be_able_to_upload_an_image() throws Exception{

        Robot robot = new Robot();

        String projectPath = System.getProperty("user.dir");
        String filePath = "src\\test\\resources\\111.jpg";
        String fullPath = projectPath+"\\"+filePath;
        System.out.println(fullPath);

        themePage.uploadBackgroundImage.click();

        robot.setAutoDelay(2000);

        StringSelection stringSelection = new StringSelection(fullPath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

        robot.setAutoDelay(1000);

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);

        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);

        robot.setAutoDelay(1000);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

    }

    @When("The User should click Create button")
    public void the_User_should_click_Create_button() {
        themePage.CustomThemeCreateButton.click();
        BrowserUtils.waitFor(2);
    }

    @And("The User should click save button")
    public void theUserShouldClickSaveButton() {
        themePage.saveButton.click();
        BrowserUtils.waitFor(1);
        (Driver.get()).navigate().refresh();
    }

    @Then("Uploaded image should be visible in the background")
    public void uploadedImageShouldBeVisibleInTheBackground() {
        BrowserUtils.waitFor(2);
        String Up = themePage.backgroundImage.getAttribute("innerHTML");
        System.out.println(Up);
        Assert.assertTrue(Up.contains("111"));

        BrowserUtils.waitFor(2);
        basePage.rightTopUsername.click();
        themePage.theme.click();
        BrowserUtils.waitFor(1);
        themePage.remove.click();
        BrowserUtils.waitFor(2);
        themePage.defaultImage.click();
        BrowserUtils.waitFor(2);
        themePage.saveButton.click();
        BrowserUtils.waitFor(2);

    }

    @When("The User selects any animated image in new window that opens")
    public void the_User_selects_any_animated_image_in_new_window_that_opens() {
        BrowserUtils.waitFor(2);
        themePage.animatedImage.click();
        BrowserUtils.waitFor(2);
    }

    @And("The User should click Save Button")
    public void TheUserShouldClickSaveButton() {
        themePage.saveButton.click();
        BrowserUtils.waitFor(2);
    }

    @Then("Selected animated image should be visible in the background")
    public void selected_animated_image_should_be_visible_in_the_background() {
        BrowserUtils.waitFor(2);
        String Up = themePage.animatedBackground.getAttribute("innerHTML");
        System.out.println(Up);
        Assert.assertTrue(Up.contains("waterfall"));

        BrowserUtils.waitFor(2);
        basePage.rightTopUsername.click();
        themePage.theme.click();
        BrowserUtils.waitFor(2);
        themePage.defaultImage.click();
        BrowserUtils.waitFor(1);
        themePage.saveButton.click();
        BrowserUtils.waitFor(2);
    }

    @When("The User selects Configure Notifications on the opened list")
    public void the_User_selects_Configure_Notifications_on_the_opened_list() {
        BrowserUtils.waitFor(1);
        themePage.configureNotifications.click();
        BrowserUtils.waitFor(2);
    }

    @When("The User should be able to select Simple Mode or Advance Mode")
    public void the_User_should_be_able_to_select_Simple_Mode_or_Advance_Mode() {
        themePage.Advanced.click();
        BrowserUtils.waitFor(1);
    }

    @Then("Only Simple Mode or Advance Mode should be selected")
    public void only_Simple_Mode_or_Advance_Mode_should_be_selected() {
        Assert.assertTrue(themePage.Advanced.isSelected());
        Assert.assertFalse(themePage.simpleMode.isSelected());
        themePage.simpleMode.click();
        BrowserUtils.waitFor(1);
        themePage.NotificationsSave.click();
    }



}

