package com.sumdu.edu.ua.uitests.DBUsers;

import com.sumdu.edu.ua.BaseTest;
import com.sumdu.edu.ua.pageobject.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import static com.sumdu.edu.ua.properties.Properties.ELEPHANT_LOGIN2;
import static com.sumdu.edu.ua.properties.Properties.ELEPHANT_PASS2;

public class NotChekedUserProfile extends BaseTest{
    @AfterTest
    public void tearDown() {
        quit();
    }

    @Test
    public void positiveNotCheckedUserDBProfileAvailable() {
        LoginPage loginPage = new LoginPage(webDriver);

        boolean fineUpgrade = loginPage
                .open()
                .login(ELEPHANT_LOGIN2, ELEPHANT_PASS2)
                .clickProfileButton()
                .ChangeLanguageIsDisplayed();

        Assert.assertTrue(fineUpgrade);
    }
}
