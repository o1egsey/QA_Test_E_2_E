package com.sumdu.edu.ua.uitests.login;

import com.sumdu.edu.ua.BaseTest;
import com.sumdu.edu.ua.pageobject.pages.LoginPage;
import com.sumdu.edu.ua.properties.Properties;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @AfterTest
    public void tearDown() {
        quit();
    }

    @Test
    public void positiveLoginTest() {
        LoginPage loginPage = new LoginPage(webDriver);
        String userInformation = loginPage
                .open()
                .login(Properties.ELEPHANT_LOGIN, Properties.ELEPHANT_PASS)
                .getUserInformationLabel();

        Assert.assertEquals("oleg.anischenko00+b@gmail.com", userInformation, "User nicks are nor equals");
    }
}
