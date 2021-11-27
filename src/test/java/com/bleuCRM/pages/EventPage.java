package com.bleuCRM.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class EventPage extends BasePage {

    @FindBy(id = "feed-cal-event-fromcal_3Jcl")
    public WebElement eventFromDate;

    @FindBy(id = "feed_cal_event_from_timecal_3Jcl")
    public WebElement eventFromTime;

    @FindBy(id = "feed-cal-event-tocal_3Jcl")
    public WebElement eventToDate;

    @FindBy(id = "feed_cal_event_to_timecal_3Jcl")
    public WebElement eventToTime;

    @FindBy(xpath = "//img[@title='Close']")
    public WebElement closeClock;

    @FindBy(css = ".feed-ev-tz-open")
    public WebElement timeZoneButton;

    @FindBy(id = "feed-cal-tz-fromcal_3Jcl")
    public WebElement timeZoneStartPick;

    @FindBy(id = "feed-cal-tz-tocal_3Jcl")
    public WebElement timeZoneEndPick;

    @FindBy(css = ".feed-event-rem-lbl-for")
    public WebElement setReminderCheckmark;

    @FindBy(id = "event-locationcal_3Jcl")
    public WebElement eventLocationDropdown;

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
