package com.sumdu.edu.ua.uitests.registration;

import com.sumdu.edu.ua.BaseTest;
import com.sumdu.edu.ua.pageobject.pages.HomePage;
import com.sumdu.edu.ua.pageobject.pages.SignInPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.sumdu.edu.ua.properties.Properties.*;

public class SignInTest extends BaseTest {

    @AfterTest
    public void tearDown() {
        quit();
    }

    @Test
    public void positiveSignInTest() throws IOException {
        String s = "registration/SignInTest", label;
        boolean message;
        HomePage userInformation;
        SignInPage signInPage;


        signInPage = new SignInPage(webDriver);
        signInPage.open();
        signInPage.capture(s);

        userInformation = signInPage.signIn(ELEPHANT_EMAIL2, ELEPHANT_PASS, ELEPHANT_PASS);
        userInformation.capture(s);
        label = userInformation.getUserInformationLabel(); //перевірка редіректа на домашню сторінку

        Assert.assertEquals(ELEPHANT_EMAIL2, label, "User nicks are not equals");
    }

}
