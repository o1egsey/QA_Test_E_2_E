package com.sumdu.edu.ua.pageobject.pages;

import com.sumdu.edu.ua.pageobject.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;

public class ProfilePage extends BasePage {

    @FindBy(xpath = "//button[text()='Upgrade']")
    private WebElement userUpgradeRoleButton;
    // /html/body/div/div/main/div[6]/div/div[2]/form/div/div[2]/button

    @FindBy(xpath = "//button[@class='btn-close']")
    private WebElement fineUpgradeLabel;

    @FindBy(xpath = "//li[@class='nav-item']/a[@href='/']")
    private WebElement backToHomePage;

    @FindBy(xpath = "//div[@class='container shadow border p-5 mb-3']")
    private WebElement ChangeLanguage;

    @FindBy(xpath = "//input[@id=\"public-api\"]")
    private WebElement publicKeyInput;

    @FindBy(xpath = "//input[@id=\"private-api\"]")
    private WebElement privateKeyInput;

    @FindBy(xpath = "//button[text()='Re-generate']")
    private WebElement regenerateButton;

    @FindBy(xpath = "//*[@id=\"web-password\"]")
    private WebElement passwordInput;

    @FindBy(xpath = "//*[@id=\"web-password-c\"]")
    private WebElement confirmPasswordInput;

    @FindBy(xpath = "/html/body/div/div/main/div[6]/form/div[2]/button")
    private WebElement changePasswordButton;

    @FindBy(xpath = "/html/body/div/div/main/div[1]")
    private WebElement changePassObservationElement;

    @FindBy(linkText = "Remove account")
    private WebElement deleteAccountButton;

    @FindBy(xpath = "//input[@id='db-password']")
    private WebElement dbPassInput;

    @FindBy(xpath = "//form[contains(@action,'reset-db')]//button[@class='btn']")
    private WebElement changeDBPasswordButton;

    @FindBy(xpath = "//div[@class=\'alert alert-success alert-dismissible fade show\']")
    private WebElement alert;

    public ProfilePage(WebDriver webDriver) {
        super(webDriver);
    }

    public ProfilePage open() {
        webDriver.get("https://elephant.tss2021.site/profile");
        return this;
    }

    public boolean GetUpgradeRole(){
        fineUpgradeLabel = new WebDriverWait(webDriver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn-close']")));
        return fineUpgradeLabel.isDisplayed();
    }

//    public ProfilePage UpgradeRole(){
//        Actions act = new Actions(webDriver);
//        act.moveToElement(userUpgradeRoleButton).click();
//        return this;
//    }

    public ProfilePage UpgradeRole(){

        userUpgradeRoleButton = new WebDriverWait(webDriver, 10)
                .until(ExpectedConditions.elementToBeClickable(userUpgradeRoleButton));

        Actions act = new Actions(webDriver);
        act.moveToElement(userUpgradeRoleButton).click();
        return this;
    }

    public ProfilePage UpgradeRoleClick(){
        userUpgradeRoleButton = new WebDriverWait(webDriver, 10)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Upgrade']")));
        return new ProfilePage(webDriver);
    }

    public HomePage BackToHomePage(){
        backToHomePage.click();
        return new HomePage(webDriver);
    }

    // ChangeWebPasswordTest Methods
    public ProfilePage changeWebPassword(String pass, String pass1) {
        Actions act = new Actions(webDriver);
        this.passwordInput.sendKeys(pass);
        this.confirmPasswordInput.sendKeys(pass1);
        act.moveToElement(changePasswordButton).click();
        return new ProfilePage(webDriver);
    }
    public boolean changePassObservationElementIsDisplayed() {
        return changePassObservationElement.isDisplayed();
    }

    public String[] getKeyValue() {
        String [] arr = new String[2];
        arr[0]=privateKeyInput.getAttribute("value");
        arr[1]=publicKeyInput.getAttribute("value");
        return arr;
    }
    public ProfilePage regenerate(){
        regenerateButton.click();
        return new ProfilePage(webDriver);
    }

    // DeleteAccountTest Methods
    public ProfilePage deleteUserAcc() {
        Actions act = new Actions(webDriver);
        act.moveToElement(deleteAccountButton).click();
        return new ProfilePage(webDriver);
    }
    public boolean deleteAccObservationElementIsDisplayed() { return deleteAccountButton.isDisplayed(); }

    public boolean ChangeLanguageIsDisplayed(){
        return ChangeLanguage.isDisplayed();
    }

    public boolean changePassAlertIsDisplayed() {
        return alert.isDisplayed();
    }

    public ProfilePage changeDBPassword(String pass) {
        Actions act = new Actions(webDriver);
        act.moveToElement(changeDBPasswordButton);
        dbPassInput.clear();
        dbPassInput.sendKeys(pass);
        changeDBPasswordButton = new WebDriverWait(webDriver, 20)
                .until(ExpectedConditions.elementToBeClickable(changeDBPasswordButton));
        changeDBPasswordButton.click();
        return new ProfilePage(webDriver);
    }
}
