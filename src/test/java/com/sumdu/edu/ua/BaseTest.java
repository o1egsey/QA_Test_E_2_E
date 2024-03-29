package com.sumdu.edu.ua;

import com.sumdu.edu.ua.factory.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class BaseTest {
    protected final WebDriver webDriver = new WebDriverFactory().getWebDriver();

    protected void setUpDriver() {
        webDriver.manage().window().maximize();
    }

    protected void quit() {
        webDriver.quit();
    }
}
