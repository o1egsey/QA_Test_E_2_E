package com.sumdu.edu.ua.pageobject.pages;

import com.sumdu.edu.ua.pageobject.BasePage;
import com.sumdu.edu.ua.pageobject.modules.LogoutModule;
import com.sumdu.edu.ua.pageobject.modules.ProfileDropDownModule;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    @FindBy(xpath = "//summary[@class=\"Header-link\"]/img")
    private WebElement profileDropDownButton;

    @FindBy(xpath = "//span[@class=\"text-nowrap\"]/a")
    private WebElement userInformationLabel;

    @FindBy(xpath = "//div/a[@href=\"/logout\"]")
    private WebElement logoutButton;

    @FindBy(xpath = "//button[@class='w-100 btn']")
    private WebElement createDB;
    //button[text()='Створіть нову базу даних']
    @FindBy(xpath = "//button[@class='w-100 btn disabled']")
    private WebElement createDBDisable;

    //button[@class='w-100 btn']

    @FindBy(xpath = "//li[@class='nav-item']/a[@class='nav-link']")
    private WebElement userProfileButton;

    @FindBy(xpath = "//button[@class='btn']")
    private WebElement deletedb;

    @FindBy(xpath = "/html/body/div/div/main/div[4]/div/div[2]/p")
    private WebElement noDBMessage;

    //p[text()='В даний час у вас немає жодної бази даних']

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public ProfileDropDownModule openProfileDropDown() {
        profileDropDownButton.click();
        return new ProfileDropDownModule(webDriver);
    }

    public String getUserInformationLabel() {
        return userInformationLabel.getText();
    }

    public LogoutModule logout() {
        logoutButton.click();
        return new LogoutModule(webDriver);
    }

    public ProfilePage clickProfileButton () {
        userInformationLabel.click();
        return new ProfilePage(webDriver);
    }

    public DBPage ClickCreateDB(){
        createDB.click();
        return new DBPage(webDriver);
    }

    public boolean DeleteDB(){
        deletedb.click();
        return noDBMessage.isDisplayed();
    }

    public boolean createDBIsClickable(){
        return createDBDisable.isDisplayed();
    }

//    public boolean getErrorExistEmail() {
//        return errorExistEmail.isDisplayed();
//    }

}
