package com.sumdu.edu.ua.uitests.registration;

import com.sumdu.edu.ua.BaseTest;
import com.sumdu.edu.ua.pageobject.pages.SignInPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import static com.sumdu.edu.ua.properties.Properties.*;

public class SignInTest extends BaseTest {

    @AfterTest
    public void tearDown() {
        quit();
    }

    @Test
    public void positiveSignInTest() {
        SignInPage signInPage = new SignInPage(webDriver);
        String userInformation = signInPage
                .open()
                .signIn(ELEPHANT_EMAIL,ELEPHANT_PASS,ELEPHANT_PASS)
                .getUserInformationLabel();

        Assert.assertEquals("oleg.anischenko00+b@gmail.com", userInformation, "User nicks are nor equals");
    }
}
