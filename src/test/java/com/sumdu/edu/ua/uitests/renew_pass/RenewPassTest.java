package com.sumdu.edu.ua.uitests.renew_pass;

import com.sumdu.edu.ua.BaseTest;
import com.sumdu.edu.ua.pageobject.pages.SignInPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import static com.sumdu.edu.ua.properties.Properties.*;

public class RenewPassTest extends BaseTest {

    @AfterTest
    public void tearDown() {
        quit();
    }

    @Test
    public void negativeSignInTest() {
        SignInPage signInPage = new SignInPage(webDriver);
        String userInformation = signInPage
                .open()
                .signIn(ELEPHANT_EMAIL2,ELEPHANT_PASS,ELEPHANT_PASS)
                .getUserInformationLabel();

        Assert.assertEquals(ELEPHANT_EMAIL2, userInformation, "User nicks are nor equals");


    }
}
