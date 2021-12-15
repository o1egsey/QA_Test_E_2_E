package com.sumdu.edu.ua.enumeration;

import com.sumdu.edu.ua.invoker.WebDriverInvoker;
import com.sumdu.edu.ua.invoker.implementations.LocalChromeInvoker;
import com.sumdu.edu.ua.invoker.implementations.LocalEdgeInvoker;
import com.sumdu.edu.ua.invoker.implementations.LocalFirefoxInvoker;
import org.openqa.selenium.WebDriver;

public enum SupportedBrowsers {
    LOCAL_FIREFOX(new LocalFirefoxInvoker()),
    LOCAL_CHROME(new LocalChromeInvoker()),
    LOCAL_EDGE(new LocalEdgeInvoker());
    private WebDriverInvoker webDriverInvoker;

    SupportedBrowsers(WebDriverInvoker webDriverInvoker) {
        this.webDriverInvoker = webDriverInvoker;
    }

    public WebDriver getWebDriver() {
        return webDriverInvoker.invokeWebDriver();
    }
}
