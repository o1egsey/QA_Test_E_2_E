package com.sumdu.edu.ua.pageobject.pages;

import com.sumdu.edu.ua.pageobject.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginGmailPage extends BasePage {

    @FindBy(xpath = "//input[@type=\"/email\"]")
    private WebElement username;
    @FindBy(xpath = "//input[@type=\"/password\"]")
    private WebElement pass;
    @FindBy(xpath = "//*[@id=\"identifierNext\"]/div/button/span")
    private WebElement nextLog;
    @FindBy(xpath = "//*[@id=\"passwordNext\"]/div/button/span")
    private WebElement nextPass;

    protected LoginGmailPage(WebDriver webDriver) {
        super(webDriver);
    }
    public LoginGmailPage open() {
        webDriver.get("https://www.google.com/accounts/Login?hl=ru");
        return this;
    }

//    public HomeGmailPage login(String username, String pass) {
//        this.username.sendKeys(username);
//        nextLog.click();
//        this. pass.sendKeys(pass);
//        nextPass.click();
//
//        return new HomeGmailPage(webDriver);
//    }

}
