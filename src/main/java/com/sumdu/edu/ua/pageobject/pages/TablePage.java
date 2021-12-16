package com.sumdu.edu.ua.pageobject.pages;

import com.sumdu.edu.ua.pageobject.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TablePage extends BasePage
{
    @FindBy(xpath = "/html/body/div/div/main/table/tbody/tr[2]/td/a")
    private WebElement tableLabel;

    @FindBy(xpath = "/html/body/div/div/main/h1")
    private WebElement tableName;

    public TablePage(WebDriver webDriver) {
        super(webDriver);
    }

    // CheckDisplayTableDataTest Methods
    public boolean positiveCheckDisplayTableData() {
        return tableLabel.isDisplayed();
    }

    public TablePage ClickdbTableName () {
        tableLabel.click();
        return new TablePage(webDriver);
    }

    public boolean positiveCheckDisplayTablenInfo() {
        return tableName.isDisplayed();
    }
}
