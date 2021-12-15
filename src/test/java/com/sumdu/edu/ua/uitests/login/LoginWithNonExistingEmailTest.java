package com.sumdu.edu.ua.uitests.login;

import com.sumdu.edu.ua.BaseTest;
import com.sumdu.edu.ua.pageobject.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import static com.sumdu.edu.ua.properties.Properties.*;

public class LoginWithNonExistingEmailTest extends BaseTest {

    @AfterTest
    public void tearDown() {
        quit();
    }

    @Test
    public void negativeLoginTest() {
        LoginPage loginPage = new LoginPage(webDriver);
        boolean errorLogin = loginPage
                .open()
                .negLogin(ELEPHANT_LOGIN1, ELEPHANT_PASS)
                .existErrorLogin();

        Assert.assertTrue(errorLogin);
    }
}
