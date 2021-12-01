package com.bleuCRM.step_definitions;

import com.bleuCRM.pages.DashboardPage;
import com.bleuCRM.utilities.BrowserUtils;
import com.bleuCRM.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

public class CommentStepDefs extends DashboardPage {
    String message = "This is a test comment";


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


    }

    @Then("Click Send button and verify the comment")
    public void click_Send_button_and_verify_the_comment() {
        String actual = Driver.get().findElement(By.xpath("//body[@contenteditable='true']")).getText();
        Driver.get().switchTo().defaultContent();
        BrowserUtils.waitFor(4);
        WebElement sendButton = Driver.get().findElement(By.xpath("//button[starts-with(@id,'lhe_button_submit_blogCommentForm')]"));
        sendButton.click();

        System.out.println(actual);
        Assert.assertEquals(message,actual);
    }



}
