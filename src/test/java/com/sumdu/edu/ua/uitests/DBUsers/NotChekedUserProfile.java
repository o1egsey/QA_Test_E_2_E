package com.sumdu.edu.ua.uitests.DBUsers;

import com.sumdu.edu.ua.BaseTest;
import com.sumdu.edu.ua.pageobject.pages.LoginPage;
import com.sumdu.edu.ua.pageobject.pages.ProfilePage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.sumdu.edu.ua.properties.Properties.ELEPHANT_LOGIN2;
import static com.sumdu.edu.ua.properties.Properties.ELEPHANT_PASS2;

public class NotChekedUserProfile extends BaseTest{
    @AfterTest
    public void tearDown() {
        quit();
    }

    @Test
    public void positiveNotCheckedUserDBProfileAvailable() throws IOException {
        String foldername = "positiveNotCheckedUserDBProfileAvailable";
        boolean error;
        LoginPage loginPage = new LoginPage(webDriver);

        ProfilePage fineUpgrade = loginPage
                .open()
                .login(ELEPHANT_LOGIN2, ELEPHANT_PASS2)
                .clickProfileButton();


        fineUpgrade.capture(foldername);
        error = fineUpgrade.ChangeLanguageIsDisplayed();
        Assert.assertTrue(error);
    }
}
