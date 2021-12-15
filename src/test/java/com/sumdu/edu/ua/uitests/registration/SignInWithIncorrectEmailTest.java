package com.sumdu.edu.ua.uitests.registration;

import com.sumdu.edu.ua.BaseTest;
import com.sumdu.edu.ua.pageobject.pages.SignInPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import static com.sumdu.edu.ua.properties.Properties.ELEPHANT_PASS;
import static com.sumdu.edu.ua.properties.Properties.INV_EMAIL;

public class SignInWithIncorrectEmailTest  extends BaseTest {

        @AfterTest
        public void tearDown() {
            quit();
        }

        @Test
        public void negativeSignInTest() {
            SignInPage signInPage = new SignInPage(webDriver);
            boolean errorSignIn = signInPage
                    .open()
                    .negSignIn(INV_EMAIL,ELEPHANT_PASS ,ELEPHANT_PASS)
                    .logoSignIn();
            Assert.assertTrue(errorSignIn);
        }
    }


