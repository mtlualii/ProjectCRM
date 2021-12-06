package com.bleuCRM.step_definitions;

import com.bleuCRM.pages.ActivityStream;
import com.bleuCRM.pages.AppreciationPage;
import com.bleuCRM.pages.LoginPage;
import com.bleuCRM.utilities.BrowserUtils;
import com.bleuCRM.utilities.ConfigurationReader;
import com.bleuCRM.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AppreciationStepDefs {

    AppreciationPage appreciationPage = new AppreciationPage();

    @Given("the user lands on the appreciation message page")
    public void the_user_lands_on_the_appreciation_message_page() {

        ActivityStream activityStream = new ActivityStream();

        BrowserUtils.waitFor(2);

        activityStream.moreBtn.click();

        BrowserUtils.waitFor(2);

        activityStream.AppreciationBtn.click();

        BrowserUtils.waitFor(2);

    }

    @Given("the user clicks on the link icon")
    public void the_user_clicks_on_the_link_icon() {


        appreciationPage.linkBtn.click();
        BrowserUtils.waitFor(2);

    }

    @When("the user enters text and link infos and click on the save button")
    public void the_user_enters_text_and_link_infos_and_click_on_the_save_button() {


        appreciationPage.linkTxtBox.sendKeys("news");
        appreciationPage.linkUrlBox.sendKeys("https://edition.cnn.com/");
        appreciationPage.linkSaveBtn.click();

    }


    @Then("the user should be able to send and display the appreciation message")
    public void the_user_should_be_able_to_send_and_display_the_appreciation_message() {

        BrowserUtils.waitFor(2);

        appreciationPage.AppreciationSendBtn.click();

        appreciationPage.newsUrl.isDisplayed();

    }

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {

        String url = ConfigurationReader.get("url");
        Driver.get().get(url);

    }

    @When("the user enters the hr100 information")
    public void the_user_enters_the_hr100_information() {

        String username = ConfigurationReader.get("hr100_username");
        String password = ConfigurationReader.get("hr100_password");

        LoginPage loginPage = new LoginPage();
        loginPage.usernameBox.sendKeys(username);
        loginPage.passwordBox.sendKeys(password);
        loginPage.logInButton.click();

    }

    @Then("the user should be able to login")
    public void the_user_should_be_able_to_login() {

        BrowserUtils.waitFor(1);
        String actualTitle = Driver.get().getTitle();


    }




    @Given("the user clicks on the mention icon")
    public void the_user_clicks_on_the_mention_icon() throws InterruptedException {

        Thread.sleep(1);
        appreciationPage.mentionBtn.click();
        BrowserUtils.waitFor(2);

    }

    @Given("the user clicks the Employees and departments option")
    public void the_user_clicks_the_Employees_and_departments_option() {

        appreciationPage.EmplyAndDepOpt.click();
        BrowserUtils.waitFor(2);
    }

    @When("the user clicks the marketing2@cybertekschool.com")
    public void the_user_clicks_the_marketing2_cybertekschool_com() {

        appreciationPage.Market2Mention.click();
        BrowserUtils.waitFor(2);
    }

    @Then("the user should be able to add mention and send and display the the message")
    public void the_user_should_be_able_to_add_mention_and_send_and_display_the_the_message() {

        BrowserUtils.waitFor(2);
        appreciationPage.AppreciationSendBtn.click();

    }


    @Given("the user clicks on the quote icon")
    public void the_user_clicks_on_the_quote_icon() {// Write code here that turns the phrase above into concrete actions

        appreciationPage.QuoteBtn.click();
        BrowserUtils.waitFor(2);
    }


    @Then("the user clicks the send button")
    public void the_user_clicks_the_send_button() {

        appreciationPage.AppreciationSendBtn.click();

    }

    @Given("the user clicks on the video icon")
    public void the_user_clicks_on_the_video_icon() {
        appreciationPage.VideoBtn.click();


    }

    @Given("the user enters the video URL")
    public void the_user_enters_the_video_URL() {

        appreciationPage.VideoLinkBox.sendKeys("https://www.youtube.com/watch?v=uK2H0i6tObI");

    }

    @When("the user clicks the save button")
    public void the_user_clicks_the_save_button() {

        appreciationPage.VideoSaveBtn.click();

    }

    @Then("the user should be able to send the message")
    public void the_user_should_be_able_to_send_the_message() {

        appreciationPage.AppreciationSendBtn.click();

    }



}
