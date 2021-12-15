package com.sumdu.edu.ua.pageobject.modules;

import com.sumdu.edu.ua.pageobject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ErrorLoginModule extends BasePage {
    private WebElement errorLabel;

    public ErrorLoginModule(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean existError() {
        errorLabel = new WebDriverWait(webDriver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"alert alert-danger alert-dismissible fade show\"]")));
        return errorLabel.isDisplayed();
    }

}


