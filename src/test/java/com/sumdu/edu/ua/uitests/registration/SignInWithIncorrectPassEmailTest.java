package com.sumdu.edu.ua.uitests.registration;

import com.sumdu.edu.ua.BaseTest;
import com.sumdu.edu.ua.pageobject.pages.SignInPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.sumdu.edu.ua.properties.Properties.*;

public class SignInWithIncorrectPassEmailTest extends BaseTest {

    @AfterTest
    public void tearDown() {
        quit();
    }

    @Test
    public void negativeSignInTest() throws IOException {
        String foldername = "SignInWithIncorrectPassEmailTest";
        boolean error;
        SignInPage signInPage = new SignInPage(webDriver);
        SignInPage errorSignIn = signInPage
                .open()
                .negSignIn(INV_EMAIL, ELEPHANT_INV_PASS ,ELEPHANT_INV_PASS);

        errorSignIn.capture(foldername);
        error = errorSignIn.logoSignIn();
        Assert.assertTrue(error);

    }
}

/*
    boolean errorSignIn = signInPage
            .open()
            .negSignIn(INV_EMAIL, ELEPHANT_INV_PASS ,ELEPHANT_INV_PASS)
            .logoSignIn();
        Assert.assertTrue(errorSignIn);

 */