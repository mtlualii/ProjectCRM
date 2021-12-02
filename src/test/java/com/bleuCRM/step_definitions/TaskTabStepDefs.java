package com.bleuCRM.step_definitions;

import com.bleuCRM.pages.TaskPage;
import com.bleuCRM.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class TaskTabStepDefs {

    TaskPage taskPage = new TaskPage();

    @When("the user clicks on the High Priority Check Box")
    public void the_user_clicks_on_the_High_Priority_Check_Box() {
        BrowserUtils.waitFor(3);
        taskPage.highPriorityCheckBox.click();
    }

    @Then("the High Priority Check Box should be able to selected")
    public void the_High_Priority_Check_Box_should_be_able_to_selected() {

        Assert.assertTrue("verify check box is selected",taskPage.highPriorityCheckBox.isSelected());
    }

}
