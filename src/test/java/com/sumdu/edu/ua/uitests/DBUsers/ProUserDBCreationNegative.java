package com.sumdu.edu.ua.uitests.DBUsers;
import com.sumdu.edu.ua.BaseTest;
import com.sumdu.edu.ua.pageobject.pages.HomePage;
import com.sumdu.edu.ua.pageobject.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.sumdu.edu.ua.properties.Properties.*;

public class ProUserDBCreationNegative extends BaseTest {
    @AfterTest
    public void tearDown() {
        quit();
    }

    @Test
    public void negativeProUserDBCreation() throws IOException {
        String foldername = "negativeProUserDBCreation";
        boolean error;
        LoginPage loginPage = new LoginPage(webDriver);

        HomePage fineUpgrade = loginPage
                .open()
                .login(ELEPHANT_LOGIN1, ELEPHANT_PASS)
                .clickProfileButton()
                .UpgradeRole()
                .BackToHomePage()
                .ClickCreateDB()
                .clickProfileButton()
                .BackToHomePage()
                .ClickCreateDB()
                .clickProfileButton()
                .BackToHomePage()
                .ClickCreateDB()
                .clickProfileButton()
                .BackToHomePage();


        fineUpgrade.capture(foldername);
        error = fineUpgrade.createDBIsClickable();
        Assert.assertTrue(error);
    }
}
