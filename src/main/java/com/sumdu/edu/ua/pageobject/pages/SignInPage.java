package com.sumdu.edu.ua.pageobject.pages;

import com.sumdu.edu.ua.pageobject.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BasePage {
    @FindBy(name = "login")
    private WebElement username;

    @FindBy(name = "password")
    private WebElement pass;

    @FindBy(name = "conformation")
    private WebElement confPass;

    @FindBy(xpath = "//button[@class='w-100 btn']")
    private WebElement signInButton;

    @FindBy(xpath = "//div[@class=\"alert alert-danger alert-dismissible fade show\"]")
    private WebElement errorNonCorrectEmail;

    @FindBy(xpath = "//img[@src=\"/images/hero.svg\"]")
    private WebElement logoSignIn;

    public SignInPage(WebDriver webDriver) {
        super(webDriver);
    }

    public SignInPage open() {
        webDriver.get("https://elephant.tss2021.site/registration");
        return this;
    }

    public HomePage signIn(String username, String pass, String pass1 ) {
        this.username.sendKeys(username);
        this.pass.sendKeys(pass);
        this.confPass.sendKeys(pass1);
        signInButton.click();

        return new HomePage(webDriver);
    }

    public SignInPage negSignIn(String username, String pass, String pass1 ) {
        this.username.sendKeys(username);
        this.pass.sendKeys(pass);
        this.confPass.sendKeys(pass1);
        signInButton.click();

        return new SignInPage(webDriver);
    }
    public boolean existErrorSignIn() {
        return errorNonCorrectEmail.isDisplayed();
    }

    public boolean logoSignIn() {
        return logoSignIn.isDisplayed();
    }

}
