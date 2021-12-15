package com.sumdu.edu.ua.pageobject.pages;

import com.sumdu.edu.ua.pageobject.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TablePage extends BasePage
{
    @FindBy(xpath = "/html/body/div/div/main/div/h1/a[1]")
    private WebElement tableLabel;

    public TablePage(WebDriver webDriver) {
        super(webDriver);
    }

    // CheckDisplayTableDataTest Methods
    public boolean positiveCheckDisplayTableData() {
        return tableLabel.isDisplayed();
    }
}

