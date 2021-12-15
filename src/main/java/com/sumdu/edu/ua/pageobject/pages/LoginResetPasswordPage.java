package com.sumdu.edu.ua.pageobject.pages;

import com.sumdu.edu.ua.pageobject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginResetPasswordPage extends BasePage{

    @FindBy(xpath = "//*[@id=\"web-email\"]")
    private WebElement emailNew;

    @FindBy(xpath = "/html/body/main/div/div/div/form/div[2]/button")
    private WebElement sendButton;

    @FindBy(xpath = "/html/body/main/div[1]/div/div[2]/div")
    private WebElement emailMessage;

    public LoginResetPasswordPage(WebDriver webDriver) {
        super(webDriver);
    }

    /*public LoginResetPasswordPage reset(String email) {
        this.emailNew.sendKeys(email);
        sendButton.click();

        return new LoginResetPasswordPage(webDriver);
    }*/

    public boolean FindMessage(){

        emailMessage = new WebDriverWait(webDriver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/main/div[1]/div/div[2]/div")));

        return emailMessage.isDisplayed();


    }
}
