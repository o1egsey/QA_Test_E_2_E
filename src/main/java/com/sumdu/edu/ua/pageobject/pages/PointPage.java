package com.sumdu.edu.ua.pageobject.pages;

import com.sumdu.edu.ua.pageobject.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class PointPage extends BasePage {
    @FindBy(xpath = "//input[@class='form-control']")
    private WebElement backupNameInput;

    @FindBy(xpath = "//button[@class='w-100 btn']")
    private WebElement createNewBackupButton;

    @FindBy(xpath = "/html/body/div/div/main/div[3]/div/div[2]/div/div[2]/div/form[1]/input")
    private WebElement updateButton;

    @FindBy(xpath = "/html/body/div/div/main/div[3]/div/div[2]/div/div[2]/div/form[2]/input")
    private WebElement resetButton;

    @FindBy(xpath = "/html/body/div/div/main/div[1]")
    private WebElement resetMessage;

    @FindBy(xpath = "/html/body/div/div/main/div[3]/div/div[2]/div/div[2]/div/form[3]/input")
    private WebElement removeButton;

    @FindBy(xpath = "/html/body/div/div/main/div[2]/div/div[2]/p")
    private WebElement removeMessage;

    public PointPage(WebDriver webDriver) {
        super(webDriver);
    }

    // PositiveBackupTest Methods
    public PointPage positiveBackup(String backupName) {
        Actions act = new Actions(webDriver);
        this.backupNameInput.sendKeys(backupName);
        act.moveToElement(createNewBackupButton).click();
        return new PointPage(webDriver);
    }

    public boolean backupObservationElementIsDisplayed() {
        return updateButton.isDisplayed();
    }

    // NegativeBackupTest Methods
    public PointPage negativeBackup(String backupName) {
        Actions act = new Actions(webDriver);
        for (int i = 0; i < 2; i++) {
            this.backupNameInput.sendKeys(backupName + i);
            act.moveToElement(createNewBackupButton).click();
        }
        return new PointPage(webDriver);
    }

    // DatabaseUpdateTest Methods
    public PointPage databaseUpdate() {
        Actions act = new Actions(webDriver);
        act.moveToElement(updateButton).click();
        return new PointPage(webDriver);
    }

    // ResetDatabaseTest Methods
    public PointPage resetDatabase() {
        Actions act = new Actions(webDriver);
        act.moveToElement(resetButton).click();
        return new PointPage(webDriver);
    }
    public boolean resetObservationElementIsDisplayed() {
        return resetMessage.isDisplayed();
    }

    // RemoveDatabaseTest Methods
    public PointPage removeDatabase() {
        Actions act = new Actions(webDriver);
        act.moveToElement(removeButton).click();
        return new PointPage(webDriver);
    }
    public boolean removeObservationElementIsDisplayed() {
        return removeMessage.isDisplayed();
    }

}

