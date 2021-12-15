package com.sumdu.edu.ua.factory;

import com.sumdu.edu.ua.properties.holder.PropertyHolder;
import com.sumdu.edu.ua.properties.conventors.SupportedBrowserConverter;
import org.openqa.selenium.WebDriver;

public class WebDriverFactory {
    public WebDriver getWebDriver() {
        return SupportedBrowserConverter.valueOfWebBrowser(
                new PropertyHolder().readProperty("browser")).getWebDriver();
    }
}
