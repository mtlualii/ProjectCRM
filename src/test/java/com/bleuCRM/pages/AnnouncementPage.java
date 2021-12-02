package com.bleuCRM.pages;

import com.bleuCRM.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AnnouncementPage extends BasePage{
    {PageFactory.initElements(Driver.get(), this);}
    @FindBy(css = ".bxhtmled-top-bar-btn.bxhtmled-button-link")
    public WebElement link;
    @FindBy(css = "#linkidPostFormLHE_blogPostForm-href")
    public WebElement linkBox;
    @FindBy(xpath = "(//span[.='Announcement'])[1]")
    public WebElement announcementtab;
    @FindBy(css = "#undefined")
    public WebElement saveButton;
    @FindBy(xpath = "//body[@contenteditable='true']")
    public WebElement announcementTextBox;
    @FindBy(id = "feed-post-contentview-BLOG_POST-257")
    public WebElement sendedAnnouncementTextBox;
    @FindBy(css = "span[title='Quote text']")
    public WebElement quatoButton;
    @FindBy(css = ".bxhtmled-quote")
    public WebElement quatoTextBox;
}
