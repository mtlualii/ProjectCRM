package com.bleuCRM.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FilterandSerarchPage extends BasePage{

    @FindBy(xpath = "//input[@placeholder='Filter and search']")
    public WebElement filterAndSearchBox;

    @FindBy(css = "span.main-ui-filter-sidebar-item-text")
    public List<WebElement> filters;

    @FindBy(xpath = "//span[@class='main-ui-filter-field-add-item']")
    public WebElement addField;

    @FindBy(xpath = "//span[@class='main-ui-filter-field-restore-items']")
    public WebElement restore;

    @FindBy(xpath = "//div[@class='popup-select-content']/div[3]")
    public WebElement selectDate;

    @FindBy(xpath = "//button[contains(text(),'Search')]")
    public WebElement searchButton;

}
