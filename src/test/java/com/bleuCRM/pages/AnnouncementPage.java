package com.bleuCRM.pages;

import com.bleuCRM.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

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
    @FindBy(id = "bx-b-mention-blogPostForm")
    public WebElement addMention;

    @FindBy(xpath = "//button[@id='blog-submit-button-save']")
    public WebElement sendButton;
    @FindBy(xpath = "(//div[@class='feed-post-text-block-inner-inner'])[1]")
    public WebElement lastBox;
}
