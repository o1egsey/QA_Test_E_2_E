package com.sumdu.edu.ua.uitests.registration;

import com.sumdu.edu.ua.BaseTest;
import com.sumdu.edu.ua.pageobject.pages.SignInPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class SignInWithBlankPassTest extends BaseTest {

    @AfterTest
    public void tearDown() {
        quit();
    }

    @Test
    public void negativeSignInTest() {
        SignInPage signInPage = new SignInPage(webDriver);
        boolean errorSignIn = signInPage
                .open()
                .negSignIn("oleg.anischenko00+b@gmail.com","" ,"")
                .logoSignIn();
        Assert.assertTrue(errorSignIn);
    }
}

