package com.sumdu.edu.ua.invoker;

import org.openqa.selenium.WebDriver;

@FunctionalInterface
public interface WebDriverInvoker {
    WebDriver invokeWebDriver();
}
