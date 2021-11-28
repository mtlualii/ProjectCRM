package com.bleuCRM.pages;

import com.bleuCRM.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class EventPage extends BasePage {

    public EventPage() {PageFactory.initElements(Driver.get(), this);}

    @FindBy(id = "feed-cal-event-namecal_3Jcl")
    public WebElement eventNameBox;

    @FindBy(id = "feed-cal-event-fromcal_3Jcl")
    public WebElement eventFromDate;

    @FindBy(id = "feed_cal_event_from_timecal_3Jcl")
    public WebElement eventFromTime;

    @FindBy(id = "feed-cal-event-tocal_3Jcl")
    public WebElement eventToDate;

    @FindBy(id = "feed_cal_event_to_timecal_3Jcl")
    public WebElement eventToTime;

    @FindBy(xpath = "//input[@title='Hours']")
    public WebElement hourBox;

    @FindBy(xpath = "//input[@title='Minutes']")
    public WebElement minutesBox;

    @FindBy(xpath = "(//input[@title='Hours'])[2]")
    public WebElement hourBox2;

    @FindBy(xpath = "(//input[@title='Minutes'])[2]")
    public WebElement minutesBox2;

    @FindBy(xpath = "//img[@title='Close']")
    public WebElement closeClock;

    @FindBy(xpath = "//input[@value='Set Time']")
    public WebElement setTime;

    @FindBy(xpath = "(//input[@value='Set Time'])[2]")
    public WebElement setTime2;

    @FindBy(css = ".feed-ev-tz-open")
    public WebElement timeZoneButton;

    @FindBy(id = "feed-cal-tz-fromcal_3Jcl")
    public WebElement timeZoneStartPick;

    @FindBy(id = "feed-cal-tz-tocal_3Jcl")
    public WebElement timeZoneEndPick;

    @FindBy(xpath = "(//td[@class='feed-calendar-view-text-cell-r'])[1]")
    public WebElement eventName;

    @FindBy(xpath = "(//td[@class='feed-calendar-view-text-cell-r'])[2]")
    public WebElement eventTime;

    @FindBy(xpath = "(//td[@class='feed-calendar-view-text-cell-r'])[3]")
    public WebElement location;

    @FindBy(css = ".feed-event-rem-lbl-for")
    public WebElement setReminderCheckmark;

    @FindBy(id = "event-remind_countcal_3Jcl")
    public WebElement numberBox;

    @FindBy(id = "event-remind_typecal_3Jcl")
    public WebElement timeTypeOptionDropdown;

    @FindBy(id = "event-locationcal_3Jcl")
    public WebElement eventLocationDropdown;

    public WebElement pickLocation(String locationName) {

        String path = "//div[text()='"+ locationName + "']";

        return Driver.get().findElement(By.xpath(path));
    }

    @FindBy(id = "feed-event-dest-add-link")
    public WebElement addingAttendees;

    @FindBy(id = "destDepartmentTab_calnAJEM3")
    public WebElement employeesAndDepartments;

    @FindBy(xpath = "(//div[@class='bx-finder-company-department-text'])[2]")
    public WebElement departmentName;

    @FindBy(css = ".bx-finder-company-department-check-text")
    public WebElement selectDepartment;

    @FindBy(css = ".bx-finder-company-department-employee-name")
    public WebElement selectIndividual;

    @FindBy(css = ".feed-event-destination-text")
    public List<WebElement> membersBox;

    @FindBy(id = "feed-cal-additional-show")
    public WebElement moreButton;

    @FindBy(xpath = "//label[text()='Availability']")
    public WebElement availability;

    @FindBy(xpath = "//label[text()='Repeat']")
    public WebElement repeat;

    @FindBy(xpath = "//label[text()='Calendar']")
    public WebElement calendar;

    @FindBy(xpath = "//label[text()='Importance']")
    public WebElement importance;

    @FindBy(id = "blog-submit-button-save")
    public WebElement sendButton;

























}
