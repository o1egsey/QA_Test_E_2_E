package com.sumdu.edu.ua.uitests.registration;

import com.sumdu.edu.ua.BaseTest;
import com.sumdu.edu.ua.pageobject.pages.SignInPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.IOException;
import static com.sumdu.edu.ua.properties.Properties.*;
public class SignInWithBlankPassTest extends BaseTest {

    @AfterTest
    public void tearDown() {
        quit();
    }

    @Test
    public void negativeSignInTest() throws IOException {
        String folderName = "registration/SignInWithBlankPassTest";
        boolean check;

        SignInPage signInPage = new SignInPage(webDriver);
        SignInPage errorSignIn = signInPage
                .open()
                .negSignIn(ELEPHANT_EMAIL, "", "");

        errorSignIn.capture(folderName);
        check = errorSignIn.existErrorSignIn();
        Assert.assertTrue(check);
    }

}

