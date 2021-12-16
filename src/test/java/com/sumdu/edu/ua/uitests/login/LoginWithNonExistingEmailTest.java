package com.sumdu.edu.ua.uitests.login;

import com.sumdu.edu.ua.BaseTest;
import com.sumdu.edu.ua.pageobject.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.sumdu.edu.ua.properties.Properties.*;

public class LoginWithNonExistingEmailTest extends BaseTest {

    @AfterTest
    public void tearDown() {
        quit();
    }

    @Test
    public void negativeLoginTest() throws IOException {
        String folderName = "/login/LoginWithNonExistingEmailTest";

        boolean check;
        LoginPage loginPage = new LoginPage(webDriver);
        LoginPage errorSignIn = loginPage
                .open()
                .negLogin(ELEPHANT_LOGIN1, ELEPHANT_PASS);

        errorSignIn.capture(folderName);
        check =  errorSignIn.existErrorLogin(); //перевірка повідомлення про неіснуючу почту
        Assert.assertTrue(check);
    }

}
