package com.bleuCRM.step_definitions;

import com.bleuCRM.pages.EventPage;
import com.bleuCRM.utilities.BrowserUtils;
import com.sun.xml.internal.ws.policy.AssertionSet;
import io.cucumber.java.ca.Cal;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
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

    @Then("Two dropdown menu appears")
    public void two_dropdown_menu_appears() {

        Assert.assertTrue(eventPage.timeZoneStartPick.isDisplayed());
        Assert.assertTrue(eventPage.timeZoneEndPick.isDisplayed());

    }

    @When("Clicks send")
    public void clicks_send() {

        eventPage.sendButton.click();

    }

    @Then("Should be able to see entered {string} as event name, {string}, {string}, {string} as event date and time")
    public void should_be_able_to_see_entered_as_event_name_hour_minutes_as_event_date_and_time(String input, String date, String hour, String minutes) {

        System.out.println("TimeZone.getDefault() = " + TimeZone.getDefault());


        String expectedEventTime = date + ", " + hour + ":" + minutes + " am";
        BrowserUtils.waitForVisibility(eventPage.eventName,2);
        Assert.assertEquals(input, eventPage.eventName.getText() );
        Assert.assertEquals(expectedEventTime, eventPage.eventTime.getText());

    }

    @When("Clicks set reminder checkmark")
    public void clicks_set_reminder_checkmark() {

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

        eventPage.eventLocationDropdown.click();
        eventPage.pickLocation(roomName);

    }

    @Then("Should be able to see selected meeting room {string} as location")
    public void should_be_able_to_see_selected_meeting_room_as_Location(String roomName) {

        Assert.assertEquals(eventPage.location.getText(), roomName);

    }

    @When("Clicks Member Box")
    public void clicks_Member_Box() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("Clicks Employees and Departments")
    public void clicks_Employees_and_Departments() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("Clicks the arrow left side of {string} which would like to be added")
    public void clicks_the_arrow_left_side_of_which_would_like_to_be_added(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("Selects checkmark")
    public void selects_checkmark() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("Selects {string}")
    public void selects(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Should be able to see {string} and {string}")
    public void should_be_able_to_see_and(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("Clicks more button")
    public void clicks_more_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Should be able to see followings as parameters")
    public void should_be_able_to_see_followings_as_parameters(io.cucumber.datatable.DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
        throw new io.cucumber.java.PendingException();
    }

    @Then("Should be able to see an event with the name of {string}")
    public void should_be_able_to_see_an_event_with_the_name_of(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }



}
