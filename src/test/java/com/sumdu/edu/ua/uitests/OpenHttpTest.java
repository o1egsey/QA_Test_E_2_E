package com.sumdu.edu.ua.uitests;

import com.sumdu.edu.ua.BaseTest;
import com.sumdu.edu.ua.pageobject.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import static com.sumdu.edu.ua.properties.Properties.ELEPHANT_LOGIN;
import static com.sumdu.edu.ua.properties.Properties.ELEPHANT_PASS;

public class OpenHttpTest extends BaseTest{
    @AfterTest
    public void tearDown() {
        quit();
    }

    @Test
    public void positiveLoginTest() {
        LoginPage loginPage = new LoginPage(webDriver);
        String userInformation = loginPage
                .openhttp()
                .login(ELEPHANT_LOGIN, ELEPHANT_PASS)
                .getUserInformationLabel();

        Assert.assertEquals("oleg.anischenko00+b@gmail.com", userInformation, "User nicks are nor equals");
    }
}
