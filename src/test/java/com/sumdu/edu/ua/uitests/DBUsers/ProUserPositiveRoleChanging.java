package com.sumdu.edu.ua.uitests.DBUsers;

import com.sumdu.edu.ua.BaseTest;
import com.sumdu.edu.ua.pageobject.pages.LoginPage;
import com.sumdu.edu.ua.pageobject.pages.ProfilePage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.sumdu.edu.ua.properties.Properties.*;

public class ProUserPositiveRoleChanging extends BaseTest {

        @AfterTest
        public void tearDown() {
            quit();
        }

        @Test
        public void positiveProUserRoleChanging() throws IOException {

            String foldername = "/DBUsers/positiveProUserRoleChanging";
            boolean error;

            LoginPage loginPage = new LoginPage(webDriver);

            ProfilePage fineUpgrade = loginPage
                    .open()
                    .login(ELEPHANT_LOGIN1, ELEPHANT_PASS)
                    .clickProfileButton()
                    .UpgradeRole();


            fineUpgrade.capture(foldername);
            error = fineUpgrade.GetUpgradeRole();
            Assert.assertTrue(error);
        }
    }

