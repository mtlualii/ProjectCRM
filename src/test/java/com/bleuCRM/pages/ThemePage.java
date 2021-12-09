package com.bleuCRM.pages;

import com.bleuCRM.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ThemePage extends BasePage{

    public ThemePage() {
        PageFactory.initElements(Driver.get(), this);}

    @FindBy(xpath = "//div[@class='menu-popup-items']/span[.='Themes']")
    public WebElement theme;

    @FindBy(css = "[data-theme-id='light:sunset']")
    public WebElement sunsetImage;

    @FindBy(xpath = "//div[.='Bitrix24Default']")
    public WebElement defaultImage;

    @FindBy(xpath = "//script[contains(.,'BX.Intranet.Bitrix24.ThemePicker.Singleton = new BX.Intranet.Bitrix24.ThemePicke')]")
    public WebElement backgroundImage;

    @FindBy(xpath = "//span[@id='save-button']")
    public WebElement saveButton;

    @FindBy(id = "create-button")
    public WebElement createButton;

    @FindBy(id = "bitrix24-new-theme-dialog")
    public WebElement createCustomTheme;

    @FindBy(xpath = "//span[@class='theme-dialog-field-file-add']")
    public WebElement uploadBackgroundImage;

    @FindBy(id = "theme-dialog-create-button")
    public WebElement CustomThemeCreateButton;

    @FindBy(css = "[data-theme-id='light:video-waterfall']")
    public WebElement animatedImage;

    @FindBy(xpath = "/html/body/div[1]/video")
    public WebElement animatedBackground;

    @FindBy(xpath = "//*[@id=\"popup-window-content-bitrix24-theme-list-dialog\"]/div/div/div[1]/div/div")
    public WebElement remove;

    @FindBy(xpath = "//div[@class='menu-popup-items']/span[.='Configure notifications']")
    public WebElement configureNotifications;

    @FindBy(id = "notifySchemeSimpleValue")
    public WebElement simpleMode;

    @FindBy(xpath = "//*[@id=\"notifySchemeExpertValue\"]")
    public WebElement Advanced;

    @FindBy(xpath = "//span[@class='popup-window-button popup-window-button-accept']")
    public WebElement NotificationsSave;




}