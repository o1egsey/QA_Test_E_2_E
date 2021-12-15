package com.sumdu.edu.ua.uitests.login;

import com.sumdu.edu.ua.BaseTest;
import com.sumdu.edu.ua.pageobject.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import static com.sumdu.edu.ua.properties.Properties.ELEPHANT_LOGIN;
import static com.sumdu.edu.ua.properties.Properties.ELEPHANT_PASS;

public class LogOutTest extends BaseTest {

    @AfterTest
    public void tearDown() {
        quit();
    }

    @Test
    public void logoutTest() {
        LoginPage loginPage = new LoginPage(webDriver);
        boolean logout = loginPage
                .open()
                .login(ELEPHANT_LOGIN, ELEPHANT_PASS)
                .logout()
                .getLoginField();

        Assert.assertTrue(logout);
    }
}
