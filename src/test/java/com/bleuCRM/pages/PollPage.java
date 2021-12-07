package com.bleuCRM.pages;

import com.bleuCRM.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PollPage extends DashboardPage {

    public static int countsOfAnswers;

    @FindBy(id = "bx-destination-tag")
    public WebElement addMoreButtonOnToLine;

    @FindBy(id = "popup-window-content-BXSocNetLogDestination")
    public WebElement addMorePopupWindow;

    @FindBy(xpath = "//a[starts-with(@id,'destDepartmentTab_')]")
// @FindBy(xpath = "//a[starts-with(@id,'destDepartmentTab_destination')]")
    public WebElement employeesAndDepartmentsTabOnPopUp;

    @FindBy(xpath = "//div[@class='bx-finder-company-department-employee-name']")
    public List<WebElement> EmployeesAndDepartmentsContactsList;

    @FindBy(css = "#feed-add-post-destination-item>span")
    public List<WebElement> toListBox;

    @FindBy(id = "bx-admin-prefix")
    public WebElement linkAddPopup;

    @FindBy(id = "undefined")
    public WebElement saveLinkButton;

    @FindBy(xpath = "//body[starts-with(@style,'min-height')]")
    public WebElement pollMessageBox;

    @FindBy(linkText = "Add question")
    public WebElement addQuestionLink;

    @FindBy(xpath = "//li[@class='vote-question']")
    public List<WebElement> questionOptionsBlocks;

    @FindBy(xpath = "(//li[@class='vote-question'])[1]/ol/li//input[@id]")
    public List<WebElement> firstQuestionBlockAnswerList;

    @FindBy(xpath = "(//li[@class='vote-question'])[1]/div//input[@type='text']")
    public WebElement firstQuestionInputBox;

    @FindBy(css = "[title='Delete question']")
    public WebElement deleteQuestionMark;

    @FindBy(css = "[title='Delete answer']")
    public WebElement deleteAnswerMark;

    @FindBy(css = "input[id^='multi']")
    public WebElement allowMultipleChoiceCheckBox;

    @FindBy(id = "blog-submit-button-save")
    public WebElement sendButton;

    @FindBy(xpath = "//div[starts-with(@id,'blog_post_body_')]")
    public List<WebElement> activityStreamList;

    @FindBy(xpath = "(//div[starts-with(@id,'blg-post-img-')])[1]/div[4]")
    public WebElement lastPostBodyVoteElement;

    public WebElement myIcon(String iconName) {
        return Driver.get().findElement(By.xpath("//*[@title='" + iconName + "']"));
    }

    public void swapToMessageIframe() {
        Driver.get().switchTo().frame(0);
    }

}
