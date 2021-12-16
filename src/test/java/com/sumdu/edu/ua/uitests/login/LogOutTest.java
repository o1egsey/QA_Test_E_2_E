package com.sumdu.edu.ua.uitests.login;

import com.sumdu.edu.ua.BaseTest;
import com.sumdu.edu.ua.pageobject.modules.LogoutModule;
import com.sumdu.edu.ua.pageobject.pages.HomePage;
import com.sumdu.edu.ua.pageobject.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.sumdu.edu.ua.properties.Properties.ELEPHANT_LOGIN;
import static com.sumdu.edu.ua.properties.Properties.ELEPHANT_PASS;

public class LogOutTest extends BaseTest {

    @AfterTest
    public void tearDown() {
        quit();
    }

    @Test
    public void logoutTest() throws IOException {
        String folderName = "/login/LogOutTest";
        boolean check;

        LoginPage loginPage = new LoginPage(webDriver);
        LoginPage lp = loginPage
                .open();

        lp.capture(folderName);
        HomePage hp = lp.login(ELEPHANT_LOGIN, ELEPHANT_PASS);
        hp.capture(folderName);
        LogoutModule lm = new LogoutModule(webDriver);
        lm = hp.logout();
        lm.capture(folderName);
        check = lm.getLoginField();
        Assert.assertTrue(check);
    }

}
