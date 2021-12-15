package com.sumdu.edu.ua.uitests.DBUsers;

import com.sumdu.edu.ua.BaseTest;
import com.sumdu.edu.ua.pageobject.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import static com.sumdu.edu.ua.properties.Properties.ELEPHANT_LOGIN1;
import static com.sumdu.edu.ua.properties.Properties.ELEPHANT_PASS;

public class BasicUserDeleteDb extends BaseTest {
    @AfterTest
    public void tearDown() {
        quit();
    }

    @Test
    public void positiveBasicUserDBDeletion() {
        LoginPage loginPage = new LoginPage(webDriver);

        boolean fineUpgrade = loginPage
                .open()
                .login(ELEPHANT_LOGIN1, ELEPHANT_PASS).ClickCreateDB().clickProfileButton().BackToHomePage().DeleteDB();

        Assert.assertTrue(fineUpgrade);
    }
}
