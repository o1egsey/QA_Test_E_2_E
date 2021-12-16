package com.sumdu.edu.ua.uitests.DBUsers;

import com.sumdu.edu.ua.BaseTest;
import com.sumdu.edu.ua.pageobject.pages.HomePage;
import com.sumdu.edu.ua.pageobject.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.sumdu.edu.ua.properties.Properties.ELEPHANT_LOGIN1;
import static com.sumdu.edu.ua.properties.Properties.ELEPHANT_PASS;

public class ProUserDeleteDB extends BaseTest {
    @AfterTest
    public void tearDown() {
        quit();
    }

    @Test
    public void deleteDbProUser() throws IOException {
        String foldername = "/DBUsers/deleteDbProUser";
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
                .BackToHomePage();


        fineUpgrade.capture(foldername);
        error = fineUpgrade.DeleteDB();
        Assert.assertTrue(error);
    }
}
