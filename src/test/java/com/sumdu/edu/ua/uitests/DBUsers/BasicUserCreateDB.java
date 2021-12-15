package com.sumdu.edu.ua.uitests.DBUsers;

import com.sumdu.edu.ua.BaseTest;
import com.sumdu.edu.ua.pageobject.pages.LoginPage;
import com.sumdu.edu.ua.properties.Properties;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class BasicUserCreateDB extends BaseTest {

    @AfterTest
    public void tearDown() {
        quit();
    }

    @Test
    public void positiveBasicUserDBCreation() {
        LoginPage loginPage = new LoginPage(webDriver);

        boolean fineUpgrade = loginPage
                .open()
                .login(Properties.ELEPHANT_LOGIN1, Properties.ELEPHANT_PASS).ClickCreateDB().dBObservationElementIsDisplayed();

        Assert.assertTrue(fineUpgrade);
    }
}

