package com.sumdu.edu.ua.uitests.DBUsers;

import com.sumdu.edu.ua.BaseTest;
import com.sumdu.edu.ua.pageobject.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import static com.sumdu.edu.ua.properties.Properties.*;

public class ProUserPositiveRoleChanging extends BaseTest {

        @AfterTest
        public void tearDown() {
            quit();
        }

        @Test
        public void positiveProUserRoleChanging() {
            LoginPage loginPage = new LoginPage(webDriver);

            boolean fineUpgrade = loginPage
                    .open()
                    .login(ELEPHANT_LOGIN1, ELEPHANT_PASS).clickProfileButton().UpgradeRole().GetUpgradeRole();

          Assert.assertTrue(fineUpgrade);
        }
    }

