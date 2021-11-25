package com.bleuCRM.pages;

import com.bleuCRM.utilities.BrowserUtils;
import com.bleuCRM.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    public WebElement quickMenuNavigation(String menuName) {

        String path = "//span[.='"+menuName+"']";
        return Driver.get().findElement(By.xpath(path));

    }

    public WebElement leftMenuNavigation(String menuName) {

        String path = "//*[@id='left-menu-list']//a[@title='"+menuName+"']";

        return Driver.get().findElement(By.xpath(path));
    }

    @FindBy(id = "search-textbox-input")
    public WebElement searchBox;

    @FindBy(xpath = "(//form[@id='search']//span)[1]")
    public WebElement searchBoxSearchIcon;

    @FindBy(xpath = "(//form[@id='search']//span)[2]")
    public WebElement searchBoxDeleteIcon;

    @FindBy(id = "user-name")
    public WebElement rightTopUsername;

    @FindBy(id = "timeman-block")
    public WebElement time;

    @FindBy(id = "logo_24_a")
    public WebElement homeButton;

    @FindBy(css = ".sitemap-menu")
    public WebElement sideMenuButton;


    // It is the menu which opened up when you click username at top. You need use this WebElement in order to LOGOUT also
    public WebElement popupUserMenu(String menuName) {

        rightTopUsername.click();
        return Driver.get().findElement(By.xpath("//div[@id='popup-window-content-menu-popup-user-menu']//span[.='"+menuName+"']"));

    }








}
