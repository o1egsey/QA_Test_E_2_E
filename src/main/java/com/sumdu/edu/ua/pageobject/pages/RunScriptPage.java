package com.sumdu.edu.ua.pageobject.pages;

import com.sumdu.edu.ua.pageobject.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RunScriptPage extends BasePage {

    @FindBy(xpath = "//div[@class='container']")
    private WebElement scriptContainer;

    @FindBy(xpath = "//*[@id=\"sidebarMenu\"]/div/ul/li[1]/a")
    private WebElement dBExplorer;

    public RunScriptPage(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean scriptContainerIsDisplayed(){
        return scriptContainer.isDisplayed();
    }

    public TablePage dBExplorerClick(){
        dBExplorer.click();
        return new TablePage(webDriver);
    }
}

