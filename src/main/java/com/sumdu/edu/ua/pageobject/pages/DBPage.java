package com.sumdu.edu.ua.pageobject.pages;

import com.sumdu.edu.ua.pageobject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DBPage extends BasePage {
    @FindBy(xpath = "/html/body/div/div/main/div[1]")
    private WebElement DBObservElement;
    @FindBy(xpath = "//h1/a[contains(@href,'database/')]")
    private WebElement dbName;
    @FindBy(xpath = "//div[@class=\"alert alert-success alert-dismissible fade show\"]")
    private WebElement dbCreatedAlert;
    @FindBy(xpath = "//span[@class=\"text-nowrap\"]/a")
    private WebElement userInformationLabel;

    @FindBy(xpath = "//li/a[contains(@href,'script')]")
    private WebElement scriptLabel;

    @FindBy(xpath = "//*[@id=\"sidebarMenu\"]/div/ul/li[4]/a")
    private WebElement sqlConsole;

    // For positiveCheckDBExplorerPage Method
    @FindBy(xpath = "//*[@id=\"sidebarMenu\"]/div/ul/li[1]/a")
    private WebElement databaseExplorerButton;

    @FindBy(xpath = "/html/body/div/div/main/div[2]/div/div[2]/div/a")
    private WebElement backupButton;



    @FindBy(xpath = "//*[@id=\"sidebarMenu\"]/div/ul/li[4]/a")
    private WebElement sqlLabel;


    public boolean dBObservationElementIsDisplayed(){
        //Actions act = new Actions(webDriver);
        //act.
        return DBObservElement.isDisplayed();
    }
    protected DBPage(WebDriver webDriver) {
        super(webDriver);
    }
    public boolean checkDB(){
        dbName = new WebDriverWait(webDriver, 1)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1/a[contains(@href,'database/')]")));
        return dbName.isDisplayed();
    }

    public boolean userInfo () {
        return userInformationLabel.isDisplayed();
    }
    public ProfilePage clickProfileButton () {
        userInformationLabel.click();
        return new ProfilePage(webDriver);
    }

    public ScriptPage clickScript(){
        scriptLabel.click();
        return new ScriptPage(webDriver);
    }

    public SQLPage clickSQLConsole(){
        sqlConsole.click();
        return new SQLPage(webDriver);
    }

    // CheckDBExplorerPageTest Methods
    public boolean positiveCheckDBExplorerPage() {
        return databaseExplorerButton.isDisplayed();
    }

    // CheckDisplayTableDataTest Methods
    public TablePage clickDataExplorerButton() {
        Actions act = new Actions(webDriver);
        act.moveToElement(databaseExplorerButton).click();
        return new TablePage(webDriver);
    }

    // PositiveBackupTest Methods
    public PointPage clickBackupButton() {
        Actions act = new Actions(webDriver);
        act.moveToElement(backupButton).click();
        return new PointPage(webDriver);
    }



    public SQLPage clickSQL(){
        sqlLabel.click();
        return new SQLPage(webDriver);
    }


}
