package com.bleuCRM.pages;

import com.bleuCRM.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TaskPage extends BasePage{

    public TaskPage(){PageFactory.initElements(Driver.get(), this);}

    @FindBy(css = "input#tasks-task-priority-cb")
    public WebElement highPriorityCheckBox;




}
