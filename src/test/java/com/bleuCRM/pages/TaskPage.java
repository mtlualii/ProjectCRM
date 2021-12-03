package com.bleuCRM.pages;

import com.bleuCRM.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TaskPage extends BasePage{

    public TaskPage(){PageFactory.initElements(Driver.get(), this);}

    @FindBy(css = "input#tasks-task-priority-cb")
    public WebElement highPriorityCheckBox;

    @FindBy(xpath = "//span[@class='tasks-task-mpf-link'][.='Checklist']")
    public WebElement checklistItem;

    @FindBy(xpath = "//span/input[@placeholder='Things to do']")
    public WebElement checklistLine;

    @FindBy(xpath = "//div/span/span[.='add']")
    public WebElement checklistAddItem;

    @FindBy(xpath = "//span[@class='js-id-checklist-is-i-title ']")
    public WebElement checklistMessageLocated;

    @FindBy(css = "span.js-id-checklist-is-i-delete.task-field-title-del.tasks-btn-delete")
    public WebElement checklistDeleteButton;

    @FindBy(xpath = "//div/input[@placeholder='Things to do']")
    public WebElement thingsToDoLine;

//    @FindBy()
//    public WebElement thingsToDoTaskDetailsBox;

    @FindBy(css = "button#blog-submit-button-save")
    public WebElement thingsToDoSendButton;

    @FindBy(xpath = "//span[@class='popup-window-button'][.='View task']")
    public WebElement thingsToDoViewTaskPopUp;

    @FindBy(css = "span#pagetitle")
    public WebElement thingsToDoPageTitle;

    @FindBy(xpath = "//iframe[starts-with(@id, 'iframe_')]")
    public WebElement iframeElement;

//    @FindBy(css = "div#task-detail-description")
//    public WebElement thingsToDoPageTitle;






}
