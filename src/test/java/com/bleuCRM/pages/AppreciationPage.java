package com.bleuCRM.pages;

import com.bleuCRM.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AppreciationPage {

    public AppreciationPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//*[@id='bx-b-link-blogPostForm']/span/i")
    public WebElement linkBtn;

    @FindBy(xpath = "//input[@id='linkidPostFormLHE_blogPostForm-text']")
    public WebElement linkTxtBox;

    @FindBy(xpath = "//input[@id='linkidPostFormLHE_blogPostForm-href']")
    public WebElement linkUrlBox;

    @FindBy(xpath = "//input[@id='undefined']")
    public WebElement linkSaveBtn;

    @FindBy(xpath = "//button[@id='blog-submit-button-save']")
    public WebElement AppreciationSendBtn;

    @FindBy(xpath = "//div[@id='blg-post-200']")
    public WebElement AppreciationDisplay;

    @FindBy(xpath = "//a[@href='https://edition.cnn.com/']")
    public WebElement newsUrl;

    @FindBy(xpath = " (//span[@title='Add mention'])[1]")
    public WebElement mentionBtn;

    @FindBy(xpath= "//a[@class='bx-finder-box-tab bx-lm-tab-department']")
    public WebElement EmplyAndDepOpt;

    @FindBy(xpath = "//*[@id='bx-lm-category-relation-129']/a[1]/div[1]/div[1]")
    public WebElement Market2Mention;

    //*[@id='bx-lm-category-relation-129']/a[1]/div[1]/div[1]

    @FindBy(xpath = "//*[@id='blog_post_body_201']/a[2]")
    public WebElement Market2MentionDisplay;

    @FindBy(xpath = "//*[@id='bx-b-quote-blogPostForm']/span/i")
    public WebElement QuoteBtn;

    @FindBy(xpath = "//body[@contenteditable='true']")
    public WebElement QuoteTxtBox;


    @FindBy(xpath = "//td[text()='-this is a trial-']")
    public WebElement QuoteMessageDisplay;

    @FindBy(xpath = "//*[@id='bx-b-video-blogPostForm']/span/i")
    public WebElement VideoBtn;

    @FindBy(css = " #video_idPostFormLHE_blogPostForm-source")
    public WebElement VideoLinkBox;

    @FindBy(css = "#undefined")
    public WebElement VideoSaveBtn;





}