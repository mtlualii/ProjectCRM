package com.bleuCRM.step_definitions;

import com.bleuCRM.pages.EventPage;
import com.bleuCRM.utilities.BrowserUtils;
import com.sun.xml.internal.ws.policy.AssertionSet;
import io.cucumber.java.ca.Cal;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.eo.Se;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

public class EventTabStepDefinitions {

    EventPage eventPage = new EventPage();

    @Then("Navigate to {string} by Quick Menu")
    public void navigate_to_by_Quick_Menu(String menuName) {

        eventPage.quickMenuNavigation(menuName).click();

    }

    @Then("Enters {string} on Event Name Box")
    public void enters_on_Event_Name_Box(String input) {

        BrowserUtils.waitForVisibility(eventPage.eventNameBox,3);
        eventPage.eventNameBox.sendKeys(input);

    }

    @When("Clicks event start date box")
    public void clicks_event_start_date_box() {

        BrowserUtils.waitForVisibility(eventPage.eventFromDate,2);
        eventPage.eventFromDate.clear();
        eventPage.eventFromDate.click();

    }

    @When("Enters start {string}")
    public void enters_start(String fromDate) {

        eventPage.eventFromDate.sendKeys(fromDate);

    }

    @When("Clicks start time box, clicks start hour box and enters {string}, clicks minutes box and enters {string} and close it")
    public void clicks_start_time_box_clicks_start_hour_box_and_enters_clicks_minutes_box_and_enters_and_close_it(String hour, String minutes) {

        eventPage.eventFromTime.click();
        BrowserUtils.waitForVisibility(eventPage.hourBox,2);
        eventPage.hourBox.clear();
        eventPage.hourBox.sendKeys(hour);

        BrowserUtils.waitForVisibility(eventPage.minutesBox,2);
        eventPage.minutesBox.clear();
        eventPage.minutesBox.sendKeys(minutes);

        eventPage.setTime.click();

    }

    @When("Clicks specify time zone")
    public void clicks_specify_time_zone() {

        eventPage.timeZoneButton.click();
    }

    @Then("Two dropdown menu appears and select start zone {string}")
    public void two_dropdown_menu_appears(String timeZone) {

        BrowserUtils.waitForVisibility(eventPage.timeZoneStartPick,2);
        Assert.assertTrue(eventPage.timeZoneStartPick.isDisplayed());
        Assert.assertTrue(eventPage.timeZoneEndPick.isDisplayed());

        Select select = new Select(eventPage.timeZoneStartPick);

        select.selectByValue(timeZone);


    }

    @When("Clicks send")
    public void clicks_send() {

        eventPage.sendButton.click();

    }

    @Then("Should be able to see entered {string} as event name, {string}, {string}, {string} as event date and time depends on time zone {string}")
    public void should_be_able_to_see_entered_as_event_name_hour_minutes_as_event_date_and_time(String input, String date, String hour, String minutes, String timeZone) {

        int a = Integer.parseInt(ZoneId.of(timeZone).getRules().getOffset(Instant.now()).toString().substring(1,3));
        int b = Integer.parseInt(ZoneId.of(TimeZone.getDefault().getID()).getRules().getOffset(Instant.now()).toString().substring(1,3));

        int c = a+b;
        System.out.println(a+b);

        int hourInt = Integer.parseInt(hour)+c;

        String expectedEventTime = date + ", " + hourInt + ":" + minutes + " pm";
        if(hourInt>11) {
            hourInt = hourInt-12;
            expectedEventTime = date + ", " + hourInt + ":" + minutes + " am";
        }

        BrowserUtils.waitForVisibility(eventPage.eventName,3);
        Assert.assertEquals(input, eventPage.eventName.getText() );
        Assert.assertEquals(expectedEventTime, eventPage.eventTime.getText());

    }

    @When("Clicks set reminder checkmark")
    public void clicks_set_reminder_checkmark() {

        eventPage.setReminderCheckmark.click();
        BrowserUtils.waitFor(3);
        eventPage.setReminderCheckmark.click();

    }

    @Then("Should be able to see two boxes to set a reminder")
    public void should_be_able_to_see_two_boxes_to_set_a_reminder() {

        Assert.assertTrue(eventPage.numberBox.isDisplayed());
        Assert.assertTrue(eventPage.timeTypeOptionDropdown.isDisplayed());

    }

    @When("Clicks Event Location Box and pick {string}")
    public void clicks_Event_Location_Box(String roomName) {

        // Select select = new Select(eventPage.eventLocationDropdown);

        eventPage.pickLocation(roomName);

    }

    @Then("Should be able to see selected meeting room {string} as location")
    public void should_be_able_to_see_selected_meeting_room_as_Location(String roomName) {

        BrowserUtils.waitForVisibility(eventPage.location,3);
        Assert.assertEquals(roomName, eventPage.location.getText() );
    }

    @When("Clicks Member Box")
    public void clicks_Member_Box() {

        eventPage.addingAttendees.click();
        BrowserUtils.waitFor(3);

    }

    @When("Clicks Employees and Departments")
    public void clicks_Employees_and_Departments() {

        eventPage.employeesAndDepartments.click();
        BrowserUtils.waitFor(3);
    }

    @When("Clicks the arrow left side of department name {string} which would like to be added")
    public void clicks_the_arrow_left_side_of_which_would_like_to_be_added(String depName) {

        eventPage.pickDepartment(depName);
        BrowserUtils.waitFor(3);

    }

    @When("Selects {string}")
    public void selects(String name) {

        eventPage.pickIndividual(name);
        BrowserUtils.waitFor(3);

    }

    @Then("Should be able to see followings")
    public void should_be_able_to_see_and(List<String> attendees) {

        System.out.println(BrowserUtils.getElementsText(eventPage.informationBox));
        Assert.assertEquals(attendees, BrowserUtils.getElementsText(eventPage.informationBox));


    }

    @When("Clicks more button")
    public void clicks_more_button() {

        eventPage.moreButton.click();

    }

    @Then("Should be able to see followings as parameters")
    public void should_be_able_to_see_followings_as_parameters(List<String> parameters) {

        Assert.assertEquals( parameters, BrowserUtils.getElementsText(eventPage.parameters));




    }

    @Then("Should be able to see an event with the name of {string}")
    public void should_be_able_to_see_an_event_with_the_name_of(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }



}
