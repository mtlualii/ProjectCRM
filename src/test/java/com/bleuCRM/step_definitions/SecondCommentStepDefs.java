package com.bleuCRM.step_definitions;

import com.bleuCRM.pages.LoginPage;
import com.bleuCRM.utilities.BrowserUtils;
import com.bleuCRM.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SecondCommentStepDefs extends LoginPage {


    String message2 = "This is a second test comment";

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

        Assert.assertEquals(expected,actual);

    }
}
