package com.sumdu.edu.ua.uitests.profile;

import com.sumdu.edu.ua.BaseTest;
import com.sumdu.edu.ua.pageobject.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import static com.sumdu.edu.ua.properties.Properties.*;

// Test Case 32 - User Account Deleting (User Profile)
public class DeleteAccountTest extends BaseTest
{
    @AfterTest
    public void tearDown() { quit(); }

    @Test
    public void deleteUserAccount() {
        LoginPage loginPage = new LoginPage(webDriver);

        boolean deleteUserAccount = loginPage
                .open()
                .login(ELEPHANT_LOGIN1, ELEPHANT_PASS)
                .clickProfileButton()
                .deleteUserAcc()
                .deleteAccObservationElementIsDisplayed();

        Assert.assertTrue(deleteUserAccount);
    }
}