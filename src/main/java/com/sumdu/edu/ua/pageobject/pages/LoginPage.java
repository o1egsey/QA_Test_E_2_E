package com.sumdu.edu.ua.pageobject.pages;

import com.sumdu.edu.ua.pageobject.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(name = "login")
    private WebElement username;

    @FindBy(name = "password")
    private WebElement pass;

    @FindBy(xpath = "//button[@class='w-100 btn']")
    private WebElement loginButton;

    @FindBy(xpath = "//div[@class=\"alert alert-danger alert-dismissible fade show\"]")
    private WebElement errorLogin;

    @FindBy(xpath = "/html/body/main/div[1]/div/div[2]/form/p/a")
    private WebElement forgotPassword;

    @FindBy(xpath = "//*[@id=\"web-email\"]")
    private WebElement emailNew;

    @FindBy(xpath = "/html/body/main/div/div/div/form/div[2]/button")
    private WebElement sendButton;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public LoginPage open() {
        webDriver.get("https://elephant.tss2021.site/login");
        return this;
    }
    public LoginPage openhttp() {
        webDriver.get("http://elephant.tss2021.site/login");
        return this;
    }

    public HomePage login(String username, String pass) {
        this.username.sendKeys(username);
        this. pass.sendKeys(pass);
        loginButton.click();

        return new HomePage(webDriver);
    }

    public LoginPage negLogin(String username, String pass) {
        this.username.sendKeys(username);
        this. pass.sendKeys(pass);
        loginButton.click();

        return new LoginPage(webDriver);
    }

    public LoginPage forgotPassword()
    {
        Actions act = new Actions(webDriver);
        act.moveToElement(forgotPassword).click();
        return new LoginPage(webDriver);
    }

    public LoginResetPasswordPage reset(String email) {
        this.emailNew.sendKeys(email);
        sendButton.click();

        return new LoginResetPasswordPage(webDriver);
    }

    public boolean existErrorLogin() {
        return errorLogin.isDisplayed();
    }

}
