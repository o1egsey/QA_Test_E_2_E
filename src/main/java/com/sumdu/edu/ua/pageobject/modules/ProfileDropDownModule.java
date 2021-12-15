package com.sumdu.edu.ua.pageobject.modules;

import com.sumdu.edu.ua.pageobject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfileDropDownModule extends BasePage {
    private WebElement userInformationLabel;

    public ProfileDropDownModule(WebDriver webDriver) {
        super(webDriver);
    }

    public String getUserInformationLabel() {
        userInformationLabel = new WebDriverWait(webDriver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//strong[text()=\"juliaHrabovska\"]")));
        return userInformationLabel.getText();
    }
}
