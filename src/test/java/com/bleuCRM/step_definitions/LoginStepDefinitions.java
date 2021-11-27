package com.bleuCRM.step_definitions;

import com.bleuCRM.pages.BasePage;
import com.bleuCRM.pages.DashboardPage;
import com.bleuCRM.pages.LoginPage;
import com.bleuCRM.utilities.BrowserUtils;
import com.bleuCRM.utilities.ConfigurationReader;
import com.bleuCRM.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.eo.Se;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class LoginStepDefinitions {

    LoginPage loginPage = new LoginPage();

    @Given("the user is on login page")
    public void the_user_is_on_login_page() {

        Driver.get().get(ConfigurationReader.get("url"));
        Driver.get().manage().window().maximize();
    }

    @When("the user enters valid credentials")
    public void the_user_enters_valid_credentials() {

        loginPage.usernameBox.sendKeys(ConfigurationReader.get("username"));
        loginPage.passwordBox.sendKeys(ConfigurationReader.get("password"));
        loginPage.logInButton.click();

    }

    @Then("the user sees title {string}")
    public void the_user_sees_title(String expectedTitle) {

        BrowserUtils.waitForPageToLoad(1);
        Assert.assertEquals(expectedTitle, Driver.get().getTitle());


    }




}
