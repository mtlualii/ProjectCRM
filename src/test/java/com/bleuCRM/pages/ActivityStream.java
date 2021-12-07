package com.bleuCRM.pages;

import com.bleuCRM.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ActivityStream {

    public ActivityStream(){
        PageFactory.initElements(Driver.get(), this);
    }



    @FindBy(css = "#feed-add-post-form-link-text")
    public WebElement moreBtn;


    @FindBy(xpath = "//span[text()='Appreciation']")
    public WebElement AppreciationBtn;








}
