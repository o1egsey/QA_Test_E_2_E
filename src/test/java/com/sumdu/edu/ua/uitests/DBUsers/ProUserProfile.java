package com.sumdu.edu.ua.uitests.DBUsers;

import com.sumdu.edu.ua.BaseTest;
import com.sumdu.edu.ua.pageobject.pages.LoginPage;
import com.sumdu.edu.ua.pageobject.pages.ProfilePage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.sumdu.edu.ua.properties.Properties.ELEPHANT_LOGIN1;
import static com.sumdu.edu.ua.properties.Properties.ELEPHANT_PASS;

public class ProUserProfile extends BaseTest {
    @AfterTest
    public void tearDown() {
        quit();
    }

    @Test
    public void positiveBasicUserDBProfileAvailable()throws IOException {

        String foldername = "/DBUsers/positiveBasicUserDBProfileAvailable";
        boolean error;
        LoginPage loginPage = new LoginPage(webDriver);

        ProfilePage fineUpgrade = loginPage
                .open()
                .login(ELEPHANT_LOGIN1, ELEPHANT_PASS)
                .clickProfileButton()
                .UpgradeRole()
                .BackToHomePage()
                .clickProfileButton();


        fineUpgrade.capture(foldername);
        error = fineUpgrade.ChangeLanguageIsDisplayed();
        Assert.assertTrue(error);
    }
}
