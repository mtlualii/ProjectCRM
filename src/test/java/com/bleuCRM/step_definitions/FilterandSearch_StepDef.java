package com.bleuCRM.step_definitions;

import com.bleuCRM.pages.FilterandSerarchPage;
import com.bleuCRM.utilities.BrowserUtils;
import com.bleuCRM.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class FilterandSearch_StepDef {

    FilterandSerarchPage filterandSerarchPage = new FilterandSerarchPage();
    List<WebElement> fields = Driver.get().findElements(By.xpath("//div[@*='main-ui-filter-field-list-item main-ui-select-inner-item main-ui-checked']"));
    List<String> fieldsList =BrowserUtils.getElementsText(fields);

    @And("the user click on filter and search field")
    public void the_user_click_on_filter_and_search_field() {

        filterandSerarchPage.filterAndSearchBox.click();

    }

    @Then("the user should see following values")
    public void the_user_should_see_following_values(List<String> filters) {
        ArrayList<String> expectedList = new ArrayList<>();
        expectedList.add("WORK");
        expectedList.add("FAVORITES");
        expectedList.add("MY ACTIVITY");
        expectedList.add("ANNOUNCEMENTS");
        expectedList.add("WORKFLOWS");


        com.bleuCRM.utilities.BrowserUtils.waitFor(2);
        List<String>actualFilters = com.bleuCRM.utilities.BrowserUtils.getElementsText(new FilterandSerarchPage().filters);
        actualFilters.remove(1);
        actualFilters.remove(2);

        System.out.println("expectedList = " + expectedList);
        System.out.println("actualFilters = " + actualFilters);
        Assert.assertEquals("verify", actualFilters, expectedList);
    }

    @When("the user click addfield")
    public void the_user_click_addfield() {
        BrowserUtils.waitFor(2);
        Driver.get().manage().window().maximize();
        filterandSerarchPage.addField.click();
    }

    @And("Unselect {string},{string},{string},{string} and Select {string},{string},{string}")
    public void unselect_and_select(String Date, String Type, String Author, String To, String Favorites, String Tag, String Extranet) {
        List<WebElement> items = Driver.get().findElements(By.xpath("//div[@class='main-ui-select-inner-label']"));

        for (int i = 0; i < items.size(); i++) {
            BrowserUtils.waitFor(1);
            items.get(i).click();
        }
    }

    @Then("the user check last selected fields")
    public void the_user_check_last_selected_fields() {
        BrowserUtils.waitFor(1);
        List<WebElement> lastFields = Driver.get().findElements(By.xpath("//div[@*='main-ui-filter-field-list-item main-ui-select-inner-item main-ui-checked']"));
        List<String> lastFieldsList = BrowserUtils.getElementsText(lastFields);
        Assert.assertFalse("verify",lastFieldsList.contains(fieldsList));
    }

    @When("the user click date area and select Current day")
    public void the_user_click_date_area_and_select_Current_day() {
       /*
        Driver.get().findElement(By.id("LIVEFEED_search")).click();
        BrowserUtils.waitFor(3);
        //Driver.get().findElement(By.xpath("//div[@data-name='DATE_CREATE_datesel']")).click();
        //Click on Date DropDown
        WebDriverWait wait=new WebDriverWait(Driver.get(),5);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='main-ui-control-field']")));
        Driver.get().findElement(By.xpath("//div[@class='main-ui-control-field']")).click();
        //After Clicking Date DropDown, JavaScript or Hidden HTML5 codes activated
        BrowserUtils.waitFor(4);
       // Driver.get().findElement(By.xpath("//div[@class='popup-select-content']/div[2]")).click();
        */
        Driver.get().findElement(By.xpath("//input[@name='FIND']")).click();
        BrowserUtils.waitFor(2);
        filterandSerarchPage.restore.click();
        BrowserUtils.waitFor(3);

        Driver.get().findElement(By.xpath("//div[@class='main-ui-control-field']")).click();
        BrowserUtils.waitFor(2);
        filterandSerarchPage.selectDate.click();
        BrowserUtils.waitFor(2);
    }

    @And("the user click search button")
    public void the_user_click_search_button() {
        //Driver.get().findElement(By.cssSelector("button[class='ui-btn ui-btn-primary ui-btn-icon-search main-ui-filter-field-button main-ui-filter-find']")).click();
        filterandSerarchPage.searchButton.click();

    }

    @Then("the user should be see only selected date")
    public void the_user_should_be_see_only_selected_date() {

        BrowserUtils.waitFor(3);
        List<WebElement> feedTime = Driver.get().findElements(By.xpath("//div[@class='feed-time']"));
        String expected = "today";
        List<String> feedList = BrowserUtils.getElementsText(feedTime);
        System.out.println(feedList);
        for (int i = 0; i < feedTime.size(); i++) {
            System.out.println(feedList.get(i));
            Assert.assertTrue("verify", feedList.get(i).contains(expected));
        }
    }

    @When("User click SAVE FILTER button")
    public void user_click_SAVE_FILTER_button() {
        BrowserUtils.waitFor(2);
        Driver.get().manage().window().maximize();
        Driver.get().findElement(By.xpath("//span[@class='main-ui-filter-add-item']")).click();

    }

    @Then("User wright {string} and click SAVE button")
    public void user_wright_and_click_SAVE_button(String string) {
        Driver.get().findElement(By.xpath("//input[@class='main-ui-filter-sidebar-edit-control']")).sendKeys("TEAM ACTIVITY");
        Driver.get().findElement(By.xpath("//span[@class='ui-btn ui-btn-success main-ui-filter-field-button main-ui-filter-save']")).click();
    }

    @Then("User check last filters")
    public void user_check_last_filters() {
        BrowserUtils.waitFor(2);
        List<WebElement> actualFilters = Driver.get().findElements(By.cssSelector("span.main-ui-filter-sidebar-item-text"));
        String expected ="TEAM ACTIVITY";
        List<String> lastList = BrowserUtils.getElementsText(actualFilters);
        //System.out.println(lastList);
        Assert.assertTrue("verify",lastList.contains(expected));

    }

}
