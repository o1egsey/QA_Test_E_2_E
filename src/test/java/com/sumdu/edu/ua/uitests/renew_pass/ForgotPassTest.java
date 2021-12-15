package com.sumdu.edu.ua.uitests.renew_pass;

import com.sumdu.edu.ua.BaseTest;
import com.sumdu.edu.ua.pageobject.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import static com.sumdu.edu.ua.properties.Properties.ELEPHANT_LOGIN;

public class ForgotPassTest extends BaseTest {
    @AfterTest
    public void tearDown() {
        quit();
    }

    @Test
    public void positivePassRenew() {
        LoginPage loginPage = new LoginPage(webDriver);

        boolean fineUpgrade = loginPage
                .open()
                .forgotPassword()
                .reset(ELEPHANT_LOGIN)
                .FindMessage();


        Assert.assertTrue(fineUpgrade);
    }
}
