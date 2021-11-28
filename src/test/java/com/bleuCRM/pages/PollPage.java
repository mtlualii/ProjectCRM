package com.bleuCRM.pages;

import com.bleuCRM.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PollPage extends DashboardPage{

    @FindBy(id = "bx-destination-tag")
    public WebElement addMoreButtonOnToLine;

    @FindBy(id = "popup-window-content-BXSocNetLogDestination")
    public WebElement addMorePopupWindow;

    @FindBy(xpath = "//a[starts-with(@id,'destDepartmentTab_')]")// @FindBy(xpath = "//a[starts-with(@id,'destDepartmentTab_destination')]")
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

    public WebElement myIcon(String iconName){
 return Driver.get().findElement(By.xpath("//*[@title='" + iconName + "']"));
    }

    public void swapToMessageIframe(){
        Driver.get().switchTo().frame(0);
    }
}
