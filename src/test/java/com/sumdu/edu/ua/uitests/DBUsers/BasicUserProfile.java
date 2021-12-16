package com.sumdu.edu.ua.uitests.DBUsers;

import com.sumdu.edu.ua.BaseTest;
import com.sumdu.edu.ua.pageobject.pages.HomePage;
import com.sumdu.edu.ua.pageobject.pages.LoginPage;
import com.sumdu.edu.ua.pageobject.pages.ProfilePage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.IOException;
import static com.sumdu.edu.ua.properties.Properties.*;

public class BasicUserProfile extends BaseTest {
    @AfterTest
    public void tearDown() {
        quit();
    }

    @Test
    public void positiveBasicUserDBProfileAvailable() throws IOException{
        String foldername = "positiveBasicUserDBProfileAvailable";
        boolean error;

        LoginPage loginPage = new LoginPage(webDriver);

        ProfilePage fineUpgrade = loginPage
                .open()
                .login(ELEPHANT_LOGIN1, ELEPHANT_PASS)
                .clickProfileButton();


        fineUpgrade.capture(foldername);
        error = fineUpgrade.ChangeLanguageIsDisplayed();
        Assert.assertTrue(error);
    }
}
