package com.sumdu.edu.ua.uitests.DBUsers;

import com.sumdu.edu.ua.BaseTest;
import com.sumdu.edu.ua.pageobject.pages.DBPage;
import com.sumdu.edu.ua.pageobject.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.sumdu.edu.ua.properties.Properties.ELEPHANT_LOGIN1;
import static com.sumdu.edu.ua.properties.Properties.ELEPHANT_PASS;

public class ProUserCreateDB extends BaseTest {
    @AfterTest
    public void tearDown() {
        quit();
    }

    @Test
    public void positiveProUserDBCreation() throws IOException {
        String foldername = "/DBUsers/positiveProUserDBCreation";
        boolean error;
        LoginPage loginPage = new LoginPage(webDriver);

        DBPage fineUpgrade = loginPage
                .open()
                .login(ELEPHANT_LOGIN1, ELEPHANT_PASS)
                .clickProfileButton()
                .UpgradeRole()
                .BackToHomePage()
                .ClickCreateDB();


        fineUpgrade.capture(foldername);
        error = fineUpgrade.dBObservationElementIsDisplayed();
        Assert.assertTrue(error);
    }
}
