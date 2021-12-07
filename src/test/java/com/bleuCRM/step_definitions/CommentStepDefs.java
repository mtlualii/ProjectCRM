package com.bleuCRM.step_definitions;

import com.bleuCRM.pages.DashboardPage;
import com.bleuCRM.utilities.BrowserUtils;
import com.bleuCRM.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import java.util.List;

public class CommentStepDefs extends DashboardPage {
    String message = "This is a test comment";
    String message2 = "This is a second test comment";

    @When("Click on Comment button on any employees' post")
    public void click_on_Comment_button_on_any_employees_post() {
        BrowserUtils.waitFor(2);
        Driver.get().findElement(By.xpath("(//a[text()='Comment'])[1]")).click();

    }

    @And("Enter text {string} into comment box")
    public void enter_text_into_comment_box(String string) {
        BrowserUtils.waitFor(2);
        Driver.get().switchTo().frame(0);
        WebElement a = Driver.get().findElement(By.xpath("//body[@contenteditable='true']"));
        a.sendKeys(message);
        BrowserUtils.waitFor(2);

    }

    @Then("Click Send button and verify the comment")
    public void click_Send_button_and_verify_the_comment() {
        String actual = Driver.get().findElement(By.xpath("//body[@contenteditable='true']")).getText();
        Driver.get().switchTo().defaultContent();
        BrowserUtils.waitFor(4);
        WebElement sendButton = Driver.get().findElement(By.xpath("//button[starts-with(@id,'lhe_button_submit_blogCommentForm')]"));
        sendButton.click();

        System.out.println(actual);
        Assert.assertEquals(message, actual);
    }


    @Given("Click on Reply button on other reviewer's comment")
    public void click_on_Reply_button_on_other_reviewer_s_comment() {
        BrowserUtils.waitFor(3);
        Driver.get().findElement(By.xpath("(//a[contains(text(),'Reply')])[1]")).click();
    }

    @And("Enter Reply text {string} into comment box")
    public void enter_Reply_text_into_comment_box(String string) {
        BrowserUtils.waitFor(2);
        Driver.get().switchTo().frame(0);
        Driver.get().findElement(By.xpath("//span[@class='bxhtmled-metion']")).sendKeys(message2);

    }

    @Then("Click on Send button and verify the comment")
    public void click_on_Send_button_and_verify_the_comment() {

        Driver.get().switchTo().defaultContent();
        BrowserUtils.waitFor(2);
        WebElement sendButton = Driver.get().findElement(By.xpath("//button[starts-with(@id,'lhe_button_submit_blogCommentForm')]"));
        sendButton.click();
        BrowserUtils.waitFor(2);
        String actual = Driver.get().findElement(By.xpath("(//a[@target='_blank'])[12]")).getText();

        System.out.println(actual);
        String expected = "hr6@cybertekschool.com";

        Assert.assertEquals(expected, actual);

    }

    @When("the user click on any reviewers name on the posts and verify that")
    public void the_user_click_on_any_reviewers_name_on_the_posts_and_verify_that() {

        List<WebElement> reviewers = Driver.get().findElements(By.xpath("//a[@class='feed-post-user-name']"));
        BrowserUtils.waitFor(1);
        List<String> reviewersList = BrowserUtils.getElementsText(reviewers);
        BrowserUtils.waitFor(3);
        for (int i =1;i< reviewersList.size();i++){
            if (reviewers.get(i).getText().equals("hr6@cybertekschool.com")){

            }else{
                BrowserUtils.waitFor(5);
                reviewers.get(i).click();
                BrowserUtils.waitFor(3);
                System.out.println(reviewersList.get(i));
                Assert.assertNotEquals("hr6@cybertekschool.com",reviewersList.get(i));
                break;
            }
        }
    }



}
