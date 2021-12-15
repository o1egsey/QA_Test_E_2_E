package com.sumdu.edu.ua.uitests.DBUsers;

import com.sumdu.edu.ua.BaseTest;
import com.sumdu.edu.ua.pageobject.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import static com.sumdu.edu.ua.properties.Properties.*;

// Test Case 37 - Checking the database update to the current state (User Profile)
public class DatabaseUpdateTest extends BaseTest
{
    @AfterTest
    public void tearDown() { quit(); }

    @Test
    public void databaseUpdate() {
        LoginPage loginPage = new LoginPage(webDriver);

        boolean databaseUpdate = loginPage
                .open()
                .login(ELEPHANT_LOGIN1, ELEPHANT_PASS)
                .ClickCreateDB()
                .clickBackupButton()
                .positiveBackup(BACKUP_NAME)
                .databaseUpdate()
                .backupObservationElementIsDisplayed();

        Assert.assertTrue(databaseUpdate);
    }
}