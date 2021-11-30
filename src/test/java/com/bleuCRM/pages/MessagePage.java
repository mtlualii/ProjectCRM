package com.bleuCRM.pages;


import com.bleuCRM.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MessagePage extends BasePage{

    @FindBy(xpath = "//div[starts-with(@id,'diskuf-selectdialog')]//td//span[text()='Upload files and images']")
    public WebElement uploadFilesAndImagesText;

    @FindBy(id = "bx-destination-tag")
    public WebElement addMoreButtonOnMessage;

    @FindBy(id = "popup-window-content-BXSocNetLogDestination")
    public WebElement addMorePopupWindow;

    @FindBy(xpath = "//a[starts-with(@id,'destDepartmentTab_')]")// @FindBy(xpath = "//a[starts-with(@id,'destDepartmentTab_destination')]")
    public WebElement employeesAndDepartmentsTabButton;

    @FindBy(xpath = "//div[@class='bx-finder-company-department-employee-name']")
    public List<WebElement> EmployeesAndDepartmentsContactsList;

    @FindBy(css = "#feed-add-post-destination-item>span")
    public List<WebElement> toListBox;

    @FindBy(css = ".bxhtmled-quote")
    public WebElement quoteYellowArea;

    @FindBy(xpath = "//body[starts-with(@style,'min-height')]")
    public WebElement messageBox;

    @FindBy(css = "#blog-submit-button-save")
    public WebElement messageSendButton;

    public void swapToMessageIframe(){
        Driver.get().switchTo().frame(0);
    }
}
