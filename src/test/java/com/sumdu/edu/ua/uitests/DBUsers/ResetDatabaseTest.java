package com.sumdu.edu.ua.uitests.DBUsers;

import com.sumdu.edu.ua.BaseTest;
import com.sumdu.edu.ua.pageobject.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import static com.sumdu.edu.ua.properties.Properties.*;

// Test Case 38 - Checking the reset of the database to the backup state (Backup Page)
public class ResetDatabaseTest extends BaseTest
{
    @AfterTest
    public void tearDown() { quit(); }

    @Test
    public void resetDatabase() {
        LoginPage loginPage = new LoginPage(webDriver);

        boolean resetDatabase = loginPage
                .open()
                .login(ELEPHANT_LOGIN1, ELEPHANT_PASS)
                .ClickCreateDB()
                .clickBackupButton()
                .positiveBackup(BACKUP_NAME)
                .resetDatabase()
                .resetObservationElementIsDisplayed();

        Assert.assertTrue(resetDatabase);
    }
}

